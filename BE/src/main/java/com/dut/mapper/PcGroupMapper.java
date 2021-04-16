package com.dut.mapper;

import com.dut.entity.PcGroup;
import com.dut.entity.PcGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PcGroupMapper {
    long countByExample(PcGroupExample example);

    int deleteByExample(PcGroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PcGroup record);

    int insertSelective(PcGroup record);

    List<PcGroup> selectByExample(PcGroupExample example);

    PcGroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PcGroup record, @Param("example") PcGroupExample example);

    int updateByExample(@Param("record") PcGroup record, @Param("example") PcGroupExample example);

    int updateByPrimaryKeySelective(PcGroup record);

    int updateByPrimaryKey(PcGroup record);
}