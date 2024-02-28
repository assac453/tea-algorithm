package com.assac453.tea.algorithm;

public class TinyEncryptionAlgorithm {

    protected static int DELTA = 0x9e3779b9; // is (Math.sqrt(5) - 1) * Math.pow(2, 31) - from golden ration

    protected static int ROUNDS = 32;
    protected int sum;

    protected int[] key;

    public TinyEncryptionAlgorithm(int key[]) {
        this.key = new int[4];
        this.key[0] = key[0];
        this.key[1] = key[1];
        this.key[2] = key[2];
        this.key[3] = key[3];
    }

    public TinyEncryptionAlgorithm() {
        this.key = null;
    }
}
