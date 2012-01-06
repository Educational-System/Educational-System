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
import java.util.StringTokenizer;

/**
 *
 * @author ASUS
 */
public class Course implements Cloneable, Serializable {
    
// <editor-fold desc="Private Data Members">
    
    private String courseName;
    private long courseID;
    private static long courseIDGenerator = 0;
    
// </editor-fold>
    
// <editor-fold desc="Constructors">
    
    public Course(String courseName)
    {
        setCourseName(courseName);
        courseID = courseIDGenerator;
        courseIDGenerator++;
    }
    
    private Course()
    {
        
    }
    
// </editor-fold>
    
// <editor-fold desc="Getters and Setters">
    
    public final long getCourseID() {
        return courseID;
    }

    public final String getCourseName() {
        return courseName;
    }

    public final void setCourseName(String courseName) {
        this.courseName = courseName;
    }    
    
// </editor-fold>
    
// <editor-fold desc="Implementatoins and Overrides">
    
    public @Override String toString()
    {
        return "Course: " + courseName + ", ID: " + new Long(courseID).toString();
    }
    
    public @Override boolean equals(Object obj)
    {
        if (obj==null)
            return false;
        if (obj==this)
            return true;
        if (obj instanceof Course)
        {
            Course Temp = (Course)obj;
            if ((this.courseName.equals(Temp.courseName)) && (this.courseID == Temp.courseID))
                return true;
        }
        return false;
    }
    
    protected @Override Object clone()
    {
        return new Course(courseName);
    }
    
// </editor-fold>
    
// <editor-fold desc="Text File IO">
    
    public void textFileWrite(PrintWriter writer)
    {
        StringBuilder Temp = new StringBuilder();
        Temp.append(courseName);
        Temp.append('\t');
        Temp.append(courseID);
        writer.println(Temp.toString());
    }
    
    public static Course textFileRead(BufferedReader reader) throws IOException
    {
        Course Temp = new Course();
        StringTokenizer T = new StringTokenizer(reader.readLine(), "\t");
        Temp.courseName = T.nextToken();
        Temp.courseID = new Long(T.nextToken());
        return Temp;
    }
    
// </editor-fold>
    
// <editor-fold desc="Binary File IO">
    
    public void binaryFileWrite(DataOutputStream writer) throws IOException
    {
        writer.writeInt(courseName.length());
        writer.writeChars(courseName);
        writer.writeLong(courseID);
    }
    
    public static Course binaryFileRead(DataInputStream reader) throws IOException
    {
        Course Temp = new Course();
        
        int Length = reader.readInt();
        StringBuilder S = new StringBuilder(Length);
        for (int i = 0;i<Length;i++)
            S.append(reader.readChar());
        Temp.courseName = S.toString();
        
        Temp.courseID = reader.readLong();
        return Temp;
    }
    
// </editor-fold>
    
}
