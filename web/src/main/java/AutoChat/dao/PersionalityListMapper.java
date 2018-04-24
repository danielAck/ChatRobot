package AutoChat.dao;

import AutoChat.pojo.PersionalityList;

public interface PersionalityListMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersionalityList record);

    int insertSelective(PersionalityList record);

    PersionalityList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersionalityList record);

    int updateByPrimaryKey(PersionalityList record);
}