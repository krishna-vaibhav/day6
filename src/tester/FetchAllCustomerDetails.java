package tester;
import static utils.HibernateUtils.*;

import org.hibernate.SessionFactory;

import dao.CustomerDaoImpl;

public class FetchAllCustomerDetails {

	public static void main(String[] args) {
		
		try(SessionFactory sf=getSf())
		{
			System.out.println("Hibernate bootstrapped....");
			new CustomerDaoImpl().fetchAllCustomers().forEach(System.out::println);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
