package tester;
import static utils.HibernateUtils.*;

import org.hibernate.SessionFactory;

public class TestHibernate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(SessionFactory sf=getSf())
		{
			System.out.println("Hibernate bootstrapped....");
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
