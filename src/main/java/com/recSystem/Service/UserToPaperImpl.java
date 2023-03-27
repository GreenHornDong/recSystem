package com.recSystem.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.recSystem.Entity.DO.Paper;
import com.recSystem.Entity.DO.User;
import com.recSystem.Entity.DO.UserToPaper;
import com.recSystem.Entity.DTO.StatusDTO;
import com.recSystem.Entity.POJO.HttpResponse;
import com.recSystem.Mapper.UserToPaperMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserToPaperImpl extends MPJBaseServiceImpl<UserToPaperMapper, UserToPaper> implements UserToPaperService{
    UserToPaperMapper userToPaperMapper;
    public HttpResponse getFavorite(String authentication, int maxLengh, int offset){
        String[] s1 = authentication.split(",");
        String username = s1[0];
        UserServiceImpl userService = new UserServiceImpl();
        int userId = userService.searchUserByUsername(username);
//        int[] paperId;
//        QueryWrapper<UserToPaper> userToPaperQueryWrapper = Wrappers.query();
//        userToPaperQueryWrapper.select("paper_id").like("user_id", userId);
//        List<Paper> list = userToPaperMapper.selectJoinList(Paper.class,
//                new MPJLambdaWrapper<UserToPaper>()
//                        .selectAll(Paper.class)
//                        .leftJoin(User.class, User::getUserId, UserToPaper::getUserId)
//                        .leftJoin(Paper.class, Paper::getPaperId, UserToPaper::getPaperId)
//                        .eq(UserToPaper::getUserId,userId));
        Page<Paper> page=new Page<>(offset,maxLengh);
        IPage<Paper> paperIPage = userToPaperMapper.selectJoinPage(page, Paper.class, new MPJLambdaWrapper<UserToPaper>()
                .selectAll(Paper.class)
                .leftJoin(User.class, User::getUserId, UserToPaper::getUserId)
                .leftJoin(Paper.class, Paper::getPaperId, UserToPaper::getPaperId)
                .eq(UserToPaper::getUserId,userId));
        return new HttpResponse<>(new StatusDTO(0, "查询成功"), paperIPage);
    }

    public HttpResponse modifyFavorite(String authentication, int paperId){
        String[] s1 = authentication.split(",");
        String username = s1[0];
        UserServiceImpl userService = new UserServiceImpl();
        int userId = userService.searchUserByUsername(username);

        UserToPaper newUserToPaper = new UserToPaper(userId, paperId);
        UserToPaper oldUserToPaper = query().eq("user_id", userId).one();
        if (oldUserToPaper == null || oldUserToPaper.getPaperId() != paperId){
            save(newUserToPaper);
        }else{
            removeById(oldUserToPaper);
        }
        return new HttpResponse<>(new StatusDTO(0, "收藏成功"), null);
    }
}
