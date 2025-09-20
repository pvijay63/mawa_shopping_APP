package com.shopping.dto;

public class AdminDetails {
	
	private int admin_id;
	private String admin_email_id;
    private String admin_password;
    private String admin_role;
    
    public AdminDetails() {
		// TODO Auto-generated constructor stub
	}
	public AdminDetails(int admin_id, String admin_email_id, String admin_password, String admin_role) {
		super();
		this.admin_id = admin_id;
		this.admin_email_id = admin_email_id;
		this.admin_password = admin_password;
		this.admin_role = admin_role;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	
	public String getAdmin_email_id() {
		return admin_email_id;
	}
	public void setAdmin_email_id(String admin_email_id) {
		this.admin_email_id = admin_email_id;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	public String getAdmin_role() {
		return admin_role;
	}
	public void setAdmin_role(String admin_role) {
		this.admin_role = admin_role;
	}
    
    @Override
    public String toString()
    {
    	return "Admin id :"+getAdmin_id()+" \n Admin email_id :"+getAdmin_email_id()
    +" \n Admin password : "+getAdmin_password()+"\n Admin_role :"+getAdmin_role();
    }
}
