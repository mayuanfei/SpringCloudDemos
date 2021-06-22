package com.laoma.usercenter.dao.mapper;

import com.laoma.usercenter.common.mapper.BaseMapper;
import com.laoma.usercenter.dao.entity.UserInfo;
import org.apache.ibatis.annotations.Select;

public interface UserInfoMapper extends BaseMapper<UserInfo> {

    //通过wxid进行查询
    @Select("select * from user_info t where t.wx_id=#{wxid}")
    UserInfo selectUserInfoByWxId(String wxid);
}