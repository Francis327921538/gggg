package com.infosys.ssh.service.impl;

import java.util.List;
import com.infosys.ssh.dao.UserDao;
import com.infosys.ssh.domain.PageBean;
import com.infosys.ssh.domain.User;
import com.infosys.ssh.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	@Override
	public User userLogin(String username, String password) {
		
		return userDao.getUserByNamePwd(username, password);
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUserByID(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public PageBean<User> findByPage(int currPage) {
		
		PageBean<User> pageBean = new PageBean<>();
		
		pageBean.setCurPage(currPage);

		int pageSize = 6;
		pageBean.setPageSize(pageSize);
		
		int totalCount = userDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		
		int begin = (currPage - 1) * pageSize;
		List<User> list = userDao.findByPage(begin, pageSize);
		
		pageBean.setList(list);
		
		return pageBean;
	}

	@Override
	public PageBean<User> findByPageFuzzy(int currPage, String queryStr) {
		
		PageBean<User> pageBean = new PageBean<>();
		
		pageBean.setCurPage(currPage);
		
		int pageSize = 6;
		pageBean.setPageSize(pageSize);
		
		int totalCount = userDao.findCountFuzzy(queryStr);
		pageBean.setTotalCount(totalCount);
		
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		
		List<User> list = userDao.findByPageFuzzy(currPage, pageSize, queryStr);
		pageBean.setList(list);
		
		return pageBean;
	}

	@Override
	public User findUserByID(int selectedUserID) {

		User user = userDao.getUserByID(selectedUserID);
		return user;
	}

	@Override
	public boolean updateUser(int id, User updateUser) {
		
		return userDao.updateUserByID(id, updateUser);
	}
	@Override
	public boolean changePwd(int id, User updateUser) {
		
		return userDao.changePwdByID(id, updateUser);
	}

	@Override
	public String getPasswordByID(int id) {

		return  userDao.getUserByID(id).getPassword();
	}

	@Override
	public boolean uploadImage(int id, String imgPath) {
		
		return userDao.uploadFileByID(id, imgPath);
	}
	
}
