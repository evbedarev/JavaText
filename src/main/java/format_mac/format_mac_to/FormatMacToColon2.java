package format_mac.format_mac_to;

import java.util.List;
import java.util.regex.Pattern;

public class FormatMacToColon2 extends FormatMacTo{
    public FormatMacToColon2(List<StringBuffer> buffers) {
        super(buffers, ':');
        super.patternMac = Pattern.compile("([0-9A-Fa-f]{2})([0-9A-Fa-f]{2})([0-9A-Fa-f]{2})([0-9A-Fa-f]{2})([0-9A-Fa-f]{2})([0-9A-Fa-f]{2})");
    }
}
