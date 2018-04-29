package com.uniovi.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.uniovi.entities.types.AgentKind;

@Document(collection = "agents")
public class Agent {
	@Id
	private String id;
	
	private String username;
	private String password;
	
	private AgentKind kind;
	
	public Agent() {
		
	}

	public Agent(String username, String password, AgentKind kind) {
		super();
		this.username = username;
		this.password = password;
		this.kind = kind;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AgentKind getKind() {
		return kind;
	}

	public void setKind(AgentKind kind) {
		this.kind = kind;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
		Agent other = (Agent) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agent [id=" + id + ", username=" + username + ", password=" + password + ", kind=" + kind + "]";
	}
	
	

}
