package com.zhxw.smbms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhxw.smbms.pojo.Smbms_Provider;

public interface ProviderService {
    /**
     * 查询供应商集合
     *
     * @param proCode
     * @param proName
     * @param currPageNo
     * @param pageSize
     * @return Provider
     */
    List<Smbms_Provider> getProviderList(@Param("proCode") String proCode,
                                         @Param("proName") String proName,
                                         @Param("currPageNo") Integer currPageNo, @Param("pageSize") Integer pageSize);

    /**
     * 查询供应商总数
     *
     * @param proCode
     * @param proName
     * @return
     */
    int getProviderCount(String proCode,String proName);

    /**
     * 查询供应商名称
     *
     * @return Provider
     */
    List<Smbms_Provider> getProviderName();

    /**
     * 查看供应商
     *
     * @param id
     * @return Provider
     */
    Smbms_Provider getProvideById(int id);

    /**
     * 修改供应商
     *
     * @param provider
     */
    void proUpdate(Smbms_Provider provider);

    /**
     * 删除供应商
     *
     * @param id
     */
    void proDelete(int id);
}
