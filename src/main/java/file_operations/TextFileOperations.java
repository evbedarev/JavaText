package file_operations;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileOperations {
    private int c;
    private char ch;
    private String pathFile;
    private List<StringBuffer> textByLine = new ArrayList<StringBuffer>();
    private StringBuffer stringBuffer = new StringBuffer();

    public TextFileOperations(String pathFile) throws Exception{
        this.pathFile = pathFile;
    }

    public List<StringBuffer> readLines() throws IOException {
        try (FileReader fileReader = new FileReader(pathFile)) {
            while ((c = fileReader.read()) != -1) {
                ch = (char) c;
                if (ch == '\n') {
                    textByLine.add(stringBuffer);
                    stringBuffer = new StringBuffer();
                } else {
                    stringBuffer.append(ch);
                }
            }
        }
        return textByLine;
    }

    public void writeLinesToFile(String pathFile, List<StringBuffer> line) throws Exception{
        try (FileWriter fileWriter = new FileWriter(pathFile)) {
            for (StringBuffer buffer : line) {
                for (int i = 0; i < buffer.length(); i++) {
                    fileWriter.write(buffer.charAt(i));
                }
                fileWriter.write('\r');
                fileWriter.write('\n');
            }
        }
    }
}
