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
@Table(name="uelist")
public class Uelist implements Serializable{

	@Id
	private String id;//


	
	private Integer userid;//
	private Integer examid;//

	
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

	public Integer getExamid() {		
		return examid;
	}
	public void setExamid(Integer examid) {
		this.examid = examid;
	}


	
}
