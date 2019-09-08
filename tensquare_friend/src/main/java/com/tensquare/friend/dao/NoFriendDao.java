package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.NoFriend;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @auther likeyu
 * @create 2019-09-08-14:18
 **/
public interface NoFriendDao extends JpaRepository<NoFriend, String> {

    public NoFriend findByUseridAndFriendid(String userid, String friendid);

}
