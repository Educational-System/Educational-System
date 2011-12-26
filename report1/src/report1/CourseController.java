/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package report1;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ASUS
 */
public class CourseController {
    
// <editor-fold desc="Private Data Members">
    
    private ArrayList<AcademicStaff> academics;
    private ArrayList<Course> courses;
    private ArrayList<Enrollment> enrollments;
    private ArrayList<Semester> semesters;
    private ArrayList<Student> students;
    private ArrayList<Supervisor> supervisors;
    
// </editor-fold>
    
// <editor-fold desc="Constructors">
    
    public CourseController()
    {
        academics = new ArrayList<AcademicStaff>();
        courses = new ArrayList<Course>();
        enrollments = new ArrayList<Enrollment>();
        semesters = new ArrayList<Semester>();
        students = new ArrayList<Student>();
        supervisors = new ArrayList<Supervisor>();
    }
    
// </editor-fold>
    
// <editor-fold desc="Getters and Setters">
    
// </editor-fold>
    
}
