package com.assac453.tea;

import com.assac453.tea.file.FileManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EncryptTests {
    @Autowired
    private FileManager manager;
    @Test
    void FileManager_Encrypt_ShouldEncryptFile(){
        manager.encrypt();
        manager.decrypt();
    }

}
