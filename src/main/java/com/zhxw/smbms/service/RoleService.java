package com.zhxw.smbms.service;

import java.util.List;

import com.zhxw.smbms.pojo.Smbms_Role;

public interface RoleService {
    /**
     * 查询所有用户角色
     *
     * @param role
     * @return
     * @throws Exception
     */
    List<Smbms_Role> getRoleList(Smbms_Role role) throws Exception;

}
