package com.centurydean.platform.login.bo.impl;

import java.util.List;




import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centurydean.platform.login.bo.LoginBo;
import com.centurydean.platform.login.dao.UserMapper;
import com.centurydean.platform.login.pojo.User;

/**
 * Author：Galo
 * CreateTime：2015年4月28日 下午3:20:56
 * UpdateBy：Galo
 * UpdateTime：2015年4月28日 下午3:20:56
 * Copyright：CenturyDean.com
 * Description：TODO(简单描述一下该文件功能)
 * Comment：TODO(其它说明)
 */
@Service("loginBoImpl")
public class LoginBoImpl implements LoginBo{
	
	public static final Logger logger = Logger.getLogger(LoginBoImpl.class);
	
	@Autowired
	private UserMapper loginDao;
	
	@Override
	public List<User> findAll() {
		
		List<User> users = null;
		try {
			users = loginDao.findAll();
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return users;
	}

}
