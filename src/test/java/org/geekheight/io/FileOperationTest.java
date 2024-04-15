package org.geekheight.io;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileOperationTest {
    @Test
    public void readFileAsStringShouldReturnFileContent() throws FileNotFoundException {
        String fileName = "test-file.txt";
        String expectedContent = """
                This is a test file content.
                It has multiple lines.
                """;
        String fileContent = FileOperation.readFileAsString(fileName);
        assertEquals(expectedContent, fileContent);
    }

    @Test
    public void readFileAsStringShouldThrowFileNotFoundExceptionForNonExistentFile() {
        String nonExistentFileName = "non-existent-file.txt";
        assertThrows(FileNotFoundException.class, () -> FileOperation.readFileAsString(nonExistentFileName));
    }
}
