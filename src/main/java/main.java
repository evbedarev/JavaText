import file_operations.TextFileOperations;
import format_mac_from.FormatMacFromColon2;
import format_mac_from.FormatMacFromDot4;
import format_mac_from.FormatMacFromMinus2;
import format_mac_from.FormatMacInterface;
import format_mac_to.FormatMacToColon2;
import format_mac_to.FormatMacToDot4;
import format_mac_to.FormatMacToInterface;
import format_mac_to.FormatMacToMinus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class main {
    public static void main(String[] args) throws Exception{

        if (!new File(args[1]).exists()) {
            throw new FileNotFoundException();
        }

        if (!args[0].equals("xx:")&&!args[0].equals("xx-")&&!args[0].equals("xxxx.")) {
            throw new IllegalAccessException();
        }

        System.out.println(args[2]);

//        if (!new File(args[2]).exists()) {
//            throw new FileNotFoundException();
//        }

        if (!args[2].equals("xx:") && !args[2].equals("xx-") && !args[2].equals("xxxx.")) {
            throw new IllegalAccessException();
        }

        List<StringBuffer> sb;
        FormatMacInterface inputMac = null;
        FormatMacToInterface outputMac = null;

        System.out.println(args[0]);

        if (args[0].equals("xx:")) {
            inputMac = new FormatMacFromColon2(args[1]);
        }

        if (args[0].equals("xx-")) {
            inputMac = new FormatMacFromMinus2(args[1]);
        }

        if (args[0].equals("xxxx.")) {
            inputMac = new FormatMacFromDot4(args[1]);
        }

        if (inputMac == null) throw new NullPointerException();

        sb = inputMac.writeFormatedMacToFile();

        if (args[2].equals("xx:")) {
            outputMac = new FormatMacToColon2(sb);
        }

        if (args[2].equals("xx-")) {
            outputMac = new FormatMacToMinus(sb);
        }

        if (args[2].equals("xxxx.")) {
            outputMac = new FormatMacToDot4(sb);
        }

        sb = outputMac.formatMac();

        TextFileOperations textFileOperations = new TextFileOperations(args[3]);
        textFileOperations.writeLinesToFile(args[3], sb);
    }
}
