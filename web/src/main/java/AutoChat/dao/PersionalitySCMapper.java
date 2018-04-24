package AutoChat.dao;

import AutoChat.pojo.PersionalitySC;

public interface PersionalitySCMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersionalitySC record);

    int insertSelective(PersionalitySC record);

    PersionalitySC selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersionalitySC record);

    int updateByPrimaryKeyWithBLOBs(PersionalitySC record);

    String selectAnswerByQuestion(String question);
}