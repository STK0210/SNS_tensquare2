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

import com.tensquare.exam.dao.ExamDao;
import com.tensquare.exam.pojo.Exam;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class ExamService {

	@Autowired
	private ExamDao examDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Exam> findAll() {
		return examDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Exam> findSearch(Map whereMap, int page, int size) {
		Specification<Exam> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return examDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Exam> findSearch(Map whereMap) {
		Specification<Exam> specification = createSpecification(whereMap);
		return examDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Exam findById(String id) {
		return examDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param exam
	 */
	public void add(Exam exam) {
		exam.setId( idWorker.nextId()+"" );
		examDao.save(exam);
	}

	/**
	 * 修改
	 * @param exam
	 */
	public void update(Exam exam) {
		examDao.save(exam);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		examDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Exam> createSpecification(Map searchMap) {

		return new Specification<Exam>() {

			@Override
			public Predicate toPredicate(Root<Exam> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 
                if (searchMap.get("examid")!=null && !"".equals(searchMap.get("examid"))) {
                	predicateList.add(cb.like(root.get("examid").as(String.class), "%"+(String)searchMap.get("examid")+"%"));
                }
                // 
                if (searchMap.get("examname")!=null && !"".equals(searchMap.get("examname"))) {
                	predicateList.add(cb.like(root.get("examname").as(String.class), "%"+(String)searchMap.get("examname")+"%"));
                }
                // 
                if (searchMap.get("desc")!=null && !"".equals(searchMap.get("desc"))) {
                	predicateList.add(cb.like(root.get("desc").as(String.class), "%"+(String)searchMap.get("desc")+"%"));
                }
                // 
                if (searchMap.get("problemids")!=null && !"".equals(searchMap.get("problemids"))) {
                	predicateList.add(cb.like(root.get("problemids").as(String.class), "%"+(String)searchMap.get("problemids")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
