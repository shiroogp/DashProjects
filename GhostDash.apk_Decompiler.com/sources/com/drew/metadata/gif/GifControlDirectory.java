package com.drew.metadata.gif;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class GifControlDirectory extends Directory {
    public static final int TAG_DELAY = 1;
    public static final int TAG_DISPOSAL_METHOD = 2;
    public static final int TAG_TRANSPARENT_COLOR_FLAG = 4;
    public static final int TAG_TRANSPARENT_COLOR_INDEX = 5;
    public static final int TAG_USER_INPUT_FLAG = 3;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "GIF Control";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(1, "Delay");
        hashMap.put(2, "Disposal Method");
        hashMap.put(3, "User Input Flag");
        hashMap.put(4, "Transparent Color Flag");
        hashMap.put(5, "Transparent Color Index");
    }

    public GifControlDirectory() {
        setDescriptor(new GifControlDescriptor(this));
    }

    public DisposalMethod getDisposalMethod() {
        return (DisposalMethod) getObject(2);
    }

    public boolean isTransparent() {
        Boolean booleanObject = getBooleanObject(4);
        return booleanObject != null && booleanObject.booleanValue();
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }

    public enum DisposalMethod {
        NOT_SPECIFIED,
        DO_NOT_DISPOSE,
        RESTORE_TO_BACKGROUND_COLOR,
        RESTORE_TO_PREVIOUS,
        TO_BE_DEFINED,
        INVALID;

        public static DisposalMethod typeOf(int i) {
            switch (i) {
                case 0:
                    return NOT_SPECIFIED;
                case 1:
                    return DO_NOT_DISPOSE;
                case 2:
                    return RESTORE_TO_BACKGROUND_COLOR;
                case 3:
                    return RESTORE_TO_PREVIOUS;
                case 4:
                case 5:
                case 6:
                case 7:
                    return TO_BE_DEFINED;
                default:
                    return INVALID;
            }
        }

        public String toString() {
            switch (AnonymousClass1.$SwitchMap$com$drew$metadata$gif$GifControlDirectory$DisposalMethod[ordinal()]) {
                case 1:
                    return "Don't Dispose";
                case 2:
                    return "Invalid value";
                case 3:
                    return "Not Specified";
                case 4:
                    return "Restore to Background Color";
                case 5:
                    return "Restore to Previous";
                case 6:
                    return "To Be Defined";
                default:
                    return super.toString();
            }
        }
    }

    /* renamed from: com.drew.metadata.gif.GifControlDirectory$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$drew$metadata$gif$GifControlDirectory$DisposalMethod;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.drew.metadata.gif.GifControlDirectory$DisposalMethod[] r0 = com.drew.metadata.gif.GifControlDirectory.DisposalMethod.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$drew$metadata$gif$GifControlDirectory$DisposalMethod = r0
                com.drew.metadata.gif.GifControlDirectory$DisposalMethod r1 = com.drew.metadata.gif.GifControlDirectory.DisposalMethod.DO_NOT_DISPOSE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$drew$metadata$gif$GifControlDirectory$DisposalMethod     // Catch:{ NoSuchFieldError -> 0x001d }
                com.drew.metadata.gif.GifControlDirectory$DisposalMethod r1 = com.drew.metadata.gif.GifControlDirectory.DisposalMethod.INVALID     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$drew$metadata$gif$GifControlDirectory$DisposalMethod     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.drew.metadata.gif.GifControlDirectory$DisposalMethod r1 = com.drew.metadata.gif.GifControlDirectory.DisposalMethod.NOT_SPECIFIED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$drew$metadata$gif$GifControlDirectory$DisposalMethod     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.drew.metadata.gif.GifControlDirectory$DisposalMethod r1 = com.drew.metadata.gif.GifControlDirectory.DisposalMethod.RESTORE_TO_BACKGROUND_COLOR     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$drew$metadata$gif$GifControlDirectory$DisposalMethod     // Catch:{ NoSuchFieldError -> 0x003e }
                com.drew.metadata.gif.GifControlDirectory$DisposalMethod r1 = com.drew.metadata.gif.GifControlDirectory.DisposalMethod.RESTORE_TO_PREVIOUS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$drew$metadata$gif$GifControlDirectory$DisposalMethod     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.drew.metadata.gif.GifControlDirectory$DisposalMethod r1 = com.drew.metadata.gif.GifControlDirectory.DisposalMethod.TO_BE_DEFINED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.drew.metadata.gif.GifControlDirectory.AnonymousClass1.<clinit>():void");
        }
    }
}
