package com.drew.lang;

import java.util.HashMap;
import java.util.Map;

public class ByteTrie<T> {
    private int _maxDepth;
    private final ByteTrieNode<T> _root = new ByteTrieNode<>();

    static class ByteTrieNode<T> {
        /* access modifiers changed from: private */
        public final Map<Byte, ByteTrieNode<T>> _children = new HashMap();
        /* access modifiers changed from: private */
        public T _value = null;

        ByteTrieNode() {
        }

        public void setValue(T t) {
            if (this._value == null) {
                this._value = t;
                return;
            }
            throw new RuntimeException("Value already set for this trie node");
        }
    }

    public T find(byte[] bArr) {
        ByteTrieNode<T> byteTrieNode = this._root;
        T access$000 = byteTrieNode._value;
        for (byte valueOf : bArr) {
            byteTrieNode = (ByteTrieNode) byteTrieNode._children.get(Byte.valueOf(valueOf));
            if (byteTrieNode == null) {
                break;
            }
            if (byteTrieNode._value != null) {
                access$000 = byteTrieNode._value;
            }
        }
        return access$000;
    }

    public void addPath(T t, byte[]... bArr) {
        ByteTrieNode<T> byteTrieNode = this._root;
        int i = 0;
        for (byte[] bArr2 : bArr) {
            for (byte b : bArr[r3]) {
                ByteTrieNode<T> byteTrieNode2 = (ByteTrieNode) byteTrieNode._children.get(Byte.valueOf(b));
                if (byteTrieNode2 == null) {
                    byteTrieNode2 = new ByteTrieNode<>();
                    byteTrieNode._children.put(Byte.valueOf(b), byteTrieNode2);
                }
                byteTrieNode = byteTrieNode2;
                i++;
            }
        }
        if (i != 0) {
            byteTrieNode.setValue(t);
            this._maxDepth = Math.max(this._maxDepth, i);
            return;
        }
        throw new IllegalArgumentException("Parts must contain at least one byte.");
    }

    public void setDefaultValue(T t) {
        this._root.setValue(t);
    }

    public int getMaxDepth() {
        return this._maxDepth;
    }
}
