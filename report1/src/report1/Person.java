/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package report1;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public abstract class Person implements Cloneable, Serializable {
    
// <editor-fold desc="Private Data Members">
    
    private String firstName, lastName;
    private long NSN;
    
// </editor-fold>
    
// <editor-fold desc="Constructors">
    
    public Person(String firstName, String lastName, long NSN)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setNSN(NSN);
    }
    
    protected Person()
    {
        
    }
    
// </editor-fold>
    
// <editor-fold desc="Getters and Setters">
    
    public final long getNSN() {
        return NSN;
    }

    public final void setNSN(Long NSN) {
        this.NSN = NSN;
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
    
    // Implements Cloneable, but doesn't implement it because it's abstract
    
    public @Override String toString()
    {
        return firstName + ' ' + lastName + ", National SN: " + NSN;
    }
    
    public @Override boolean equals(Object obj)
    {
        if (obj==null)
            return false;
        if (this==obj)
            return true;
        if (!(obj instanceof Person))
            return false;
        Person Temp = (Person)obj;
        if   (  (this.NSN == Temp.NSN)
             && (this.firstName.equals(Temp.firstName))
             && (this.lastName.equals(Temp.lastName)) )
            return true;
        return false;
    }
    
// </editor-fold>
    
}
