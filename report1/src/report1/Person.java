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
public class Person implements Cloneable, Comparable<Person> {
    
// <editor-fold desc="Private Data Members">
    
    private String firstName, lastName;
    private long NSN;
    
// </editor-fold>
    
// <editor-fold desc="Constructors">
    
    public Person(String firstName, String lastName, long NSN) throws InvalidValue
    {
        setFirstName(firstName);
        setLastName(lastName);
        setNSN(NSN);
    }
    
// </editor-fold>
    
// <editor-fold desc="Getters and Setters">
    
    public final long getNSN() {
        return NSN;
    }

    public final void setNSN(Long NSN) throws InvalidValue {
        if (NSN>0)
            this.NSN = NSN;
        else
            throw new InvalidValue("National Security Number cannot be negative.");
    }

    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
// </editor-fold>
    
// <editor-fold desc="Implementatoins and Overrides">
    
    
    
// </editor-fold>

    public @Override String toString()
    {
        return "Person: "
             + firstName + ' ' + lastName
             + ", National SN: " + NSN;
    }
    
    protected @Override Object clone() throws CloneNotSupportedException
    {
        try
        {
            return new Person(new String(this.firstName),new String(this.lastName),NSN);
        }
        catch(InvalidValue E)
        {
            return null;
        }
    }
    
}
