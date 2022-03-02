package com.fc.vo;

import java.util.List;

/**
 *
 * @param <T> 泛型
 */
public class PageInfo<T> {
    //总页数
    private int pageCount;
    //共几页
    private int totalCount;
    private int pageSize;
    //当前页
    private int pageNo;
    private List<T> list;

    public PageInfo() {
    }

    public PageInfo(int totalCount, int pageSize, int pageNo, List<T> list) {
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.list = list;
        if (totalCount%pageSize==0){
            this.pageCount=totalCount/pageSize;
        }else {
            this.pageCount=totalCount/pageSize+1;
        }
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
