package format_mac_to;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatMacTo implements FormatMacToInterface {
    private List<StringBuffer> buffers;
    private char delimiter;
    Pattern patternMac ;

    public FormatMacTo(List<StringBuffer> buffers, char delimiter) {
        this.buffers = buffers;
        this.delimiter = delimiter;
    }

    @Override
    public List<StringBuffer> formatMac () {
        Matcher matcher;
        List<StringBuffer> newText = new ArrayList<StringBuffer>();
        for (StringBuffer buffer : buffers) {
            StringBuffer sb = new StringBuffer();

            if ((matcher = patternMac.matcher(buffer)).find()) {
                for (int i = 1; i <= matcher.groupCount(); i++) {
                    sb.append(matcher.group(i));
                    if (i != matcher.groupCount())
                        sb.append(delimiter);

                }
                newText.add(sb);
            }
        }
        return newText;
    }
}
