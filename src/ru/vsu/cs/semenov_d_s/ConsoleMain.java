package ru.vsu.cs.semenov_d_s;

import ru.vsu.cs.semenov_d_s.utils.ListUtils;

import java.io.PrintStream;
import java.util.List;

public class ConsoleMain {

    public static class CmdParams {
        public String inputFile;
        public String outputFile;
        public int numberOfBudgetPlaces;
        public boolean error;
        public boolean help;
        public boolean window;
    }

    public static CmdParams parseArgs(String[] args) {
        CmdParams params = new CmdParams();
        if (args.length > 0) {
            if (args[0].equals("--help")) {
                params.help = true;
                return params;
            }
            if (args[0].equals("--window")) {
                params.window = true;
                return params;
            }
            if (args.length < 2) {
                params.help = true;
                params.error = true;
                return params;
            }

            params.numberOfBudgetPlaces = Integer.parseInt(args[0]);
            params.inputFile = args[1];

            if (args.length > 2) {
                params.outputFile = args[2];
                return params;
            } else
                params.outputFile = null;
        } else {
            params.help = true;
            params.error = true;
        }
        return params;
    }

    public static void main(String[] args) throws Exception {
        CmdParams params = parseArgs(args);
        SelectionOfPassingStudentsByPriority selectionOfPassingStudentsByPriority = new SelectionOfPassingStudentsByPriority();

        if (params.help) {
            printHelpMessage(params);
        } else if (params.window) {
            GUIMain.winMain();
        } else {
            List<List<String>> list = ListUtils.readDataFromFile(params.inputFile);

            List<Student> passedStudents = selectionOfPassingStudentsByPriority.selectPassingStudentsByPriority(list, params.numberOfBudgetPlaces);

            if (params.outputFile != null) {
                ListUtils.writeList2ToFile(params.outputFile, ListUtils.toList2(ListUtils.toStringArray2(passedStudents)));
            } else {
                ListUtils.writeList2ToConsole(ListUtils.toList2(ListUtils.toStringArray2(passedStudents)));
            }
        }
    }

    private static void printHelpMessage(CmdParams params) {
        PrintStream out = params.error ? System.err : System.out;
        out.println("Usage:");
        out.println("  <cmd> args <placesValue> <input-file> (<output-file>)");
        out.println("  <cmd> --help");
        out.println("  <cmd> --window  // show window");
        System.exit(params.error ? 1 : 0);
    }
}
