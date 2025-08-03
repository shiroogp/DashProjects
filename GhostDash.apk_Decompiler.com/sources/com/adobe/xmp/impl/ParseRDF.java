package com.adobe.xmp.impl;

import com.adobe.xmp.XMPConst;
import com.adobe.xmp.XMPError;
import com.adobe.xmp.XMPException;
import com.adobe.xmp.XMPMetaFactory;
import com.adobe.xmp.XMPSchemaRegistry;
import com.adobe.xmp.options.PropertyOptions;
import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Attr;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class ParseRDF implements XMPError, XMPConst {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String DEFAULT_PREFIX = "_dflt";
    public static final int RDFTERM_ABOUT = 3;
    public static final int RDFTERM_ABOUT_EACH = 10;
    public static final int RDFTERM_ABOUT_EACH_PREFIX = 11;
    public static final int RDFTERM_BAG_ID = 12;
    public static final int RDFTERM_DATATYPE = 7;
    public static final int RDFTERM_DESCRIPTION = 8;
    public static final int RDFTERM_FIRST_CORE = 1;
    public static final int RDFTERM_FIRST_OLD = 10;
    public static final int RDFTERM_FIRST_SYNTAX = 1;
    public static final int RDFTERM_ID = 2;
    public static final int RDFTERM_LAST_CORE = 7;
    public static final int RDFTERM_LAST_OLD = 12;
    public static final int RDFTERM_LAST_SYNTAX = 9;
    public static final int RDFTERM_LI = 9;
    public static final int RDFTERM_NODE_ID = 6;
    public static final int RDFTERM_OTHER = 0;
    public static final int RDFTERM_PARSE_TYPE = 4;
    public static final int RDFTERM_RDF = 1;
    public static final int RDFTERM_RESOURCE = 5;

    private static XMPNode addChildNode(XMPMetaImpl xMPMetaImpl, XMPNode xMPNode, Node node, String str, boolean z) throws XMPException {
        XMPSchemaRegistry schemaRegistry = XMPMetaFactory.getSchemaRegistry();
        String namespaceURI = node.getNamespaceURI();
        if (namespaceURI != null) {
            if (XMPConst.NS_DC_DEPRECATED.equals(namespaceURI)) {
                namespaceURI = "http://purl.org/dc/elements/1.1/";
            }
            String namespacePrefix = schemaRegistry.getNamespacePrefix(namespaceURI);
            if (namespacePrefix == null) {
                namespacePrefix = schemaRegistry.registerNamespace(namespaceURI, node.getPrefix() != null ? node.getPrefix() : DEFAULT_PREFIX);
            }
            String str2 = namespacePrefix + node.getLocalName();
            PropertyOptions propertyOptions = new PropertyOptions();
            boolean z2 = false;
            if (z) {
                xMPNode = XMPNodeUtils.findSchemaNode(xMPMetaImpl.getRoot(), namespaceURI, DEFAULT_PREFIX, true);
                xMPNode.setImplicit(false);
                if (schemaRegistry.findAlias(str2) != null) {
                    xMPMetaImpl.getRoot().setHasAliases(true);
                    xMPNode.setHasAliases(true);
                    z2 = true;
                }
            }
            boolean equals = "rdf:li".equals(str2);
            boolean equals2 = "rdf:value".equals(str2);
            XMPNode xMPNode2 = new XMPNode(str2, str, propertyOptions);
            xMPNode2.setAlias(z2);
            if (!equals2) {
                xMPNode.addChild(xMPNode2);
            } else {
                xMPNode.addChild(1, xMPNode2);
            }
            if (equals2) {
                if (z || !xMPNode.getOptions().isStruct()) {
                    throw new XMPException("Misplaced rdf:value element", XMPError.BADRDF);
                }
                xMPNode.setHasValueChild(true);
            }
            if (equals) {
                if (xMPNode.getOptions().isArray()) {
                    xMPNode2.setName(XMPConst.ARRAY_ITEM_NAME);
                } else {
                    throw new XMPException("Misplaced rdf:li element", XMPError.BADRDF);
                }
            }
            return xMPNode2;
        }
        throw new XMPException("XML namespace required for all elements and attributes", XMPError.BADRDF);
    }

    private static XMPNode addQualifierNode(XMPNode xMPNode, String str, String str2) throws XMPException {
        if (XMPConst.XML_LANG.equals(str)) {
            str2 = Utils.normalizeLangValue(str2);
        }
        XMPNode xMPNode2 = new XMPNode(str, str2, (PropertyOptions) null);
        xMPNode.addQualifier(xMPNode2);
        return xMPNode2;
    }

    private static void fixupQualifiedNode(XMPNode xMPNode) throws XMPException {
        XMPNode child = xMPNode.getChild(1);
        if (child.getOptions().getHasLanguage()) {
            if (!xMPNode.getOptions().getHasLanguage()) {
                XMPNode qualifier = child.getQualifier(1);
                child.removeQualifier(qualifier);
                xMPNode.addQualifier(qualifier);
            } else {
                throw new XMPException("Redundant xml:lang for rdf:value element", XMPError.BADXMP);
            }
        }
        for (int i = 1; i <= child.getQualifierLength(); i++) {
            xMPNode.addQualifier(child.getQualifier(i));
        }
        for (int i2 = 2; i2 <= xMPNode.getChildrenLength(); i2++) {
            xMPNode.addQualifier(xMPNode.getChild(i2));
        }
        xMPNode.setHasValueChild(false);
        xMPNode.getOptions().setStruct(false);
        xMPNode.getOptions().mergeWith(child.getOptions());
        xMPNode.setValue(child.getValue());
        xMPNode.removeChildren();
        Iterator iterateChildren = child.iterateChildren();
        while (iterateChildren.hasNext()) {
            xMPNode.addChild((XMPNode) iterateChildren.next());
        }
    }

    private static int getRDFTermKind(Node node) {
        String localName = node.getLocalName();
        String namespaceURI = node.getNamespaceURI();
        if (namespaceURI == null && (("about".equals(localName) || "ID".equals(localName)) && (node instanceof Attr) && XMPConst.NS_RDF.equals(((Attr) node).getOwnerElement().getNamespaceURI()))) {
            namespaceURI = XMPConst.NS_RDF;
        }
        if (!XMPConst.NS_RDF.equals(namespaceURI)) {
            return 0;
        }
        if ("li".equals(localName)) {
            return 9;
        }
        if ("parseType".equals(localName)) {
            return 4;
        }
        if ("Description".equals(localName)) {
            return 8;
        }
        if ("about".equals(localName)) {
            return 3;
        }
        if ("resource".equals(localName)) {
            return 5;
        }
        if ("RDF".equals(localName)) {
            return 1;
        }
        if ("ID".equals(localName)) {
            return 2;
        }
        if ("nodeID".equals(localName)) {
            return 6;
        }
        if ("datatype".equals(localName)) {
            return 7;
        }
        if ("aboutEach".equals(localName)) {
            return 10;
        }
        if ("aboutEachPrefix".equals(localName)) {
            return 11;
        }
        return "bagID".equals(localName) ? 12 : 0;
    }

    private static boolean isCoreSyntaxTerm(int i) {
        return 1 <= i && i <= 7;
    }

    private static boolean isOldTerm(int i) {
        return 10 <= i && i <= 12;
    }

    private static boolean isPropertyElementName(int i) {
        if (i == 8 || isOldTerm(i)) {
            return false;
        }
        return !isCoreSyntaxTerm(i);
    }

    private static boolean isWhitespaceNode(Node node) {
        if (node.getNodeType() != 3) {
            return false;
        }
        String nodeValue = node.getNodeValue();
        for (int i = 0; i < nodeValue.length(); i++) {
            if (!Character.isWhitespace(nodeValue.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    static XMPMetaImpl parse(Node node) throws XMPException {
        XMPMetaImpl xMPMetaImpl = new XMPMetaImpl();
        rdf_RDF(xMPMetaImpl, node);
        return xMPMetaImpl;
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x00f1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void rdf_EmptyPropertyElement(com.adobe.xmp.impl.XMPMetaImpl r16, com.adobe.xmp.impl.XMPNode r17, org.w3c.dom.Node r18, boolean r19) throws com.adobe.xmp.XMPException {
        /*
            r0 = r16
            boolean r1 = r18.hasChildNodes()
            r2 = 202(0xca, float:2.83E-43)
            if (r1 != 0) goto L_0x015a
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x0010:
            org.w3c.dom.NamedNodeMap r9 = r18.getAttributes()
            int r9 = r9.getLength()
            java.lang.String r10 = "Unrecognized attribute of empty property element"
            r11 = 6
            r12 = 5
            r13 = 2
            java.lang.String r14 = "xml:lang"
            java.lang.String r15 = "xmlns"
            if (r4 >= r9) goto L_0x00b5
            org.w3c.dom.NamedNodeMap r9 = r18.getAttributes()
            org.w3c.dom.Node r9 = r9.item(r4)
            java.lang.String r1 = r9.getPrefix()
            boolean r1 = r15.equals(r1)
            if (r1 != 0) goto L_0x00b1
            java.lang.String r1 = r9.getPrefix()
            if (r1 != 0) goto L_0x0049
            java.lang.String r1 = r9.getNodeName()
            boolean r1 = r15.equals(r1)
            if (r1 == 0) goto L_0x0049
            goto L_0x00b1
        L_0x0049:
            int r1 = getRDFTermKind(r9)
            java.lang.String r15 = "Empty property element can't have both rdf:value and rdf:resource"
            if (r1 == 0) goto L_0x0080
            if (r1 == r13) goto L_0x00b1
            java.lang.String r13 = "Empty property element can't have both rdf:resource and rdf:nodeID"
            if (r1 == r12) goto L_0x0069
            if (r1 != r11) goto L_0x0063
            if (r6 != 0) goto L_0x005d
            r8 = 1
            goto L_0x00b1
        L_0x005d:
            com.adobe.xmp.XMPException r0 = new com.adobe.xmp.XMPException
            r0.<init>(r13, r2)
            throw r0
        L_0x0063:
            com.adobe.xmp.XMPException r0 = new com.adobe.xmp.XMPException
            r0.<init>(r10, r2)
            throw r0
        L_0x0069:
            if (r8 != 0) goto L_0x007a
            if (r5 != 0) goto L_0x0072
            if (r5 != 0) goto L_0x0070
            r3 = r9
        L_0x0070:
            r6 = 1
            goto L_0x00b1
        L_0x0072:
            com.adobe.xmp.XMPException r0 = new com.adobe.xmp.XMPException
            r1 = 203(0xcb, float:2.84E-43)
            r0.<init>(r15, r1)
            throw r0
        L_0x007a:
            com.adobe.xmp.XMPException r0 = new com.adobe.xmp.XMPException
            r0.<init>(r13, r2)
            throw r0
        L_0x0080:
            java.lang.String r1 = r9.getLocalName()
            java.lang.String r10 = "value"
            boolean r1 = r10.equals(r1)
            if (r1 == 0) goto L_0x00a6
            java.lang.String r1 = r9.getNamespaceURI()
            java.lang.String r10 = "http://www.w3.org/1999/02/22-rdf-syntax-ns#"
            boolean r1 = r10.equals(r1)
            if (r1 == 0) goto L_0x00a6
            if (r6 != 0) goto L_0x009e
            r3 = r9
            r5 = 1
            goto L_0x00b1
        L_0x009e:
            com.adobe.xmp.XMPException r0 = new com.adobe.xmp.XMPException
            r1 = 203(0xcb, float:2.84E-43)
            r0.<init>(r15, r1)
            throw r0
        L_0x00a6:
            java.lang.String r1 = r9.getNodeName()
            boolean r1 = r14.equals(r1)
            if (r1 != 0) goto L_0x00b1
            r7 = 1
        L_0x00b1:
            int r4 = r4 + 1
            goto L_0x0010
        L_0x00b5:
            java.lang.String r1 = ""
            r4 = r17
            r8 = r18
            r9 = r19
            com.adobe.xmp.impl.XMPNode r4 = addChildNode(r0, r4, r8, r1, r9)
            if (r5 != 0) goto L_0x00d2
            if (r6 == 0) goto L_0x00c6
            goto L_0x00d2
        L_0x00c6:
            if (r7 == 0) goto L_0x00e5
            com.adobe.xmp.options.PropertyOptions r1 = r4.getOptions()
            r6 = 1
            r1.setStruct(r6)
            r1 = r6
            goto L_0x00e6
        L_0x00d2:
            r6 = 1
            if (r3 == 0) goto L_0x00d9
            java.lang.String r1 = r3.getNodeValue()
        L_0x00d9:
            r4.setValue(r1)
            if (r5 != 0) goto L_0x00e5
            com.adobe.xmp.options.PropertyOptions r1 = r4.getOptions()
            r1.setURI(r6)
        L_0x00e5:
            r1 = 0
        L_0x00e6:
            r5 = 0
        L_0x00e7:
            org.w3c.dom.NamedNodeMap r6 = r18.getAttributes()
            int r6 = r6.getLength()
            if (r5 >= r6) goto L_0x0159
            org.w3c.dom.NamedNodeMap r6 = r18.getAttributes()
            org.w3c.dom.Node r6 = r6.item(r5)
            if (r6 == r3) goto L_0x0155
            java.lang.String r7 = r6.getPrefix()
            boolean r7 = r15.equals(r7)
            if (r7 != 0) goto L_0x0155
            java.lang.String r7 = r6.getPrefix()
            if (r7 != 0) goto L_0x0116
            java.lang.String r7 = r6.getNodeName()
            boolean r7 = r15.equals(r7)
            if (r7 == 0) goto L_0x0116
            goto L_0x0155
        L_0x0116:
            int r7 = getRDFTermKind(r6)
            if (r7 == 0) goto L_0x0133
            if (r7 == r13) goto L_0x0155
            if (r7 == r12) goto L_0x0129
            if (r7 != r11) goto L_0x0123
            goto L_0x0155
        L_0x0123:
            com.adobe.xmp.XMPException r0 = new com.adobe.xmp.XMPException
            r0.<init>(r10, r2)
            throw r0
        L_0x0129:
            java.lang.String r6 = r6.getNodeValue()
            java.lang.String r7 = "rdf:resource"
        L_0x012f:
            addQualifierNode(r4, r7, r6)
            goto L_0x0155
        L_0x0133:
            java.lang.String r7 = r6.getNodeName()
            if (r1 != 0) goto L_0x013e
            java.lang.String r6 = r6.getNodeValue()
            goto L_0x012f
        L_0x013e:
            boolean r7 = r14.equals(r7)
            if (r7 == 0) goto L_0x014c
            java.lang.String r6 = r6.getNodeValue()
            addQualifierNode(r4, r14, r6)
            goto L_0x0155
        L_0x014c:
            java.lang.String r7 = r6.getNodeValue()
            r9 = 0
            addChildNode(r0, r4, r6, r7, r9)
            goto L_0x0156
        L_0x0155:
            r9 = 0
        L_0x0156:
            int r5 = r5 + 1
            goto L_0x00e7
        L_0x0159:
            return
        L_0x015a:
            com.adobe.xmp.XMPException r0 = new com.adobe.xmp.XMPException
            java.lang.String r1 = "Nested content not allowed with rdf:resource or property attributes"
            r0.<init>(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.xmp.impl.ParseRDF.rdf_EmptyPropertyElement(com.adobe.xmp.impl.XMPMetaImpl, com.adobe.xmp.impl.XMPNode, org.w3c.dom.Node, boolean):void");
    }

    private static void rdf_LiteralPropertyElement(XMPMetaImpl xMPMetaImpl, XMPNode xMPNode, Node node, boolean z) throws XMPException {
        XMPNode addChildNode = addChildNode(xMPMetaImpl, xMPNode, node, (String) null, z);
        int i = 0;
        for (int i2 = 0; i2 < node.getAttributes().getLength(); i2++) {
            Node item = node.getAttributes().item(i2);
            if (!"xmlns".equals(item.getPrefix()) && (item.getPrefix() != null || !"xmlns".equals(item.getNodeName()))) {
                String namespaceURI = item.getNamespaceURI();
                String localName = item.getLocalName();
                if (XMPConst.XML_LANG.equals(item.getNodeName())) {
                    addQualifierNode(addChildNode, XMPConst.XML_LANG, item.getNodeValue());
                } else if (!XMPConst.NS_RDF.equals(namespaceURI) || (!"ID".equals(localName) && !"datatype".equals(localName))) {
                    throw new XMPException("Invalid attribute for literal property element", XMPError.BADRDF);
                }
            }
        }
        String str = "";
        while (i < node.getChildNodes().getLength()) {
            Node item2 = node.getChildNodes().item(i);
            if (item2.getNodeType() == 3) {
                str = str + item2.getNodeValue();
                i++;
            } else {
                throw new XMPException("Invalid child of literal property element", XMPError.BADRDF);
            }
        }
        addChildNode.setValue(str);
    }

    private static void rdf_NodeElement(XMPMetaImpl xMPMetaImpl, XMPNode xMPNode, Node node, boolean z) throws XMPException {
        int rDFTermKind = getRDFTermKind(node);
        if (rDFTermKind != 8 && rDFTermKind != 0) {
            throw new XMPException("Node element must be rdf:Description or typed node", XMPError.BADRDF);
        } else if (!z || rDFTermKind != 0) {
            rdf_NodeElementAttrs(xMPMetaImpl, xMPNode, node, z);
            rdf_PropertyElementList(xMPMetaImpl, xMPNode, node, z);
        } else {
            throw new XMPException("Top level typed node not allowed", XMPError.BADXMP);
        }
    }

    private static void rdf_NodeElementAttrs(XMPMetaImpl xMPMetaImpl, XMPNode xMPNode, Node node, boolean z) throws XMPException {
        int i = 0;
        for (int i2 = 0; i2 < node.getAttributes().getLength(); i2++) {
            Node item = node.getAttributes().item(i2);
            if (!"xmlns".equals(item.getPrefix()) && (item.getPrefix() != null || !"xmlns".equals(item.getNodeName()))) {
                int rDFTermKind = getRDFTermKind(item);
                if (rDFTermKind == 0) {
                    addChildNode(xMPMetaImpl, xMPNode, item, item.getNodeValue(), z);
                } else if (rDFTermKind != 6 && rDFTermKind != 2 && rDFTermKind != 3) {
                    throw new XMPException("Invalid nodeElement attribute", XMPError.BADRDF);
                } else if (i <= 0) {
                    i++;
                    if (z && rDFTermKind == 3) {
                        if (xMPNode.getName() == null || xMPNode.getName().length() <= 0) {
                            xMPNode.setName(item.getNodeValue());
                        } else if (!xMPNode.getName().equals(item.getNodeValue())) {
                            throw new XMPException("Mismatched top level rdf:about values", XMPError.BADXMP);
                        }
                    }
                } else {
                    throw new XMPException("Mutally exclusive about, ID, nodeID attributes", XMPError.BADRDF);
                }
            }
        }
    }

    private static void rdf_NodeElementList(XMPMetaImpl xMPMetaImpl, XMPNode xMPNode, Node node) throws XMPException {
        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            Node item = node.getChildNodes().item(i);
            if (!isWhitespaceNode(item)) {
                rdf_NodeElement(xMPMetaImpl, xMPNode, item, true);
            }
        }
    }

    private static void rdf_ParseTypeCollectionPropertyElement() throws XMPException {
        throw new XMPException("ParseTypeCollection property element not allowed", XMPError.BADXMP);
    }

    private static void rdf_ParseTypeLiteralPropertyElement() throws XMPException {
        throw new XMPException("ParseTypeLiteral property element not allowed", XMPError.BADXMP);
    }

    private static void rdf_ParseTypeOtherPropertyElement() throws XMPException {
        throw new XMPException("ParseTypeOther property element not allowed", XMPError.BADXMP);
    }

    private static void rdf_ParseTypeResourcePropertyElement(XMPMetaImpl xMPMetaImpl, XMPNode xMPNode, Node node, boolean z) throws XMPException {
        XMPNode addChildNode = addChildNode(xMPMetaImpl, xMPNode, node, "", z);
        addChildNode.getOptions().setStruct(true);
        for (int i = 0; i < node.getAttributes().getLength(); i++) {
            Node item = node.getAttributes().item(i);
            if (!"xmlns".equals(item.getPrefix()) && (item.getPrefix() != null || !"xmlns".equals(item.getNodeName()))) {
                String localName = item.getLocalName();
                String namespaceURI = item.getNamespaceURI();
                if (XMPConst.XML_LANG.equals(item.getNodeName())) {
                    addQualifierNode(addChildNode, XMPConst.XML_LANG, item.getNodeValue());
                } else if (!XMPConst.NS_RDF.equals(namespaceURI) || (!"ID".equals(localName) && !"parseType".equals(localName))) {
                    throw new XMPException("Invalid attribute for ParseTypeResource property element", XMPError.BADRDF);
                }
            }
        }
        rdf_PropertyElementList(xMPMetaImpl, addChildNode, node, false);
        if (addChildNode.getHasValueChild()) {
            fixupQualifiedNode(addChildNode);
        }
    }

    private static void rdf_PropertyElement(XMPMetaImpl xMPMetaImpl, XMPNode xMPNode, Node node, boolean z) throws XMPException {
        if (isPropertyElementName(getRDFTermKind(node))) {
            NamedNodeMap attributes = node.getAttributes();
            ArrayList<String> arrayList = null;
            for (int i = 0; i < attributes.getLength(); i++) {
                Node item = attributes.item(i);
                if ("xmlns".equals(item.getPrefix()) || (item.getPrefix() == null && "xmlns".equals(item.getNodeName()))) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(item.getNodeName());
                }
            }
            if (arrayList != null) {
                for (String removeNamedItem : arrayList) {
                    attributes.removeNamedItem(removeNamedItem);
                }
            }
            if (attributes.getLength() <= 3) {
                int i2 = 0;
                while (i2 < attributes.getLength()) {
                    Node item2 = attributes.item(i2);
                    String localName = item2.getLocalName();
                    String namespaceURI = item2.getNamespaceURI();
                    String nodeValue = item2.getNodeValue();
                    if (XMPConst.XML_LANG.equals(item2.getNodeName()) && (!"ID".equals(localName) || !XMPConst.NS_RDF.equals(namespaceURI))) {
                        i2++;
                    } else if ("datatype".equals(localName) && XMPConst.NS_RDF.equals(namespaceURI)) {
                        rdf_LiteralPropertyElement(xMPMetaImpl, xMPNode, node, z);
                        return;
                    } else if (!"parseType".equals(localName) || !XMPConst.NS_RDF.equals(namespaceURI)) {
                        rdf_EmptyPropertyElement(xMPMetaImpl, xMPNode, node, z);
                        return;
                    } else if ("Literal".equals(nodeValue)) {
                        rdf_ParseTypeLiteralPropertyElement();
                        return;
                    } else if ("Resource".equals(nodeValue)) {
                        rdf_ParseTypeResourcePropertyElement(xMPMetaImpl, xMPNode, node, z);
                        return;
                    } else if ("Collection".equals(nodeValue)) {
                        rdf_ParseTypeCollectionPropertyElement();
                        return;
                    } else {
                        rdf_ParseTypeOtherPropertyElement();
                        return;
                    }
                }
                if (node.hasChildNodes()) {
                    for (int i3 = 0; i3 < node.getChildNodes().getLength(); i3++) {
                        if (node.getChildNodes().item(i3).getNodeType() != 3) {
                            rdf_ResourcePropertyElement(xMPMetaImpl, xMPNode, node, z);
                            return;
                        }
                    }
                    rdf_LiteralPropertyElement(xMPMetaImpl, xMPNode, node, z);
                    return;
                }
            }
            rdf_EmptyPropertyElement(xMPMetaImpl, xMPNode, node, z);
            return;
        }
        throw new XMPException("Invalid property element name", XMPError.BADRDF);
    }

    private static void rdf_PropertyElementList(XMPMetaImpl xMPMetaImpl, XMPNode xMPNode, Node node, boolean z) throws XMPException {
        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            Node item = node.getChildNodes().item(i);
            if (!isWhitespaceNode(item)) {
                if (item.getNodeType() == 1) {
                    rdf_PropertyElement(xMPMetaImpl, xMPNode, item, z);
                } else {
                    throw new XMPException("Expected property element node not found", XMPError.BADRDF);
                }
            }
        }
    }

    static void rdf_RDF(XMPMetaImpl xMPMetaImpl, Node node) throws XMPException {
        if (node.hasAttributes()) {
            rdf_NodeElementList(xMPMetaImpl, xMPMetaImpl.getRoot(), node);
            return;
        }
        throw new XMPException("Invalid attributes of rdf:RDF element", XMPError.BADRDF);
    }

    private static void rdf_ResourcePropertyElement(XMPMetaImpl xMPMetaImpl, XMPNode xMPNode, Node node, boolean z) throws XMPException {
        XMPException xMPException;
        if (!z || !"iX:changes".equals(node.getNodeName())) {
            XMPNode addChildNode = addChildNode(xMPMetaImpl, xMPNode, node, "", z);
            for (int i = 0; i < node.getAttributes().getLength(); i++) {
                Node item = node.getAttributes().item(i);
                if (!"xmlns".equals(item.getPrefix()) && (item.getPrefix() != null || !"xmlns".equals(item.getNodeName()))) {
                    String localName = item.getLocalName();
                    String namespaceURI = item.getNamespaceURI();
                    if (XMPConst.XML_LANG.equals(item.getNodeName())) {
                        addQualifierNode(addChildNode, XMPConst.XML_LANG, item.getNodeValue());
                    } else if (!"ID".equals(localName) || !XMPConst.NS_RDF.equals(namespaceURI)) {
                        throw new XMPException("Invalid attribute for resource property element", XMPError.BADRDF);
                    }
                }
            }
            boolean z2 = false;
            for (int i2 = 0; i2 < node.getChildNodes().getLength(); i2++) {
                Node item2 = node.getChildNodes().item(i2);
                if (!isWhitespaceNode(item2)) {
                    if (item2.getNodeType() == 1 && !z2) {
                        boolean equals = XMPConst.NS_RDF.equals(item2.getNamespaceURI());
                        String localName2 = item2.getLocalName();
                        if (equals && "Bag".equals(localName2)) {
                            addChildNode.getOptions().setArray(true);
                        } else if (equals && "Seq".equals(localName2)) {
                            addChildNode.getOptions().setArray(true).setArrayOrdered(true);
                        } else if (!equals || !"Alt".equals(localName2)) {
                            addChildNode.getOptions().setStruct(true);
                            if (!equals && !"Description".equals(localName2)) {
                                String namespaceURI2 = item2.getNamespaceURI();
                                if (namespaceURI2 != null) {
                                    addQualifierNode(addChildNode, XMPConst.RDF_TYPE, namespaceURI2 + ':' + localName2);
                                } else {
                                    throw new XMPException("All XML elements must be in a namespace", XMPError.BADXMP);
                                }
                            }
                        } else {
                            addChildNode.getOptions().setArray(true).setArrayOrdered(true).setArrayAlternate(true);
                        }
                        rdf_NodeElement(xMPMetaImpl, addChildNode, item2, false);
                        if (addChildNode.getHasValueChild()) {
                            fixupQualifiedNode(addChildNode);
                        } else if (addChildNode.getOptions().isArrayAlternate()) {
                            XMPNodeUtils.detectAltText(addChildNode);
                        }
                        z2 = true;
                    } else if (z2) {
                        throw xMPException;
                    } else {
                        xMPException = new XMPException("Children of resource property element must be XML elements", XMPError.BADRDF);
                        throw xMPException;
                    }
                }
            }
            if (!z2) {
                throw new XMPException("Missing child of resource property element", XMPError.BADRDF);
            }
        }
    }
}
