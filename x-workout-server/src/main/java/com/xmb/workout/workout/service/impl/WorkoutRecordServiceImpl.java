package com.xmb.workout.workout.service.impl;

import com.alibaba.fastjson.JSON;
import com.xmb.auth.entity.SysUserEntity;
import com.xmb.common.utils.DateUtils;
import com.xmb.workout.utils.CodeGenerateUtils;
import com.xmb.workout.workout.constant.WorkoutTypeEnum;
import com.xmb.workout.workout.dto.QueryStartOrEndTimeDTO;
import com.xmb.workout.workout.dto.StatisticsDurationAndTimesDTO;
import com.xmb.workout.workout.dto.StatisticsEachTypeDTO;
import com.xmb.workout.workout.dto.WorkoutRecordEnterDailyTemporaryDTO;
import com.xmb.workout.workout.entity.WorkoutRecordDetailEntity;
import com.xmb.workout.workout.service.WorkoutRecordDetailService;
import com.xmb.workout.workout.vo.StatisticsDurationAndTimesVO;
import com.xmb.workout.workout.vo.StatisticsEachTypeVO;
import com.xmb.workout.workout.vo.ToNowStatisticsVO;
import com.xmb.workout.workout.vo.TodayStatisticsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xmb.workout.workout.dao.WorkoutRecordDao;
import com.xmb.workout.workout.entity.WorkoutRecordEntity;
import com.xmb.workout.workout.service.WorkoutRecordService;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("workoutRecordService")
public class WorkoutRecordServiceImpl extends ServiceImpl<WorkoutRecordDao, WorkoutRecordEntity> implements WorkoutRecordService {

    @Autowired
    private WorkoutRecordDetailService workoutRecordDetailService;

