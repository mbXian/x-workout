package com.xmb.workout.lifestyle.weather;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ben
 * @date 2021-01-14
 * @desc
 */
@ApiModel(value = "一周每天的城市预报VO")
@Data
public class WeekDayForecastCityVO {

    @ApiModelProperty(value = "日期")
    private String time;

    @ApiModelProperty(value = "周几")
    private String week;

    @ApiModelProperty(value = "天气形势")
    private String situation;

    @ApiModelProperty(value = "天气变化")
    private String weatherShape;

    @ApiModelProperty(value = "天气现象")
    private String weatherPhenomena;

    @ApiModelProperty(value = "天气现象")
    private String weatherPhenomenaEx;

    @ApiModelProperty(value = "")
    private String joinWord;

    @ApiModelProperty(value = "温度")
    private String temperature;

    @ApiModelProperty(value = "风向")
    private String windDirection;

    @ApiModelProperty(value = "风速")
    private String windSpeed;

    @ApiModelProperty(value = "湿度")
    private String humidity;

    @ApiModelProperty(value = "能见度")
    private String visibility;

    @ApiModelProperty(value = "图标")
    private String icon;

    /**
     * 解析
     *
     * @param cityElement
     * @return
     */
    public static List<WeekDayForecastCityVO> parseElementToVOList(Element cityElement) throws Exception {
        List<WeekDayForecastCityVO> voList = new ArrayList<WeekDayForecastCityVO>();
        List<Element> elementList = cityElement.elements();
        if (elementList == null || elementList.size() != 99) {
            throw new Exception("城市一周每天预报子元素数量不对！");
        } else {
            //第一天
            WeekDayForecastCityVO vo1 = new WeekDayForecastCityVO();
            if (elementList.get(1).getData() != null) {
                vo1.setTime(String.valueOf(elementList.get(1).getData()));
            }
            if (elementList.get(2).getData() != null) {
                vo1.setWeek(String.valueOf(elementList.get(2).getData()));
            }
            if (elementList.get(3).getData() != null) {
                vo1.setSituation(String.valueOf(elementList.get(3).getData()));
            }
            if (elementList.get(4).getData() != null) {
                vo1.setWeatherShape(String.valueOf(elementList.get(4).getData()));
            }
            if (elementList.get(5).getData() != null) {
                vo1.setWeatherPhenomena(String.valueOf(elementList.get(5).getData()));
            }
            if (elementList.get(6).getData() != null) {
                vo1.setWeatherPhenomenaEx(String.valueOf(elementList.get(6).getData()));
            }
            if (elementList.get(7).getData() != null) {
                vo1.setJoinWord(String.valueOf(elementList.get(7).getData()));
            }
            if (elementList.get(8).getData() != null) {
                vo1.setTemperature(String.valueOf(elementList.get(8).getData()));
            }
            if (elementList.get(9).getData() != null) {
                vo1.setWindDirection(String.valueOf(elementList.get(9).getData()));
            }
            if (elementList.get(10).getData() != null) {
                vo1.setWindSpeed(String.valueOf(elementList.get(10).getData()));
            }
            if (elementList.get(12).getData() != null) {
                vo1.setHumidity(String.valueOf(elementList.get(12).getData()));
            }
            if (elementList.get(13).getData() != null) {
                vo1.setVisibility(String.valueOf(elementList.get(13).getData()));
            }
            if (elementList.get(14).getData() != null) {
                vo1.setIcon(String.valueOf(elementList.get(14).getData()));
            }
            voList.add(vo1);

            //第二天
            WeekDayForecastCityVO vo2 = new WeekDayForecastCityVO();
            if (elementList.get(15).getData() != null) {
                vo2.setTime(String.valueOf(elementList.get(15).getData()));
            }
            if (elementList.get(16).getData() != null) {
                vo2.setWeek(String.valueOf(elementList.get(16).getData()));
            }
            if (elementList.get(17).getData() != null) {
                vo2.setSituation(String.valueOf(elementList.get(17).getData()));
            }
            if (elementList.get(18).getData() != null) {
                vo2.setWeatherShape(String.valueOf(elementList.get(18).getData()));
            }
            if (elementList.get(19).getData() != null) {
                vo2.setWeatherPhenomena(String.valueOf(elementList.get(19).getData()));
            }
            if (elementList.get(20).getData() != null) {
                vo2.setWeatherPhenomenaEx(String.valueOf(elementList.get(20).getData()));
            }
            if (elementList.get(21).getData() != null) {
                vo2.setJoinWord(String.valueOf(elementList.get(21).getData()));
            }
            if (elementList.get(22).getData() != null) {
                vo2.setTemperature(String.valueOf(elementList.get(22).getData()));
            }
            if (elementList.get(23).getData() != null) {
                vo2.setWindDirection(String.valueOf(elementList.get(23).getData()));
            }
            if (elementList.get(24).getData() != null) {
                vo2.setWindSpeed(String.valueOf(elementList.get(24).getData()));
            }
            if (elementList.get(26).getData() != null) {
                vo2.setHumidity(String.valueOf(elementList.get(26).getData()));
            }
            if (elementList.get(27).getData() != null) {
                vo2.setVisibility(String.valueOf(elementList.get(27).getData()));
            }
            if (elementList.get(28).getData() != null) {
                vo2.setIcon(String.valueOf(elementList.get(28).getData()));
            }
            voList.add(vo2);

            //第三天
            WeekDayForecastCityVO vo3 = new WeekDayForecastCityVO();
            if (elementList.get(29).getData() != null) {
                vo3.setTime(String.valueOf(elementList.get(29).getData()));
            }
            if (elementList.get(30).getData() != null) {
                vo3.setWeek(String.valueOf(elementList.get(30).getData()));
            }
            if (elementList.get(31).getData() != null) {
                vo3.setSituation(String.valueOf(elementList.get(31).getData()));
            }
            if (elementList.get(32).getData() != null) {
                vo3.setWeatherShape(String.valueOf(elementList.get(32).getData()));
            }
            if (elementList.get(33).getData() != null) {
                vo3.setWeatherPhenomena(String.valueOf(elementList.get(33).getData()));
            }
            if (elementList.get(34).getData() != null) {
                vo3.setWeatherPhenomenaEx(String.valueOf(elementList.get(34).getData()));
            }
            if (elementList.get(35).getData() != null) {
                vo3.setJoinWord(String.valueOf(elementList.get(35).getData()));
            }
            if (elementList.get(36).getData() != null) {
                vo3.setTemperature(String.valueOf(elementList.get(36).getData()));
            }
            if (elementList.get(37).getData() != null) {
                vo3.setWindDirection(String.valueOf(elementList.get(37).getData()));
            }
            if (elementList.get(38).getData() != null) {
                vo3.setWindSpeed(String.valueOf(elementList.get(38).getData()));
            }
            if (elementList.get(40).getData() != null) {
                vo3.setHumidity(String.valueOf(elementList.get(40).getData()));
            }
            if (elementList.get(41).getData() != null) {
                vo3.setVisibility(String.valueOf(elementList.get(41).getData()));
            }
            if (elementList.get(42).getData() != null) {
                vo3.setIcon(String.valueOf(elementList.get(42).getData()));
            }
            voList.add(vo3);

            //第四天
            WeekDayForecastCityVO vo4 = new WeekDayForecastCityVO();
            if (elementList.get(43).getData() != null) {
                vo4.setTime(String.valueOf(elementList.get(43).getData()));
            }
            if (elementList.get(44).getData() != null) {
                vo4.setWeek(String.valueOf(elementList.get(44).getData()));
            }
            if (elementList.get(45).getData() != null) {
                vo4.setSituation(String.valueOf(elementList.get(45).getData()));
            }
            if (elementList.get(46).getData() != null) {
                vo4.setWeatherShape(String.valueOf(elementList.get(46).getData()));
            }
            if (elementList.get(47).getData() != null) {
                vo4.setWeatherPhenomena(String.valueOf(elementList.get(47).getData()));
            }
            if (elementList.get(48).getData() != null) {
                vo4.setWeatherPhenomenaEx(String.valueOf(elementList.get(48).getData()));
            }
            if (elementList.get(49).getData() != null) {
                vo4.setJoinWord(String.valueOf(elementList.get(49).getData()));
            }
            if (elementList.get(50).getData() != null) {
                vo4.setTemperature(String.valueOf(elementList.get(50).getData()));
            }
            if (elementList.get(51).getData() != null) {
                vo4.setWindDirection(String.valueOf(elementList.get(51).getData()));
            }
            if (elementList.get(52).getData() != null) {
                vo4.setWindSpeed(String.valueOf(elementList.get(52).getData()));
            }
            if (elementList.get(54).getData() != null) {
                vo4.setHumidity(String.valueOf(elementList.get(54).getData()));
            }
            if (elementList.get(55).getData() != null) {
                vo4.setVisibility(String.valueOf(elementList.get(55).getData()));
            }
            if (elementList.get(56).getData() != null) {
                vo4.setIcon(String.valueOf(elementList.get(56).getData()));
            }
            voList.add(vo4);

            //第五天
            WeekDayForecastCityVO vo5 = new WeekDayForecastCityVO();
            if (elementList.get(57).getData() != null) {
                vo5.setTime(String.valueOf(elementList.get(57).getData()));
            }
            if (elementList.get(58).getData() != null) {
                vo5.setWeek(String.valueOf(elementList.get(58).getData()));
            }
            if (elementList.get(59).getData() != null) {
                vo5.setSituation(String.valueOf(elementList.get(59).getData()));
            }
            if (elementList.get(60).getData() != null) {
                vo5.setWeatherShape(String.valueOf(elementList.get(60).getData()));
            }
            if (elementList.get(61).getData() != null) {
                vo5.setWeatherPhenomena(String.valueOf(elementList.get(61).getData()));
            }
            if (elementList.get(62).getData() != null) {
                vo5.setWeatherPhenomenaEx(String.valueOf(elementList.get(62).getData()));
            }
            if (elementList.get(63).getData() != null) {
                vo5.setJoinWord(String.valueOf(elementList.get(63).getData()));
            }
            if (elementList.get(64).getData() != null) {
                vo5.setTemperature(String.valueOf(elementList.get(64).getData()));
            }
            if (elementList.get(65).getData() != null) {
                vo5.setWindDirection(String.valueOf(elementList.get(65).getData()));
            }
            if (elementList.get(66).getData() != null) {
                vo5.setWindSpeed(String.valueOf(elementList.get(66).getData()));
            }
            if (elementList.get(68).getData() != null) {
                vo5.setHumidity(String.valueOf(elementList.get(68).getData()));
            }
            if (elementList.get(69).getData() != null) {
                vo5.setVisibility(String.valueOf(elementList.get(69).getData()));
            }
            if (elementList.get(70).getData() != null) {
                vo5.setIcon(String.valueOf(elementList.get(70).getData()));
            }
            voList.add(vo5);

            //第六天
            WeekDayForecastCityVO vo6 = new WeekDayForecastCityVO();
            if (elementList.get(71).getData() != null) {
                vo6.setTime(String.valueOf(elementList.get(71).getData()));
            }
            if (elementList.get(72).getData() != null) {
                vo6.setWeek(String.valueOf(elementList.get(72).getData()));
            }
            if (elementList.get(73).getData() != null) {
                vo6.setSituation(String.valueOf(elementList.get(73).getData()));
            }
            if (elementList.get(74).getData() != null) {
                vo6.setWeatherShape(String.valueOf(elementList.get(74).getData()));
            }
            if (elementList.get(75).getData() != null) {
                vo6.setWeatherPhenomena(String.valueOf(elementList.get(75).getData()));
            }
            if (elementList.get(76).getData() != null) {
                vo6.setWeatherPhenomenaEx(String.valueOf(elementList.get(76).getData()));
            }
            if (elementList.get(77).getData() != null) {
                vo6.setJoinWord(String.valueOf(elementList.get(77).getData()));
            }
            if (elementList.get(78).getData() != null) {
                vo6.setTemperature(String.valueOf(elementList.get(78).getData()));
            }
            if (elementList.get(79).getData() != null) {
                vo6.setWindDirection(String.valueOf(elementList.get(79).getData()));
            }
            if (elementList.get(80).getData() != null) {
                vo6.setWindSpeed(String.valueOf(elementList.get(80).getData()));
            }
            if (elementList.get(82).getData() != null) {
                vo6.setHumidity(String.valueOf(elementList.get(82).getData()));
            }
            if (elementList.get(83).getData() != null) {
                vo6.setVisibility(String.valueOf(elementList.get(83).getData()));
            }
            if (elementList.get(84).getData() != null) {
                vo6.setIcon(String.valueOf(elementList.get(84).getData()));
            }
            voList.add(vo6);

            //第七天
            WeekDayForecastCityVO vo7 = new WeekDayForecastCityVO();
            if (elementList.get(85).getData() != null) {
                vo7.setTime(String.valueOf(elementList.get(85).getData()));
            }
            if (elementList.get(86).getData() != null) {
                vo7.setWeek(String.valueOf(elementList.get(86).getData()));
            }
            if (elementList.get(87).getData() != null) {
                vo7.setSituation(String.valueOf(elementList.get(87).getData()));
            }
            if (elementList.get(88).getData() != null) {
                vo7.setWeatherShape(String.valueOf(elementList.get(88).getData()));
            }
            if (elementList.get(89).getData() != null) {
                vo7.setWeatherPhenomena(String.valueOf(elementList.get(89).getData()));
            }
            if (elementList.get(90).getData() != null) {
                vo7.setWeatherPhenomenaEx(String.valueOf(elementList.get(90).getData()));
            }
            if (elementList.get(91).getData() != null) {
                vo7.setJoinWord(String.valueOf(elementList.get(91).getData()));
            }
            if (elementList.get(92).getData() != null) {
                vo7.setTemperature(String.valueOf(elementList.get(92).getData()));
            }
            if (elementList.get(93).getData() != null) {
                vo7.setWindDirection(String.valueOf(elementList.get(93).getData()));
            }
            if (elementList.get(94).getData() != null) {
                vo7.setWindSpeed(String.valueOf(elementList.get(94).getData()));
            }
            if (elementList.get(96).getData() != null) {
                vo7.setHumidity(String.valueOf(elementList.get(96).getData()));
            }
            if (elementList.get(97).getData() != null) {
                vo7.setVisibility(String.valueOf(elementList.get(97).getData()));
            }
            if (elementList.get(98).getData() != null) {
                vo7.setIcon(String.valueOf(elementList.get(98).getData()));
            }
            voList.add(vo7);
        }
        return voList;
    }
}
