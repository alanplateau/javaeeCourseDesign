package converter;


import com.opensymphony.xwork2.conversion.TypeConversionException;
import org.apache.struts2.util.StrutsTypeConverter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @Author 王怡静
 * @Date 2019-12-25 19:36
 * @Version 1.0
 */
public class DateTypeConverter extends StrutsTypeConverter {
    private final DateFormat sdf[]={new SimpleDateFormat("yyyy-MM-dd HH:mm")};

    //将指定格式字符串转换为日期类型
    @Override
    public Object convertFromString(Map map, String[] strings, Class aClass) {
        String dateStr=strings[0]; //获取日期的字符串
        for(int i=0;i<sdf.length;i++){
            try {
                return sdf[i].parse(dateStr);
            } catch (Exception e) {
                continue;

            }
        }
        //如果遍历完毕后扔没有转换成功，则表明出现转换异常
        throw new TypeConversionException();

    }

    //将日期转换为指定格式字符串
    @Override
    public String convertToString(Map map, Object o) {
        Date date=(Date)o;
        //输出的格式是yyyy-MM-dd HH:mm
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
    }
}
