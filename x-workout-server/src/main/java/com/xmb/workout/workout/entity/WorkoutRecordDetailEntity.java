package com.xmb.workout.workout.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 训练项目表
 * 
 * @author Ben
 * @email 
 * @date 2020-04-22 11:23:29
 */
@Data
@TableName("workout_record_detail")
public class WorkoutRecordDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 训练编号
	 */
	private String workoutNumber;
	/**
	 * 训练类型
	 */
	private Integer type;
	/**
	 * 排序
	 */
	private Integer sortNo;
	/**
	 * 单组数量
	 */
	private Integer count;
	/**
	 * 分组数量
	 */
	private Integer groups;
	/**
	 * 删除状态（0：未删除；1：已删除）
	 */
	private Integer deleted;

}
