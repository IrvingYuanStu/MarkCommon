package com.irving.mark.comm.util;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Json���л��뷴���л�����
 * @author ���
 * @since 2017��7��22�� ����10:25:22
 * @version MARK 0.0.1
 */
public class JsonConvertUtil {
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	//����objectMapper
	static {
		// �����л�δ֪���Բ���ʧ��
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		// ���л����ֶΰ���
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.setSerializationInclusion(Include.NON_EMPTY);
	}

	/**
	 * ���л�����
	 * @author ���
	 * @since 2017��7��22�� ����10:25:59
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
	 * �����л�
	 * @author ���
	 * @since 2017��7��22�� ����10:37:45
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
