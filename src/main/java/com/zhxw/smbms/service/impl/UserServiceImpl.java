package com.zhxw.smbms.service.impl;

import com.zhxw.smbms.dao.UserMapper;
import com.zhxw.smbms.pojo.Smbms_User;
import com.zhxw.smbms.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("userServiceImpl")//定义一个业务逻辑层对象
@Transactional//所有的public方法都开启事务
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper UserMapper;

    public UserMapper getUserDao() {
        return UserMapper;
    }

    public void setUserDao(UserMapper userDao) {
        this.UserMapper = userDao;
    }

    /**
     * 用户登录
     *
     * @param userCode
     * @return
     */
    @Override
    public Smbms_User login(String userCode) throws Exception {
        return UserMapper.getLoginUser(userCode);
    }

    /**
     * 增加用户信息
     *
     * @param user
     * @return
     */
    @Override
    public int add(Smbms_User user) throws Exception {
        return UserMapper.add(user);
    }


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
    @Override
    public List<Smbms_User> getUserList(String userName, Integer userRole, Integer currPageNo, Integer pageSize) throws Exception {
        return UserMapper.getUserList(userName, userRole, currPageNo, pageSize);
    }

    /**
     * 根据条件查询用户表记录数
     *
     * @param userName
     * @param userRole
     * @return
     */
    @Override
    public int getUserCount(String userName, Integer userRole) throws Exception {
        return UserMapper.getUserCount(userName, userRole);
    }

    /**
     * 根据userCode查询出User
     *
     * @param userCode
     * @return
     */
    @Override
    public Smbms_User selectUserCodeExist(String userCode) throws Exception {
        return UserMapper.getLoginUser(userCode);
    }

    /**
     * 根据ID删除user
     *
     * @param delId
     * @return
     */
    @Override
    public int deleteUserById(Integer delId) throws Exception {
        return UserMapper.deleteUserById(delId);
    }

    /**
     * 根据ID查找user
     *
     * @param id
     * @return
     */
    @Override
    public Smbms_User getUserById(Integer id) throws Exception {
        return UserMapper.getUserById(id);
    }

    /**
     * 改用户信息
     *
     * @param user
     * @return
     */
    @Override
    public int userUpdate(Smbms_User user) throws Exception {
        return UserMapper.userUpdate(user);
    }

    /**
     * 根据userId修改密码
     *
     * @param id
     * @param pwd
     * @return
     */
    @Override
    public void updatePwd(Integer id, String pwd) throws Exception {
        UserMapper.updatePwd(id, pwd);
    }
}