    /**
     * 临时登记
     *
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void enterDailyDataTemporary(WorkoutRecordEnterDailyTemporaryDTO workoutRecordEnterDailyTemporaryDTO, SysUserEntity sysUserEntity) {
        log.info("参数 = {}", JSON.toJSONString(workoutRecordEnterDailyTemporaryDTO));
        Date currentDate = new Date();
        WorkoutRecordEntity workoutRecordEntity = new WorkoutRecordEntity();
        workoutRecordEntity.setNumber(CodeGenerateUtils.generate(DateUtils.format(currentDate, DateUtils.DATE_TIME_PATTERN_WITHOUT_SYMBOL)));
        workoutRecordEntity.setUserMobile(sysUserEntity.getMobile());
        workoutRecordEntity.setTrainTime(new Date(workoutRecordEnterDailyTemporaryDTO.getTrainTimeMilliSec()));
        workoutRecordEntity.setFinishTime(currentDate);
        workoutRecordEntity.setLatitude(workoutRecordEnterDailyTemporaryDTO.getLatitude());
        workoutRecordEntity.setLongitude(workoutRecordEnterDailyTemporaryDTO.getLongitude());

        List<WorkoutRecordDetailEntity> detailEntityList = new ArrayList<WorkoutRecordDetailEntity>();

        WorkoutRecordDetailEntity detailEntity1 = new WorkoutRecordDetailEntity();
        detailEntity1.setWorkoutNumber(workoutRecordEntity.getNumber());
        detailEntity1.setType(WorkoutTypeEnum.PUSH_UP.getIndex());
        detailEntity1.setSortNo(1);
        detailEntity1.setCount(21);
        detailEntity1.setGroups(1);
        detailEntityList.add(detailEntity1);

        WorkoutRecordDetailEntity detailEntity2 = new WorkoutRecordDetailEntity();
        detailEntity2.setWorkoutNumber(workoutRecordEntity.getNumber());
        detailEntity2.setType(WorkoutTypeEnum.SIT_UP.getIndex());
        detailEntity2.setSortNo(2);
        detailEntity2.setCount(62);
        detailEntity2.setGroups(1);
        detailEntityList.add(detailEntity2);

        WorkoutRecordDetailEntity detailEntity3 = new WorkoutRecordDetailEntity();
        detailEntity3.setWorkoutNumber(workoutRecordEntity.getNumber());
        detailEntity3.setType(WorkoutTypeEnum.PUSH_UP.getIndex());
        detailEntity3.setSortNo(3);
        detailEntity3.setCount(21);
        detailEntity3.setGroups(1);
        detailEntityList.add(detailEntity3);

        WorkoutRecordDetailEntity detailEntity4 = new WorkoutRecordDetailEntity();
        detailEntity4.setWorkoutNumber(workoutRecordEntity.getNumber());
        detailEntity4.setType(WorkoutTypeEnum.AIR_CYCLING.getIndex());
        detailEntity4.setSortNo(4);
        detailEntity4.setCount(20);
        detailEntity4.setGroups(1);
        detailEntityList.add(detailEntity4);

        WorkoutRecordDetailEntity detailEntity5 = new WorkoutRecordDetailEntity();
        detailEntity5.setWorkoutNumber(workoutRecordEntity.getNumber());
        detailEntity5.setType(WorkoutTypeEnum.BENT_KNEE_V_UP.getIndex());
        detailEntity5.setSortNo(5);
        detailEntity5.setCount(10);
        detailEntity5.setGroups(1);
        detailEntityList.add(detailEntity5);

        WorkoutRecordDetailEntity detailEntity6 = new WorkoutRecordDetailEntity();
        detailEntity6.setWorkoutNumber(workoutRecordEntity.getNumber());
        detailEntity6.setType(WorkoutTypeEnum.ROPE_JUMPING.getIndex());
        detailEntity6.setSortNo(6);
        detailEntity6.setCount(300);
        detailEntity6.setGroups(1);
        detailEntityList.add(detailEntity6);

        workoutRecordDetailService.saveBatch(detailEntityList);

        this.baseMapper.insert(workoutRecordEntity);

        log.info(workoutRecordEntity.getTrainTime().toString());
    }

    @Override
    public TodayStatisticsVO todayStatistics(SysUserEntity sysUserEntity) {
        Date currentDate = new Date();

        StatisticsEachTypeDTO dto = new StatisticsEachTypeDTO();
        dto.setMobile(sysUserEntity.getMobile());
        dto.setStartDate(DateUtils.getDayStartTime(currentDate));
        dto.setEndDate(DateUtils.getDayEndTime(currentDate));

        List<StatisticsEachTypeVO> statisticsEachTypeVOList = workoutRecordDetailService.statisticsByTimeAndType(dto);
        parseWorkoutName(statisticsEachTypeVOList);

        StatisticsDurationAndTimesDTO statisticsDurationAndTimesDTO = new StatisticsDurationAndTimesDTO();
        statisticsDurationAndTimesDTO.setMobile(sysUserEntity.getMobile());
        statisticsDurationAndTimesDTO.setStartDate(DateUtils.getDayStartTime(currentDate));
        statisticsDurationAndTimesDTO.setEndDate(DateUtils.getDayEndTime(currentDate));
        StatisticsDurationAndTimesVO statisticsDurationAndTimesVO = this.baseMapper.statisticsDurationAndTimes(statisticsDurationAndTimesDTO);

        TodayStatisticsVO todayStatisticsVO = new TodayStatisticsVO();
        todayStatisticsVO.setStatisticsEachTypeVOList(statisticsEachTypeVOList);
        todayStatisticsVO.setDuration((statisticsDurationAndTimesVO == null || statisticsDurationAndTimesVO.getDuration() == null) ? 0 : statisticsDurationAndTimesVO.getDuration());
        return todayStatisticsVO;
    }

    @Override
    public ToNowStatisticsVO toNowStatistics(SysUserEntity sysUserEntity) {
        Date currentDate = new Date();

        StatisticsEachTypeDTO dto = new StatisticsEachTypeDTO();
        dto.setMobile(sysUserEntity.getMobile());
        dto.setEndDate(DateUtils.getDayEndTime(currentDate));
        List<StatisticsEachTypeVO> statisticsEachTypeVOList = workoutRecordDetailService.statisticsByTimeAndType(dto);
        parseWorkoutName(statisticsEachTypeVOList);

        StatisticsDurationAndTimesDTO statisticsDurationAndTimesDTO = new StatisticsDurationAndTimesDTO();
        statisticsDurationAndTimesDTO.setMobile(sysUserEntity.getMobile());
        statisticsDurationAndTimesDTO.setEndDate(DateUtils.getDayEndTime(currentDate));
        StatisticsDurationAndTimesVO statisticsDurationAndTimesVO = this.baseMapper.statisticsDurationAndTimes(statisticsDurationAndTimesDTO);

        QueryStartOrEndTimeDTO queryStartTimeDTO = new QueryStartOrEndTimeDTO();
        queryStartTimeDTO.setMobile(sysUserEntity.getMobile());
        queryStartTimeDTO.setSortType(0);
        Date startTrainTime = this.baseMapper.findStartOrEndTrainTime(queryStartTimeDTO);

        QueryStartOrEndTimeDTO queryEndTimeDTO = new QueryStartOrEndTimeDTO();
        queryEndTimeDTO.setMobile(sysUserEntity.getMobile());
        queryEndTimeDTO.setSortType(1);
        Date endTrainTime = this.baseMapper.findStartOrEndTrainTime(queryEndTimeDTO);

        ToNowStatisticsVO toNowStatisticsVO = new ToNowStatisticsVO();
        toNowStatisticsVO.setStatisticsEachTypeVOList(statisticsEachTypeVOList);
        toNowStatisticsVO.setDuration((statisticsDurationAndTimesVO == null || statisticsDurationAndTimesVO.getDuration() == null) ? 0 : statisticsDurationAndTimesVO.getDuration());
        toNowStatisticsVO.setTimes(statisticsDurationAndTimesVO.getTimes());
        toNowStatisticsVO.setStartTrainTime(startTrainTime.getTime());
        toNowStatisticsVO.setEndTrainTime(endTrainTime.getTime());
        return toNowStatisticsVO;
    }

    private void parseWorkoutName(List<StatisticsEachTypeVO> statisticsEachTypeVOList) {
        for (StatisticsEachTypeVO vo : statisticsEachTypeVOList) {
            if (vo.getType().equals(WorkoutTypeEnum.PUSH_UP.getIndex())) {
                vo.setNameCN(WorkoutTypeEnum.PUSH_UP.getName());
                vo.setName(WorkoutTypeEnum.PUSH_UP.name());
            } else if (vo.getType().equals(WorkoutTypeEnum.SIT_UP.getIndex())) {
                vo.setNameCN(WorkoutTypeEnum.SIT_UP.getName());
                vo.setName(WorkoutTypeEnum.SIT_UP.name());
            } else if (vo.getType().equals(WorkoutTypeEnum.LATERAL_CRUNCHES.getIndex())) {
                vo.setNameCN(WorkoutTypeEnum.LATERAL_CRUNCHES.getName());
                vo.setName(WorkoutTypeEnum.LATERAL_CRUNCHES.name());
            } else if (vo.getType().equals(WorkoutTypeEnum.BENT_KNEE_V_UP.getIndex())) {
                vo.setNameCN(WorkoutTypeEnum.BENT_KNEE_V_UP.getName());
                vo.setName(WorkoutTypeEnum.BENT_KNEE_V_UP.name());
            } else if (vo.getType().equals(WorkoutTypeEnum.ROPE_JUMPING.getIndex())) {
                vo.setNameCN(WorkoutTypeEnum.ROPE_JUMPING.getName());
                vo.setName(WorkoutTypeEnum.ROPE_JUMPING.name());
            } else if (vo.getType().equals(WorkoutTypeEnum.AIR_CYCLING.getIndex())) {
                vo.setNameCN(WorkoutTypeEnum.AIR_CYCLING.getName());
                vo.setName(WorkoutTypeEnum.AIR_CYCLING.name());
            }
        }
    }
}