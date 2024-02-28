package com.assac453.tea.file.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EncryptFilePath extends AbstractFilePathProvider{
    @Value("${file.path.encrypt}")
    private String encryptFilePath;
    @Override
    public String getPath() {
        return encryptFilePath;
    }
}
