package format_mac.maint;

import format_mac.format_mac_from.FormatMacFromDot4;
import format_mac.format_mac_from.FormatMacFromMinus2;
import format_mac.format_mac_from.FormatMacInterface;
import format_mac.format_mac_to.FormatMacToColon2;
import format_mac.format_mac_to.FormatMacToDot4;
import format_mac.format_mac_to.FormatMacToInterface;

import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        List<StringBuffer> sb;
        FormatMacInterface fm = new FormatMacFromDot4("/home/mj/text.txt");
        sb = fm.writeFormatedMacToFile();
        for (StringBuffer stringBuffer : sb) {
            System.out.println(stringBuffer.toString());
        }

        FormatMacInterface fmr = new FormatMacFromMinus2("/home/mj/text.txt");
        sb = fmr.writeFormatedMacToFile();
        for (StringBuffer stringBuffer : sb) {
            System.out.println(stringBuffer.toString()) ;
        }

        FormatMacToInterface formatMacToDot4 = new FormatMacToDot4(sb);
        List<StringBuffer> sb1 = formatMacToDot4.formatMac();
        for (StringBuffer stringBuffer : sb1) {
            System.out.println(stringBuffer.toString()) ;
        }

        FormatMacToInterface formatMacToColon2 = new FormatMacToColon2(sb);
        sb1 = formatMacToColon2.formatMac();
        for (StringBuffer stringBuffer : sb1) {
            System.out.println(stringBuffer.toString()) ;
        }

    }
}
