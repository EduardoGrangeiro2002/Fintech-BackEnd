package domain.beans;

import java.util.regex.Pattern;

public class Customer {
	private int idCustomer;
	private String email;
	private String name;
	private String password;
	private int idAddress;
	private int idDocument;
	private int idAccount;
	
	public Customer(String email, String password, String name) {
		this.email = email;
		this.password = password;
		this.name = name;
	}
	
	public Customer(
			int idCustomer,
			String email, 
			String name, 
			String password, 
			int idAddress, 
			int idDocument, 
			int idAccount
			) {
		this.setIdCustomer(idCustomer);
		this.setEmail(email);
		this.setName(name);
		this.setPassword(password);
		this.setIdAddress(idAddress);
		this.setIdDocument(idDocument);
		this.setIdAccount(idAccount);
	}
	
	public void setIdCustomer(int IdCustomer) {
		this.idCustomer = IdCustomer;
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(int idAddress) {
		this.idAddress = idAddress;
	}

	public int getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(int idDocument) {
		this.idDocument = idDocument;
	}

	public int getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}
	
	public boolean validateStrongPassword(String password) {
	     String COMPLEX_PASSWORD_REGEX =
	            "^(?:(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])|" +
	            "(?=.*\\d)(?=.*[^A-Za-z0-9])(?=.*[a-z])|" +
	            "(?=.*[^A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z])|" +
	            "(?=.*\\d)(?=.*[A-Z])(?=.*[^A-Za-z0-9]))(?!.*(.)\\1{2,})" +
	            "[A-Za-z0-9!~<>,;:_=?*+#.\"&§%°()\\|\\[\\]\\-\\$\\^\\@\\/]" +
	            "{8,32}$";
	     Pattern passwordPattern = Pattern.compile(COMPLEX_PASSWORD_REGEX);
	     
	     if(passwordPattern.matcher(password).matches()) {
	    	 return true;
	     }
	     else {
	    	 return false;
	     }
	}
	
	
}
