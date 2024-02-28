package com.assac453.tea.algorithm;

public class TEA_ECB {

    private static final int[] SCHEDULE = { 0x01234567, 0x89ABCDEF, 0xFEDCBA98, 0x76543210 };
    private static final int DELTA = 0x9e3779b9;
    private static final int ROUNDS = 32;

    public static int[] encrypt(int[] block, int[] key) {
        int sum = 0;
        int v0 = block[0];
        int v1 = block[1];
        int k0 = key[0];
        int k1 = key[1];
        int k2 = key[2];
        int k3 = key[3];

        for (int i = 0; i < ROUNDS; i++) {
            sum += DELTA;
            v0 += ((v1 << 4) + k0) ^ (v1 + sum) ^ ((v1 >> 5) + k1);
            v1 += ((v0 << 4) + k2) ^ (v0 + sum) ^ ((v0 >> 5) + k3);
        }

        return new int[]{v0, v1};
    }

    public static int[] decrypt(int[] block, int[] key) {
        int sum = DELTA * ROUNDS;
        int v0 = block[0];
        int v1 = block[1];
        int k0 = key[0];
        int k1 = key[1];
        int k2 = key[2];
        int k3 = key[3];

        for (int i = 0; i < ROUNDS; i++) {
            v1 -= ((v0 << 4) + k2) ^ (v0 + sum) ^ ((v0 >> 5) + k3);
            v0 -= ((v1 << 4) + k0) ^ (v1 + sum) ^ ((v1 >> 5) + k1);
            sum -= DELTA;
        }

        return new int[]{v0, v1};
    }

    public static byte[] tea_ecb_encrypt(byte[] plaintext, int[] key) {
        // Pad plaintext if necessary
        if (plaintext.length % 8 != 0) {
            byte[] padded = new byte[plaintext.length + (8 - plaintext.length % 8)];
            System.arraycopy(plaintext, 0, padded, 0, plaintext.length);
            plaintext = padded;
        }

        byte[] ciphertext = new byte[plaintext.length];
        int blockCount = plaintext.length / 8;

        for (int i = 0; i < blockCount; i++) {
            int[] block = {toInt(plaintext, i * 8), toInt(plaintext, i * 8 + 4)};
            int[] encryptedBlock = encrypt(block, key);
            System.arraycopy(toBytes(encryptedBlock[0]), 0, ciphertext, i * 8, 4);
            System.arraycopy(toBytes(encryptedBlock[1]), 0, ciphertext, i * 8 + 4, 4);
        }

        return ciphertext;
    }

    public static byte[] tea_ecb_decrypt(byte[] ciphertext, int[] key) {
        byte[] plaintext = new byte[ciphertext.length];
        int blockCount = ciphertext.length / 8;

        for (int i = 0; i < blockCount; i++) {
            int[] block = {toInt(ciphertext, i * 8), toInt(ciphertext, i * 8 + 4)};
            int[] decryptedBlock = decrypt(block, key);
            System.arraycopy(toBytes(decryptedBlock[0]), 0, plaintext, i * 8, 4);
            System.arraycopy(toBytes(decryptedBlock[1]), 0, plaintext, i * 8 + 4, 4);
        }

        return plaintext;
    }

    private static int toInt(byte[] bytes, int offset) {
        return (bytes[offset] & 0xFF) |
                ((bytes[offset + 1] & 0xFF) << 8) |
                ((bytes[offset + 2] & 0xFF) << 16) |
                ((bytes[offset + 3] & 0xFF) << 24);
    }

    private static byte[] toBytes(int value) {
        return new byte[] {
                (byte) (value),
                (byte) (value >>> 8),
                (byte) (value >>> 16),
                (byte) (value >>> 24)
        };
    }

    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }
}

