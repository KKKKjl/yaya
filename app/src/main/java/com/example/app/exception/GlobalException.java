package com.example.app.exception;

import com.example.app.model.Resp;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalException {

    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public Resp handle(ApiException e) {
        Resp resp = new Resp();
        resp.setCode(200);
        resp.setMessage(e.getMessage());
        resp.setData(null);
        return resp;
    }

}
