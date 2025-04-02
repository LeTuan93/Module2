package src.service;

import src.exception.FileReadException;
import src.exception.FileWriteException;

public interface IFileService {
    public String readFile(String fileName) throws FileReadException;
    public void writeFile(String fileName, String content) throws FileWriteException;
}
