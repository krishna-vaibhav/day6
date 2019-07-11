package tester;
import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CustomerDaoImpl;
import pojos.Customer;
import pojos.CustomerType;

public class RegisterCustomer {

	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in))
		{
			System.out.println("Hibernate bootstrapped....");
			System.out.println("Enter customer details name,email,password,regAmount,regDate,role,custType");
			Customer c1=new Customer(sc.next(), sc.next(), sc.next(), sc.nextDouble(), sdf.parse(sc.next()), sc.next(), CustomerType.valueOf(sc.next().toUpperCase()));
			System.out.println(new CustomerDaoImpl().registerCustomer(c1));
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
