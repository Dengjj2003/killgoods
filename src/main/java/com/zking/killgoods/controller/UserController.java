package com.zking.killgoods.controller;


import com.zking.killgoods.service.IUserService;
import com.zking.killgoods.util.JsonResponseBody;
import com.zking.killgoods.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author zsy
 * @since 2022-03-07
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/userLogin")
    public JsonResponseBody<?> userLogin(@Valid UserVo userVo,
                                         HttpServletRequest req,
                                         HttpServletResponse resp){

        return userService.userLogin(userVo,req,resp);
    }

    @RequestMapping("/doLogin")
    public JsonResponseBody<?> getLogin(String userName){
        System.out.println(userName);
        return new JsonResponseBody<>();
    }


}
