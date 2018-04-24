package AutoChat.dao;

import AutoChat.pojo.Customize;

public interface CustomizeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Customize record);

    int insertSelective(Customize record);

    Customize selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Customize record);

    int updateByPrimaryKeyWithBLOBs(Customize record);

    String selectAnswer(String question);
}