package org.geekheight.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileOperation {
    public static String readFileAsString(String fileName) throws FileNotFoundException {
        InputStream inputStream = FileOperation.class.getClassLoader().getResourceAsStream(fileName);
        if (inputStream != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                    stringBuilder.append("\n");
                }
                return stringBuilder.toString();
            } catch (Exception e) {
                throw new FileNotFoundException();
            }
        } else {
            throw new FileNotFoundException();
        }
    }
}

