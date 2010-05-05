package de.kerner.commons.ee.web;

import java.io.Serializable;

public abstract class AbstractUserBean implements Serializable {

	private static final long serialVersionUID = 5660659333319105816L;

	private String username;

	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
