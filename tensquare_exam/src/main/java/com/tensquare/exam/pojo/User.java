package com.tensquare.exam.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="user")
public class User implements Serializable{

	@Id
	private String id;//


	
	private Integer userid;//
	private String password;//
	private String registData;//
	private Integer role;//

	
	public String getId() {		
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public Integer getUserid() {		
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getPassword() {		
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegistData() {		
		return registData;
	}
	public void setRegistData(String registData) {
		this.registData = registData;
	}

	public Integer getRole() {		
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}


	
}
