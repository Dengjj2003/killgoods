package com.zking.killgoods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zking.killgoods.exception.BusinessException;
import com.zking.killgoods.model.User;
import com.zking.killgoods.mapper.UserMapper;
import com.zking.killgoods.service.IRedisService;
import com.zking.killgoods.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zking.killgoods.util.CookieUtils;
import com.zking.killgoods.util.JsonResponseBody;
import com.zking.killgoods.util.JsonResponseStatus;
import com.zking.killgoods.util.MD5Utils;
import com.zking.killgoods.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author zsy
 * @since 2022-03-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IRedisService redisService;
    @Override
    public JsonResponseBody<?> userLogin(UserVo userVo,
                                         HttpServletRequest req,
                                         HttpServletResponse resp) {
        //手机号码为空
        if(null==userVo.getMobile()){
            throw new BusinessException(JsonResponseStatus.USER_LOGING_NULL_MOBILE);
        }

        User user = userMapper.selectOne(new QueryWrapper<User>().eq("id", userVo.getMobile()));
        //根据账号找不到对象
        if(null==user)
            throw new BusinessException(JsonResponseStatus.USER_LOGIN_ERROR_MOBILE);

        //根据账号得到对象
        //密码不正确
        //接收前端密码再次加密
        String inputPwd=userVo.getPassword();
        //得到数据库用户盐
        String salt=user.getSalt();
        //再次加密
        String dbPass = MD5Utils.formPassToDbPass(inputPwd, salt);
        if(!dbPass.equals(user.getPassword())){
            throw new BusinessException(JsonResponseStatus.USER_LOGIN_ERROR_PWD);
        }

        //生成对应的令牌
        String token = UUID.randomUUID().toString().replace("-","");
        //将令牌保存到Cookie
        CookieUtils.setCookie(req,resp,"token",token,7200);
        //将用户的登录信息和令牌绑定起来
        redisService.setRedis(token,user);
        return new JsonResponseBody<>();

    }
}
