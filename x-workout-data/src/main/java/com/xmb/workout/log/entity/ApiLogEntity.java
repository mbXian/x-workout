package com.xmb.workout.log.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Ben
 * @date 2021-01-18
 * @desc
 */
@Data
@TableName("api_log")
public class ApiLogEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("服务id")
    private String serviceId;

    @ApiModelProperty("服务器名")
    private String serverHost;

    @ApiModelProperty("服务器IP地址")
    private String serverIp;

    @ApiModelProperty("服务器环境")
    private String env;

    @ApiModelProperty("日志类型")
    private Integer type;

    @ApiModelProperty("日志标题")
    private String title;

    @ApiModelProperty("请求方式")
    private String method;

    @ApiModelProperty("请求URI")
    private String requestUri;

    @ApiModelProperty("请求端Host")
    private String remoteHost;

    @ApiModelProperty("请求端IP地址")
    private String remoteIp;

    @ApiModelProperty("方法类")
    private String methodClass;

    @ApiModelProperty("方法名")
    private String methodName;

    @ApiModelProperty("请求提交的参数")
    private String params;

    @ApiModelProperty("返回结果")
    private String result;

    @ApiModelProperty("执行开始时间")
    private Date startTime;

    @ApiModelProperty("执行结束时间")
    private Date endTime;

    @ApiModelProperty("录入时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("删除状态（0：未删除；1：已删除）")
    private Integer deleted;

}
