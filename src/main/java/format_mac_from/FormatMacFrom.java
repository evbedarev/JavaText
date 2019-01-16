package format_mac_from;

import file_operations.TextFileOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class FormatMacFrom implements FormatMacInterface {
    private String sourceFile;
    Pattern patternMac ;

    public FormatMacFrom(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    @Override
    public List<StringBuffer> writeFormatedMacToFile() throws Exception {
        TextFileOperations readTextFile = new TextFileOperations(sourceFile);
        List<StringBuffer> text = readTextFile.readLines();
        List<StringBuffer> newText = new ArrayList<StringBuffer>();
        Matcher matcher;

        for (StringBuffer stringBuffer : text) {
            StringBuffer sb = new StringBuffer();
            if ((matcher = patternMac.matcher(stringBuffer)).find()) {
                for (int i = 1; i <= matcher.groupCount(); i++) {
                        sb.append(matcher.group(i));
                }
                newText.add(sb);
            }
        }
        return newText;
    }

}
