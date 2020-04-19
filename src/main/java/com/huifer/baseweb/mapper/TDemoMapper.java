package com.huifer.baseweb.mapper;

import com.huifer.baseweb.model.db.TDemo;
import com.huifer.baseweb.model.enums.SexEnums;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TDemoMapper {

  int deleteByPrimaryKey(Integer id);

  int insert(TDemo record);

  int insertSelective(TDemo record);

  TDemo selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(TDemo record);

  int updateByPrimaryKey(TDemo record);

  TDemo queryEnums(@Param("man") SexEnums man);
}