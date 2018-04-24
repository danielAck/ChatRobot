package AutoChat.dao;

import AutoChat.pojo.UserFriend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserFriendMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserFriend record);

    int insertSelective(UserFriend record);

    UserFriend selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserFriend record);

    int updateByPrimaryKey(UserFriend record);

    int selectState(String friendId);

    UserFriend selectByFriendId(String friendId);

    List<UserFriend> selectFriends(Integer userId);

    void changeState(@Param("id") Integer id,@Param("state") Integer state);

}