package com.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.*;
import com.dao.*;

@RestController
public class RoleController {

	@Autowired
	RoleDao roleDao;

	@PostMapping("/role")
	public String addRole(RoleBean roleBean) {
		roleDao.addRole(roleBean);
		return "success";
	}

   @GetMapping("/roles")
   public List<RoleBean> listRoles()
   {
	   
	   return roleDao.listroles(); 
   }
   
   @DeleteMapping("/role/{roleId}")
   public List<RoleBean> deleteRole(@PathVariable("roleId") int id)
   {
	   roleDao.deleteRole(id);
	return roleDao.listroles();
	   
   }

}
