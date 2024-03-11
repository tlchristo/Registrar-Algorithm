public class Course implements Comparable {
    String dept;
    int courseNum;
    int section;
    String title;
    double credits;
    int maxEnrollment;
    String daysOfTheWeek;
    int startTime;
    int endTime;
    int duration;
    String timeString;
    String loc;
    String instructor;

    /**
     * Constructor takes in all values from the CSV.
     */
    public Course(String dept, int courseNum, int section, String title, double credits, int maxEnrollment, String daysOfTheWeek, int startTime,int endTime,int duration,String timeString, String loc, String instructor){
        //AFRS,100,51,Intro to Africana Studies,1,20,TR,810,885,75,0130PM-0245PM,BH 305,"Harriford, Diane"
        this.dept = dept;
        this.courseNum = courseNum;
        this.section = section;
        this.title = title;
        this.credits = credits;
        this.maxEnrollment = maxEnrollment;
        this.daysOfTheWeek = daysOfTheWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
        this.timeString = timeString;
        this.loc = loc;
        this.instructor = instructor;
    }

    /**
     * Key is a string representation of department-courseNumber-section.
     * Example: CMPU-102-51
     */
    public String getKey(){
        return dept + "-" + courseNum + "-" + section;
    }

    /**
     * Returns true if key is the same.  (Department, Course Number, and Section).
     * 
     */
    public boolean equals(Object o){
        if(!(o instanceof  Course)){
            return false;
        }
        Course c = (Course) o;
        return this.getKey().equals(c.getKey());
    }

    /**
     * String representation as it might appear on askBanner.
     */
    public String toString(){
        return getKey() + " " + title + "\t" + credits + "\t" + daysOfTheWeek + " " + timeString;
    }

    /**
     * Should sort classes by department, then course number, then section. (just like
     * askBanner)
     */
    public int compareTo(Object o){
        Course c = (Course) o;
        if (this.dept.equals(c.dept)){
            if (this.courseNum == c.courseNum) {
                return this.section - c.section;
            } else {
                return this.courseNum - c.courseNum;
            }
        } else {
            return this.dept.compareTo(c.dept);
        }
    }
    
    /**
     * helper method to check if any days of the week match
     */
    public static boolean containsAnyChar(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            if (str2.indexOf(str1.charAt(i)) != -1) {
                return true;
            }
        }
        return false;
    }

    /**
     * a method that checks times and days to determine whether or not they overlap.
     */
    public boolean conflictsWith(Course maybe){
        if(containsAnyChar(this.daysOfTheWeek, maybe.daysOfTheWeek)){
            if(this.startTime >= maybe.startTime && this.startTime <= maybe.endTime){
                return true;
            }
            if(this.endTime >= maybe.startTime && this.endTime <= maybe.endTime){
                return true;
            }
        }
        return false;
    }
}
