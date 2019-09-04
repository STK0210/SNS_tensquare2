package com.tensquare.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.exam.pojo.Answer;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface AnswerDao extends JpaRepository<Answer,String>,JpaSpecificationExecutor<Answer>{
	
}
