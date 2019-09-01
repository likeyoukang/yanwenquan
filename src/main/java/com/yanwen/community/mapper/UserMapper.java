package com.yanwen.community.mapper;

import com.yanwen.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


/**
 * @author likeyou
 * @user 12397
 * @package com.yanwen.community.mapper
 * @create 2019-08-28 22:26
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user (account_id,name,token,gmt_creat,gmt_modified,avatar_url) values (#{accountId},#{name},#{token},#{gmtCreat},#{gmtModified},#{avatarUrl})")
    void insert(User user);

    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id=#{id}")
    User findById(@Param("id") Integer id);
}
