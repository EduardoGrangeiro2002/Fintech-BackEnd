package dataLayer.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dataLayer.DAO.IDAOCustomer;
import domain.beans.Customer;
import main.singletons.ConnectionManager;

public class CustomerDAOImpl implements IDAOCustomer {
	private Connection connection;
	@Override
	public String create(String name, String email, String password) throws Exception {
		PreparedStatement stmt = null;
		try {
			connection = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_CUSTOMER (email, name, password, created_at) VALUES(SQ_T_CUSTOMER.nextval, ?, ?, ?, sysdate())";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, password);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return email;
	}

	@Override
	public Customer selectByEmail(String email) throws Exception {
		PreparedStatement stmt = null;
		ResultSet res = null;
		Customer customer = null;
		try {
			connection = ConnectionManager.getInstance().getConnection();
			String sql = 
					"SELECT "
					+ "id_customer as idCustomer, "
					+ "email, "
					+ "name, "
					+ "password, "
					+ "id_address AS idAddress, "
					+ "id_document AS idDocument, "
					+ "id_account AS idAccount "
					+ "WHERE email = ?";
			stmt = connection.prepareStatement(sql);
			res = stmt.executeQuery(sql);
			
			String name = res.getString("name");
			String password = res.getString("password");
			int idCustomer = res.getInt("idCustomer");
			int idAddress = res.getInt("idAddress");
			int idDocument = res.getInt("idDocument");
			int idAccount = res.getInt("idAccount");

			customer = new Customer(idCustomer, email, name, password, idAddress, idDocument, idAccount);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				res.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return customer;
	}

	@Override
	public String update(int idCustomer, String name, String email, String password, int idAddress, int idDocument, int idAccount) throws Exception {
		PreparedStatement stmt = null;
		try {
			connection = ConnectionManager.getInstance().getConnection();
			String sql = 
					"UPDATE T_CUSTOMER"
					+ "SET "
					+ "name = ?, "
					+ "email = ?, "
					+ "password = ?,"
					+ "id_address = ?, "
					+ "id_document = ?, "
					+ "id_account = ?, "
					+ "updated_at = sysdate()"
					+ "WHERE id_customer = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, password);
			stmt.setInt(4, idAddress);
			stmt.setInt(5, idDocument);
			stmt.setInt(6, idAccount);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return email;
	}

	@Override
	public Customer selectByIdCustomer(int idCustomer) throws Exception {
		PreparedStatement stmt = null;
		ResultSet res = null;
		Customer customer = null;
		try {
			connection = ConnectionManager.getInstance().getConnection();
			String sql = 
					"SELECT "
					+ "id_customer as idCustomer, "
					+ "email, "
					+ "name, "
					+ "password, "
					+ "id_address AS idAddress, "
					+ "id_document AS idDocument, "
					+ "id_account AS idAccount "
					+ "WHERE id_customer = ?";
			stmt = connection.prepareStatement(sql);
			res = stmt.executeQuery(sql);
			
			String name = res.getString("name");
			String email = res.getString("email");
			String password = res.getString("password");
			int idAddress = res.getInt("idAddress");
			int idDocument = res.getInt("idDocument");
			int idAccount = res.getInt("idAccount");

			customer = new Customer(idCustomer, email, name, password, idAddress, idDocument, idAccount);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				res.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return customer;
	}

}
