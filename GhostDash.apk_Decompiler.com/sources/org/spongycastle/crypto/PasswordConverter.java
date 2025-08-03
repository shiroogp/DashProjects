package org.spongycastle.crypto;

public enum PasswordConverter implements CharToByteConverter {
    ASCII {
        public String getType() {
            return "ASCII";
        }

        public byte[] convert(char[] cArr) {
            return PBEParametersGenerator.PKCS5PasswordToBytes(cArr);
        }
    },
    UTF8 {
        public String getType() {
            return "UTF8";
        }

        public byte[] convert(char[] cArr) {
            return PBEParametersGenerator.PKCS5PasswordToUTF8Bytes(cArr);
        }
    },
    PKCS12 {
        public String getType() {
            return "PKCS12";
        }

        public byte[] convert(char[] cArr) {
            return PBEParametersGenerator.PKCS12PasswordToBytes(cArr);
        }
    }
}
