package com.niit.skillmap_Backend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.skillmap_Backend.model.Employee;

@Repository("employeeDAO")
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	
	public boolean addUser(Employee employee) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		session.save(employee);
		tx.commit();
		return true;
	}

	public boolean deleteUser(String emp_Id) {
		sessionFactory.getCurrentSession().delete(getByid(emp_Id));
		return true;
	}

	public Employee getByName(String email) {
	
		return (Employee)sessionFactory.getCurrentSession()
				.createQuery("From Employee "
						+ "where emp_email=?"+email+".");
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllUsers() {
		
		return sessionFactory.getCurrentSession()
				.createQuery("From Employee").list();
				
	}

	public Employee getByid(String emp_Id) {
		
		return (Employee)sessionFactory.getCurrentSession()
				.createQuery("From Employee where emp_id='"+emp_Id+"'")
				.uniqueResult();
	}

	public boolean updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
		return true;
	}

}
