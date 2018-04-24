package AutoChat.dao;

import AutoChat.pojo.Common;

public interface CommonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Common record);

    int insertSelective(Common record);

    Common selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Common record);

    int updateByPrimaryKeyWithBLOBs(Common record);

    String selectAnswer(String question);
}