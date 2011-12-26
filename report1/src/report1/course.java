package report1;

public class Course {
	//Data Member
    private String Name;
    private int courseID;
    private static int coursesNum;
    LinkedList<Enrollement> enrollments;


//Constructor
public Course(String Name) {
    setName(Name);
    this.courseID = coursesNum + 1;
    this.coursesNum =this.coursesNum + 1;
}

//Setters
    public void setName(String Name) {
    this.Name = Name;
    }
//Getters
public String getName() {
    return Name;
}

public int getCourseID() {
    return courseID;
}

public static int getCoursesNum() {
    return coursesNum;
}


public void finalize() throws Throwable {

}

}

}

