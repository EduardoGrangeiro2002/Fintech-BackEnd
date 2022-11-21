package dataLayer.services;

import dataLayer.Crypto.CryptoString;
import dataLayer.DAO.IDAOCustomer;
import domain.beans.Customer;
import domain.usecases.IRegisteCustomer;

public class RegisterCustomer implements IRegisteCustomer {
	private IDAOCustomer CustomerDAO;
	
	@Override
	public String register(String name, String email, String password) throws Exception {
		Customer customer = new Customer(email, password, name);
		
		if(customer.validateStrongPassword(password) == false) {
			throw new Exception("Password must be a strong password!");
		};
		
		Customer checkIfEmailCustomerAlreadyInUse = CustomerDAO.selectByEmail(email);
		
		if(checkIfEmailCustomerAlreadyInUse != null) {
			throw new Exception("Email aready in use!");
		}
		
		String passwordHash = CryptoString.crypto(password);
		
		String insertEmail = CustomerDAO.create(name, email, passwordHash);
		
		String msg = "Customer register successfully! Email: " + insertEmail;
		
		return msg;
	}
}
