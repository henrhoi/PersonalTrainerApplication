package tdt4140.gr1801.app.core;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.client.ClientProtocolException;

import javafx.scene.control.TextField;
import junit.framework.TestCase;

public class PersonalTrainerTest extends TestCase{
	
	 PersonalTrainer pt, pt1;
	 Client c1, c2, c3;
	 String d1;
	
	protected void setUp() {
		pt = new PersonalTrainer();
		pt1 = new PersonalTrainer("martin", "Martin", "Johansen", "martin@johansen.no", "47638632", "19950517-1400");
		
		c1 = new Client(1, "Heisann Sveisann", 175, pt1);
		c2 = new Client(2, "Gjortleif Sveisen", 160, pt1);
		c3 = new Client(3, "Dansemann Dans", 180, pt);
	}
	
	public void testSetEmail() {
		pt.setEmail("martin@online.no");
		assertEquals(pt.getEmail(),"martin@online.no");
	}
	
	public void testSetPhoneNumber() {
		pt.setPhoneNumber("90943559");
		assertEquals(pt.getPhoneNumber(),"90943559");
	}
	public void testCheckPhoneNumber() {
		assertTrue(PersonalTrainer.checkPhoneNumber("90943559"));
	}
	
	public void testRemoveClient() {
		Client clientTest1 = new Client(81,"Ingalf Randolf",190,pt);
		pt.removeClient(clientTest1);
		assertFalse(pt.getClientList().contains(clientTest1));
		try {
			pt1.removeClient(c3);
		} catch (IllegalArgumentException IAE) {
			// Correct to go
		} catch (Exception e) {
			fail();
		}
	}
	
	
	
	@SuppressWarnings("restriction")
	public void testAllFields() {
		com.sun.javafx.application.PlatformImpl.startup(()->{});
		TextField tf0 = new TextField();
		TextField tf1 = new TextField();
		TextField tf2 = new TextField();
		TextField tf3 = new TextField();
		TextField tf4 = new TextField();
		tf0.setText("testtest");
		tf1.setText("Test");
		tf2.setText("Test");
		tf3.setText("12345678");
		tf4.setText("test@test.no");
		ArrayList<TextField> fields = new ArrayList<>();
		fields.add(tf0);fields.add(tf1);fields.add(tf2);fields.add(tf3);fields.add(tf4);
		
		ArrayList<Boolean> correctness_test = new ArrayList<>();
		correctness_test.add(true);correctness_test.add(true);correctness_test.add(true);correctness_test.add(true);correctness_test.add(true);
		assertEquals(correctness_test, PersonalTrainer.checkAllFields(fields));
		com.sun.javafx.application.PlatformImpl.exit();
		
		
	}
	
	public void testGetBirthday() {
		assertEquals(pt.getBirthday(),null);
	}
	
	public void testConstructor() throws ClientProtocolException, IOException {
		PersonalTrainer testPT = new PersonalTrainer("vilde", "Vilde", "Arntzen", "vildera@stud.ntnu.no", "90943558", "19970517-1400");
		assertEquals(testPT.getBirthday(),"19970517-1400");
		assertEquals(testPT.getUsername(),"vilde");
		assertEquals(testPT.getName(), "Vilde Arntzen");
		assertEquals(testPT.getEmail(),"vildera@stud.ntnu.no");
		assertEquals(testPT.getPhoneNumber(),"90943558");
	}
	
	public void testCheckUsername() {
		assertEquals(PersonalTrainer.checkUsername(pt1.getUsername()), true);
		assertEquals(PersonalTrainer.checkUsername(".t31f!"), false);
	}
	
	public void testFirstName() {
		assertEquals(PersonalTrainer.checkFirstName(pt1.getName().split(" ")[0]), true);
		assertEquals(PersonalTrainer.checkFirstName("1234SS"), false);
	}
	
	public void testLastName() {
		assertEquals(PersonalTrainer.checkLastName(pt1.getName().split(" ")[1]), true);
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
		pt.addClient(c1);
		assertEquals(pt.getClient(c1),c1);
		try {
			pt1.getClient(c3);
		} catch (IllegalArgumentException IAE) {
			// Correct to go
		} catch (Exception e) {
			fail();
		}
	}
	
	public void testGetClientList() {
		ArrayList<Client> testClientList = new ArrayList<Client>();
		PersonalTrainer testPT = new PersonalTrainer("vilde", "Vilde", "Arntzen", "vildera@stud.ntnu.no", "90943558", "19970517-1400");
		testPT.addClient(c1);
		testPT.addClient(c2);
		testClientList.add(c1);
		testClientList.add(c2);
		assertEquals(testPT.getClientList(),testClientList);
	}
	
	public void testAddClient() {
		try {
			pt1.addClient(c1);
		} catch(IllegalArgumentException IAE) {
			
		}
	}
}