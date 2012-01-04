/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package report1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
 * @author ASUS
 */
public class Course implements Cloneable {
    
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
    
    public void fileWrite(PrintWriter writer)
    {
        StringBuilder Temp = new StringBuilder();
        Temp.append(courseName);
        Temp.append('\t');
        Temp.append(courseID);
        writer.println(Temp.toString());
    }
    
    public static Course fileRead(BufferedReader reader) throws IOException
    {
        Course Temp = new Course();
        StringTokenizer T = new StringTokenizer(reader.readLine(), "\t");
        Temp.courseName = T.nextToken();
        Temp.courseID = new Long(T.nextToken());
        return Temp;
    }
    
// </editor-fold>
    
}
