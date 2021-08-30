package Controller;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import DateUtils.DateUtils;
import Validate.ObjectValidatorException;
import Validate.ObjectValidatorMessage;
import Entity.User;
import HibernateUtil.HibernateUtil;

/**
 * CRUD database operations
 * 
 * @author Caven Fernanda
 *
 */
public class UserController {

	public void validateResource(User r) throws ObjectValidatorException, Exception {

		List<ObjectValidatorMessage> messages = new ArrayList<>();

		if (r == null) {
			throw new NullPointerException();
		}

		String firstName = r.getFirstName();
		if (firstName == null || firstName.isEmpty() || firstName.isBlank()) {
			messages.add(new ObjectValidatorMessage(ObjectValidatorMessage.MSG_ERROR, "error.firstName.empty"));
		} else if (!(firstName.matches("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$"))) {
			messages.add(new ObjectValidatorMessage(ObjectValidatorMessage.MSG_ERROR,
					"error.firstName.containsNumbers/specialCharacters"));
		}

		String lastName = r.getLastName();
		if (lastName == null || lastName.isEmpty() || lastName.isBlank()) {
			messages.add(new ObjectValidatorMessage(ObjectValidatorMessage.MSG_ERROR, "error.lastname.empty"));
		} else if (!(firstName.matches("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){2,24}$"))) {
			messages.add(new ObjectValidatorMessage(ObjectValidatorMessage.MSG_ERROR,
					"error.lastName.containsNumbers/specialCharacters"));
		}

		if (!messages.isEmpty()) {
			throw new ObjectValidatorException(messages);
		}
		// -------------------------Date Validation

		Calendar dob = r.getDob();

		if (DateUtils.formatDate(dob) == null || DateUtils.formatDate(dob).trim().isEmpty()) {
			messages.add(new ObjectValidatorMessage(ObjectValidatorMessage.MSG_ERROR, "error.date.null"));
		} else if (!DateUtils.isValidDate(DateUtils.formatDate(dob))) {
			messages.add(new ObjectValidatorMessage(ObjectValidatorMessage.MSG_ERROR, "error.date.format"));
		}

		if (!messages.isEmpty()) {
			throw new ObjectValidatorException(messages);
		}

		String address = r.getAddress();
		if (address == null || address.isEmpty() || address.isBlank()) {
			messages.add(new ObjectValidatorMessage(ObjectValidatorMessage.MSG_ERROR, "error.address.empty"));
		} else if (!(address.matches(
				"[\sa-zA-Z0-9]+[\\s,;]+[\sa-zA-Z0-9]+[\\s,;]+[\sa-zA-Z]+[\\s,;]+[\sa-zA-Z]+[\\s,;]+[0-9]{4}"))) {
			messages.add(new ObjectValidatorMessage(ObjectValidatorMessage.MSG_ERROR, "error.address.format"));
		}

		if (!messages.isEmpty()) {
			throw new ObjectValidatorException(messages);
		}

		String phoneNo = r.getPhoneNo();
		if (phoneNo == null || phoneNo.isEmpty() || phoneNo.isBlank()) {
			messages.add(new ObjectValidatorMessage(ObjectValidatorMessage.MSG_ERROR, "error.phoneNumber.empty"));
		} else if (!(phoneNo.matches("^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"))) {
			messages.add(new ObjectValidatorMessage(ObjectValidatorMessage.MSG_ERROR, "error.phoneNo.format"));
		}

		if (!messages.isEmpty()) {
			throw new ObjectValidatorException(messages);
		}

		// Dont forget o make email utils

		String emailAddress = r.getEmailAddress();
		if (emailAddress == null || emailAddress.isEmpty() || emailAddress.isBlank()) {
			messages.add(new ObjectValidatorMessage(ObjectValidatorMessage.MSG_ERROR, "error.emailAddress.empty"));
		} else if (!(emailAddress.matches(
				"^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"))) {
			messages.add(new ObjectValidatorMessage(ObjectValidatorMessage.MSG_ERROR, "error.emailAddress.format"));
		}

		String userName = r.getUsername();
		if (userName == null || userName.isBlank() || userName.isBlank()) {
			messages.add(new ObjectValidatorMessage(ObjectValidatorMessage.MSG_ERROR, "error.username.empty"));
		} else if (!(userName.matches("^[a-zA-Z0-9._-]{3,}$"))) {
			messages.add(new ObjectValidatorMessage(ObjectValidatorMessage.MSG_ERROR, "error.username.format"));
		}

		String password = r.getPassword();
		if (password == null || password.isBlank() || password.isEmpty()) {
			messages.add(new ObjectValidatorMessage(ObjectValidatorMessage.MSG_ERROR, "error.password.empty"));
		} else if (!(password
				.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$"))) {
			messages.add(new ObjectValidatorMessage(ObjectValidatorMessage.MSG_ERROR, "error.password.strength"));
		}

//		Resource managerId = r.getManager();
//		if (getManager != null) {
//			messages.add(new ObjectValidatorMessage(ObjectValidatorMessage.MSG_ERROR, "error.managerId.null"));
//		}
	}

	//////////////////////////////////// Create
	//////////////////////////////////// Resource///////////////////////////////////////////
	public User createUser(User user) throws HibernateException {

		Transaction transaction = null;



		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// start the transaction
			transaction = session.beginTransaction();

            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(user);
            // commit transaction
            transaction.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return user;
	}


}