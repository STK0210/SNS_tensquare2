package com.tensquare.friend.service;

import com.tensquare.friend.dao.FriendDao;
import com.tensquare.friend.dao.NoFriendDao;
import com.tensquare.friend.pojo.Friend;
import com.tensquare.friend.pojo.NoFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @auther likeyu
 * @create 2019-09-08-14:17
 **/
@Service
@Transactional
public class FriendService {

    @Autowired
    private FriendDao friendDao;

    @Autowired
    private NoFriendDao noFriendDao;

    public int addFriend(String userid, String friendid) {
        //判断userid到friendid是否有数据，有就是重复添加，返回0
        Friend friend = friendDao.findByUseridAndFriendid(userid, friendid);
        if (friend != null) {
            return 0;//已有数据重复添加
        }
        //直接添加好友，让好友表中userid到friendid方向的type为0
        friend = new Friend();
        friend.setUserid(userid);
        friend.setFriendid(friendid);
        friend.setIslike("0");
        friendDao.save(friend);
        //判断从friendid到userid是否有数据，如果有把双方的状态都改为1
        if (friendDao.findByUseridAndFriendid(friendid, userid) != null) {
            //朋友也喜欢你，那么就把双方的状态都改为1
            friendDao.updateIslike("1", userid, friendid);
            friendDao.updateIslike("1", friendid, userid);
        }
        return 1;
    }


    public int addNoFriend(String userid, String friendid) {
        //判断是否已经是非好友
        NoFriend noFriend = noFriendDao.findByUseridAndFriendid(userid, friendid);
        if (noFriend != null) {
            //已经是非好友了，不能重复不喜欢
            return 0;
        }
        noFriend = new NoFriend();
        noFriend.setUserid(userid);
        noFriend.setFriendid(friendid);
        noFriendDao.save(noFriend);
        return 1;
    }

    public void deleteFriend(String userid, String friendid) {
        //删除朋友表中userid到friendid这条数据
        friendDao.deleteFriend(userid, friendid);
        //更新朋友表中朋友对你的状态（0是朋友单向喜欢你，因为你和朋友已经删除状态了），找不到会空操作一次，不影响
        friendDao.updateIslike("0", friendid, userid);
        //非好友表中添加数据，把我对朋友添加进非好友表
        NoFriend nofriend = new NoFriend();
        nofriend.setUserid(userid);
        nofriend.setFriendid(friendid);
        noFriendDao.save(nofriend);
    }
}
