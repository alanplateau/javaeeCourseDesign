/*
 * Copyright(c)2002-2019
 *    项目名称:ARS55version
 *    文件名称:PinYin.java
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

package tool;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/*获得中文单词的首字母*/

public class PinYin {

    public static char getFirstPinYin(String hanyu) {
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

        StringBuilder firstPinyin = new StringBuilder();
        char[] hanyuArr = hanyu.trim().toCharArray();
        try {
                for(int i=0;i<hanyuArr.length;i++) {
                    if (Character.toString(hanyuArr[i]).matches("[\\u4E00-\\u9FA5]+")) {
                        String[] pys = PinyinHelper.toHanyuPinyinStringArray(hanyuArr[i], format);
                        return pys[0].charAt(0);
                    }
                }
        } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
            badHanyuPinyinOutputFormatCombination.printStackTrace();
        }
        return '!';
    }


}
