import java.util.*;

/**
 * Write a description of class RequestLoader here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RequestLoader extends DataLoader
{   
    HashMap<Integer,Student> mapStudents = new HashMap<Integer,Student>();
    HashMap<String,Course> mapCourses = new HashMap<String,Course>();

    /**
     * Constructor creates hashMaps for students and courses.  
     * mapStudents: idNum is the key.
     * mapCourses: courseKey (string) is the key, 
     * 
     * calls the load(file) method in abstract parent class.
     * 
     * @param file: the path to the file.
     * @param students: List of students successfully loaded from file
     * @param courses:  List of courses successfully loaded from file
     */
    public RequestLoader(String file, List<Student> students, List<Course> courses){
        for(Student s : students){
            mapStudents.put(s.idNum, s);
        }

        for(Course c : courses){
            mapCourses.put(c.getKey(),c);
        }

        load(file);
    }

    /**
     * Parse a single line of CSV in the form:
     * studentId, Course 1, course 2, course 3, course 4, course 5, course 6, course 7
     * 999248624,CMPU-145-51,CMPU-145-52,EDUC-361-51,ECON-235-51,PHED-105-51,ECON-235-51,COGS-311-51
     * 
     * Method should 
     * 1) extract the studentId and find the associated Student in mapStudents.
     * 2) extract the courseKey and find the associated Course in mapCourses
     * 3) add the course to the student requests.
     * 
     * @param data: a single line from the csv file.
     * parse
     */
    public void parseAndLoadLine(String data){
        String[] info = data.split(",");
        int studentId = Integer.parseInt(info[0]);
        Student student = mapStudents.get(studentId);
        if (student == null) {
            return;
        }
        for (int i = 1; i < info.length; i++) {
            String courseKey = info[i];
            Course course = mapCourses.get(courseKey);
            if (course == null) {
                continue;
            }
            mapStudents.get(studentId).requests.add(course);
        }
        
    }

    /**
     * Method takes finished hashmap of students with all of their requests and turns
     * it back into a List, sorts it, and returns it.
     * 
     * @return students: list of all students and their requests sorted by drawNumber and Class
     * (as specified in the Student compareTo method task).
     */
    public List<Student> mapStudentRequests(){
        List<Student> students = new ArrayList<Student>();
        students.addAll(mapStudents.values());
        Collections.sort(students);
        return students;
    }
}
