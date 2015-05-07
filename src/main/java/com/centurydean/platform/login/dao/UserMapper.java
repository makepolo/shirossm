package com.centurydean.platform.login.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.centurydean.platform.login.pojo.User;

/**
 * Author：Galo
 * CreateTime：2015年4月21日 下午3:16:51
 * UpdateBy：Galo
 * UpdateTime：2015年4月21日 下午3:16:51
 * Copyright：CenturyDean.com
 * Description：用户刀
 * Comment：TODO(其它说明)
 */
@Repository
public interface UserMapper {
	
	public List<User> findAll() throws Exception;
	public User findByUid(Integer uid) throws Exception;
}
