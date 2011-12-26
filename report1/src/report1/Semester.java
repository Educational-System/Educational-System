/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package report1;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Semester {

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
    
// </editor-fold>
    
}
