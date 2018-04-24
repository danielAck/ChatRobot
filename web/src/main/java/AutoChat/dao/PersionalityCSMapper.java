package AutoChat.dao;

import AutoChat.pojo.PersionalityCS;

public interface PersionalityCSMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersionalityCS record);

    int insertSelective(PersionalityCS record);

    PersionalityCS selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersionalityCS record);

    int updateByPrimaryKeyWithBLOBs(PersionalityCS record);

    String selectAnswerByQuestion(String question);
}