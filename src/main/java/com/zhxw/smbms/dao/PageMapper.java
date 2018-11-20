package com.zhxw.smbms.dao;

public interface PageMapper {
    //查询总数据量
    int querytotalCount(String tableName, String proCode, String proName, String userName, int userRole, String productName, int providerId, int isPayment) throws Exception;
}
