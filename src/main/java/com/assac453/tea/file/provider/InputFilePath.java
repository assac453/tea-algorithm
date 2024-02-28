package com.assac453.tea.file.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class InputFilePath extends AbstractFilePathProvider{
    @Value("${file.path.input}")
    private String inputFilePath;
    @Override
    public String getPath() {
        return inputFilePath;
    }
}
