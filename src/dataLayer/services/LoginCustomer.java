package dataLayer.services;

import dataLayer.Crypto.CryptoString;
import dataLayer.DAO.IDAOCustomer;
import domain.beans.Customer;
import domain.usecases.ILoginCustomer;

public class LoginCustomer implements ILoginCustomer {
	private IDAOCustomer CustomerDAO;
	
	public LoginCustomer(IDAOCustomer CustomerDAO) {
		this.CustomerDAO = CustomerDAO;
	}
	
	
	@Override
	public String login(String email, String password) throws Exception {
		Customer customer = this.CustomerDAO.selectByEmail(email);
		
		String passwordHash = CryptoString.crypto(password);
		
		if(customer.getPassword().equals(passwordHash) == false) throw new Exception("Incorrect Email or Password!");
		
		String msg = "Login successfully!";
		
		return msg;
	}
	
}
