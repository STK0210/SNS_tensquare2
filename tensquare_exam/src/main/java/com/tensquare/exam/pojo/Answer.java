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
@Table(name="answer")
public class Answer implements Serializable{

	@Id
	private String id;//


	
	private Integer userid;//
	private Integer examid;//
	private String answercontent;//
	private Integer grade;//

	
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

	public String getAnswercontent() {		
		return answercontent;
	}
	public void setAnswercontent(String answercontent) {
		this.answercontent = answercontent;
	}

	public Integer getGrade() {		
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}


	
}
