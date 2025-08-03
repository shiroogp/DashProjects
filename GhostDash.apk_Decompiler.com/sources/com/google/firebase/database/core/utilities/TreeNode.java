package com.google.firebase.database.core.utilities;

import com.google.firebase.database.snapshot.ChildKey;
import java.util.HashMap;
import java.util.Map;

public class TreeNode<T> {
    public Map<ChildKey, TreeNode<T>> children = new HashMap();
    public T value;

    /* access modifiers changed from: package-private */
    public String toString(String str) {
        String str2 = str + "<value>: " + this.value + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE;
        if (this.children.isEmpty()) {
            return str2 + str + "<empty>";
        }
        for (Map.Entry next : this.children.entrySet()) {
            str2 = str2 + str + next.getKey() + ":\n" + ((TreeNode) next.getValue()).toString(str + "\t") + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE;
        }
        return str2;
    }
}
