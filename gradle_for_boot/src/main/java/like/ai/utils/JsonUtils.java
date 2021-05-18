package like.ai.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author by chenaiquan<like.aiquan@qq.com> create on 2021/5/10 10.06
 */
public class JsonUtils {
  private static final ObjectMapper OBJECT_MAPPER;
  public static final ObjectReader OBJECT_READER;
  public static final ObjectWriter OBJECT_WRITER;

  static {
    OBJECT_MAPPER = new ObjectMapper();
    // 转换为格式化的json
    OBJECT_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
    //序列化的时候序列对象的所有属性
    OBJECT_MAPPER.setSerializationInclusion(Include.ALWAYS);
    // 如果json中有新增的字段并且是实体类类中不存在的，不报错(忽略多于字段)
    OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    //如果是空对象的时候,不抛异常
    // OBJECT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    //取消时间的转化格式,默认是时间戳,可以取消,同时需要设置要表现的时间格式
    OBJECT_MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    OBJECT_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    OBJECT_READER = OBJECT_MAPPER.reader();
    OBJECT_WRITER = OBJECT_MAPPER.writer();
  }

  public static String objectToJson(Object o) {
    try {
      return OBJECT_WRITER.writeValueAsString(o);
    } catch (Exception e) {
      throw new RuntimeException("Check that your json string is formatted");
    }
  }

  public static <T> T jsonToObject(String json, Class<T> type) {
    try {
      return OBJECT_READER.forType(type).readValue(json);
    } catch (Exception e) {
      throw new RuntimeException("Check that your json string is formatted or you class type is correct");
    }
  }

  @SuppressWarnings("unchecked")
  public static Map<String, Object> map(String json) {
    Map<String, Object> map;
    try {
      map = (Map<String, Object>) jsonToObject(json, Map.class);
    } catch (Exception e) {
      throw new RuntimeException("check your json string is formatted");
    }
    return map;
  }

  public static ObjectMapper copy() {
    return OBJECT_MAPPER.copy();
  }
}