package com.zking.killgoods.exception;

import com.zking.killgoods.util.JsonResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 业务类的异常处理
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessException extends RuntimeException {
    private JsonResponseStatus jsonResponseStatus;
}
