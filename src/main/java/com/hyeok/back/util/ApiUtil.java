package com.hyeok.back.util;

import com.hyeok.back.common.CommonResult;
import com.hyeok.back.common.HyeokApi;
import com.hyeok.back.enums.ApiCode;
import com.hyeok.back.hyeokException.HyeokException;

public class ApiUtil {
    public static HyeokApi getMsg(String code, String msg) {
        return new HyeokApi(new CommonResult(code, msg));
    }

    public static HyeokApi getMsg(HyeokException e) {
        return ApiUtil.getMsg(e.getCode(), e.getMsg());
    }

    public static HyeokApi getMsg(ApiCode errorCode) {
        return ApiUtil.getMsg(errorCode.getCode(), errorCode.getMsg());
    }
}
