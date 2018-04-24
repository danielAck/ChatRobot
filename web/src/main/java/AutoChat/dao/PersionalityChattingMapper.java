package AutoChat.dao;

import AutoChat.pojo.PersionalityChatting;

public interface PersionalityChattingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersionalityChatting record);

    int insertSelective(PersionalityChatting record);

    PersionalityChatting selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersionalityChatting record);

    int updateByPrimaryKeyWithBLOBs(PersionalityChatting record);

    String selectAnswerByQuestion(String question);
}