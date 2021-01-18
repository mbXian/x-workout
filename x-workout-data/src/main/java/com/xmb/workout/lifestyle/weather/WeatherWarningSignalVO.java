package com.xmb.workout.lifestyle.weather;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ben
 * @date 2021-01-18
 * @desc
 */
@ApiModel(value = "预警信号VO")
@Data
public class WeatherWarningSignalVO {

    @ApiModelProperty(value = "地区名称")
    private String area;

    @ApiModelProperty(value = "预警信号更新时间")
    private String yjxhUdTime;

    @ApiModelProperty(value = "")
    private String path1;

    @ApiModelProperty(value = "")
    private String path2;

    @ApiModelProperty(value = "")
    private String path3;

    @ApiModelProperty(value = "")
    private String path4;

    @ApiModelProperty(value = "")
    private String path5;

    @ApiModelProperty(value = "")
    private String path6;

    @ApiModelProperty(value = "")
    private String path7;

    @ApiModelProperty(value = "")
    private String path8;

    @ApiModelProperty(value = "")
    private String path9;

    @ApiModelProperty(value = "")
    private String path10;

    @ApiModelProperty(value = "预警信号描述")
    private String yjxhStr;

    @ApiModelProperty(value = "预警信号扩展描述")
    private String yjxhExp;

    public static List<WeatherWarningSignalVO> parseXmlRespStringToVO(String respXmlString) throws Exception {
        List<WeatherWarningSignalVO> voList = new ArrayList<WeatherWarningSignalVO>();
        if (StringUtils.isEmpty(respXmlString)) {
            throw new Exception("xml数据错误！");
        } else {
            Document doc = DocumentHelper.parseText(respXmlString);
            Element dataRootElement = doc.getRootElement();
            if (dataRootElement == null) {
                throw new Exception("xml数据不包含根元素！");
            } else {
                List<Element> rootElementList = dataRootElement.elements();
                if (CollectionUtils.isEmpty(rootElementList) || rootElementList.size() != 1) {
                    throw new Exception("DS元素下包含子元素数量不对！");
                } else {
                    List<Element> listElementList = rootElementList.get(0).elements();
                    for (Element element : listElementList) {
                        WeatherWarningSignalVO vo = new WeatherWarningSignalVO();
                        vo.setArea(element.elements().get(0).getStringValue());
                        vo.setYjxhUdTime(element.elements().get(1).getStringValue());
                        vo.setPath1(element.elements().get(2).getStringValue());
                        vo.setPath2(element.elements().get(3).getStringValue());
                        vo.setPath3(element.elements().get(4).getStringValue());
                        vo.setPath4(element.elements().get(5).getStringValue());
                        vo.setPath5(element.elements().get(6).getStringValue());
                        vo.setPath6(element.elements().get(7).getStringValue());
                        vo.setPath7(element.elements().get(8).getStringValue());
                        vo.setPath8(element.elements().get(9).getStringValue());
                        vo.setPath9(element.elements().get(10).getStringValue());
                        vo.setPath10(element.elements().get(11).getStringValue());
                        vo.setYjxhStr(element.elements().get(22).getStringValue());
                        vo.setYjxhExp(element.elements().get(23).getStringValue());
                        voList.add(vo);
                    }
                }
            }
        }

        return voList;
    }

}
