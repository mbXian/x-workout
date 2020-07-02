package com.xmb.workout.lifestyle.controller;

import com.xmb.auth.controller.BaseController;
import com.xmb.common.network.Result;
import com.xmb.workout.lifestyle.BookContentDTO;
import com.xmb.workout.lifestyle.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Ben
 * @date 2020-03-02
 */
@RestController
@Api(description = "读书接口")
@RequestMapping("/book")
public class BookController extends BaseController {

    @Autowired
    private BookService bookService;

    @ApiOperation(value = "章节总数",notes = "章节总数",consumes = "application/json")
    @PostMapping("/getTotalChapter")
    public Result getTotalChapter() {

        return Result.ok(bookService.getTotalChapter());
    }

    @ApiOperation(value = "书本信息",notes = "书本信息",consumes = "application/json")
    @PostMapping("/getBookInfo")
    public Result getBookInfo() {

        return Result.ok(bookService.getBookInfo());
    }

    @ApiOperation(value = "读取章节内容",notes = "读取章节内容",consumes = "application/json")
    @PostMapping("/getContent")
    public Result getContent(@RequestBody BookContentDTO bookContentDTO) {

        return Result.ok(bookService.getContent(bookContentDTO.getChapterNum()));
    }
}
