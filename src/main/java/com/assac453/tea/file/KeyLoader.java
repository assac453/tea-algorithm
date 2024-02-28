package com.assac453.tea.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class KeyLoader {

    @Value("${file.path.key}")
    private String keyFilePath;

    public int[] loadKeyFromFile() {
        String filePath = keyFilePath;
        List<Integer> keyList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Пропускаем пустые строки
                if (!line.trim().isEmpty()) {
                    keyList.add(Integer.parseInt(line.trim()));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Преобразуем список в массив
        int[] keyArray = new int[keyList.size()];
        for (int i = 0; i < keyList.size(); i++) {
            keyArray[i] = keyList.get(i);
        }
        return keyArray;
    }
}
