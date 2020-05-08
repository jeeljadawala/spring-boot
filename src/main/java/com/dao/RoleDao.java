package com.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.RoleBean;

@Repository
public class RoleDao {

	@Autowired
	JdbcTemplate stmt;

	public void addRole(RoleBean roleBean) {

		stmt.update("insert into role(roleid,rolename) values (?,?)",roleBean.getRoleId(),roleBean.getRoleName());
	}

	public List<RoleBean> listroles()
	{
		 List<RoleBean> roles =stmt.query("select * from role",new RoleBeanRowMapper());
		return roles;
	}

	class RoleBeanRowMapper implements RowMapper<RoleBean>
	{
		public RoleBean mapRow(ResultSet rs, int rowNo) throws SQLException
		{
			RoleBean roleBean =new RoleBean();
			roleBean.setRoleId(rs.getInt("roleid"));
			roleBean.setRoleName((rs.getString("rolename")));
			return null;
			
		}
		
	}
	public void deleteRole(int id)
	{
		stmt.update("delete from role where roleid = ?",id);
	}
}
