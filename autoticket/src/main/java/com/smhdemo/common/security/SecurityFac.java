package com.smhdemo.common.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhdemo.common.base.BaseException;
import com.smhdemo.common.security.entity.LoginLog;
import com.smhdemo.common.security.entity.Permission;
import com.smhdemo.common.security.entity.Role;
import com.smhdemo.common.security.entity.User;
import com.smhdemo.common.security.service.LoginLogServiceable;
import com.smhdemo.common.security.service.PermissionServiceable;
import com.smhdemo.common.security.service.RoleServiceable;
import com.smhdemo.common.security.service.UserServiceable;

/**
 * 用户功能业务实现统一集
 *  
 * 
 */
@Service
public class SecurityFac {
    @Autowired
    private UserServiceable userService;
    @Autowired
    private RoleServiceable roleService;  
    @Autowired
    private PermissionServiceable permissionService;     
    @Autowired
    private LoginLogServiceable loginLogService; 
    
	public Integer addUser(User vo) throws BaseException{
		return userService.addUser(vo);
	}


	public Integer updUser(User vo) throws BaseException{
		return userService.updUser(vo);
	}

	public Integer updUserPassword(User user)throws BaseException{
		return userService.updUserPassword(user);
	}
	public void delUser(int pk) throws BaseException{
		userService.delUser(pk);
	}


	public User getUser(int pk) throws BaseException{
		return userService.getUser(pk);
	}


	public User getUser(String accountName) throws BaseException {
		
		return userService.getUser(accountName);
	}


	public Integer addRole(Role vo) throws BaseException {
		return roleService.addRole(vo);
	}

	public Integer updRole(Role vo) throws BaseException {
		return roleService.updRole(vo);
	}


	public void delRole(int pk) throws BaseException {
		roleService.delRole(pk);
	}


	public Role getRole(int pk) throws BaseException {
		return roleService.getRole(pk);
	}

	public List<Role> getAllRole() {
		return roleService.getAllRole();
	}
	

	public Integer addPermission(Permission vo) throws BaseException {
		return permissionService.addPermission(vo);
	}


	public Integer updPermission(Permission vo) throws BaseException {
		return permissionService.updPermission(vo);
	}


	public void delPermission(int pk) throws BaseException {
		permissionService.delPermission(pk);		
	}


	public Permission getPermission(int pk) throws BaseException {
		return permissionService.getPermission(pk);
	}
	
	public Integer addLoginLog(LoginLog vo) {
		return loginLogService.addLoginLog(vo);
	}
}
