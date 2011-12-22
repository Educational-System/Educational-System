/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package report1;

import org.omg.CORBA.DynAnyPackage.InvalidValue;

/**
 *
 * @author ASUS
 */
public class Student extends Person {
    
// <editor-fold desc="Private Data Members">
    
    private static long studentNumberGenerator = 0;
    private long studentNumber;
    
// </editor-fold>
    
// <editor-fold desc="Constructors">
    
    public Student(String firstName, String lastName, long NSN) throws InvalidValue
    {
        super(firstName,lastName,NSN);
        studentNumber = studentNumberGenerator;
        studentNumberGenerator++;
    }
    
// </editor-fold>
    
// <editor-fold desc="Getters and Setters">
    
    public final long getStudentNumber() {
        return studentNumber;
    }
    
// </editor-fold>
    
}
