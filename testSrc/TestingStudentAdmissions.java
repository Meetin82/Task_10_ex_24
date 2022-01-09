import org.junit.Assert;
import org.junit.Test;
import ru.vsu.cs.semenov_d_s.SelectionOfPassingStudentsByPriority;
import ru.vsu.cs.semenov_d_s.Student;
import ru.vsu.cs.semenov_d_s.utils.ListUtils;

import java.io.FileNotFoundException;
import java.util.List;

public class TestingStudentAdmissions {
    SelectionOfPassingStudentsByPriority selectionOfPassingStudentsByPriority = new SelectionOfPassingStudentsByPriority();

    @Test
    public void testSelectionOfPassingStudentsByPriority1() throws FileNotFoundException {
        List<List<String>> inputDataForTestInListInOtherList = ListUtils.readDataFromFile("testSrc/TestFiles/inputForStudentAdmissions1.txt");
        int numberOfBudgetPlaces = 3;
        List<List<String>> expectedResult = ListUtils.readDataFromFile("testSrc/TestFiles/answerForStudentAdmissions1.txt");

        List<Student> actualResultInListStudents = selectionOfPassingStudentsByPriority.selectPassingStudentsByPriority(inputDataForTestInListInOtherList, numberOfBudgetPlaces);
        List<List<String>> actualResultInListInOtherList = ListUtils.toList2(ListUtils.toStringArray2(actualResultInListStudents));

        Assert.assertEquals(expectedResult, actualResultInListInOtherList);
    }

    @Test
    public void testSelectionOfPassingStudentsByPriority2() throws FileNotFoundException {
        List<List<String>> inputDataForTestInListInOtherList = ListUtils.readDataFromFile("testSrc/TestFiles/inputForStudentAdmissions2.txt");
        int numberOfBudgetPlaces = 5;
        List<List<String>> expectedResult = ListUtils.readDataFromFile("testSrc/TestFiles/answerForStudentAdmissions2.txt");

        List<Student> actualResultInListStudents = selectionOfPassingStudentsByPriority.selectPassingStudentsByPriority(inputDataForTestInListInOtherList, numberOfBudgetPlaces);
        List<List<String>> actualResultInListInOtherList = ListUtils.toList2(ListUtils.toStringArray2(actualResultInListStudents));

        Assert.assertEquals(expectedResult, actualResultInListInOtherList);
    }

    @Test
    public void testSelectionOfPassingStudentsByPriority3() throws FileNotFoundException {
        List<List<String>> inputDataForTestInListInOtherList = ListUtils.readDataFromFile("testSrc/TestFiles/inputForStudentAdmissions3.txt");
        int numberOfBudgetPlaces = 2;
        List<List<String>> expectedResult = ListUtils.readDataFromFile("testSrc/TestFiles/answerForStudentAdmissions3.txt");

        List<Student> actualResultInListStudents = selectionOfPassingStudentsByPriority.selectPassingStudentsByPriority(inputDataForTestInListInOtherList, numberOfBudgetPlaces);
        List<List<String>> actualResultInListInOtherList = ListUtils.toList2(ListUtils.toStringArray2(actualResultInListStudents));

        Assert.assertEquals(expectedResult, actualResultInListInOtherList);
    }

    @Test
    public void testSelectionOfPassingStudentsByPriority4() throws FileNotFoundException {
        List<List<String>> inputDataForTestInListInOtherList = ListUtils.readDataFromFile("testSrc/TestFiles/inputForStudentAdmissions4.txt");
        int numberOfBudgetPlaces = 2;
        List<List<String>> expectedResult = ListUtils.readDataFromFile("testSrc/TestFiles/answerForStudentAdmissions4.txt");

        List<Student> actualResultInListStudents = selectionOfPassingStudentsByPriority.selectPassingStudentsByPriority(inputDataForTestInListInOtherList, numberOfBudgetPlaces);
        List<List<String>> actualResultInListInOtherList = ListUtils.toList2(ListUtils.toStringArray2(actualResultInListStudents));

        Assert.assertEquals(expectedResult, actualResultInListInOtherList);
    }

    @Test
    public void testSelectionOfPassingStudentsByPriority5() throws FileNotFoundException {
        List<List<String>> inputDataForTestInListInOtherList = ListUtils.readDataFromFile("testSrc/TestFiles/inputForStudentAdmissions5.txt");
        int numberOfBudgetPlaces = 2;
        List<List<String>> expectedResult = ListUtils.readDataFromFile("testSrc/TestFiles/answerForStudentAdmissions5.txt");

        List<Student> actualResultInListStudents = selectionOfPassingStudentsByPriority.selectPassingStudentsByPriority(inputDataForTestInListInOtherList, numberOfBudgetPlaces);
        List<List<String>> actualResultInListInOtherList = ListUtils.toList2(ListUtils.toStringArray2(actualResultInListStudents));

        Assert.assertEquals(expectedResult, actualResultInListInOtherList);
    }
}
