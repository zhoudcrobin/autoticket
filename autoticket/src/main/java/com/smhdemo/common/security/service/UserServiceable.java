package com.smhdemo.common.security.service;

import com.smhdemo.common.base.BaseException;
import com.smhdemo.common.security.entity.User;

public interface UserServiceable {
    /**
     * 添加用户
     * 
     * @param user 用户对象
     * 
     * @return 用户账号
     * @throws BaseException
     */	
	Integer addUser(User user)throws BaseException;
	
    /**
     * 修改用户
     * 
     * @param user 用户对象
     * 
     * @return 用户账号
     * @throws BaseException
     */	
	Integer updUser(User user)throws BaseException;	
	
    /**
     * 修改用户密码
     * 
     * @param user 用户对象
     * 
     * @return 用户账号
     * @throws BaseException
     */	
	Integer updUserPassword(User user)throws BaseException;	
    /**
     * 删除用户
     * 
     * @param ccountName 用户对象账号
     * 
     * @return 用户账号
     * @throws BaseException
     */	
	void delUser(int pk)throws BaseException;	
	
    /**
     * 查询用户
     * 
     * @param accountName 用户对象账号
     * 
     * @return 用户对象
     * @throws BaseException
     */	
	User getUser(String accountName)throws BaseException;	
	
    /**
     * 查询用户
     * 
     * @param pk 用户id
     * 
     * @return 用户对象
     * @throws BaseException
     */	
	User getUser(int pk)throws BaseException;	
}
