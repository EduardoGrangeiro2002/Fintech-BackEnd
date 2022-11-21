package dataLayer.DAO;

import domain.beans.Customer;

public interface IDAOCustomer {
	public String create(String name, String email, String password) throws Exception;
	
	public Customer selectByEmail(String email) throws Exception;
	
	public String update(int idCustomer, String name, String email, String password, int idAddress, int idDocument, int idAccount) throws Exception;
	
	public Customer selectByIdCustomer(int idCustomer) throws Exception;
}
