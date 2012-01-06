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
public class Enrollment implements Cloneable, Comparable<Enrollment>, Serializable {

// <editor-fold desc="Private Data Members">
    
    private Student student;
    private Course course;
    private Semester semester;
    private int mark;

// </editor-fold>
    
// <editor-fold desc="Constructors">

    public Enrollment(Student student, Course course, Semester semester, int mark)
    {
        setCourse(course);
        setMark(mark);
        setSemester(semester);
        setStudent(student);
    }
    
// </editor-fold>
    
// <editor-fold desc="Getters and Setters">
    
    public final Course getCourse() {
        return course;
    }

    public final void setCourse(Course course) {
        this.course = course;
    }

    public final int getMark() {
        return mark;
    }

    public final void setMark(int mark) {
        this.mark = mark;
    }

    public final Semester getSemester() {
        return semester;
    }

    public final void setSemester(Semester semester) {
        this.semester = semester;
    }

    public final Student getStudent() {
        return student;
    }

    public final void setStudent(Student student) {
        this.student = student;
    }
    
// </editor-fold>
    
// <editor-fold desc="Implementatoins and Overrides">
    
    public @Override int compareTo(Enrollment o)
    {
        if(this.mark > o.mark)
            return 1;
        else if (this.mark<o.mark)
            return -1;
        else
            return this.student.compareTo(o.student);
    }
    
    public @Override String toString()
    {
        return "Enrollment: "
             + student.toString() + ", "
             + course.toString() + ", "
             + semester.toString() + ", "
             + "Mark: " + new Integer(mark).toString();
    }
    
    protected @Override Object clone()
    {
        return new Enrollment(student, course, semester, mark);
    }
    
    public @Override boolean equals(Object obj)
    {
        if (obj==null)
            return false;
        if (this==obj)
            return true;
        if (obj instanceof Enrollment)
        {
            Enrollment Temp = (Enrollment)obj;
            if (    (this.student==Temp.student)
               &&   (this.course == Temp.course)
               &&   (this.semester==Temp.semester)
               &&   (this.mark==Temp.mark)
                    )
                return true;
        }
        return false;
    }
    
// </editor-fold>
    
// <editor-fold desc="Text File IO">
    
    public void textFileWrite(PrintWriter writer)
    {
        writer.println(mark);
        student.textFileWrite(writer);
        course.textFileWrite(writer);
        semester.textFileWrite(writer);
        writer.println();
    }
    
    public static Enrollment textFileRead(BufferedReader reader) throws IOException
    {
        int m = new Integer(reader.readLine());
        Student S = Student.textFileRead(reader);
        Course C = Course.textFileRead(reader);
        Semester T = Semester.textFileRead(reader);
        return new Enrollment(S, C, T, m);
    }
    
// </editor-fold>
    
// <editor-fold desc="Text File IO">
    
    public void  binaryFileWrite(DataOutputStream writer) throws IOException
    {
        writer.writeInt(mark);
        student.binaryFileWrite(writer);
        course.binaryFileWrite(writer);
        semester.binaryFileWrite(writer);
    }
    
    public static Enrollment binaryFileRead(DataInputStream reader) throws IOException
    {
        int m = reader.readInt();
        Student S = Student.binaryFileRead(reader);
        Course C = Course.binaryFileRead(reader);
        Semester T = Semester.binaryFileRead(reader);
        return new Enrollment(S, C, T, m);
    }
    
// </editor-fold>
    
}
