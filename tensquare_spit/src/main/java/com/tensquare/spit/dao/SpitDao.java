package com.tensquare.spit.dao;

import com.tensquare.spit.pojo.Spit;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @auther likeyu
 * @create 2019-09-03-21:16
 **/
public interface SpitDao extends MongoRepository<Spit, String> {

}