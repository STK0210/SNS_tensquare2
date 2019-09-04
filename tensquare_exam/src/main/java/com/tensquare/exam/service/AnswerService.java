package com.tensquare.exam.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import util.IdWorker;

import com.tensquare.exam.dao.AnswerDao;
import com.tensquare.exam.pojo.Answer;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class AnswerService {

	@Autowired
	private AnswerDao answerDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Answer> findAll() {
		return answerDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Answer> findSearch(Map whereMap, int page, int size) {
		Specification<Answer> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return answerDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Answer> findSearch(Map whereMap) {
		Specification<Answer> specification = createSpecification(whereMap);
		return answerDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Answer findById(String id) {
		return answerDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param answer
	 */
	public void add(Answer answer) {
		answer.setId( idWorker.nextId()+"" );
		answerDao.save(answer);
	}

	/**
	 * 修改
	 * @param answer
	 */
	public void update(Answer answer) {
		answerDao.save(answer);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		answerDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Answer> createSpecification(Map searchMap) {

		return new Specification<Answer>() {

			@Override
			public Predicate toPredicate(Root<Answer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 
                if (searchMap.get("answercontent")!=null && !"".equals(searchMap.get("answercontent"))) {
                	predicateList.add(cb.like(root.get("answercontent").as(String.class), "%"+(String)searchMap.get("answercontent")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
