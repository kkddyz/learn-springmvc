package cn.itcast.util;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kkddyz
 * <p>
 * 将 2021-10-2 这种格式的字符串转换成Date对象
 */
public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        if (source == null || "".equals(source)) {
            throw new RuntimeException("传入字符串先");
        }

        // 我们不需要直接对字符串进行分割，然后将年月日分别指定；
        // 我们只需要指定日期的格式，通过DateFormat将字符串转换为日期对象
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = df.parse(source);
            return date;
        } catch (ParseException e) {
            throw new RuntimeException("传入字符串格式错误，你应该传入如下格式：yyyy-MM-dd");
        }
    }
}
