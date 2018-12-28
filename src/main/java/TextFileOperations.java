import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileOperations {
    private FileReader fileReader;
    private int c;
    private char ch;
    private List<StringBuffer> textByLine = new ArrayList<StringBuffer>();
    private StringBuffer stringBuffer = new StringBuffer();

    public TextFileOperations(String pathFile) throws Exception{
        fileReader = new FileReader(pathFile);
    }

    public List<StringBuffer> readLines() throws IOException {
        while ((c = fileReader.read()) != -1) {
            ch = (char) c;
            if (ch == '\n') {
                textByLine.add(stringBuffer);
                stringBuffer = new StringBuffer();
            } else {
                stringBuffer.append(ch);
            }
        }
        return textByLine;
    }

    public void writeLinesToFile(String pathFile, List<StringBuffer> line) throws Exception{
        FileWriter fileWriter = new FileWriter(pathFile);
        for (StringBuffer buffer : line) {
            for (int i=0; i < buffer.length(); i++) {
                fileWriter.write(buffer.charAt(i));
            }
            fileWriter.write('\r');
            fileWriter.write('\n');
        }
        fileWriter.close();
    }
}
