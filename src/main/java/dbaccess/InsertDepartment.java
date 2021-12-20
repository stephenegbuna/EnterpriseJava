package dbaccess;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class InsertDepartment {

	public static void main(String[] args) {
		InsertDepartment obj = new InsertDepartment();
		obj.saveEmployee();	
	}
	
	
	public void saveEmployee() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;

		try {
			trans = session.beginTransaction();
			Department d = new Department();
			d.setDepartmentNr(60);
			d.setName("Accounts");
			d.setLocation("Paris");
			session.save(d);
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
