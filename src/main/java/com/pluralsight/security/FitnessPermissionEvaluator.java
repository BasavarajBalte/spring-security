package com.pluralsight.security;

import java.io.Serializable;

import javax.activation.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

public class FitnessPermissionEvaluator implements PermissionEvaluator {
	  
	private javax.sql.DataSource dataSource;

	public javax.sql.DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(javax.sql.DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Object[] args = {((User) auth.getPrincipal()).getUsername(),targetDomainObject.getClass().getName(),
				permission.toString()};
		int count = jdbcTemplate.queryForObject("select count(*) from permissions p where "
				+ "p.username = ? and p.target = ? p.permission = ? ",args,Integer.class);
		if(count == 1) {
			return true;
		}else {
		return false;
		}
	}

	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
		// TODO Auto-generated method stub
		return false;
	}

}
 