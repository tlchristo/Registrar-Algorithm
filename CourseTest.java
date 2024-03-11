
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CourseTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CourseTest
{
    @Test
    public void TestConflictsWithTrue(){
        Course c1 = new Course("CMPU",145,51,"Foundations/Computer Science",1,24,"TRF",720,795,75,"1200PM-0115PM","SP 309","Gomerschdat Anna");
        Course c2 = new Course("CMPU",145,52,"Foundations/Computer Science",1,24,"TRF",780,855,75,"100PM-0215PM","SP 309","Gomerschdat Anna");
        Course c3 = new Course("CMPU",145,53,"Foundations/Computer Science",1,24,"TRF",660,735,75,"1100PM-1215PM","SP 309","Gomerschdat Anna");
        Course c4 = new Course("CMPU",145,54,"Foundations/Computer Science",1,24,"TRF",720,795,75,"1200PM-0115PM","SP 309","Gomerschdat Anna");

        assertTrue(c1.conflictsWith(c2));
        assertTrue(c1.conflictsWith(c3));
        assertTrue(c1.conflictsWith(c4));
    }

    @Test
    public void TestConflictsWithFalse(){
        Course c1 = new Course("CMPU",145,51,"Foundations/Computer Science",1,24,"TRF",720,795,75,"1200PM-0115PM","SP 309","Gomerschdat Anna");
        Course c2 = new Course("CMPU",145,52,"Foundations/Computer Science",1,24,"MW",720,795,75,"1200PM-0115PM","SP 309","Gomerschdat Anna");
        Course c3 = new Course("CMPU",145,53,"Foundations/Computer Science",1,24,"TRF",810,870,75,"0130-0245","SP 309","Gomerschdat Anna");
        Course c4 = new Course("CMPU",145,54,"Foundations/Computer Science",1,24,"TRF",630,705,75,"1030-1145AM","SP 309","Gomerschdat Anna");
        
        assertFalse(c1.conflictsWith(c2));
        assertFalse(c1.conflictsWith(c3));
        assertFalse(c1.conflictsWith(c4));
        
    }
    
    @Test
    public void TestCompareToNotEqual(){
        Course c1 = new Course("CMPU",145,51,"Foundations/Computer Science",1,24,"TRF",720,795,75,"1200PM-0115PM","SP 309","Gomerschdat Anna");
        Course c2 = new Course("CMPU",145,52,"Foundations/Computer Science",1,24,"TRF",720,795,75,"1200PM-0115PM","SP 309","Gomerschdat Anna");
        Course c3 = new Course("CMPU",146,01,"Foundations/Computer Science",1,24,"TRF",780,855,75,"100PM-0215PM","SP 309","Gomerschdat Anna");
        Course c4 = new Course("ART",145,51,"Foundations/Computer Science",1,24,"TRF",660,735,75,"1100PM-1215PM","SP 309","Gomerschdat Anna");
        
        assertTrue(c1.compareTo(c2) < 0);
        assertTrue(c1.compareTo(c3) < 0);
        assertTrue(c1.compareTo(c4) > 0);
    }
    
    @Test
    public void TestCompareToEqual(){
        Course c1 = new Course("CMPU",145,51,"Foundations/Computer Science",1,24,"TRF",720,795,75,"1200PM-0115PM","SP 309","Gomerschdat Anna");
        Course c2 = new Course("CMPU",145,51,"Foundations/Computer Science",1,24,"TRF",720,795,75,"1200PM-0115PM","SP 309","Gomerschdat Anna");
        assertTrue(c1.compareTo(c2) == 0);
    }
}
