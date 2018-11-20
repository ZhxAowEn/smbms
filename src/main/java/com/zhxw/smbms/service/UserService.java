package com.zhxw.smbms.service;

import com.zhxw.smbms.pojo.Smbms_User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    /**
     * 用户登录
     *
     * @param userCode
     * @return
     */
    Smbms_User login(String userCode) throws Exception;

    /**
     * 增加用户信息
     *
     * @param user
     * @return
     */
    int add(Smbms_User user) throws Exception;

    /**
     * 根据条件查询用户列表
     *
     * @param userName
     * @param userRole
     * @param currPageNo
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<Smbms_User> getUserList(String userName, Integer userRole, Integer currPageNo, Integer pageSize) throws Exception;

    /**
     * 根据条件查询用户表记录数
     *
     * @param userName
     * @param userRole
     * @return
     */
    int getUserCount(String userName, Integer userRole) throws Exception;

    /**
     * 根据userCode查询出User
     *
     * @param userCode
     * @return
     */
    Smbms_User selectUserCodeExist(String userCode) throws Exception;

    /**
     * 根据ID删除user
     *
     * @param delId
     * @return
     */
    int deleteUserById(Integer delId) throws Exception;

    /**
     * 根据ID查找user
     *
     * @param id
     * @return
     */
    Smbms_User getUserById(Integer id) throws Exception;

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    int userUpdate(Smbms_User user) throws Exception;

    /**
     * 根据userId修改密码
     *
     * @param id
     * @param pwd
     * @return
     */
    void updatePwd(Integer id, String pwd) throws Exception;
}
