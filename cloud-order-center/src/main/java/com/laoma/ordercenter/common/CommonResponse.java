package com.laoma.ordercenter.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @program: szwfj-weixin-work
 * @description: 通用信息返回
 * @author: 老马
 * @create: 2021-03-01 10:21
 **/
@SuppressWarnings("all")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> implements Serializable {

    protected Integer code;

    protected String msg;

    //扩展的其他信息.最终都会变成json格式
    protected T data;

    public static CommonResponse buildSuccessCommonResponse() {
        return new CommonResponse(Constants.COMMON_RESPONSE_CODE_SUCCESS, "成功", null);
    }

    public static CommonResponse buildFailCommonResponse(String errorMsg) {
        return new CommonResponse(Constants.COMMON_RESPONSE_CODE_ERROR, errorMsg, null);
    }

    public static <T> CommonResponse buildSuccessCommonResponseWithData(T data) {
        return new CommonResponse(Constants.COMMON_RESPONSE_CODE_SUCCESS, "成功", data);
    }

    public static <T> CommonResponse buildFailCommonResponseWithData(String errorMsg, Object data) {
        return new CommonResponse(Constants.COMMON_RESPONSE_CODE_ERROR, errorMsg, data);
    }

}
