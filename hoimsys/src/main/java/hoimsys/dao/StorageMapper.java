package hoimsys.dao;

import hoimsys.po.Storage;

public interface StorageMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(Storage record);

    int insertSelective(Storage record);

    Storage selectByPrimaryKey(Integer sId);

    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);
}