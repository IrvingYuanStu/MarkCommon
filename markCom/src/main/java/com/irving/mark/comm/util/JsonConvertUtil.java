package com.irving.mark.comm.util;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Json序列化与反序列化工具
 * @author 毅成
 * @since 2017年7月22日 上午10:25:22
 * @version MARK 0.0.1
 */
public class JsonConvertUtil {
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	//设置objectMapper
	static {
		// 反序列化未知属性不会失败
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		// 序列化的字段包含
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.setSerializationInclusion(Include.NON_EMPTY);
	}

	/**
	 * 序列化对象
	 * @author 毅成
	 * @since 2017年7月22日 上午10:25:59
	 * @version MARK 0.0.1
	 */
	public static String serializeObj(Object t){
		String jsonStr = null;
		try {
			jsonStr = objectMapper.writeValueAsString(t);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	/**
	 * 反序列化
	 * @author 毅成
	 * @since 2017年7月22日 上午10:37:45
	 * @version MARK 0.0.1
	 */
	public static <T> T deserializeJson(String jsonStr, Class<T> type){
		T obj = null;
		try {
			obj = objectMapper.readValue(jsonStr, type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7};
		String arrStr = serializeObj(array);
		System.out.println(arrStr);
		int[] arrayo = deserializeJson(arrStr, int[].class);
		System.out.println(arrayo);
	}
}
