package format_mac_to;

import java.util.List;
import java.util.regex.Pattern;

public class FormatMacToDot4  extends FormatMacTo{
    public FormatMacToDot4(List<StringBuffer> buffers) {
        super(buffers, (char)'.');
        super.patternMac = Pattern.compile("([0-9A-Fa-f]{4})([0-9A-Fa-f]{4})([0-9A-Fa-f]{4})");
    }
}
