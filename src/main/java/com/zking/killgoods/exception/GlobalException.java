package com.zking.killgoods.exception;

import com.zking.killgoods.util.JsonResponseBody;
import com.zking.killgoods.util.JsonResponseStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler
    public JsonResponseBody<?> handleException(Exception e){
        JsonResponseBody jsonResponseBody=null;
         if(e instanceof BindException){
             BindException be=(BindException)e;
             jsonResponseBody=new JsonResponseBody(JsonResponseStatus.ERROR);
             String msg = be.getBindingResult().getFieldError().getDefaultMessage();
             jsonResponseBody.setMsg(msg);

         }else if (e instanceof  BusinessException){
             BusinessException ex=(BusinessException)e;
             jsonResponseBody=new JsonResponseBody(ex.getJsonResponseStatus());
         }else{
             e.printStackTrace();
             jsonResponseBody=new JsonResponseBody(JsonResponseStatus.ERROR);
         }
        return jsonResponseBody;
    }
}
