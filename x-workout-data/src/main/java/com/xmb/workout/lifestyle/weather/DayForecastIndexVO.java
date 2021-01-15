package com.xmb.workout.lifestyle.weather;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.dom4j.Element;

import java.util.List;

/**
 * @author Ben
 * @date 2021-01-14
 * @desc
 */
@ApiModel(value = "今天天气指数VO")
@Data
public class DayForecastIndexVO {

    @ApiModelProperty(value = "紫外线强度")
    private String ultraviolet;

    @ApiModelProperty(value = "舒适度")
    private String comfortLevel;

    @ApiModelProperty(value = "城市火警")
    private String cityFire;

    @ApiModelProperty(value = "晾晒指数")
    private String sunCure;

    @ApiModelProperty(value = "霉变指数")
    private String mildew;

    @ApiModelProperty(value = "晨运指数")
    private String morningExercise;

    @ApiModelProperty(value = "森林火灾指数")
    private String forestFire;

    @ApiModelProperty(value = "穿衣指数")
    private String dress;

    @ApiModelProperty(value = "空气指数")
    private String air;

    @ApiModelProperty(value = "暑热指数")
    private String heat;

    /**
     * 解析
     * @param indexElement
     * @return
     * @throws Exception
     */
    public static DayForecastIndexVO parseElementToVO(Element indexElement) throws Exception {
        DayForecastIndexVO vo = new DayForecastIndexVO();

        List<Element> elementList = indexElement.elements();
        if (elementList == null || elementList.size() != 10) {
            throw new Exception("天气指数子元素数量不对！");
        } else {
            if (elementList.get(0).getData() != null) {
                vo.setUltraviolet(String.valueOf(elementList.get(0).getData()));
            }
            if (elementList.get(1).getData() != null) {
                vo.setComfortLevel(String.valueOf(elementList.get(1).getData()));
            }
            if (elementList.get(2).getData() != null) {
                vo.setCityFire(String.valueOf(elementList.get(2).getData()));
            }
            if (elementList.get(3).getData() != null) {
                vo.setSunCure(String.valueOf(elementList.get(3).getData()));
            }
            if (elementList.get(4).getData() != null) {
                vo.setMildew(String.valueOf(elementList.get(4).getData()));
            }
            if (elementList.get(5).getData() != null) {
                vo.setMorningExercise(String.valueOf(elementList.get(5).getData()));
            }
            if (elementList.get(6).getData() != null) {
                vo.setForestFire(String.valueOf(elementList.get(6).getData()));
            }
            if (elementList.get(7).getData() != null) {
                vo.setDress(String.valueOf(elementList.get(7).getData()));
            }
            if (elementList.get(8).getData() != null) {
                vo.setAir(String.valueOf(elementList.get(8).getData()));
            }
            if (elementList.get(9).getData() != null) {
                vo.setHeat(String.valueOf(elementList.get(9).getData()));
            }
        }
        return vo;
    }
}
