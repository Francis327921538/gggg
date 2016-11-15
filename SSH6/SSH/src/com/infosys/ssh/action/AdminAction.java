package com.infosys.ssh.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import com.infosys.ssh.domain.Admin;
import com.infosys.ssh.domain.User;
import com.infosys.ssh.service.AdminService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author alan.chen
 *
 */
public class AdminAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AdminService adminService;
	public Admin admin;
	
	/**
	 * 初始化密码
	 * @return
	 */
	public String initPassword() {
		String returnString = "loginUI";
		
		return returnString;
	}
	
	/**
	 * 登录
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		String returnString = "loginUI";
		//登录验证
		System.out.println(admin.getUsername()+"0000000000000");
		Admin currentAdmin = (Admin)adminService.getUsernameAndPassword(admin.getUsername(), admin.getPassword());
		System.out.println(currentAdmin);
		if (admin == null) { // 如果登录失败
			addFieldError("loginError", "username or password error!");
			returnString = "loginUI";
		} else {
			ActionContext.getContext().getSession().put("currentAdmin", currentAdmin);
			returnString  = "toIndex";
		}
		return returnString;
	}

	/**
	 * 查询所有
	 * @return
	 */
	public String list() throws Exception {
		String returnString = "list";
		List<Admin> admins = (List<Admin>) adminService.getList();
		ActionContext.getContext().getSession().put("admins", admins);
		return returnString;
	}
	/**
	 * 添加界面
	 * @return
	 */
	public String addUI() throws Exception {
		return "addUI";
	}
	
	/**
	 * 添加界面
	 * @return
	 */
	public String loginUI() throws Exception {
		return "loginUI";
	}
	
	/**
	 * 添加
	 * @return
	 */
	public String add() throws Exception {
		String returnString = "add";
		adminService.add(getAdmin());
		return returnString;
	}
	/**
	 * 删除
	 * @return
	 */
	public String delete() throws Exception {
		String returnString = "delete";
		adminService.delete(getAdmin().getId());
		return returnString;
	}
	
	/**
	 * 修改管理员密码
	 * @return
	 */
	public String updatePassword() throws Exception {
		String returnString = "updatePassword";
		adminService.updatePassword(getAdmin());
		return returnString;
	}
	
	/**
	 * 退出系统
	 * @return
	 */
	public String logout() throws Exception {
		String returnString = "logout";
		ActionContext.getContext().getSession().remove("currentAdmin");
		return returnString;
	}
	
	/**
	 * 查看个人信息
	 * @return
	 */
	public String seeMyInfo() {
		String returnString = "seeMyInfo";
		Admin admin = (Admin)ActionContext.getContext().getSession().get("currentAdmin");
		// 从数据库中获取最新的数据
		Admin lastestAdmin = adminService.getById(admin.getId());
		// 将获取的对象放到栈顶，用于回显
		ActionContext.getContext().getValueStack().push(lastestAdmin);
		return returnString;
	}
	
	/**
	 *获取管理员的个数
	 * @return
	 */
	public String numOfAdmin() {
		int count = adminService.getCount();
		return "numOfAdmin";
	}
	/**
	 *  AdminAction类普通属性
	 */
	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
}
