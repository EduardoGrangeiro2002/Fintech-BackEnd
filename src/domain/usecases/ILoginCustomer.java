package domain.usecases;

public interface ILoginCustomer {
	public String login(String email, String password) throws Exception;
}
