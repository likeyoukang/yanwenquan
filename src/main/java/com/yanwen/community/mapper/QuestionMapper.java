package com.yanwen.community.mapper;

import com.yanwen.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author likeyou
 * @user 12397
 * @package com.yanwen.community.mapper
 * @create 2019-08-29 21:00
 */
@Mapper
public interface QuestionMapper {

    @Insert("insert into question (title,description,gmt_creat,gmt_modified,creator,tag)  values (#{title},#{description},#{gmtCreat},#{gmtModified},#{creator},#{tag})")
    void creat(Question question);
}
