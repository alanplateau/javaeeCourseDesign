/*
 * Copyright(c)2002-2019
 *    项目名称:ARS55version
 *    文件名称:SetCityService.java
 *    Date:2019/12/25 下午7:50
 *    Author:高源
 */

/*
 * *
 *  * @author  高源
 *  * @date  ${DATE} ${TIME}
 *  * @version 1.0
 *
 */

package service;

import com.opensymphony.xwork2.ActionContext;
import dao.ICityDAO;
import tool.PinYin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SetCityService implements ISetCityService {
    private ICityDAO cityDAO = null;
    private Map<String,Object> session;

    public void setCityDAO(ICityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }

    public void getSortedCities(){
        ActionContext ctx=ActionContext.getContext();
        session=(Map)ctx.getSession();
        List<String> city=(List<String>)cityDAO.getAllCities();
        Map<Character, List<String>> cityMap=new HashMap<Character, List<String>>();
        for(char index='A';index<='Z';index++){
            cityMap.put(index,new ArrayList<String>());
        }
        for(String str:city){
            char temp= PinYin.getFirstPinYin(str);
            cityMap.get(temp).add(str);
        }
//        for (Character character:cityMap.keySet()){
//            List<String> list=cityMap.get(character);
//            for(String str2:list){
//                System.out.println(str2);
//            }
//        }
        session.put("cityMap",cityMap);
    }

}
