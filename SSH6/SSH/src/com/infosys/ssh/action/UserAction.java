package com.infosys.ssh.action;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.infosys.ssh.domain.PageBean;
import com.infosys.ssh.domain.User;
import com.infosys.ssh.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private String username;
	private String password;
	private String passwordC;
	private int currPage = 1;
	private int scurrPage = 1;
	private String selectedUserID;
	private String queryStr = "";

	public String getPasswordC() {
		return passwordC;
	}

	public void setPasswordC(String passwordC) {
		this.passwordC = passwordC;
	}

	public String getSelectedUserID() {
		return selectedUserID;
	}

	public void setCurrUserID(String selectedUserID) {
		this.selectedUserID = selectedUserID;
	}

	public int getScurrPage() {
		return scurrPage;
	}

	public void setScurrPage(int scurrPage) {
		this.scurrPage = scurrPage;
	}

	public String getQueryStr() {
		return queryStr;
	}

	public void setQueryStr(String queryStr) {
		this.queryStr = queryStr;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() {
		System.out.println(username + password);
		User user = userService.userLogin(username, password);
		if (user != null) {
			ActionContext.getContext().getSession().put("currUser", user);
			System.out.println("currUser" + user);
			return "login";
		}
		return "err";
	}

	public String findAll() {
		System.out.println("aa");
		PageBean<User> pageBean = userService.findByPage(currPage);

		System.out.println(pageBean.toString());
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";

	}

	public String findFuzzy() {
		System.out.println("ok");
		PageBean<User> pageBean = userService.findByPageFuzzy(scurrPage, queryStr);
		pageBean.setQueryStr(queryStr);
		ActionContext.getContext().getValueStack().push(pageBean);

		return "findFuzzy";
	}

	public void selectUser() {

		HttpServletRequest request = ServletActionContext.getRequest();
		selectedUserID = request.getParameter("selectedUserID");
		System.out.println(selectedUserID + "sdasd");
		User selectedUser = userService.findUserByID(Integer.parseInt(selectedUserID));
		ActionContext.getContext().getSession().put("selectedUser", selectedUser);
	}

	public String logout() {

		ActionContext.getContext().getSession().remove("currUser");
		System.out.println("out");
		return "logout";
	}

	public void updateUser() {

		User user = (User) ActionContext.getContext().getSession().get("currUser");
		int id = user.getId();
		HttpServletRequest request = ServletActionContext.getRequest();
		String tele = request.getParameter("tele");
		String email = request.getParameter("email");
		String address = request.getParameter("address");

		User updateUser = new User();
		updateUser.setTele(tele);
		updateUser.setEmail(email);
		updateUser.setAddress(address);

		boolean flag = userService.updateUser(id, updateUser);
		if (flag) {
			User newUser = userService.findUserByID(id);
			ActionContext.getContext().getSession().put("currUser", newUser);
			HttpServletResponse response = ServletActionContext.getResponse();
			try {
				response.getWriter().print(flag);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validatePwd() {

		HttpServletRequest request = ServletActionContext.getRequest();
		String passwordO = request.getParameter("passwordO");

		User user = (User) ActionContext.getContext().getSession().get("currUser");
		boolean flag = false;
		if (passwordO.equals(userService.getPasswordByID(user.getId()))) {
			flag = true;
		}

		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			response.getWriter().print(flag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(flag);
	}

	public String changePwd() {

		User user = (User) ActionContext.getContext().getSession().get("currUser");
		int id = user.getId();

		User updateUser = new User();
		updateUser.setPassword(passwordC);
		boolean flag = userService.changePwd(id, updateUser);
		System.out.println(flag + "zz");
		return "pwdChanged";

	}
}
