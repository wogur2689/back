package com.hyeok.back.hyeokException;

import com.hyeok.back.common.HyeokApi;
import com.hyeok.back.enums.ApiCode;
import com.hyeok.back.util.ApiUtil;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HyeokExceptionHandler {

    /**
     * ErrorCode Exception
     */
    @ExceptionHandler({HyeokException.class})
    public HyeokApi HyeokException(HyeokException e) {
        return ApiUtil.getMsg(e);
    }

    /**
     * Json Parsing Error
     */
    @ExceptionHandler({HttpMessageNotReadableException.class, IllegalArgumentException.class})
    public HyeokApi httpMessageNotReadableException() {
        return ApiUtil.getMsg(ApiCode.API_1001);
    }

    /**
     * Exception.class
     */
    @ExceptionHandler({Exception.class})
    public HyeokApi exception() {
        return ApiUtil.getMsg(ApiCode.API_9999);
    }
}
