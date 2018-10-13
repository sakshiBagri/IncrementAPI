package com.RestAPI.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Counter")
public class Counter {
	

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

}
