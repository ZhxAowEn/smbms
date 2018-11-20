package com.zhxw.smbms.controller;

import com.zhxw.smbms.pojo.Smbms_Page;
import com.zhxw.smbms.pojo.Smbms_User;
import com.zhxw.smbms.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;
import javax.websocket.server.PathParam;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Administrator on 2018/9/27.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用户登陆
     *
     * @param userCode     用户名
     * @param userPassword 密  码
     * @param model        info：错误提示
     * @param session      用户集合
     * @return index：登陆页面
     */
    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    public String doLogin(@RequestParam(name = "userCode", required = false) String userCode, @RequestParam(name = "userPassword", required = false) String userPassword, Model model, HttpSession session) {
        logger.debug("doLogin====================================");
        //调用service方法，进行用户匹配
        Smbms_User user = null;
        try {
            user = userService.login(userCode);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (null != user) {
            if (userPassword.equals(user.getUserpassword())) {//登录成功
                //放入session
                session.setAttribute("SESSION_USER", user);
                //页面跳转（main.jsp）
                return "main";
            }
        }
        //页面跳转（login.jsp）带出提示信息--转发
        model.addAttribute("userCode", userCode);
        model.addAttribute("info", "用户名或密码不正确");
        return "index";
    }

    /**
     * 退出登陆 清除session
     *
     * @param session 用户集合
     * @return index：登陆页面
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session, Model model, Smbms_User user) {
        session.removeAttribute("SESSION_USER");
        model.addAttribute("info", "登陆信息以失效，请重新登陆！");
        model.addAttribute("userCode", user.getUsercode());
        return "index";
    }

    @RequestMapping(value = "/getUserUpdatePwd")
    public String getUserUpdatePwd() {
        return "user/updatePwd";
    }

    // 修改密码
    @RequestMapping(value = "/getUpdatePwd")
    public String getUpdatePwd(@RequestParam(name = "newpassword", required = false) String newpassword,
                               @RequestParam(name = "userId", required = false) Integer id) {
        try {
            userService.updatePwd(id, newpassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/user/logout";
    }

    /**
     * 跳转用户管理
     *
     * @param model
     * @return
     */
    @RequestMapping("/userManage")
    public String userManage(@RequestParam(name = "inputPage", required = false) Integer inputPage,
                             @RequestParam(name = "queryUserRole", required = true, defaultValue = "0") Integer userRole,
                             @RequestParam(name = "queryname", required = false) String userName,
                             @RequestParam(name = "currPageNo", required = false, defaultValue = "1") Integer currPageNo, Model model) {
        try {
            if (inputPage != null) {
                currPageNo = inputPage;
                model.addAttribute("inputPage", inputPage);
            }
            Smbms_Page page = new Smbms_Page();
            if (userService.getUserCount(userName, userRole) != 0) {
                page.setTotalCount(userService.getUserCount(userName, userRole));
                if (currPageNo > 0 & currPageNo <= page.getTotalPageCount()) {
                    page.setCurrPageNo(currPageNo);
                } else {
                    page.setCurrPageNo(page.getTotalPageCount());
                }
                List<Smbms_User> userList = userService.getUserList(userName, userRole, (page.getCurrPageNo() - 1) * page.getPageSize(), page.getPageSize());
                if (null != userList) {
                    model.addAttribute("userList", userList);
                }
            } else {
                model.addAttribute("userlist_Null", "无符合条件的用户!");
            }
            if (null != userName) {

                model.addAttribute("userName", userName);
            }
            if (null != userRole) {
                model.addAttribute("userRole", userRole);
            }
            model.addAttribute("page", page);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return "user/userManage";
        }


    }

    @RequestMapping(value = "/getUserSee")
    public String getUserSee(
            @RequestParam(value = "userId", required = true) int id,
            Model model) {
        Smbms_User user = null;
        try {
            user = userService.getUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("user", user);
        return "user/userSee";
    }

    // 添加用户
    @RequestMapping(value = "/getUserAdd")
    public String getUserAdd(
            /* @RequestParam(value = "proId", required = true) int id,*/
            Model model) {
        return "user/userAdd";
    }

    // 修改用户（预加载）
    @RequestMapping(value = "/getUserUpdate")
    public String getUserUpdate(
            @RequestParam(value = "userId", required = true) int id,
            @RequestParam(value = "currPageNo", required = true) int currPageNo,
            Model model) {
        Smbms_User user = null;
        try {
            user = userService.getUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("user", user);
        model.addAttribute("currPageNo", currPageNo);
        return "user/userUpdate";
    }

    // 修改用户
    @RequestMapping(value = "/UserUpdate")
    public String userUpdate(
            Smbms_User user,
            @RequestParam(value = "currPageNo", required = true) int currPageNo,
            @RequestParam(value = "queryname", required = true, defaultValue = "") String queryname,
            @RequestParam(value = "queryUserRole", required = true, defaultValue = "0") int queryUserRole)
            throws Exception {
        queryname = new String(queryname.getBytes("iso-8859-1"), "utf-8");
        userService.userUpdate(user);
        // 重定向 调用controller内的方法
        return "redirect:/user/UserManagement?currPageNo=" + currPageNo
                + "&queryname=" + queryname + "&queryUserRole=" + queryUserRole;
    }
}
