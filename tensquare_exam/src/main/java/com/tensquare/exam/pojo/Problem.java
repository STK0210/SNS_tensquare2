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
@Table(name="problem")
public class Problem implements Serializable{

	@Id
	private String id;//


	
	private Integer problemid;//
	private String problemcontent;//

	
	public String getId() {		
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public Integer getProblemid() {		
		return problemid;
	}
	public void setProblemid(Integer problemid) {
		this.problemid = problemid;
	}

	public String getProblemcontent() {		
		return problemcontent;
	}
	public void setProblemcontent(String problemcontent) {
		this.problemcontent = problemcontent;
	}


	
}
