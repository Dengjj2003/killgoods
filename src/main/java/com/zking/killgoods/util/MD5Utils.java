package com.zking.killgoods.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * MD5加密
 * 用户端：password=MD5(明文+固定Salt)
 * 服务端：password=MD5(用户输入+随机Salt)
 * 用户端MD5加密是为了防止用户密码在网络中明文传输，服务端MD5加密是为了提高密码安全性，双重保险。
 */
@Component
public class MD5Utils {

    //加密盐，与前端一致
    private static String salt="f1g2h3j4";

    /**
     * md5加密
     * @param src
     * @return
     */
    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }

    /**
     * 获取加密的盐
     * @return
     */
    public static String createSalt(){
        return UUID.randomUUID().toString().replace("-","");
    }

    /**
     * 将前端的明文密码通过MD5加密方式加密成后端服务所需密码
     * 注意：该步骤实际是在前端完成！！！
     * @param inputPass 明文密码
     * @return
     */
    public static String inputPassToFormpass(String inputPass){
        //混淆固定盐salt,安全性更可靠
        String str=salt.charAt(1)+""+salt.charAt(5)+inputPass+salt.charAt(0)+""+salt.charAt(3);
        return md5(str);
    }

    /**
     * 将后端密文密码+随机salt生成数据库的密码
     * @param formPass
     * @param salt
     * @return
     */
    public static String formPassToDbPass(String formPass,String salt){
        //混淆固定盐salt,安全性更可靠
        String str=salt.charAt(7)+""+salt.charAt(9)+formPass+salt.charAt(1)+""+salt.charAt(5);
        return md5(str);
    }

    /**
     * 将用户输入的密码转换成数据库的密码
     * @param inputPass 明文密码
     * @param salt      盐
     * @return
     */
    public static String inputPassToDbPass(String inputPass,String salt){
        String formPass = inputPassToFormpass(inputPass);
        String dbPass = formPassToDbPass(formPass, salt);
        return dbPass;
    }

    public static void main(String[] args) {
        //d7aaa28e3b8e6c88352bd5e7c23829f9
        //5512a78a188b318c074a15f9b056a712
        String formPass = inputPassToFormpass("123456");
        System.out.println("前端加密密码："+formPass);
        String salt = createSalt();
        System.out.println("后端加密随机盐："+salt);
        String dbPass = formPassToDbPass(formPass, salt);
        System.out.println("后端加密密码："+dbPass);
        System.out.println("-------------------------------------------");
        String dbPass1 = inputPassToDbPass("123456", salt);
        System.out.println("最终加密密码："+dbPass1);
    }
}
