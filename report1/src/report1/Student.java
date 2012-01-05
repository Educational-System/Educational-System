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
import java.util.StringTokenizer;

/**
 *
 * @author ASUS
 */
public class Student extends Person implements Comparable<Student> {
    
// <editor-fold desc="Private Data Members">
    
    private static long studentNumberGenerator = 0;
    private long studentNumber;
    
// </editor-fold>
    
// <editor-fold desc="Constructors">
    
    public Student(String firstName, String lastName, long NSN)
    {
        super(firstName,lastName,NSN);
        studentNumber = studentNumberGenerator;
        studentNumberGenerator++;
    }
    
    private Student()
    {
        
    }
    
// </editor-fold>
    
// <editor-fold desc="Getters and Setters">
    
    public final long getStudentNumber() {
        return studentNumber;
    }
    
// </editor-fold>
    
// <editor-fold desc="Implementatoins and Overrides">
    
    public @Override String toString()
    {
        Long Temp = studentNumber;
        return "Student: " + super.toString() + ", Student Number: " + Temp.toString();
    }
    
    public @Override boolean equals(Object obj)
    {
        if (super.equals(obj))
        {
            if (obj instanceof Student)
            {
                return true;
            }
        }
        return false;
    }
    
    protected @Override Object clone()
    {
        return new Student(getFirstName(),getLastName(),getNSN());
    }
    
    public @Override int compareTo(Student o)
    {
        if (o==null)
            return 1;
        if (o==this)
            return 0;
        if (this.studentNumber>o.studentNumber)
            return 1;
        else if (this.studentNumber<o.studentNumber)
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
        Temp.append(studentNumber);
        writer.println(Temp.toString());
    }
    
    public static Student textFileRead(BufferedReader reader) throws IOException
    {
        Student Temp = new Student();
        StringTokenizer T = new StringTokenizer(reader.readLine(), "\t");
        Temp.setFirstName(T.nextToken());
        Temp.setLastName(T.nextToken());
        Temp.setNSN(new Long(T.nextToken()));
        Temp.studentNumber = new Long(T.nextToken());
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
        writer.writeLong(studentNumber);
    }
    
    public static Student binaryFileRead(DataInputStream reader) throws IOException
    {
        Student Temp = new Student();
        
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
        Temp.studentNumber = reader.readLong();
        
        return Temp;
    }
    
// </editor-fold>
    
}
