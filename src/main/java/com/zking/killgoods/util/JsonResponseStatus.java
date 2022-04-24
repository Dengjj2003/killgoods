package com.zking.killgoods.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum JsonResponseStatus {

    SUCCESS(200,"ok"),
    ERROR(444,"账号或者密码错误"),
    USER_LOGING_NULL_MOBILE(10010,"手机号码不能为空"),
    USER_LOGIN_ERROR_MOBILE(10020,"手机号码不存在"),
    USER_LOGIN_ERROR_PWD(10030,"密码错误"),
    TOKEN_EMPTY(20010,"令牌不存在"),
    TOKEN_USER_EMPTY(20020,"令牌失效"),
    GOODS_SAVE_ERROR(30010,"新增商品错误"),
    GOODS_UPDATE_ERROR(30020,"修改商品错误"),
    GOODS_DEL_ERROR(30030,"删除商品错误"),
    GOODS_SELECT_ERROR(30040,"查询失败"),
    SECKILL_GOODS_COUNT_ERROR(40001,"库存不足"),
    SECKILL_ORDER_REPEAT(60001,"您已经参与过该商品的秒杀"),
    SECKILL_GOODS_ADD_ERROR(50001,"新增秒杀商品失败");

    private int code;//状态码
    private String msg;//消息
}
