package com.rktirtho.chat.model;

public class MessageModel {
	
	private String massage;
	private String fromLogin;
	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}
	public String getFromLogin() {
		return fromLogin;
	}
	public void setFromLogin(String fromLogin) {
		this.fromLogin = fromLogin;
	}
	@Override
	public String toString() {
		return "MassageModel [massage=" + massage + ", fromLogin=" + fromLogin + "]";
	}
	
	

}
