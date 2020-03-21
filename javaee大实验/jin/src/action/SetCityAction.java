/*
 * Copyright(c)2002-2019
 *    项目名称:ARS55version
 *    文件名称:SetCityAction.java
 *    Date:2019/12/25 下午7:50
 *    Author:高源
 */


package action;

/*本action用于产生一个名为cityMap的map<char,List<String>>类型，
  其中key中char中的取值为A,B,C,D,....X,Y,Z,而value中的取值为相应首字母的城市List
 */

import service.ISetCityService;

import java.util.List;
import java.util.Map;

public class SetCityAction {
    private ISetCityService setCityService=null;

    public void setSetCityService(ISetCityService setCityService) {
        this.setCityService = setCityService;
    }

    public String  getCitySort(){
        setCityService.getSortedCities();
        return "success";
    }
}
