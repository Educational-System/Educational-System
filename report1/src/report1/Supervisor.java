/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package report1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class Supervisor implements Cloneable, Serializable {
    
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
    
    public void textFileWrite(PrintWriter writer)
    {
        academicStaff.textFileWrite(writer);
        course.textFileWrite(writer);
        semester.textFileWrite(writer);
        writer.println();
    }
    
    public static Supervisor textFileRead(BufferedReader reader) throws IOException
    {
        AcademicStaff A = AcademicStaff.textFileRead(reader);
        Course C = Course.textFileRead(reader);
        Semester S = Semester.textFileRead(reader);
        return new Supervisor(A, C, S);
    }
    
// </editor-fold>
    
// <editor-fold desc="Binary File IO">
    
    public void binaryFileWrite(DataOutputStream writer) throws IOException
    {
        academicStaff.binaryFileWrite(writer);
        course.binaryFileWrite(writer);
        semester.binaryFileWrite(writer);
    }
    
    public static Supervisor binaryFileRead(DataInputStream reader) throws IOException
    {
        AcademicStaff A = AcademicStaff.binaryFileRead(reader);
        Course C = Course.binaryFileRead(reader);
        Semester S = Semester.binaryFileRead(reader);
        return new Supervisor(A, C, S);
    }
    
// </editor-fold>
    
}
