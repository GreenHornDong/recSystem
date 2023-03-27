package com.recSystem.Controller;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.recSystem.Entity.POJO.HttpResponse;
import com.recSystem.Service.PaperServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("api/paper")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PaperController {
    @Autowired
    PaperServiceImpl paperService;

    @PostMapping("search")
    @Operation(summary = "查询论文")
    public HttpResponse searchPaper(@RequestBody HashMap<String, String> map){
        return paperService.searchPaper(map);
    }

    @PostMapping("author")
    @Operation(summary = "获取作者信息")
    public HttpResponse searchAuthor(@RequestParam("author_id") int authorId){
        return paperService.searchAuthor(authorId);
    }

    @PostMapping("favorite")
    @Operation(summary = "修改收藏状态")
    public HttpResponse modifyFavorite(@RequestHeader String authentication, @RequestParam("id") int paperId){
        return paperService.modifyFavorite(authentication, paperId);
    }
}
