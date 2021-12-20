package dbaccess;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UpdateDepartment {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction trans = null;

		try {
			trans = session.beginTransaction();
			Query<Department> query = session.createQuery("from Department where department_nr = :deptNr");
			//Query<Department> query = session.getNamedQuery("getDepartmentByNr");
			int deptNr = 10;
			query.setParameter("deptNr", deptNr);
			Department dept = (Department) query.uniqueResult();
			dept.setLocation("Manila");
			session.save(dept);
			trans.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			trans.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
	}

}
