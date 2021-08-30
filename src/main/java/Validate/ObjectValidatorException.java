package Validate;

import java.util.ArrayList;
import java.util.List;

public class ObjectValidatorException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ObjectValidatorMessage> messages;
	// private Object relatedObject;

	public ObjectValidatorException() {
		super();
	}

	public ObjectValidatorException(List<ObjectValidatorMessage> messages) {
		super();
		this.messages = messages;
	}

	public ObjectValidatorException(ObjectValidatorMessage msg) {
		super();
		this.messages = new ArrayList<>();
		this.messages.add(msg);
	}

	public void addMessage(ObjectValidatorMessage msg) {
		getMessages().add(msg);
	}

	public List<ObjectValidatorMessage> getMessages() {
		if (messages == null) {
			messages = new ArrayList<ObjectValidatorMessage>();
		}
		return messages;
	}
}
