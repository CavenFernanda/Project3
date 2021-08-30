package co.workpool.HibernateTutorial;

import static org.junit.Assert.assertTrue;


import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class ResourceControllerTest {


	@Test
	void testResourceName() throws ObjectValidatorException {
		ResourceController resCtrl = new ResourceController();

		try {
			resCtrl.validateResource(null);
			assertTrue(false);
		} catch (NullPointerException e) {
			assertTrue(true);
		} catch (SQLException e) {
			assertTrue(true);
		} catch (ObjectValidatorException e) {
			assertTrue(false);
		}

		Resource r = new Resource();
		r.setFirstName("C");
		r.setLastName(" @@@@ ");

		try {
			resCtrl.validateResource(r);
			assertTrue(false);
		} catch (ObjectValidatorException ex) {
			List<ObjectValidatorMessage> msgs = ex.getMessages();
			for (Iterator iterator = msgs.iterator(); iterator.hasNext();) {
				ObjectValidatorMessage objectValidatorMessage = (ObjectValidatorMessage) iterator.next();
				if (objectValidatorMessage.getMsg().equals("error.firstName.empty")) {
					assertTrue(true);
				} else if (objectValidatorMessage.getMsg()
						.equals("error.firstName.containsNumbers/specialCharacters")) {
					assertTrue(true);
				} else if (objectValidatorMessage.getMsg().equals("error.lastname.empty")) {
					assertTrue(true);
				} else if (objectValidatorMessage.getMsg().equals("error.lastName.containsNumbers/specialCharacters")) {
					assertTrue(true);
				} else {
					assertTrue(false);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testResourceDob() throws ObjectValidatorException {

		ResourceController resCtrl = new ResourceController();

		try {
			resCtrl.validateResource(null);
			assertTrue(false);
		} catch (NullPointerException e) {
			assertTrue(true);
		} catch (SQLException e) {
			assertTrue(true);
		} catch (ObjectValidatorException e) {
			assertTrue(false);
		}

		Resource r = new Resource();
		r.setDob(null);

		try {
			resCtrl.validateResource(r);
			assertTrue(false);
		} catch (ObjectValidatorException ex) {
			List<ObjectValidatorMessage> msgs = ex.getMessages();
			for (Iterator iterator = msgs.iterator(); iterator.hasNext();) {
				ObjectValidatorMessage objectValidatorMessage = (ObjectValidatorMessage) iterator.next();
				if (objectValidatorMessage.getMsg().equals("error.date.null")) {
					assertTrue(true);
				} else if (objectValidatorMessage.getMsg().equals("error.date.format")) {
					assertTrue(true);
				} else {
					assertTrue(false);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testResourceAddress() throws ObjectValidatorException {

		ResourceController resCtrl = new ResourceController();

		try {
			resCtrl.validateResource(null);
			assertTrue(false);
		} catch (NullPointerException e) {
			assertTrue(true);
		} catch (SQLException e) {
			assertTrue(true);
		} catch (ObjectValidatorException e) {
			assertTrue(false);
		}

		Resource r = new Resource();
		r.setAddress("1111111111111111111111111111");

		try {
			resCtrl.validateResource(r);
			assertTrue(false);
		} catch (ObjectValidatorException ex) {
			List<ObjectValidatorMessage> msgs = ex.getMessages();
			for (Iterator iterator = msgs.iterator(); iterator.hasNext();) {
				ObjectValidatorMessage objectValidatorMessage = (ObjectValidatorMessage) iterator.next();
				if (objectValidatorMessage.getMsg().equals("error.address.empty")) {
					assertTrue(true);
				} else if (objectValidatorMessage.getMsg().equals("error.address.format")) {
					assertTrue(true);
				} else {
					assertTrue(false);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testResourcePhoneNo() throws ObjectValidatorException {

		ResourceController resCtrl = new ResourceController();

		try {
			resCtrl.validateResource(null);
			assertTrue(false);
		} catch (NullPointerException ex) {
			assertTrue(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Resource r = new Resource();
		r.setPhoneNo("768304312");

		try {
			resCtrl.validateResource(r);
			assertTrue(false);
		} catch (ObjectValidatorException ex) {
			List<ObjectValidatorMessage> msgs = ex.getMessages();
			for (Iterator iterator = msgs.iterator(); iterator.hasNext();) {
				ObjectValidatorMessage objectValidatorMessage = (ObjectValidatorMessage) iterator.next();
				if (objectValidatorMessage.getMsg().equals("error.phoneNumber.empty")) {
					assertTrue(true);
				} else if (objectValidatorMessage.getMsg().equals("error.phoneNo.format")) {
					assertTrue(true);
				} else {
					assertTrue(false);
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testResourceEmailAddress() throws ObjectValidatorException {

		ResourceController resCtrl = new ResourceController();

		try {
			resCtrl.validateResource(null);
			assertTrue(false);
		} catch (NullPointerException ex) {
			assertTrue(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Resource r = new Resource();
		r.setEmailAddress("cave@n@gmail.co");

		try {
			resCtrl.validateResource(r);
			assertTrue(false);
		} catch (ObjectValidatorException ex) {
			List<ObjectValidatorMessage> msgs = ex.getMessages();
			for (Iterator iterator = msgs.iterator(); iterator.hasNext();) {
				ObjectValidatorMessage objectValidatorMessage = (ObjectValidatorMessage) iterator.next();
				if (objectValidatorMessage.getMsg().equals("error.emailAddress.empty")) {
					assertTrue(true);
				} else if (objectValidatorMessage.getMsg().equals("error.emailAddress.format")) {
					assertTrue(true);
				} else {
					assertTrue(false);
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testResourceUserName() throws ObjectValidatorException {
		ResourceController resCtrl = new ResourceController();

		try {
			resCtrl.validateResource(null);
			assertTrue(false);
		} catch (NullPointerException ex) {
			assertTrue(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Resource r = new Resource();
		r.setUsername("     ");

		try {
			resCtrl.validateResource(r);
			assertTrue(false);
		} catch (ObjectValidatorException ex) {
			List<ObjectValidatorMessage> msgs = ex.getMessages();
			for (Iterator iterator = msgs.iterator(); iterator.hasNext();) {
				ObjectValidatorMessage objectValidatorMessage = (ObjectValidatorMessage) iterator.next();
				if (objectValidatorMessage.getMsg().equals("error.username.empty")) {
					assertTrue(true);
				} else if (objectValidatorMessage.getMsg().equals("error.username.format")) {
					assertTrue(true);
				} else {
					assertTrue(false);
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testResourcePassword() throws ObjectValidatorException {
		ResourceController resCtrl = new ResourceController();

		try {
			resCtrl.validateResource(null);
			assertTrue(false);
		} catch (NullPointerException ex) {
			assertTrue(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Resource r = new Resource();
		r.setUsername("     ");

		try {
			resCtrl.validateResource(r);
			assertTrue(false);
		} catch (ObjectValidatorException ex) {
			List<ObjectValidatorMessage> msgs = ex.getMessages();
			for (Iterator iterator = msgs.iterator(); iterator.hasNext();) {
				ObjectValidatorMessage objectValidatorMessage = (ObjectValidatorMessage) iterator.next();
				if (objectValidatorMessage.getMsg().equals("error.username.empty")) {
					assertTrue(true);
				} else if (objectValidatorMessage.getMsg().equals("error.username.format")) {
					assertTrue(true);
				} else {
					assertTrue(false);
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	}

}
