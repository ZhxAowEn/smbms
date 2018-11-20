package com.zhxw.smbms.pojo;

public class Smbms_Page {
    private Integer currPageNo = 1; // 当前页码
    private Integer pageSize = 5; // 页面大小，即每页显示记录数
    private Integer totalCount; // 记录总数
    private Integer totalPageCount; // 总页数


    public Integer getCurrPageNo() {
        return currPageNo;
    }

    public void setCurrPageNo(Integer currPageNo) {
        this.currPageNo = currPageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        // 计算总页数：总数量 / 每页显示数据条数 = 总页数
        // 如： (总数量 / 每页显示数据条数)有余数 在结果上 +1
        if (this.totalCount % this.pageSize == 0) {
            this.totalPageCount = this.totalCount / this.pageSize;
        } else {
            this.totalPageCount = (this.totalCount / this.pageSize) + 1;
        }
    }

    public Integer getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(Integer totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

}
