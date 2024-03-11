import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class StudentLoader here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StudentLoader extends DataLoader
{
    public List<Student> students = new ArrayList<Student>();
    /**
     * Constructor calls the load(file) method in abstract parent class.
     * 
     * @param file: the path to the file.
     */
    public StudentLoader(String file){
        load(file);
    }

    /**
     * Parse a single line of CSV in the form:
     * Name, idNum, gradYear, drawNummber
     * Hector Tran,999248624,2023,1
     * 
     * Method should create a new Student Object and add it to 
     * the students instance variable.
     * 
     * @param data: a single line from the csv file.
     */
    public void parseAndLoadLine(String data) {
        try{
            String[] info = data.split(",");
            String name = info[0];
            int idNum = Integer.parseInt(info[1]);
            int gradYear = Integer.parseInt(info[2]);
            int drawNumber = Integer.parseInt(info[3]);

            Student student = new Student(name, idNum, gradYear, drawNumber);
            students.add(student);
        }catch(IndexOutOfBoundsException e){
            System.out.println("Index out of bounds");
        }catch(IllegalArgumentException e){
            System.out.println("Wrong input");
        }
    }

    /**
     * Easy getter method to return the completed student roster.
     * @return students: the roster in the form of a List<Student>
     */
    public List<Student> getStudents(){
        return students;
    }

}
