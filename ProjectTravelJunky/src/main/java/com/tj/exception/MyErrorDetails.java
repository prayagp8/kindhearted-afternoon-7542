package com.tj.exception;

import java.time.LocalDateTime;

public class MyErrorDetails {
<<<<<<< HEAD
	 private LocalDateTime timestamp;
	 private String message;
	 private String description;
	 
	 public MyErrorDetails() {
		// TODO Auto-generated constructor stub
	}

	public MyErrorDetails(LocalDateTime timestamp, String message, String description) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.description = description;
	}
=======

	private LocalDateTime timestamp;
	private String message;
	private String description;
>>>>>>> 869447c114c7aa7f2df8a9da9a3a57e5eaa4ea3f

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "MyErrorDetails [timestamp=" + timestamp + ", message=" + message + ", description=" + description + "]";
	}
<<<<<<< HEAD
	 
}
=======

	public MyErrorDetails(LocalDateTime timestamp, String message, String description) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.description = description;
	}

	public MyErrorDetails() {
		// TODO Auto-generated constructor stub
	}

}
>>>>>>> 869447c114c7aa7f2df8a9da9a3a57e5eaa4ea3f
