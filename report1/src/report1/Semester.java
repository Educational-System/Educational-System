/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package report1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.StringTokenizer;

/**
 *
 * @author ASUS
 */
public class Semester implements Comparable<Semester> {

// <editor-fold desc="Private Data Members">

    private int semesterNumber;
    private int year;
    private Date endDate;
    
// </editor-fold>
    
// <editor-fold desc="Constructors">
    
    public Semester(int semesterNumber, int year, Date endDate)
    {
        setEndDate(endDate);
        setSemesterNumber(semesterNumber);
        setYear(year);
    }
    
    private Semester()
    {
        
    }
    
// </editor-fold>
    
// <editor-fold desc="Getters and Setters">
    
    public final Date getEndDate() {
        return endDate;
    }

    public final void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public final int getSemesterNumber() {
        return semesterNumber;
    }

    public final void setSemesterNumber(int semesterNumber) {
        this.semesterNumber = semesterNumber%4;
    }

    public final int getYear() {
        return year;
    }

    public final void setYear(int year) {
        this.year = year;
    }
    
// </editor-fold>
    
// <editor-fold desc="Implementatoins and Overrides">
    
    public @Override String toString()
    {
        return "Semester " + semesterNumber
             + "in " + year
             + ", End Date: " + endDate.toString();
    }
    
    protected @Override Object clone()
    {
        return new Semester(semesterNumber, year, endDate);
    }
    
    public @Override int compareTo(Semester o)
    {
        if (o==null)
            return 1;
        if (o==this)
            return 0;
        if (this.year>o.year)
            return 1;
        else if (this.year<o.year)
            return -1;
        else if (this.semesterNumber>o.semesterNumber)
            return 1;
        else if (this.semesterNumber>o.semesterNumber)
            return -1;
        else
            return 0;
    }
    
// </editor-fold>
    
// <editor-fold desc="Text File IO">
    
    public void fileWrite(PrintWriter writer)
    {
        StringBuilder Temp = new StringBuilder();
        Temp.append(semesterNumber);
        Temp.append('\t');
        Temp.append(year);
        Temp.append('\t');
        Temp.append(endDate.getTime());
        writer.println(Temp.toString());
    }
    
    public static Semester fileRead(BufferedReader reader) throws IOException
    {
        Semester Temp = new Semester();
        StringTokenizer T = new StringTokenizer(reader.readLine(), "\t");
        Temp.semesterNumber = new Integer(T.nextToken());
        Temp.year = new Integer(T.nextToken());
        Temp.endDate = new Date(new Long(T.nextToken()));
        return Temp;
    }
    
// </editor-fold>
    
}
