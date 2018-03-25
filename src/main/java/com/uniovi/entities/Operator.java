package com.uniovi.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.uniovi.entities.types.OperatorKind;

@Entity
public class Operator {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique=true)
	private String email;
	private String password;
	private OperatorKind kind;
	
	@OneToMany(mappedBy="operator", cascade=CascadeType.ALL)
	private Set<Incident> incidents = new HashSet<>();
	
	public Operator() {
		
	}

	public Operator(String email, String password) {
		super();
		setEmail(email);
		setPassword(password);
	}
	
	public Operator(String email, String password, OperatorKind kind) {
		this(email,password);
		setKind(kind);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Incident> getIncidents() {
		return incidents;
	}

	public void setIncidents(Set<Incident> incidents) {
		this.incidents = incidents;
	}
	
	public void assignIncident(Incident incident) {
		this.incidents.add(incident);
	}
	
	public boolean isAssignedToIncident(Incident incident) {
		return this.incidents.contains(incident);
	}

	public OperatorKind getKind() {
		return kind;
	}

	public void setKind(OperatorKind kind) {
		this.kind = kind;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operator other = (Operator) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Operator [id=" + id + ", email=" + email + ", password=" + password + ", incidents=" + incidents + "]";
	}
		
	
}
