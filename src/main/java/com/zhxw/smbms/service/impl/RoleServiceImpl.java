package com.zhxw.smbms.service.impl;

import java.util.List;

import com.zhxw.smbms.dao.RoleMapper;
import com.zhxw.smbms.pojo.Smbms_Role;
import com.zhxw.smbms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
@Service("roleServiceImpl")//定义一个业务逻辑层对象
@Transactional//所有的public方法都开启事务
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public RoleMapper getRoleMapper() {
        return roleMapper;
    }

    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    /**
     * 查询所有用户角色
     *
     * @param role
     * @return
     * @throws Exception
     */
    @Override
    public List<Smbms_Role> getRoleList(Smbms_Role role) throws Exception {
        return roleMapper.getRoleList(role);
    }
}
