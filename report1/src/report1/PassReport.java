/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package report1;

/**
 *
 * @author ASUS
 */
public class PassReport {
    
// <editor-fold desc="Private Data Members">
    
    private int passingNumber;
    private int failingNumber;
    
// </editor-fold>
    
// <editor-fold desc="Constructors">
    
    public PassReport(int pass, int fail)
    {
        
    }
    
// </editor-fold>
    
    public int getPassersNumber()
    {
        return passingNumber;
    }
    public int getFailersNumber()
    {
        return failingNumber;
    }
    public double passRatio()
    {
        return (double)passingNumber/(passingNumber+failingNumber);
    }
    public double failRatio()
    {
        return (double)failingNumber/(passingNumber+failingNumber);
    }

}
