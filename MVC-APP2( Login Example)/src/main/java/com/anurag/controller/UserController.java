package com.anurag.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.anurag.domain.Login;
import com.anurag.service.UserService;

public class UserController extends AbstractController{
	
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String targetName="/WEB-INF/pages/loginForm.jsp";
		String message="Invalid UserName or Password !Login Failed Plzz Try Again";
		if (userName!=null && password != null && userName.trim().length()>0 && password.trim().length()>0) {
			Login login=new Login();
			login.setUserName(userName);
			login.setPassword(password);
			login=userService.login(login);
			if (login.getUserID()!=null && login.getUserRole()!=null && login.getUserRole().trim().length()>0) {
				message="Welcome "+userName;
				if (login.getUserRole().equals("Admin")) {
					targetName="/WEB-INF/pages/adminHome.jsp";
				}else if (login.getUserRole().equals("Customer")) {
					targetName="/WEB-INF/pages/customerHome.jsp";
				}//else if
			}//if	
		}//if
		else{
			message="UserName or Password Cannot Be Empty ! Login Failed Plzz Try Again";
		}
		return new ModelAndView(targetName, "msg", message);
	}//method
}//class
