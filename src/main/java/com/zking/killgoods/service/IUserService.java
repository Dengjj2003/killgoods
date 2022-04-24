package com.zking.killgoods.service;

import com.zking.killgoods.model.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zking.killgoods.util.JsonResponseBody;
import com.zking.killgoods.vo.UserVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author zsy
 * @since 2022-03-07
 */
public interface IUserService extends IService<User> {

    JsonResponseBody<?> userLogin(UserVo userVo,
                                  HttpServletRequest req,
                                  HttpServletResponse resp);
}
