package app.lifeni.bms.dao;

import app.lifeni.bms.entity.Friend;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FriendDao {
    List<Friend> getFriend();
}
