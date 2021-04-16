package com.dut.mapper;

import com.dut.entity.PC;
import com.dut.entity.PCExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PCMapper {
    long countByExample(PCExample example);

    int deleteByExample(PCExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PC record);

    int insertSelective(PC record);

    List<PC> selectByExample(PCExample example);

    PC selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PC record, @Param("example") PCExample example);

    int updateByExample(@Param("record") PC record, @Param("example") PCExample example);

    int updateByPrimaryKeySelective(PC record);

    int updateByPrimaryKey(PC record);
}