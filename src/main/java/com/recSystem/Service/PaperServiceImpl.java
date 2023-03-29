package com.recSystem.Service;

import com.recSystem.Entity.DTO.StatusDTO;
import com.recSystem.Entity.POJO.HttpResponse;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.recSystem.Entity.DO.Paper;
import com.recSystem.Entity.DTO.PageDTO;
import com.recSystem.Mapper.PaperMapper;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class PaperServiceImpl extends ServiceImpl<PaperMapper, Paper> implements PaperService{
    @Autowired
    private PaperMapper paperMapper;

   public HttpResponse searchPaper(PageDTO pageDTO) {
       String query = pageDTO.getQuery();
       int maxLength = pageDTO.getMaxLength();
       int offset = pageDTO.getOffset();
       Paper paper = query().eq("title", "thec").one();
       if (query == null || maxLength == -1) {
           Page<Paper> paperPage = new Page<>(offset, maxLength);
           LambdaQueryWrapper<Paper> paperLambdaQueryWrapper = Wrappers.lambdaQuery();
           paperLambdaQueryWrapper.like(Paper::getTitle, "%%");
//           IPage<Paper> paperIPage = paperMapper.selectPage(paperPage, paperLambdaQueryWrapper);
           List<Paper> papers = paperMapper.selectList(paperLambdaQueryWrapper);
           return new HttpResponse<>(new StatusDTO(0, "查询成功"), papers);
       }

       Page<Paper> paperPage = new Page<>(offset, maxLength);
       QueryWrapper<Paper> paperQueryWrapper = new QueryWrapper<>();
       IPage<Paper> paperIPage = paperMapper.selectPage(paperPage, paperQueryWrapper.select("title", "update_date","paper_id", "favorite").like("paper_id", "1"));
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
