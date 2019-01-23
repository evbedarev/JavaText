package format_mac.format_mac_from;

import java.util.regex.Pattern;

/**
 * read lines from source file, find ip and mac-address ('xxxx.xxxx.xxxx')
 * format mac address from view 'xxxx.xxxx.xxxx' to view 'xxxxxxxxxxxx'
 */

public class FormatMacFromDot4 extends FormatMacFrom {
    public FormatMacFromDot4(String sourceFile) {
        super(sourceFile);
        super.patternMac = Pattern.compile("([0-9A-Fa-f]{2})([0-9A-Fa-f]{2})\\.([0-9A-Fa-f]{2})([0-9A-Fa-f]{2})\\.([0-9A-Fa-f]{2})([0-9A-Fa-f]{2})");
    }
}
