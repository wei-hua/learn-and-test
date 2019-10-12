//package util;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.type.CollectionType;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.IOException;
//import java.util.List;
//
//public class JsonUtils {
//
//  private static Logger log = LoggerFactory.getLogger(JsonUtils.class);
//  private static ObjectMapper mapper = new ObjectMapper();
//
//  public static <T> T parseObject(String json, Class<T> type) {
//    T object = null;
//    try {
//      object = mapper.readValue(json, type);
//    } catch (IOException e) {
//      log.error("parse json exception. ", e);
//    }
//    return object;
//  }
//
//  public static <T> T parseObject(String json, TypeReference<T> typeReference) {
//    T object = null;
//    try {
//      object = mapper.readValue(json, typeReference);
//    } catch (IOException e) {
//      log.error("parse json exception. ", e);
//    }
//    return object;
//  }
//
//  public static String parseString(String fieldName, String json) {
//    String value = "";
//    try {
//      JsonNode jsonNode = mapper.readTree(json);
//      value = jsonNode.get(fieldName).textValue();
//    } catch (IOException e) {
//      log.error("parse json exception. ", e);
//    }
//    return value;
//  }
//
//  public static <T> List<T> parseArray(String json, Class<T> type) {
//    CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, type);
//    List<T> object = null;
//    try {
//      object = mapper.readValue(json, collectionType);
//    } catch (IOException e) {
//      log.error("parse json exception. ", e);
//    }
//    return object;
//  }
//
//  public static String toJSONString(Object object) {
//    String json = null;
//    try {
//      json = mapper.writeValueAsString(object);
//    } catch (JsonProcessingException e) {
//      log.error("to json error. ", e);
//    }
//    return json;
//  }
//}
