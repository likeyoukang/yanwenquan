package com.yanwen.community.mapper;

import com.yanwen.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author likeyou
 * @user 12397
 * @package com.yanwen.community.mapper
 * @create 2019-08-28 22:26
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user (account_id,name,token,gmt_great,gmt_modified) values (#{accountId},#{name},#{token},#{gmtGreat},#{gmtModified})")
    void insert(User user);
}
