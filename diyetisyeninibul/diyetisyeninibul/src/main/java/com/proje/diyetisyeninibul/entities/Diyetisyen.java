package com.proje.diyetisyeninibul.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Diyetisyen")
public class Diyetisyen {
	@Id
	@Column(name="diyetisyen_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int diyetisyenID;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="bio")
	private String bio;
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="breakfast")
	private String breakfast;
	
	@Column(name="lunch")
	private String lunch;
	
	@Column(name="dinner")
	private String dinner;
	
	@Column(name="email")
	private String email;
	
	@Column(name="numberOfOrders")
	private int numberOfOrders;
	
	@Column(name="sum")
	private int sum;
	
	@Column(name="diyetisyenPhoto")
	private String diyetisyenPhoto;
	
	@Column(name="breakfastPhoto")
	private String breakfastPhoto;
	
	@Column(name="lunchPhoto")
	private String lunchPhoto;
	
	@Column(name="dinnerPhoto")
	private String dinnerPhoto;
	
	public Diyetisyen() {}

	public Diyetisyen(int diyetisyenID, String firstName, String lastName, String bio, int rating, String breakfast,
			String lunch, String dinner, String email) {
		this.diyetisyenID = diyetisyenID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bio = bio;
		this.rating = rating;
		this.breakfast = breakfast;
		this.lunch = lunch;
		this.dinner = dinner;
		this.email = email;
	}

	public int getDiyetisyenID() {
		return diyetisyenID;
	}

	public void setDiyetisyenId(int diyetisyenID) {
		this.diyetisyenID = diyetisyenID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}

	public String getLunch() {
		return lunch;
	}

	public void setLunch(String lunch) {
		this.lunch = lunch;
	}

	public String getDinner() {
		return dinner;
	}

	public void setDinner(String dinner) {
		this.dinner = dinner;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNumberOfOrders() {
		return numberOfOrders;
	}

	public void setNumberOfOrders(int numberOfOrders) {
		this.numberOfOrders = numberOfOrders;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	
	@Transient
	public String getDiyetisyenPhoto() {
		if (diyetisyenPhoto == null || (Integer)diyetisyenID == null)
			return null;

	return "/diyetisyen-photos/" + diyetisyenID + "/" + diyetisyenPhoto;
	}

	public void setDiyetisyenPhoto(String diyetisyenPhoto) {
		this.diyetisyenPhoto = diyetisyenPhoto;
	}

	@Transient
	public String getBreakfastPhoto() {
		if (breakfastPhoto == null || (Integer)diyetisyenID == null)
			return null;

		return "/breakfast-photos/" + diyetisyenID + "/" + breakfastPhoto;
	}

	public void setBreakfastPhoto(String breakfastPhoto) {
		this.breakfastPhoto = breakfastPhoto;
	}

	@Transient
	public String getLunchPhoto() {
		if (lunchPhoto == null || (Integer)diyetisyenID == null)
			return null;

		return "/lunch-photos/" + diyetisyenID + "/" + lunchPhoto;
	}

	public void setLunchPhoto(String lunchPhoto) {
		this.lunchPhoto = lunchPhoto;
	}

	@Transient
	public String getDinnerPhoto() {
		if (dinnerPhoto == null || (Integer)diyetisyenID == null)
			return null;

		return "/dinner-photos/" + diyetisyenID + "/" + dinnerPhoto;
	}

	public void setDinnerPhoto(String dinnerPhoto) {
		this.dinnerPhoto = dinnerPhoto;
	}
	
	
}
