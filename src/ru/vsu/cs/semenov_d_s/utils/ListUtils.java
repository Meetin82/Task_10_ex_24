package ru.vsu.cs.semenov_d_s.utils;

import ru.vsu.cs.semenov_d_s.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ListUtils {

    public static List<Student> toStudentsList(List<List<String>> list) {
        List<Student> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            newList.add(i, new Student(list.get(i)));
        }
        return newList;
    }

    private static List<String> readLinesFromFile(String fileName) throws FileNotFoundException {
        List<String> lines;
        try (Scanner scanner = new Scanner(new File(fileName), "UTF-8")) {
            lines = new ArrayList<>();
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }
        }
        return lines;
    }

    public static List<List<String>> readDataFromFile(String fileName) throws FileNotFoundException {
        List<String> lines = readLinesFromFile(fileName);
        List<List<String>> students = new ArrayList<>();
        for (String line : lines) {
            List<String> student = new ArrayList<>();
            String[] arr = line.split(" - ");
            student.add(arr[0]);
            String[] newArr = arr[1].split(", ");
            student.addAll(Arrays.asList(newArr));

            students.add(student);
        }
        return students;
    }

    public static String[][] toStringArray2(List<Student> list) {
        String[][] newArray = new String[list.size()][5];
            for (int i = 0; i < list.size(); i++) {
                newArray[i][0] = list.get(i).getFullName();

                String availabilityOfCertificate;
                if (list.get(i).isCertificate()) {
                    availabilityOfCertificate = "есть";
                } else {
                    availabilityOfCertificate = "нет";
                }

                newArray[i][1] = availabilityOfCertificate;
                newArray[i][2] = String.valueOf(list.get(i).getMathScores());
                newArray[i][3] = String.valueOf(list.get(i).getPhysicsScores());
                newArray[i][4] = String.valueOf(list.get(i).getRusScores());
            }
        return newArray;
    }

    public static List<List<String>> toList2(String[][] array) {
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            List<String> tempList = new ArrayList<>();
            for (int j = 0; j < array[0].length; j++) {
                tempList.add(array[i][j]);
            }
            list.add(tempList);
        }
        return list;
    }

    public static String[][] toStringArr2(List<List<String>> list) {
        String[][] result = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = toStringArr(list.get(i));
        }
        return result;
    }

    public static String[] toStringArr(List<String> list) {
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void writeList2ToFile(String fileName, List<List<String>> list) {
        try (PrintWriter out = new PrintWriter(fileName)) {
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.get(i).size(); j++) {
                    String str = "";
                        str += list.get(i).get(j);
                        out.print(str);
                    if (j == 0) {
                        out.print(" - ");
                    } else if (j != list.get(i).size() - 1) {
                        out.print(", ");
                    }
                }
                out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeList2ToConsole(List<List<String>> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                String str = "";
                str += list.get(i).get(j);
                System.out.print(str);
                if (j == 0) {
                    System.out.print(" - ");
                } else if (j != list.get(i).size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
