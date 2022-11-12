package com.tj.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Travels {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer travelsId;
	
	@Pattern(regexp = "^[A-Z][a-z]",message = "Name cannot start with number of symbol")
	private String travelsName;
	
	@Pattern(regexp = "^[A-Z][a-z]",message = "Name cannot start with number of symbol")
	private String agentName;
	private String address;
	private String contact;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private currentUserSession currenUserSession;
	
	
	
	
	public Travels() {

	}

	
	


	public Travels(Integer travelsId, String travelsName, String agentName, String address, String contact,
			currentUserSession currenUserSession) {
		super();
		this.travelsId = travelsId;
		this.travelsName = travelsName;
		this.agentName = agentName;
		this.address = address;
		this.contact = contact;
		this.currenUserSession = currenUserSession;
	}





	public currentUserSession getCurrenUserSession() {
		return currenUserSession;
	}


	public void setCurrenUserSession(currentUserSession currenUserSession) {
		this.currenUserSession = currenUserSession;
	}


	public Integer getTravelsId() {
		return travelsId;
	}

	public void setTravelsId(Integer travelsId) {
		this.travelsId = travelsId;
	}

	public String getTravelsName() {
		return travelsName;
	}

	public void setTravelsName(String travelsName) {
		this.travelsName = travelsName;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}


	@Override
	public String toString() {
		return "Travels [travelsId=" + travelsId + ", travelsName=" + travelsName + ", agentName=" + agentName
				+ ", address=" + address + ", contact=" + contact + ", currenUserSession=" + currenUserSession + "]";
	}

}
