package com.dut.dto;

import lombok.Data;

import java.util.List;

/**
 * 分页泛型类
 */
@Data
public class PageDto<T> {
    /**
     * 当前页码
     */
    private int page;

    /**
     * 每页条数
     */
    private int size;

    /**
     * 总条数
     */
    private long total;


    /**
     * 分页数据
     */
    private List<T> list;

    @Override
    public String toString() {
        return "PageDto{" +
                "page=" + page +
                ", size=" + size +
                ", total=" + total +
                ", list=" + list +
                '}';
    }
}
