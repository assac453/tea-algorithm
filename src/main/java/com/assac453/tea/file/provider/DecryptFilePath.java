package com.assac453.tea.file.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DecryptFilePath extends AbstractFilePathProvider{
    @Value("${file.path.decrypt}")
    private String decryptFilePath;
    @Override
    public String getPath() {
        return decryptFilePath;
    }
}
