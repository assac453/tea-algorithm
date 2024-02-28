package com.assac453.tea.file;

import com.assac453.tea.file.provider.DecryptFilePath;
import com.assac453.tea.file.provider.EncryptFilePath;
import com.assac453.tea.file.provider.InputFilePath;
import com.assac453.tea.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FileManager {

    private final InputFilePath inputFilePath;
    private final EncryptFilePath encryptFilePath;
    private final DecryptFilePath decryptFilePath;
    private final FileService fileService;

    public void encrypt(){
        fileService.encrypt(inputFilePath.getPath(), encryptFilePath.getPath());
    }
    public void decrypt(){
        fileService.decrypt(encryptFilePath.getPath(), decryptFilePath.getPath());
    }
}
