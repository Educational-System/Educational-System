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
import java.util.Date;
import java.util.StringTokenizer;

/**
 *
 * @author ASUS
 */
public class AcademicStaff extends Person implements Comparable<AcademicStaff> {
    
    public enum AcademicDegrees implements Comparable<AcademicDegrees>
    {
        Bachelor,
        Master,
        PHD;
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
    
    private AcademicStaff()
    {
        
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
    
    public @Override int compareTo(AcademicStaff o)
    {
        if (o==null)
            return 1;
        if (o==this)
            return 0;
        if (this.academicDegreee.compareTo(o.academicDegreee)>1)
            return 1;
        else if (this.academicDegreee.compareTo(o.academicDegreee)<0)
            return -1;
        else if (this.degreeDate.compareTo(o.degreeDate)<0)
            return -1;
        else if (this.degreeDate.compareTo(o.degreeDate)>0)
            return -1;
        else
        {
            String Name1 = this.getFirstName() + ' ' + this.getLastName();
            String Name2 = o.getFirstName() + ' ' + o.getLastName();
            if (Name1.compareTo(Name2)>0)
                return 1;
            else if (Name1.compareTo(Name2)<0)
                return -1;
            else if (this.getNSN()>o.getNSN())
                return 1;
            else if (this.getNSN()<o.getNSN())
                return -1;
            else
                return 0;
        }
    }
        
// </editor-fold>
    
// <editor-fold desc="Text File IO">
    
    public void textFileWrite(PrintWriter writer)
    {
        StringBuilder Temp = new StringBuilder();
        Temp.append(getFirstName());
        Temp.append('\t');
        Temp.append(getLastName());
        Temp.append('\t');
        Temp.append(getNSN());
        Temp.append('\t');
        Temp.append(academicDegreee);
        Temp.append('\t');
        Temp.append(degreeDate.getTime());
        writer.println(Temp.toString());
    }
    
    public static AcademicStaff textFileRead(BufferedReader reader) throws IOException
    {
        AcademicStaff Temp = new AcademicStaff();
        StringTokenizer T = new StringTokenizer(reader.readLine(), "\t");
        Temp.setFirstName(T.nextToken());
        Temp.setLastName(T.nextToken());
        Temp.setNSN(new Long(T.nextToken()));
        String S = T.nextToken();
        if (S.equals(AcademicDegrees.PHD.name()))
            Temp.academicDegreee = AcademicDegrees.PHD;
        else if (S.equals(AcademicDegrees.Master.name()))
            Temp.academicDegreee = AcademicDegrees.Master;
        else
            Temp.academicDegreee = AcademicDegrees.Bachelor;
        Temp.setDegreeDate(new Date(new Long(T.nextToken())));
        return Temp;
    }
    
// </editor-fold>
    
// <editor-fold desc="Binary File IO">
    
    public void binaryFileWrite(DataOutputStream writer) throws IOException
    {
        writer.writeInt(getFirstName().length());
        writer.writeChars(getFirstName());
        writer.writeInt(getLastName().length());
        writer.writeChars(getLastName());
        writer.writeLong(getNSN());
        writer.writeInt(academicDegreee.ordinal());
        writer.writeLong(degreeDate.getTime());
    }
    
    public static AcademicStaff binaryFileRead(DataInputStream reader) throws IOException
    {
        AcademicStaff Temp = new AcademicStaff();
        
        int Length = reader.readInt();
        StringBuilder S = new StringBuilder(Length);
        for (int i = 0;i<Length;i++)
            S.append(reader.readChar());
        Temp.setFirstName(S.toString());
        
        Length = reader.readInt();
        S = new StringBuilder(Length);
        for (int i = 0;i<Length;i++)
            S.append(reader.readChar());
        Temp.setLastName(S.toString());
        
        Temp.setNSN(reader.readLong());
        
        Length = reader.readInt();
        switch (Length)
        {
            case 0:
                Temp.setAcademicDegreee(AcademicDegrees.Bachelor);
                break;
            case 1:
                Temp.setAcademicDegreee(AcademicDegrees.Master);
                break;
            case 2:
                Temp.setAcademicDegreee(AcademicDegrees.PHD);
        }
        
        Temp.setDegreeDate(new Date(new Long(reader.readLong())));
        return Temp;
    }
    
// </editor-fold>
    
}
