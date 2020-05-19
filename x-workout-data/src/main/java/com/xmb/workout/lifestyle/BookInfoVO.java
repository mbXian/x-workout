package com.xmb.workout.lifestyle;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author Ben
 * @date 2020-04-07
 * @desc
 */
@ApiModel("书本信息VO")
@Data
public class BookInfoVO {

    private Long chapterTotal;

    private String name;

    private String author;
}
