package com.tensquare.exam.controller;

import com.tensquare.exam.pojo.User;
import com.tensquare.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 控制器层
 *
 * @author Administrator
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @RequestMapping(value = "/changeinfo", method = RequestMethod.POST)
    public String changeinfo(String newusername, String newpassword, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (newusername != null) {
            user.setUsername(newusername);
        }
        if (newpassword != null) {
            user.setPassword(encoder.encode(newpassword));
        }
        userService.update(user);
        request.setAttribute("loginmsg", "修改成功！请重新登陆！");
        return "web-login";
    }

    @RequestMapping(value = "/fgetpassword", method = RequestMethod.POST)
    public String fgtpassword(String registdata, String username, String newpassword, HttpServletRequest request) {
        User user = userService.findByName(username);
        if (user != null) {
            if (user.getRegistdata().equals(registdata)) {
                user.setPassword(encoder.encode(newpassword));
                userService.update(user);
                request.setAttribute("loginmsg", "修改成功！请重新登陆！");
            } else {
                request.setAttribute("loginmsg", "修改失败！验证信息错误！");
            }
        } else {
            request.setAttribute("loginmsg", "修改失败！用户不存在！");
        }
        return "web-login";
    }


    @RequestMapping(value = "/lagout", method = RequestMethod.GET)
    public String lagout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "web-login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, HttpServletRequest request) {
        user = userService.login(user.getUsername(), user.getPassword());
        if (user == null) {
            request.setAttribute("loginmsg", "登陆失败！请重新登陆！");
            return "web-login";
        } else {
            int role = user.getRole().intValue();
            if (role == -1) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                return "manager-index";
            } else if (role == 1) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                return "web-index";
            } else {
                request.setAttribute("loginmsg", "权限错误！请重新登陆！");
                return "web-login";
            }
        }
    }


//
//    /**
//     * 查询全部数据
//     *
//     * @return
//     */
//    @RequestMapping(method = RequestMethod.GET)
//    public Result findAll() {
//        return new Result(true, StatusCode.OK, "查询成功", userService.findAll());
//    }
//
//    /**
//     * 根据ID查询
//     *
//     * @param id ID
//     * @return
//     */
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public Result findById(@PathVariable String id) {
//        return new Result(true, StatusCode.OK, "查询成功", userService.findById(id));
//    }
//
//
//    /**
//     * 分页+多条件查询
//     *
//     * @param searchMap 查询条件封装
//     * @param page      页码
//     * @param size      页大小
//     * @return 分页结果
//     */
//    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
//    public Result findSearch(@RequestBody Map searchMap, @PathVariable int page, @PathVariable int size) {
//        Page<User> pageList = userService.findSearch(searchMap, page, size);
//        return new Result(true, StatusCode.OK, "查询成功", new PageResult<User>(pageList.getTotalElements(), pageList.getContent()));
//    }
//
//    /**
//     * 根据条件查询
//     *
//     * @param searchMap
//     * @return
//     */
//    @RequestMapping(value = "/search", method = RequestMethod.POST)
//    public Result findSearch(@RequestBody Map searchMap) {
//        return new Result(true, StatusCode.OK, "查询成功", userService.findSearch(searchMap));
//    }
//

    /**
     * 增加
     *
     * @param user
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(User user, HttpServletRequest request) {
        User olduser = userService.findByName(user.getUsername());
        if (olduser != null) {
            request.setAttribute("registmsg", "注册失败！已有该昵称！");
            return "web-register";
        } else {
            userService.add(user);
            request.setAttribute("registmsg", "注册成功请登录！");
            return "web-register";
        }
    }
//
//    /**
//     * 修改
//     *
//     * @param user
//     */
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public Result update(@RequestBody User user, @PathVariable String id) {
//        user.setId(id);
//        userService.update(user);
//        return new Result(true, StatusCode.OK, "修改成功");
//    }
//
//    /**
//     * 删除
//     *
//     * @param id
//     */
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public Result delete(@PathVariable String id) {
//        userService.deleteById(id);
//        return new Result(true, StatusCode.OK, "删除成功");
//    }

}
