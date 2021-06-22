package app.lifeni.bms.mapper;

import app.lifeni.bms.po.Friend;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FriendMapper {
    List<Friend> getFriend();
}
