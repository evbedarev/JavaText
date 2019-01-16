package format_mac_from;

import java.util.regex.Pattern;

/**
 * read lines from source file, find ip and mac-address ('xx:xx:xx:xx.xx:xx')
 * format mac address from view 'xx:xx:xx:xx.xx:xx' to view 'xxxxxxxxxxxx'
 */
public class FormatMacFromColon2 extends FormatMacFrom{
    public FormatMacFromColon2(String sourceFile) {
        super(sourceFile);
        super.patternMac = Pattern.compile("([0-9A-Fa-f]{2}):([0-9A-Fa-f]{2}):([0-9A-Fa-f]{2}):([0-9A-Fa-f]{2}):([0-9A-Fa-f]{2}):([0-9A-Fa-f]{2})");
    }
}
