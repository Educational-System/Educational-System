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
public class AcademicStaff extends Person {
    
    public enum AcademicDegrees
    {
        Bachelor,
        Master,
        PHD
    }
    
// <editor-fold desc="Private Data Members">
    
    private AcademicDegrees academicDegreee;
    private Date degreeDate;
    
// </editor-fold>
    
// <editor-fold desc="Constructors">
    
    public AcademicStaff(String firstName, String lastName, long NationalSN, AcademicDegrees Degree, Date DegreeDate)
    {
        super(firstName,lastName,NationalSN);
        setAcademicDegreee(Degree);
        setDegreeDate(DegreeDate);
    }
    
// </editor-fold>
    
// <editor-fold desc="Getters and Setters">
    
    public final AcademicDegrees getAcademicDegreee() {
        return academicDegreee;
    }

    public final void setAcademicDegreee(AcademicDegrees academicDegreee) {
        this.academicDegreee = academicDegreee;
    }

    public final Date getDegreeDate() {
        return degreeDate;
    }

    public final void setDegreeDate(Date degreeDate) {
        this.degreeDate = degreeDate;
    }    
    
// </editor-fold>
    
// <editor-fold desc="Implementatoins and Overrides">
    
    public @Override String toString()
    {
        return "Academic Staff: " + super.toString() 
             + ", Degree: " + academicDegreee.name()
             + ", Degree Date: " + degreeDate.toString();
    }
    
    public @Override boolean equals(Object obj)
    {
        if (super.equals(obj))
        {
            if (obj instanceof AcademicStaff)
            {
                AcademicStaff Temp = (AcademicStaff)obj;
                if (  (this.academicDegreee == Temp.academicDegreee)
                   && (this.degreeDate == Temp.degreeDate)
                   )
                    return true;
            }
        }
        return false;
    }
    
    protected @Override Object clone()
    {
        return new AcademicStaff(getFirstName(),getLastName(), getNSN(),academicDegreee,degreeDate);
    }
    
// </editor-fold>
    
}
