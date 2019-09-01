package com.yanwen.community.mapper;

import com.yanwen.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(@Param(value = "offset") Integer offset,@Param(value = "size")Integer size);

    @Select("select count(1) from question")
    Integer count();
}


