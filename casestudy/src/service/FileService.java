package src.service;

import src.exception.FileReadException;
import src.exception.FileWriteException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class FileService implements IFileService {

    @Override
    public String readFile(String fileName) throws FileReadException {
        StringBuilder fileContent = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int count = 0;
            ArrayList<String> contentHeader = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                if (count == 0) {
                    contentHeader = new ArrayList<>(Arrays.asList(line.split(",")));
                    count = 1;
                } else {
                    StringBuilder content = new StringBuilder();
                    ArrayList<String> contentLine = new ArrayList<>(Arrays.asList(line.split(",")));
                    for (int i = 0; i < contentHeader.size(); i++) {
                        content.append(contentHeader.get(i)).append(":").append(contentLine.get(i)).append(", ");
                    }
                    content = new StringBuilder(content.substring(0, content.length() - 2));
                    content.append("\n");
                    fileContent.append(content);
                }
            }
        } catch (IOException e) {
            throw new FileReadException("Lỗi khi đọc file: " + fileName, e);
        }

        return fileContent.toString();
    }

    @Override
    public void writeFile(String fileName, String content) throws FileWriteException  {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(content); // Ghi nội dung vào file
            System.out.println("Ghi file thành công: " + fileName);
        } catch (IOException e) {
            throw new FileWriteException("Lỗi khi ghi file: " + fileName, e);
        }
    }
}
