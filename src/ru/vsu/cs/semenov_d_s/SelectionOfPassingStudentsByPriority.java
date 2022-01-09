package ru.vsu.cs.semenov_d_s;

import ru.vsu.cs.semenov_d_s.utils.ListUtils;

import java.util.*;

public class SelectionOfPassingStudentsByPriority {

    public List<Student> selectPassingStudentsByPriority(List<List<String>> list, int numberOfBudgetPlaces) {
      List<Student> students = ListUtils.toStudentsList(list);
      List<Student> passingStudents = new ArrayList<>();

      students.sort(Comparator.comparingInt(Student::getPhysicsScores));
      students.sort(Comparator.comparingInt(Student::getMathScores));
      students.sort(Comparator.comparingInt(Student::getTotalScores));
      Collections.reverse(students);

        for (Student student : students) {
            if (student.isCertificate() && numberOfBudgetPlaces > 0) {
                passingStudents.add(student);
                numberOfBudgetPlaces--;
            }
        }
        return passingStudents;
    }
}
