package hoimsys.dao;

import hoimsys.po.Title;

public interface TitleMapper {
    int deleteByPrimaryKey(Integer tId);

    int insert(Title record);

    int insertSelective(Title record);

    Title selectByPrimaryKey(Integer tId);

    int updateByPrimaryKeySelective(Title record);

    int updateByPrimaryKey(Title record);
}