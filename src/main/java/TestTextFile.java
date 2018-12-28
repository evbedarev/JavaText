import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestTextFile {
    public static void main(String[] args) throws Exception {

        Pattern pattern = Pattern.compile("([0-9A-Fa-f]{2})([0-9A-Fa-f]{2})\\.([0-9A-Fa-f]{2})([0-9A-Fa-f]{2})\\.([0-9A-Fa-f]{2})([0-9A-Fa-f]{2})");
        TextFileOperations readTextFile = new TextFileOperations("C:\\TEMP\\mac.txt");
        List<StringBuffer> text = readTextFile.readLines();
        List<StringBuffer> newText = new ArrayList<StringBuffer>();


        for (StringBuffer stringBuffer : text) {
            Matcher matcher = pattern.matcher(stringBuffer);
            StringBuffer sb = new StringBuffer();
            if (matcher.find()) {
                System.out.println(matcher.group());
                for (int i = 1; i < 7; i++) {
                    sb.append(matcher.group(i));
                    if (i != 6)
                        sb.append("-");
                }
            }
            newText.add(sb);
        }

        readTextFile.writeLinesToFile("C:\\TEMP\\copy_mac.txt", newText);
    }
}
