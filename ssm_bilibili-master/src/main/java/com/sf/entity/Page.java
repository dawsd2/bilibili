package com.sf.entity;

import java.util.List;

public class Page {
    // 总页数
    private int totalPageCount = 0;
    // 页面大小，即每页显示记录数
    private int pageSize = 5;
    // 记录总数
    private int totalCount;
    // 当前页码
    private int currPageNo = 1;
    // 每页新闻集合
    private List<VideoEntity> VideoList;


    public int getCurrPageNo() {
        if (totalPageCount == 0)
            return 0;
        return currPageNo;
    }

    public void setCurrPageNo(int currPageNo) {
        if (currPageNo > 0)
            this.currPageNo = currPageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize > 0)
            this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount > 0) {
            this.totalCount = totalCount;
            // 计算总页数
            totalPageCount = this.totalCount % pageSize == 0 ? (this.totalCount / pageSize)
                    : (this.totalCount / pageSize + 1);
        }
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }


    public List<VideoEntity> getNewsList() {
        return VideoList;
    }

    public void setNewsList(List<VideoEntity> VideoList) {
        this.VideoList = VideoList;
    }

    @Override
    public String toString() {
        return "Page{" +
                "totalPageCount=" + totalPageCount +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", currPageNo=" + currPageNo +
                ", VideoList=" + VideoList +
                '}';
    }
}
