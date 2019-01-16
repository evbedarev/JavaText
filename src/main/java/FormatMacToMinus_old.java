import file_operations.TextFileOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * read lines from source file, find ip and mac-address ('xxxx.xxxx.xxxx')
 * format mac address from view 'xxxx.xxxx.xxxx' to view 'xx-xx-xx-xx-xx-xx'
 * write to consumer file lines type 'ip;mac-address'
 */

public class FormatMacToMinus_old {
    public static String sourceFile = "C:\\TEMP\\mac_not_formated.txt";
    public static String consumerFile = "C:\\TEMP\\copy_mac.txt";

    public FormatMacToMinus_old(String sourceFile, String consumerFile) {
        FormatMacToMinus_old.sourceFile = sourceFile;
        FormatMacToMinus_old.consumerFile = consumerFile;

    }

    public Matcher findMac(StringBuffer stringBuffer) {
        Pattern patternMac = Pattern.compile("([0-9A-Fa-f]{2})([0-9A-Fa-f]{2})\\.([0-9A-Fa-f]{2})([0-9A-Fa-f]{2})\\.([0-9A-Fa-f]{2})([0-9A-Fa-f]{2})");
        return patternMac.matcher(stringBuffer);
    }


    public void writeFormatedMacToFile() throws Exception {
        TextFileOperations readTextFile = new TextFileOperations(sourceFile);
        List<StringBuffer> text = readTextFile.readLines();
        List<StringBuffer> newText = new ArrayList<StringBuffer>();
        Matcher matcher;

        for (StringBuffer stringBuffer : text) {
            StringBuffer sb = new StringBuffer();

            if ((matcher = findMac(stringBuffer)).find()) {
                System.out.println(matcher.group());
                for (int i = 1; i < 7; i++) {
                    sb.append(matcher.group(i));
                    if (i != 6)
                        sb.append("-");
                }
            }
            newText.add(sb);
        }
        readTextFile.writeLinesToFile(consumerFile, newText);
    }

//    public List<StringBuffer> formatMacList() {
//
//    }
}
