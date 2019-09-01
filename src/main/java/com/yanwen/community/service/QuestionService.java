package com.yanwen.community.service;

import com.yanwen.community.dto.PaginationDTO;
import com.yanwen.community.dto.QuestionDTO;
import com.yanwen.community.mapper.QuestionMapper;
import com.yanwen.community.mapper.UserMapper;
import com.yanwen.community.model.Question;
import com.yanwen.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author likeyou
 * @user 12397
 * @package com.yanwen.community.service
 * @create 2019-08-30 20:29
 */
@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;


    public PaginationDTO list(Integer page, Integer size) {

        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.count();
        paginationDTO.setPagination(totalCount,page,size);


        if(page<1){
            page=1;
        }

        if(page>=paginationDTO.getTotalPage()){
            page=paginationDTO.getTotalPage();
        }

        Integer offset= size*(page-1);
        List<Question> questions =questionMapper.list(offset,size);
        List<QuestionDTO> questionDTOList =new ArrayList<>();


        for (Question question : questions) {
             User user = userMapper.findById(question.getCreator());
             QuestionDTO questionDTO=new QuestionDTO();

            BeanUtils.copyProperties(question,questionDTO);//此函数将Question中的属性copy到QuestionDTO中去
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);

        }

        paginationDTO.setQuestions(questionDTOList);

        return paginationDTO;
    }
}
