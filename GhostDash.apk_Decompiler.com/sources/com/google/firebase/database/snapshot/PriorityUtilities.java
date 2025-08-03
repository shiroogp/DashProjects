package com.google.firebase.database.snapshot;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.core.Path;

public class PriorityUtilities {
    public static Node NullPriority() {
        return EmptyNode.Empty();
    }

    public static boolean isValidPriority(Node node) {
        return node.getPriority().isEmpty() && (node.isEmpty() || (node instanceof DoubleNode) || (node instanceof StringNode) || (node instanceof DeferredValueNode));
    }

    public static Node parsePriority(Object obj) {
        return parsePriority((Path) null, obj);
    }

    public static Node parsePriority(Path path, Object obj) {
        Node NodeFromJSON = NodeUtilities.NodeFromJSON(obj);
        if (NodeFromJSON instanceof LongNode) {
            NodeFromJSON = new DoubleNode(Double.valueOf((double) ((Long) NodeFromJSON.getValue()).longValue()), NullPriority());
        }
        if (isValidPriority(NodeFromJSON)) {
            return NodeFromJSON;
        }
        throw new DatabaseException((path != null ? "Path '" + path + "'" : "Node") + " contains invalid priority: Must be a string, double, ServerValue, or null");
    }
}
