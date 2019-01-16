package format_mac_to;

import java.util.List;
import java.util.regex.Pattern;

public class FormatMacToMinus extends FormatMacTo{
    public FormatMacToMinus(List<StringBuffer> buffers) {
        super(buffers, '-');
        super.patternMac = Pattern.compile("([0-9A-Fa-f]{2})([0-9A-Fa-f]{2})([0-9A-Fa-f]{2})([0-9A-Fa-f]{2})([0-9A-Fa-f]{2})([0-9A-Fa-f]{2})");
    }
}
