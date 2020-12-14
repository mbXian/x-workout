package com.xmb.workout.workout.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xmb.auth.entity.SysUserEntity;
import com.xmb.common.utils.DateUtils;
import com.xmb.workout.utils.CodeGenerateUtils;
import com.xmb.workout.workout.constant.WorkoutTypeEnum;
import com.xmb.workout.workout.dto.QueryStartOrEndTimeDTO;
import com.xmb.workout.workout.dto.StatisticsDurationAndTimesDTO;
import com.xmb.workout.workout.dto.StatisticsEachTypeDTO;
import com.xmb.workout.workout.dto.WorkoutRecordEnterDailyTemporaryBaseDTO;
import com.xmb.workout.workout.entity.WorkoutRecordDetailEntity;
import com.xmb.workout.workout.service.WorkoutRecordDetailService;
import com.xmb.workout.workout.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xmb.workout.workout.dao.WorkoutRecordDao;
import com.xmb.workout.workout.entity.WorkoutRecordEntity;
import com.xmb.workout.workout.service.WorkoutRecordService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

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
    public Boolean enterDailyDataTemporary(WorkoutRecordEnterDailyTemporaryBaseDTO workoutRecordEnterDailyTemporaryDTO, SysUserEntity sysUserEntity) throws Exception {
        log.info("参数 = {}", JSON.toJSONString(workoutRecordEnterDailyTemporaryDTO));
        if (!"4444".equals(workoutRecordEnterDailyTemporaryDTO.getPassword())) {
            throw new Exception("密码错误!");
        }
        Date currentDate = new Date();
        WorkoutRecordEntity workoutRecordEntity = new WorkoutRecordEntity();
        workoutRecordEntity.setNumber(CodeGenerateUtils.generate(DateUtils.format(currentDate, DateUtils.DATE_TIME_PATTERN_WITHOUT_SYMBOL)));
        workoutRecordEntity.setUserMobile(sysUserEntity.getMobile());
        workoutRecordEntity.setTrainTime(new Date(workoutRecordEnterDailyTemporaryDTO.getTrainTimeMilliSec()));
        workoutRecordEntity.setFinishTime(new Date(workoutRecordEnterDailyTemporaryDTO.getFinishTimeMilliSec()));
        workoutRecordEntity.setLatitude(workoutRecordEnterDailyTemporaryDTO.getLatitude());
        workoutRecordEntity.setLongitude(workoutRecordEnterDailyTemporaryDTO.getLongitude());

        List<WorkoutRecordDetailEntity> detailEntityList = new ArrayList<WorkoutRecordDetailEntity>();

        WorkoutRecordDetailEntity detailEntity1 = new WorkoutRecordDetailEntity();
        detailEntity1.setWorkoutNumber(workoutRecordEntity.getNumber());
        detailEntity1.setType(WorkoutTypeEnum.PUSH_UP.getIndex());
        detailEntity1.setSortNo(1);
        detailEntity1.setCount(25);
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
        detailEntity3.setCount(25);
        detailEntity3.setGroups(1);
        detailEntityList.add(detailEntity3);

        WorkoutRecordDetailEntity detailEntity4 = new WorkoutRecordDetailEntity();
        detailEntity4.setWorkoutNumber(workoutRecordEntity.getNumber());
        detailEntity4.setType(WorkoutTypeEnum.AIR_CYCLING.getIndex());
        detailEntity4.setSortNo(4);
        detailEntity4.setCount(26);
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
        detailEntity6.setCount(400);
        detailEntity6.setGroups(1);
        detailEntityList.add(detailEntity6);

        workoutRecordDetailService.saveBatch(detailEntityList);

        this.baseMapper.insert(workoutRecordEntity);

        log.info(workoutRecordEntity.getTrainTime().toString());

        return Boolean.TRUE;
    }

    /**
     * 今日数据统计
     * @param sysUserEntity
     * @return
     */
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

    /**
     * 目前数据统计
     * @param sysUserEntity
     * @return
     */
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

    /**
     * 所有的锻炼项目
     * @return
     */
    @Override
    public List<WorkoutTypeVO> workoutTypeList() {

        List<WorkoutTypeVO> workoutTypeVOList = new ArrayList<WorkoutTypeVO>();
        WorkoutTypeEnum[] workoutTypeEnums = WorkoutTypeEnum.values();
        for (WorkoutTypeEnum workoutTypeEnum : workoutTypeEnums) {
            WorkoutTypeVO vo = new WorkoutTypeVO();
            vo.setName(workoutTypeEnum.name());
            vo.setNameCN(workoutTypeEnum.getName());
            vo.setType(workoutTypeEnum.getIndex());
            workoutTypeVOList.add(vo);
        }
        return workoutTypeVOList;
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

    /**
     * 过期n天训练饱和率
     * @param sysUserEntity
     * @param days
     */
    @Override
    public WorkoutDaysSaturationVO daysSaturation(SysUserEntity sysUserEntity, Integer days) {

        WorkoutDaysSaturationVO vo = new WorkoutDaysSaturationVO();

        Date currentDate = new Date();
        Date todayStartTime = DateUtils.getDayStartTime(currentDate);
        Date todayEndTime = DateUtils.getDayEndTime(currentDate);
        List<WorkoutRecordEntity> list = list(Wrappers.<WorkoutRecordEntity>query().lambda().between(WorkoutRecordEntity::getTrainTime, todayStartTime, todayEndTime));

        LocalDateTime todayLocalDateTime = DateUtils.convertFromDateToLocalDateTime(todayStartTime);
        LocalDateTime daysAgoLocalDateTime = null;
        if (CollectionUtils.isEmpty(list)) {
            daysAgoLocalDateTime = todayLocalDateTime.minusDays(days);
        } else {
            //今日有锻炼，往前算少一天
            daysAgoLocalDateTime = todayLocalDateTime.minusDays(days - 1);
        }
        Date daysAgoTime = DateUtils.convertFromLocalDateTimeToDate(daysAgoLocalDateTime);

        List<WorkoutRecordEntity> recordEntityList = list(Wrappers.<WorkoutRecordEntity>query().lambda().between(WorkoutRecordEntity::getTrainTime, daysAgoTime, todayEndTime).eq(WorkoutRecordEntity::getDeleted, 0));

        List<String> dateStringList = new ArrayList<>();
        for (WorkoutRecordEntity workoutRecordEntity : recordEntityList) {
            String format = DateUtils.format(workoutRecordEntity.getTrainTime(), DateUtils.DATE_PATTERN);
            if (!dateStringList.contains(format)) {
                dateStringList.add(format);
            }
        }
        vo.setDaysSaturation((Math.round((dateStringList.size() / (float)days) * 1000) / 1000.0));

        return vo;
    }

    /**
     * 已连续锻炼天数
     * @param sysUserEntity
     * @return
     */
    @Override
    public WorkoutKeepOnDaysVO keepOnDays(SysUserEntity sysUserEntity) {
        WorkoutKeepOnDaysVO vo = new WorkoutKeepOnDaysVO();
        vo.setKeepOnDays(0);

        Date currentDate = new Date();
        LocalDateTime startLocalDateTime = DateUtils.convertFromDateToLocalDateTime(DateUtils.getDayStartTime(currentDate));
        LocalDateTime endLocalDateTime = DateUtils.convertFromDateToLocalDateTime(DateUtils.getDayEndTime(currentDate));

        List<Date> dateList = baseMapper.findTrainTime(sysUserEntity.getMobile());

        if (!CollectionUtils.isEmpty(dateList)) {
            Date trainTime = null;
            LocalDateTime localDateTime = null;

            trainTime = dateList.get(0);
            localDateTime = DateUtils.convertFromDateToLocalDateTime(trainTime);
            if (localDateTime.isAfter(startLocalDateTime) && localDateTime.isBefore(endLocalDateTime)) {
                //今日已锻炼

            } else {
                //今日没锻炼
                startLocalDateTime = startLocalDateTime.minusDays(1);
                endLocalDateTime = endLocalDateTime.minusDays(1);
            }
            LocalDateTime lastLocalDateTime = null;
            for (int i = 0; i < dateList.size(); i++) {
                trainTime = dateList.get(i);
                localDateTime = DateUtils.convertFromDateToLocalDateTime(trainTime);
                LocalDateTime workoutDayStartLocalDateTime = startLocalDateTime.minusDays(i);
                LocalDateTime workoutDayEndLocalDateTime = endLocalDateTime.minusDays(i);
                if (lastLocalDateTime != null && lastLocalDateTime.getDayOfMonth() == localDateTime.getDayOfMonth()) {
                    continue;
                }
                if (localDateTime.isAfter(workoutDayStartLocalDateTime) && localDateTime.isBefore(workoutDayEndLocalDateTime)) {
                    vo.setKeepOnDays(vo.getKeepOnDays() + 1);
                } else {
                    break;
                }
                lastLocalDateTime = localDateTime;
            }
        }
        return vo;
    }

}