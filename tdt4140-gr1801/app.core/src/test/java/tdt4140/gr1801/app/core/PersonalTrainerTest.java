package tdt4140.gr1801.app.core;

import junit.framework.TestCase;

public class PersonalTrainerTest extends TestCase{
	
	 PersonalTrainer pt, pt1;
	 Client c1, c2, c3;
	 String d1;
	
	protected void setUp() {
		pt = new PersonalTrainer();
		pt1 = new PersonalTrainer("martin", "Martin", "Johansen", "martin@johansen.no", "47638632", "heihei", "19950517-1400");
		
		c1 = new Client(1, "Heisann Sveisann", 175, pt1);
		c2 = new Client(2, "Gjortleif Sveisen", 160, pt1);
		c3 = new Client(3, "Dansemann Dans", 180, pt);
	}
	
	public void testCheckUsername() {
		assertEquals(PersonalTrainer.checkUsername(pt1.getUsername()), true);
		assertEquals(PersonalTrainer.checkUsername(".t31f!"), false);
	}
	
	public void testFirstName() {
		assertEquals(PersonalTrainer.checkFirstName(pt1.getFirstName()), true);
		assertEquals(PersonalTrainer.checkFirstName("1234SS"), false);
	}
	
	public void testLastName() {
		assertEquals(PersonalTrainer.checkLastName(pt1.getLastName()), true);
		assertEquals(PersonalTrainer.checkLastName("1234gg"), false);
	}
	
	public void testEmail() {
		assertEquals(PersonalTrainer.checkEmail(pt1.getEmail()), true);
		assertEquals(PersonalTrainer.checkEmail("martin"), false);
	}
	
	public void testPhoneNumber() {
		assertEquals(PersonalTrainer.checkPhoneNumber(pt1.getPhoneNumber()), true);
		assertEquals(PersonalTrainer.checkPhoneNumber("1111"), false);
	}
	
	public void testGetClient() {
		try {
			pt1.getClient(c3);
		} catch (IllegalArgumentException IAE) {
			System.err.println(IAE);
		}
	}
	
	public void testAddClient() {
		try {
			pt1.addClient(c1);
		} catch(IllegalArgumentException IAE) {
			
		}
	}
}