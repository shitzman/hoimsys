package hoimsys.dao;

import hoimsys.po.Department;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer dtId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer dtId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}