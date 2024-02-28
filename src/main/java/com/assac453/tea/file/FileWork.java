package com.assac453.tea.file;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class FileWork {
    public byte[] readFile(String filePath) {
        File file = new File(filePath);
        byte[] data = new byte[(int) file.length()];
        try(FileInputStream fis = new FileInputStream(file);) {
            fis.read(data);
        } catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }

    public void saveToFile(byte[] data, String pathToFile){
        try(FileOutputStream fos = new FileOutputStream(pathToFile)) {
            fos.write(data);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
