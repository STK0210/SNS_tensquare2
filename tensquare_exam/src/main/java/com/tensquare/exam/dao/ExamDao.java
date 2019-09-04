package com.tensquare.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.exam.pojo.Exam;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ExamDao extends JpaRepository<Exam,String>,JpaSpecificationExecutor<Exam>{
	
}
