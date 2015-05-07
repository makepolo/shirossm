package com.centurydean.platform.login.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.centurydean.platform.login.bo.LoginBo;

/**
 * Author：Galo
 * CreateTime：2015年4月27日 下午4:33:25
 * UpdateBy：Galo
 * UpdateTime：2015年4月27日 下午4:33:25
 * Copyright：CenturyDean.com
 * Description：TODO(简单描述一下该文件功能)
 * Comment：TODO(其它说明)
 */
@Controller
public class LoginController {
	
	
	@Autowired
	@Resource(name="loginBoImpl")
	private LoginBo loginBo;
	
	@RequestMapping("login")
	public ModelAndView login(){
		
		System.out.println(loginBo.findAll().size());
		UsernamePasswordToken token = new UsernamePasswordToken("danica","12345");
		Subject subject = SecurityUtils.getSubject();
		try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            System.out.println("There is no user with username of " + token.getPrincipal());
        } catch (IncorrectCredentialsException ice) {
        	System.out.println("Password for account " + token.getPrincipal() + " was incorrect!");
        } catch (LockedAccountException lae) {
        	System.out.println("The account for username " + token.getPrincipal() + " is locked.  " +
                    "Please contact your administrator to unlock it.");
        }
		return new ModelAndView("index");
	}
	
	@RequestMapping("welcome")
	public void welcome(){
		
		System.out.println("username:" + String.valueOf(SecurityUtils.getSubject().getPrincipal()));
	}
}
