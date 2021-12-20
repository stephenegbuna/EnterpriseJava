package dbaccess;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeleteDepartment {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;

		try {
			trans = session.beginTransaction();
			Query query = session.createQuery("delete Department d where departmentNr = 60"); 
			int result = query.executeUpdate();			 
			if (result > 0) {
			    System.out.println("Deleted a department");
			}
			trans.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			trans.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
