package com.assac453.tea.file.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KeyFilePath extends AbstractFilePathProvider{
    @Value("${file.path.key}")
    private String keyFilePath;
    @Override
    public String getPath() {
        return null;
    }
}
