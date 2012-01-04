/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package report1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ASUS
 */
public class Supervisor implements Cloneable {
    
// <editor-fold desc="Private Data Members">
    
    private AcademicStaff academicStaff;
    private Course course;
    private Semester semester;
    
// </editor-fold>
    
// <editor-fold desc="Constructors">
    
    public Supervisor(AcademicStaff academicStaff, Course course, Semester semester)
    {
        setAcademicStaff(academicStaff);
        setCourse(course);
        setSemester(semester);
    }
    
// </editor-fold>
    
// <editor-fold desc="Getters and Setters">
    
    public final AcademicStaff getAcademicStaff() {
        return academicStaff;
    }

    public final void setAcademicStaff(AcademicStaff academicStaff) {
        this.academicStaff = academicStaff;
    }

    public final Course getCourse() {
        return course;
    }

    public final void setCourse(Course course) {
        this.course = course;
    }

    public final Semester getSemester() {
        return semester;
    }

    public final void setSemester(Semester semester) {
        this.semester = semester;
    }
    
// </editor-fold>
    
// <editor-fold desc="Implementatoins and Overrides">
    
    public @Override String toString()
    {
        return  "Supervisor: "
              + academicStaff.toString() + ", "
              + course.toString() + ", "
              + semester.toString();
    }
    
    public @Override boolean equals(Object obj)
    {
        if (obj==null)
            return false;
        if (obj==this)
            return true;
        if (!(obj instanceof Supervisor))
            return false;
        Supervisor Temp = (Supervisor)obj;
        if (    (this.academicStaff.equals(Temp.academicStaff))
           &&   (this.course.equals(Temp.course))
           &&   (this.semester.equals(Temp.semester))
           )
            return true;
        return false;
    }
    
    protected @Override Object clone()
    {
        return new Supervisor(academicStaff, course, semester);
    }
    
// </editor-fold>
    
// <editor-fold desc="Text File IO">
    
    public void fileWrite(PrintWriter writer)
    {
        academicStaff.fileWrite(writer);
        course.fileWrite(writer);
        semester.fileWrite(writer);
        writer.println();
    }
    
    public static Supervisor fileRead(BufferedReader reader) throws IOException
    {
        AcademicStaff A = AcademicStaff.fileRead(reader);
        Course C = Course.fileRead(reader);
        Semester S = Semester.fileRead(reader);
        return new Supervisor(A, C, S);
    }
    
// </editor-fold>
    
}
