
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

/**
 * The test class StudentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StudentTest
{
    @Test
    public void testComp() {
        Student s1 = new Student("John", 1, 4, 2);
        Student s2 = new Student("Jane", 1, 4, 1);
        Student s3 = new Student("Bob", 1, 3, 1);
        Student s4 = new Student("Sarah", 1, 1, 50);
        List<Student> students = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        RequestLoader loader = new RequestLoader("", students, courses);
        List<Student> studentsR = loader.mapStudentRequests();
        
        assertEquals(studentsR.get(0), s2);

        assertTrue(s1.compareTo(s2) < 0);
        assertTrue(s2.compareTo(s1) > 0);

        assertTrue(s2.compareTo(s3) > 0);
        assertTrue(s3.compareTo(s2) < 0);

        assertTrue(s4.compareTo(s3) < 0);
        assertTrue(s3.compareTo(s4) > 0);
    }
}

