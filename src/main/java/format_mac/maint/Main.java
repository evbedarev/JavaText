package format_mac.maint;

import format_mac.file_operations.TextFileOperations;
import format_mac.format_mac_from.FormatMacFromColon2;
import format_mac.format_mac_from.FormatMacFromDot4;
import format_mac.format_mac_from.FormatMacFromMinus2;
import format_mac.format_mac_from.FormatMacInterface;
import format_mac.format_mac_to.FormatMacToColon2;
import format_mac.format_mac_to.FormatMacToDot4;
import format_mac.format_mac_to.FormatMacToInterface;
import format_mac.format_mac_to.FormatMacToMinus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        if (args[0].equals("man")) {
            System.out.println("This is man page.\n\r" +
                    "--------------------------------------------------------\n\r" +
                    "java -jar format.jar xx <path to file> yy <path to file> \n\r"+
                    "--------------------------------------------------------\n\r" +
                    "xx - это исходный формат мак адреса.\n\r" +
                    "Возможные значения:\n\r" +
                    "xxxx. исходный мак адрес фората xxxx.xxxx.xxxx\n\r" +
                    "xx: исходный мак адрес фората xx:xx:xx:xx:xx:xx\n\r" +
                    "xx- исходный мак адрес фората xx-xx-xx-xx-xx-xx\n\r" +
                    "\n\r" +
                    "Второй параметр путь к исходному файлу\n\r" +
                    "\n\r" +
                    "yy - формат мак адреса который хоти получить.\n\r" +
                    "xxxx. исходный мак адрес фората xxxx.xxxx.xxxx\n\r" +
                    "xx: исходный мак адрес фората xx:xx:xx:xx:xx:xx\n\r" +
                    "xx- исходный мак адрес фората xx-xx-xx-xx-xx-xx\n\r"+
                    "\n\r" +
                    "Четвертый параметр - путь к новому файлу, создаваемому после форатирования\n\r"
                    );
            return;
        }

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
