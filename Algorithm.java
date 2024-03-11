import java.util.*;

/**
 * Write a description of class Algorithm here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Algorithm{
    public Map<Integer, PriorityQueue<Student>> classOf;
    public Map<Integer, Stack<Student>> reversedClassOf;
    public HashMap<Course, Integer> enrollment;
    public List<Student> mapStudents;

    public Algorithm(List<Student> mapStudents,  HashMap<Course,Integer> enrollment){
        this.enrollment = enrollment;
        this.mapStudents = mapStudents;
        classOf = new HashMap<Integer, PriorityQueue<Student>>();
        for (Student student : mapStudents) {
            int gradYear = student.gradYear;
            if (!classOf.containsKey(gradYear)) {
                classOf.put(gradYear, new PriorityQueue<Student>());
            }
            classOf.get(gradYear).add(student);
        }
        

        reversedClassOf = new HashMap<Integer, Stack<Student>>();
        List<Integer> keys = new ArrayList<Integer>();
        keys.addAll(classOf.keySet()); 
        Collections.sort(keys);
        for (int i = keys.size() - 1; i >= 0; i--) {
            int gradYear = keys.get(i);
            reversedClassOf.put(gradYear, new Stack<Student>());
        }

    }

    /**
     * method to run the registration algorithm
     */
    public void run(){
        List<Integer> classYears = new ArrayList<Integer>(classOf.keySet());
        Collections.sort(classYears);

        for (int i = 0; i < classYears.size(); i++) {
            int year = classYears.get(i);
            Stack<Student> reverseDraw = new Stack<>();
            PriorityQueue<Student> students = classOf.get(year);

            for(int q = 0; q<4; q++){
                while (!students.isEmpty()) {
                    Student student = students.poll();
                    if (!(student.requests.size()==0)) {
                        List<Course> requests = student.requests;
                        for (int j = 0; j < requests.size(); j++) {
                            Course course = requests.get(j);

                            if (canEnroll(student, course)) {
                                student.schedule.add(course);
                                reverseDraw.push(student);
                                enrollment.put(course, enrollment.get(course) + 1);
                                break;
                            }
                        }
                    } else {
                        reverseDraw.push(student);
                    }
                }
                if(q==4){
                    break;
                }
                while (!reverseDraw.isEmpty()) {
                    Student student = reverseDraw.pop();

                    if (!(student.requests.size()==0)) {
                        List<Course> requests = student.requests;
                        for (int j = 0; j < requests.size(); j++) {
                            Course course = requests.get(j);

                            if (canEnroll(student, course)) {
                                student.schedule.add(course);
                                students.add(student);
                                enrollment.put(course, enrollment.get(course) + 1);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * helper method to check if a student can enroll in a course
     */
    private boolean canEnroll(Student student, Course course) {
        if (student.hasAConflict(course)) {
            return false;
        }
        if (student.isRegisteredFor(course)) {
            return false;
        }
        if (enrollment.get(course) >= course.maxEnrollment) {
            return false;
        }if (student.totalRegisteredCredits() + course.credits > 4.5) {
            return false;
        }
        return true;
    }
    
    /**
     * prints all students and the classes they are enrolled in
     */
    public void printEnrollment(){
        String enroll = "";
        for(Student student : mapStudents){
            enroll = enroll + student.toString() + "\n";
            for(Course course : student.schedule){
                enroll = enroll + course.toString() + "\n";                
            }
            enroll = enroll + "--------------------\n";
        }
        System.out.println(enroll);
        //Print the toString of the student, followed by their schedule (using course toString).
        /*
         * Hector Tran 2023 1
         * CMPU-145-51 Foundations/Computer Science    1.0    TRF 1200PM-0115PM
         * EDUC-361-51 Sem: Math/Science/Elem Classrm    1.0    R 0310PM-0610PM
         * ECON-235-51 Sports Economics    1.0    TR 1030AM-1145AM
         * PHED-105-51 Foundations of Wellness    0.5    TR 0900AM-1015AM
         * --------------------
         * Chace Sanford 2023 2
         * GNCS-355-51 Childhood/Childrn 19C Britain    1.0    R 0310PM-0510PM
         * ART-318-51 Building the Museum    1.0    T 0100PM-0300PM
         * CHEM-352-51 Phys Chem-Molec Structr    1.0    MW 1030AM-1145AM
         * INTL-109-51 A Lexicon of Forced Migration    1.0    TR 1030AM-1145AM
         * --------------------
         * etc...
         */
    }
}
