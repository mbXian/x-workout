package com.xmb.workout.lifestyle.service;

import com.xmb.workout.lifestyle.BookContentVO;
import com.xmb.workout.lifestyle.BookInfoVO;

/**
 * @author Ben
 * @date 2020-03-02
 */
public interface BookService {
    Long getTotalChapter();

    /**
     * 查询书本信息
     * @return
     */
    BookInfoVO getBookInfo();

    BookContentVO getContent(int chapterNum);
}
