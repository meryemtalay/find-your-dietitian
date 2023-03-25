package com.proje.diyetisyeninibul.entities;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

public class Login {
	@NotEmpty
	@Size(min=7, max=30)
	private String email;
	@NotEmpty
	@Size(min=6)
	private String password;
	@NotEmpty
	@Size(min=6)
	private String confirm;
	@NotEmpty
	@Size(min=16, max=16)
	private String cardNumber;
	@DateTimeFormat(pattern = "MM-yy")
	@NotEmpty
	@Size(min=5, max=5)
	private String cardExpDate;
	@NotEmpty
	@Size(min=4, max=4)
	private String cvv;
	@NotEmpty
	@Size(min=20)
	private String address;
	
	public Login(String email, String password, String confirm, String cardNumber, String cardExpDate, String cvv,
			String address) {
		this.email = email;
		this.password = password;
		this.confirm = confirm;
		this.cardNumber = cardNumber;
		this.cardExpDate = cardExpDate;
		this.cvv = cvv;
		this.address = address;
	}

	public Login() {
		
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

	public String getconfirm() {
		return confirm;
	}

	public void setconfirm(String confirm) {
		this.confirm = confirm;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public String getCardExpDate() {
		return cardExpDate;
	}

	public void setCardExpDate(String cardExpDate) {
		this.cardExpDate = cardExpDate;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
