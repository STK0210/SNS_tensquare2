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

import com.tensquare.exam.dao.UelistDao;
import com.tensquare.exam.pojo.Uelist;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class UelistService {

	@Autowired
	private UelistDao uelistDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Uelist> findAll() {
		return uelistDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Uelist> findSearch(Map whereMap, int page, int size) {
		Specification<Uelist> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return uelistDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Uelist> findSearch(Map whereMap) {
		Specification<Uelist> specification = createSpecification(whereMap);
		return uelistDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Uelist findById(String id) {
		return uelistDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param uelist
	 */
	public void add(Uelist uelist) {
		uelist.setId( idWorker.nextId()+"" );
		uelistDao.save(uelist);
	}

	/**
	 * 修改
	 * @param uelist
	 */
	public void update(Uelist uelist) {
		uelistDao.save(uelist);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		uelistDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Uelist> createSpecification(Map searchMap) {

		return new Specification<Uelist>() {

			@Override
			public Predicate toPredicate(Root<Uelist> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
