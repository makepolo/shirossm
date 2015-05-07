package com.centurydean.platform.login.bo;

import java.util.List;


import com.centurydean.platform.login.pojo.User;

/**
 * Author：Galo
 * CreateTime：2015年4月28日 下午3:19:52
 * UpdateBy：Galo
 * UpdateTime：2015年4月28日 下午3:19:52
 * Copyright：CenturyDean.com
 * Description：TODO(简单描述一下该文件功能)
 * Comment：TODO(其它说明)
 */
public interface LoginBo {
	
	public List<User> findAll();
}
