import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestTextFile {
    public static void main(String[] args) throws Exception {

        Pattern patternMac = Pattern.compile("([0-9A-Fa-f]{2})([0-9A-Fa-f]{2})\\.([0-9A-Fa-f]{2})([0-9A-Fa-f]{2})\\.([0-9A-Fa-f]{2})([0-9A-Fa-f]{2})");
        Pattern patternIP =  Pattern.compile("([0-9]{3}\\.[0-9]{2}\\.[0-9]{2,3}\\.[0-9]{1,3})");
        TextFileOperations readTextFile = new TextFileOperations("C:\\TEMP\\mac_not_formated.txt");
        List<StringBuffer> text = readTextFile.readLines();
        List<StringBuffer> newText = new ArrayList<StringBuffer>();


        for (StringBuffer stringBuffer : text) {
            Matcher matcherMac = patternMac.matcher(stringBuffer);
            Matcher matcherIP = patternIP.matcher(stringBuffer);
            StringBuffer sb = new StringBuffer();

            if (matcherIP.find()) {
                sb.append(matcherIP.group());
                sb.append(";");
            }

            if (matcherMac.find()) {
                System.out.println(matcherMac.group());
                for (int i = 1; i < 7; i++) {
                    sb.append(matcherMac.group(i));
                    if (i != 6)
                        sb.append("-");
                }
            }
            newText.add(sb);
        }

        readTextFile.writeLinesToFile("C:\\TEMP\\copy_mac.txt", newText);
    }
}
