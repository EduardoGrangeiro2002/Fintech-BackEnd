package domain.usecases;

public interface IRegisteCustomer {
	public String register(String name, String email, String password) throws Exception;
}
