package com.assac453.tea.algorithm;

public class ECBAlgorithm extends TinyEncryptionAlgorithm {
    public ECBAlgorithm(){
        super();
    }

    public ECBAlgorithm(int[] key){
        super(key);
    }

    public int[] encrypt(int[] plainText){
        if (key == null) {
            throw new RuntimeException("Key is null.");
        }
        int[] block = new int[2];
        int left = plainText[0];
        int right = plainText[1];

        sum = 0;

        for (int i = 0; i < ROUNDS; i++) {
            sum += DELTA;
            left += ((right << 4) + key[0]) ^ (right + sum) ^ ((right >> 5) + key[1]);
            right += ((left << 4) + key[2]) ^ (left + sum) ^ ((left >> 5) + key[3]);
        }

        block[0] = left;
        block[1] = right;

        return block;
    }
    public int[] decrypt(int[] cypherText){
        if (key == null) {
            throw new RuntimeException("Key is null.");
        }
        int[] block = new int[2];


        int left = cypherText[0];
        int right = cypherText[1];

        sum = DELTA << 5;

        for (int i = 0; i < ROUNDS; i++) {
            right -= ((left << 4) + key[2]) ^ (left + sum) ^ ((left >> 5) + key[3]);
            left -= ((right << 4) + key[0]) ^ (right + sum) ^ ((right >> 5) + key[1]);
            sum -= DELTA;
        }

        block[0] = left;
        block[1] = right;

        return block;
    }
}
