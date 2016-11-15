package com.infosys.ssh.util;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class HibernateDaoSupportIpml extends HibernateDaoSupport {
	
	
	
	public Session getCurrentSession() {
		return super.getSessionFactory().getCurrentSession();
		
	}
}
