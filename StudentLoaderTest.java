

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class StudentLoaderTest
{
    @Test
    public void testCorrectness() {
        String H = "Hector Tran,999248624,2023,1";
        String A = "Anthony Smith,999123456,2022,2";
        String B = "Bob Smith,999987654,2022,3";
        
        StudentLoader loader = new StudentLoader(H+"\n"+A+"\n"+B);

        loader.parseAndLoadLine(H);
        loader.parseAndLoadLine(A);
        loader.parseAndLoadLine(B);
        List<Student> students = loader.getStudents();

        assertEquals(3, students.size());
        Student student1 = students.get(0);
        assertEquals("Hector Tran", student1.name);
        assertEquals(999248624, student1.idNum);
        assertEquals(2023, student1.gradYear);
        assertEquals(1, student1.drawNumber);

        Student student2 = students.get(1);
        assertEquals("Anthony Smith", student2.name);
        assertEquals(999123456, student2.idNum);
        assertEquals(2022, student2.gradYear);
        assertEquals(2, student2.drawNumber);

        Student student3 = students.get(2);
        assertEquals("Bob Smith", student3.name);
        assertEquals(999987654, student3.idNum);
        assertEquals(2022, student3.gradYear);
        assertEquals(3, student3.drawNumber);
    }   
    @Test
    public void testIncorrectInput() {
        String H = "Hector Tran,2023,1";
        String A = "Anthony Smith,999123456,2";
        String B = "Bob Smith,999987654,2022,3";
        
        StudentLoader loader = new StudentLoader(H+"\n"+A+"\n"+B);

        loader.parseAndLoadLine(H);
        loader.parseAndLoadLine(A);
        loader.parseAndLoadLine(B);
        List<Student> students = loader.getStudents();
        assertEquals(1, students.size());
        
        Student student3 = students.get(0);
        assertEquals("Bob Smith", student3.name);
        assertEquals(999987654, student3.idNum);
        assertEquals(2022, student3.gradYear);
        assertEquals(3, student3.drawNumber);
    }
}
