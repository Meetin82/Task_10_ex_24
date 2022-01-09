package ru.vsu.cs.semenov_d_s.GUIInterface;

import ru.vsu.cs.semenov_d_s.SelectionOfPassingStudentsByPriority;
import ru.vsu.cs.semenov_d_s.Student;
import ru.vsu.cs.semenov_d_s.utils.JTableUtils;
import ru.vsu.cs.semenov_d_s.utils.ListUtils;
import ru.vsu.cs.semenov_d_s.utils.SwingUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

public class FrameMain extends JFrame{

    private JTable tableOutput;
    private JTable tableInput;
    private JTextField textFieldForAmountPlaces;
    private JButton buttonLoadInputFromFile;
    private JButton buttonRun;
    private JButton buttonSaveInputIntoFile;
    private JButton buttonSaveOutputIntoFile;
    private JPanel panelMain;

    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;


    public FrameMain() {
        this.setTitle("Task_9");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(25, 200, 300, 300);
        this.setResizable(true);
        this.pack();

        JTableUtils.initJTableForArray(tableInput, 175, false, true, true, false);
        JTableUtils.initJTableForArray(tableOutput, 175, false, true, true, false);

        tableInput.setRowHeight(30);
        tableOutput.setRowHeight(30);

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        buttonRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int numberOfBudgetPlaces = Integer.parseInt(textFieldForAmountPlaces.getText());
                    SelectionOfPassingStudentsByPriority selectionOfPassingStudentsByPriority = new SelectionOfPassingStudentsByPriority();
                    String[][] array = JTableUtils.readStringMatrixFromJTable(tableInput);
                    assert array != null;
                    List<List<String>> students = ListUtils.toList2(array);
                    List<Student> passedStudents = selectionOfPassingStudentsByPriority.selectPassingStudentsByPriority(students, numberOfBudgetPlaces);
                    JTableUtils.writeArrayToJTable(tableOutput, ListUtils.toStringArray2(passedStudents));
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        buttonLoadInputFromFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        List<List<String>> list2 = ListUtils.readDataFromFile(fileChooserOpen.getSelectedFile().getPath());

                        JTableUtils.writeArrayToJTable(tableInput, ListUtils.toStringArr2(list2));
                    }
                } catch (Exception exception) {
                    SwingUtils.showErrorMessageBox(exception);
                }
            }
        });

        buttonSaveOutputIntoFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        String[][] str = JTableUtils.readStringMatrixFromJTable(tableOutput);
                        List<List<String>> outputList = ListUtils.toList2(str);
                        String file = fileChooserSave.getSelectedFile().getPath();

                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }

                        ListUtils.writeList2ToFile(file, outputList);
                    }
                } catch (HeadlessException headlessException) {
                    headlessException.printStackTrace();
                    SwingUtils.showErrorMessageBox(headlessException);
                }
            }
        });

        buttonSaveInputIntoFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        String[][] str = JTableUtils.readStringMatrixFromJTable(tableInput);
                        List<List<String>> outputList = ListUtils.toList2(str);
                        String file = fileChooserSave.getSelectedFile().getPath();

                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }

                        ListUtils.writeList2ToFile(file, outputList);
                    }
                } catch (HeadlessException headlessException) {
                    headlessException.printStackTrace();
                    SwingUtils.showErrorMessageBox(headlessException);
                }
            }
        });
    }
}

