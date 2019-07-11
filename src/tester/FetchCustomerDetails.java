package tester;
import static utils.HibernateUtils.*;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CustomerDaoImpl;

public class FetchCustomerDetails {

	public static void main(String[] args) {

		try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in))
		{
			System.out.println("Hibernate bootstrapped....");
			System.out.println("Enter customer id");
			System.out.println(new CustomerDaoImpl().getCustomerDetails(sc.nextInt()));
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
