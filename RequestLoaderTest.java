

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

/**
 * The test class RequestLoaderTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RequestLoaderTest
{
    @Test
    public void testRequestLoader() {
        List<Student> students = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        Student zoe = new Student("1",1,1,1);
        Student tristan = new Student("2",2,2,2);
        students.add(zoe);
        students.add(tristan);
        
        Course c1 = new Course("1",1,1,"1",1.0,1,"1",1,1,1,"1","1","1");
        Course c2 = new Course("2",1,1,"1",1.0,1,"1",1,1,1,"1","1","1");
        Course c3 = new Course("3",1,1,"1",1.0,1,"1",1,1,1,"1","1","1");
        Course c4 = new Course("4",1,1,"1",1.0,1,"1",1,1,1,"1","1","1");
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
        courses.add(c4);
        
        RequestLoader loader = new RequestLoader("", students, courses);
        
        loader.parseAndLoadLine("1,1-1-1,2-1-1,3-1-1,4-1-1");
    
        List<Student> studentRequests = loader.mapStudentRequests();
        
        Student s1 = studentRequests.get(0);
        Student s2 = studentRequests.get(1);
        
        List<Course> requests = s1.requests;

        
        assertEquals(4, requests.size());
        assertTrue(requests.contains(c1));
        assertTrue(requests.contains(c2));
        
        
        assertEquals(2, studentRequests.size());
        assertEquals(zoe, studentRequests.get(0));
        assertEquals(tristan, studentRequests.get(1));
        
        
    }
}
