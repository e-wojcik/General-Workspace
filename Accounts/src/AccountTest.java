import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Test case class for the Account class
 * @author WojcikEricM
 *
 */
public class AccountTest {

    @Test
    public void testTypicalResults() {
        Account accounts[] = new Account[3];
        accounts[0] = new Account();
        accounts[0].setPrincipal(35);
        accounts[0].setRate((float) .04);
        accounts[0].setDaysActive(365);
        accounts[0].setAccountType(Account.PREMIUM); 
        accounts[1] = new Account();
        accounts[1].setPrincipal(100);
        accounts[1].setRate((float) .035);
        accounts[1].setDaysActive(100);
        accounts[1].setAccountType(Account.BUDGET);
        accounts[2] = new Account();
        accounts[2].setPrincipal(50);
        accounts[2].setRate((float) .04);
        accounts[2].setDaysActive(600);
        accounts[2].setAccountType(Account.PREMIUM_PLUS);
        float result = Fees.calculateFee(accounts);
        assertEquals(result, (float) 0.060289, (float) 0.00001);
       } 
    
    @Test
    public void testNonPremiumAccounts() {
        Account accounts[] = new Account[2];
        accounts[0] = new Account();
        accounts[0].setPrincipal(12);
        accounts[0].setRate((float) .025);
        accounts[0].setDaysActive(100);
        accounts[0].setAccountType(Account.BUDGET);
        accounts[1] = new Account();
        accounts[1].setPrincipal(50);
        accounts[1].setRate((float) .0265);
        accounts[1].setDaysActive(150);
        accounts[1].setAccountType(Account.STANDARD);
        float result = Fees.calculateFee(accounts);
        assertEquals(result, 0, 0.0001);
       } 
    
    @Test
    public void testZeroRate() {
        Account accounts[] = new Account[1];
        accounts[0] = new Account();
        accounts[0].setPrincipal(1000);
        accounts[0].setRate((float) 0);
        accounts[0].setDaysActive(100);
        accounts[0].setAccountType(Account.PREMIUM);
        float result = Fees.calculateFee(accounts);
        assertEquals(result, 0, 0.00001);
       } 
    

    @Test
    public void testNegativePrincipal() {
        Account accounts[] = new Account[1];
        accounts[0] = new Account();
        accounts[0].setPrincipal(-10000);
        accounts[0].setRate((float) 0.263);
        accounts[0].setDaysActive(100);
        accounts[0].setAccountType(Account.PREMIUM);
        float result = Fees.calculateFee(accounts);
        assertEquals(result, -9.33265, 0.0001);
       } 
    
    @Test
    public void testDuplicateReference() {
        Account accounts[] = new Account[3];
        accounts[0] = new Account();
        accounts[0].setPrincipal(35);
        accounts[0].setRate((float) .04);
        accounts[0].setDaysActive(365);
        accounts[0].setAccountType(Account.PREMIUM);
        accounts[1] = accounts[0];
        accounts[2] = new Account();
        accounts[2].setPrincipal(50);
        accounts[2].setRate((float) .04);
        accounts[2].setDaysActive(600);
        accounts[2].setAccountType(Account.PREMIUM_PLUS);
        float result = Fees.calculateFee(accounts);
        assertEquals(result, 0.0781316, 0.000001);
       } 
    
    @Test
    public void testNullInput() {
        Account accounts[] = null;
        try {
        float result = Fees.calculateFee(accounts);
        fail();
        } catch (NullPointerException e) {
        assertTrue(true);
        }
       } 
    
}
