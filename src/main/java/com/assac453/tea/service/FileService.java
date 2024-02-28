package com.assac453.tea.service;

import com.assac453.tea.algorithm.TEA_ECB;
import com.assac453.tea.file.FileWork;
import com.assac453.tea.file.KeyLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FileService {

    private final FileWork fileWork;
    private final KeyLoader keyLoader;
    public void encrypt(String inputFileName, String encryptedFileName) {
        byte[] fileContent = fileWork.readFile(inputFileName);
        int[] key = keyLoader.loadKeyFromFile();
        byte[] encryptedContent = TEA_ECB.tea_ecb_encrypt(fileContent, key);
        fileWork.saveToFile(encryptedContent, encryptedFileName);
    }

    public void decrypt(String encryptedFileName, String decryptedFileName) {
        byte[]  fileContent = fileWork.readFile(encryptedFileName);
        int[] key = keyLoader.loadKeyFromFile();
        byte[] decryptedContent = TEA_ECB.tea_ecb_decrypt(fileContent, key);
        fileWork.saveToFile(decryptedContent, decryptedFileName);
    }
}
