package com.laoma.usercenter.common;

/**
 * package: cn.net.wangfujing.common
 * describe: 全局定义
 * creat_user: 老马
 * creat_date: 2021/02/26
 * creat_time: 15:25
 * copyright (C) 2016-2036 北京数字王府井科技有限公司.
 **/
@SuppressWarnings("all")
public class Constants {

    /********************************************************************
     * 编码方式
     *******************************************************************/
    public static final String UTF_8    = "utf-8";
    public static final String GBK      = "gbk";
    public static final String GB2312   = "gb2312";

    /********************************************************************
     * 返回信息相关
     *******************************************************************/
    public static final Integer COMMON_RESPONSE_CODE_SUCCESS     = 0; //成功
    public static final Integer COMMON_RESPONSE_CODE_ERROR       = 1; //失败
    public static final Integer COMMON_RESPONSE_CODE_LOGOUT      = 1001; //登录状态失效

}
