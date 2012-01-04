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
public class Enrollment implements Cloneable, Comparable<Enrollment> {

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
    
    public void fileWrite(PrintWriter writer)
    {
        writer.println(mark);
        student.fileWrite(writer);
        course.fileWrite(writer);
        semester.fileWrite(writer);
        writer.println();
    }
    
    public Enrollment fileRead(BufferedReader reader) throws IOException
    {
        int m = new Integer(reader.readLine());
        Student S = Student.fileRead(reader);
        Course C = Course.fileRead(reader);
        Semester T = Semester.fileRead(reader);
        return new Enrollment(S, C, T, m);
    }
    
// </editor-fold>
    
}
