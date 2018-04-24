package AutoChat.dao;

import AutoChat.pojo.PersionalityWH;

public interface PersionalityWHMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersionalityWH record);

    int insertSelective(PersionalityWH record);

    PersionalityWH selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersionalityWH record);

    int updateByPrimaryKeyWithBLOBs(PersionalityWH record);

    String selectAnswerByQuestion(String question);
}