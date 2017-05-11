/**
 * 
 */
package com.journaldev.jaxrs.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author julien.aubert (AUBAY)
 * @date 27 janv. 2017
 * @version 1.0
 */
@XmlRootElement(name = "response")
public class GenericResponse {

	private boolean status;
	private String message;
	private String errorCode;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return status + "|" + message + "|" + errorCode;
	}
}