

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

/**
 * The test class CourseUnitTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CourseLoaderTest
{
    @Test
    public void testCorrectness() {
        String c = "CMPU,145,51,Foundations/Computer Science,1,24,TRF,720,795,75,1200PM-0115PM,SP 309,Gomerschdat Anna";
        CourseLoader loader = new CourseLoader(c);
        loader.parseAndLoadLine(c);
        
        List<Course> courses = loader.getCourses();

        assertEquals(1, courses.size());
        Course course1 = courses.get(0);
        
        assertEquals("CMPU", course1.dept);
        assertEquals(145, course1.courseNum);
        assertEquals(51, course1.section);
        assertEquals("Foundations/Computer Science", course1.title);
        assertEquals(1.0, course1.credits, 0.001);
        assertEquals(24, course1.maxEnrollment);
        assertEquals("TRF", course1.daysOfTheWeek);
        assertEquals(720, course1.startTime);
        assertEquals(795, course1.endTime);
        assertEquals(75, course1.duration);
        assertEquals("1200PM-0115PM", course1.timeString);
        assertEquals("SP 309", course1.loc);
        assertEquals("Gomerschdat Anna", course1.instructor);
    }   
    @Test
    public void testIncorrectInput() {
        String c = "145,51,Foundations/Computer Science,1,24,TRF,720,795,75,1200PM-0115PM,SP 309,Gomerschdat Anna";
        CourseLoader loader = new CourseLoader(c);
        loader.parseAndLoadLine(c);
        
        List<Course> courses = loader.getCourses();

        assertEquals(0, courses.size());
        
    }
}