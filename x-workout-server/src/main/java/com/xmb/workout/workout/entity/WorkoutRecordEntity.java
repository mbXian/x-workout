package com.xmb.workout.workout.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 训练记录表
 * 
 * @author Ben
 * @email 
 * @date 2020-04-22 11:23:29
 */
@Data
@TableName("workout_record")
public class WorkoutRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	/**
	 * 训练编号
	 */
	private String number;
	/**
	 * 用户手机号
	 */
	private String userMobile;
	/**
	 * 训练时间
	 */
	private Date trainTime;
	/**
	 * 完成时间
	 */
	private Date finishTime;
	/**
	 * 经度
	 */
	private BigDecimal latitude;
	/**
	 * 纬度
	 */
	private BigDecimal longitude;
	/**
	 * 录入时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 删除状态（0：未删除；1：已删除）
	 */
	private Integer deleted;

}
