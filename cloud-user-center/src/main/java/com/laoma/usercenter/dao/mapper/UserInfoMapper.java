package com.laoma.usercenter.dao.mapper;

import com.laoma.usercenter.common.mapper.BaseMapper;
import com.laoma.usercenter.dao.entity.UserInfo;
import com.laoma.usercenter.dto.request.UserInfoSearchRequest;
import com.laoma.usercenter.dto.response.UserInfoResponse;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserInfoMapper extends BaseMapper<UserInfo> {

    //通过wxid进行查询
    @Select("select * from user_info t where t.wx_id=#{wxid}")
    UserInfo selectUserInfoByWxId(String wxid);

    @Select("<script>" +
            "SELECT " +
            "  *  " +
            "FROM " +
            "  user_info t  " +
            "WHERE " +
            "  1 = 1  " +
            "<if test=\"search.id != null\">" +
            "  AND t.id = #{search.id}  " +
            "</if>" +
            "<if test=\"search.wxId != null and search.wxId != ''\">" +
            "  AND t.wx_id = #{search.wxId}  " +
            "</if>" +
            "<if test=\"search.wxNickname != null and search.wxNickname != ''\">" +
            "  AND t.wx_nickname like  concat('%',#{search.wxNickname},'%')" +
            "</if>" +
            "</script>"
    )
    UserInfoResponse selectUserInfoByCondition(@Param("search") UserInfoSearchRequest search);
}