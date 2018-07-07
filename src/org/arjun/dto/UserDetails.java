package org.arjun.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
//import javax.persistence.Table;

@Entity
public class UserDetails {
	@Id
	@GeneratedValue 
	private int userId;
	private String userName;

	//@JoinTable(name="USER_VEHICLE",joinColumns=@JoinColumn(name="USER_ID"),inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))
	@ManyToMany
	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();
	
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}


	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}


		public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName + " Saligomula";
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
