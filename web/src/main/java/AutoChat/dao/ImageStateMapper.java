package AutoChat.dao;

import AutoChat.pojo.ImageState;

public interface ImageStateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImageState record);

    int insertSelective(ImageState record);

    ImageState selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImageState record);

    int updateByPrimaryKeyWithBLOBs(ImageState record);

    int updateByPrimaryKey(ImageState record);
}