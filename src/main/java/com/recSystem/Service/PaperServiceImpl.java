package com.recSystem.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.recSystem.Entity.DO.Paper;
import com.recSystem.Entity.DO.User;
import com.recSystem.Entity.DTO.PaperDTO;
import com.recSystem.Entity.DTO.StatusDTO;
import com.recSystem.Entity.POJO.HttpResponse;
import com.recSystem.Mapper.PaperMapper;
import com.recSystem.Mapper.UserMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class PaperServiceImpl extends ServiceImpl<PaperMapper, Paper> implements PaperService{
    @Autowired
    private PaperMapper paperMapper;
   public HttpResponse searchPaper(HashMap<String, String> map) {
       String keyWord = map.get("query");
       int maxNumber = Integer.parseInt(map.get("max_length"));
       int offset = Integer.parseInt(map.get("offset"));
       if (keyWord == null || maxNumber == -1) {
           Page<Paper> paperPage = new Page<>(offset, maxNumber);
           LambdaQueryWrapper<Paper> paperLambdaQueryWrapper = Wrappers.lambdaQuery();
           paperLambdaQueryWrapper.like(Paper::getTitle, "% %");
           IPage<Paper> paperIPage = paperMapper.selectPage(paperPage, paperLambdaQueryWrapper);
           return new HttpResponse<>(new StatusDTO(0, "查询成功"), paperIPage);
       }

       Page<Paper> paperPage = new Page<>(offset, maxNumber);
       QueryWrapper<Paper> paperQueryWrapper = Wrappers.query();
       paperQueryWrapper.select("paper_id", "title", "authors", "update_date", "favorite").like("title", "% %");
       IPage<Paper> paperIPage = paperMapper.selectPage(paperPage, paperQueryWrapper);
       return new HttpResponse<>(new StatusDTO(0, "查询成功"), paperIPage);
   }
    public HttpResponse searchAuthor(int authorId){
       UserServiceImpl userService = new UserServiceImpl();
       return userService.searchUserById(authorId);
    }

    public HttpResponse modifyFavorite(String authentication, int paperId){
       UserToPaperImpl userToPaper = new UserToPaperImpl();
        return userToPaper.modifyFavorite(authentication, paperId);
    }
}
