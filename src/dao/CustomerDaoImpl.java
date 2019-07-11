package dao;

import static utils.HibernateUtils.getSf;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Customer;

public class CustomerDaoImpl implements CustomerDao {
//no data members(no instance vars, no constructors,no cleanup)
	@Override
	public String registerCustomer(Customer c) {
		Integer id=null;
		//open session
		//dao is requesting for session factory
		Session hs=getSf().openSession();
		//begin transaction
		Transaction tx=hs.beginTransaction();
		try {
			id=(Integer)hs.save(c);
			System.out.println("press enter to continue");
			System.in.read();
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null)
				{
					tx.rollback();
				}
			throw e;
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		finally
		{
			if(hs!=null)
			{
				hs.close();
				//It is necessary to close the connection pooled out database 
				//can return to the pool 
			}
		}
		return "Customer Registration successfully done with ID"+id;
	}

	@Override
	public Customer getCustomerDetails(int custId) {
		Customer c=null;
		//get session
		Session hs=getSf().openSession();
		//tx
		Transaction tx=hs.beginTransaction();
		try
		{
			//c -- id does not exist--null
			//if id exist -- c--- PERSISTENT
			c=hs.get(Customer.class, custId);
			c=hs.get(Customer.class, custId);
			c=hs.get(Customer.class, custId);
			
			tx.commit();
		}catch (HibernateException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}finally
		{
			if(hs!=null)
				hs.close();/*L1 cache cleared,the pooled out connections return to the pool*/
		}
		return c;//State of c is detached because it is removed from the l1 cache.
	}

	
	public List<Customer> fetchAllCustomers() {
		List<Customer> l1=null;
		String jpql="select c from Customer c";
		// hs
		Session hs=getSf().openSession();
		//tx
		Transaction tx=hs.beginTransaction();
		try{
			l1=hs.createQuery(jpql,Customer.class).getResultList();
			//l1---> list of persistent pojos  
			tx.commit();
		}
		catch(HibernateException e)
		{
			if(tx!=null)
			{
				tx.rollback();
				throw e;
			}
		}
		finally{
			if(hs!=null)
				hs.close();
		}
		return l1; //list of DETACHED pojos
	}
}
