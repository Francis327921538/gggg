package com.infosys.ssh.dao.impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.context.ThreadLocalSessionContext;

import com.infosys.ssh.dao.AdminDao;
import com.infosys.ssh.domain.Admin;
import com.infosys.ssh.util.HibernateDaoSupportIpml;

/**
 * AdminDaoImpl类
 * @author alan.chen
 *
 */
public class AdminDaoImpl extends HibernateDaoSupportIpml implements AdminDao {

	public  void main(String[] args) {
		Admin admin = getUsernameAndPassword("1","1");
	}
	
	
	//Session session = null;
	/**
	 * 登录校验
	 */
	@Override
	public Admin getUsernameAndPassword(String username, String password) {
		
		String hql = "from Admin a where a.username=? and a.password=?";
		//Session session = getCurrentSession();
		Admin admin = (Admin)getCurrentSession().createQuery(hql)
			.setParameter(0, username)
			.setParameter(1, password)
			.uniqueResult();
		return admin;
	}

	/**
	 * 获取List
	 */
	@Override
	public List<Admin> getList() {
		//session = getCurrentSession();
		String hql = "from Admin";
		@SuppressWarnings("unchecked")
		List<Admin> admins = (List<Admin>)getCurrentSession().createQuery(hql).list();
		return admins;
	}

	/**
	 * 添加
	 */
	@Override
	public void add(Admin admin) {
		getCurrentSession().save(admin);
	}



	@Override
	public Admin findById(int id) {
		String hql = "from Admin a where a.id=?";
		return (Admin) getCurrentSession().createQuery(hql).setParameter(0, id);
	}

	/**
	 * 删除
	 */
	@Override
	public void delete(int id) {
		Admin admin = this.findById(id);
		getCurrentSession().delete(admin);
	}

	/**
	 * 更新
	 */
	@Override
	public void update(Admin admin) {
		getCurrentSession().update(admin);
	}

	@Override
	public int getCount() {
		String hql = "select count(*) from Admin";
		return (int) getCurrentSession().createQuery(hql).uniqueResult();
	}

	
	

}
