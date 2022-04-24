package com.zking.killgoods.vo;

import com.zking.killgoods.util.IsMobile;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserVo {

    @IsMobile
    private String mobile;
    @NotBlank(message = "密码不能为空")
    private String password;
}
