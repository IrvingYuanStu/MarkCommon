package com.irving.mark.comm.util;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.irving.mark.comm.config.DBconfig;
import com.irving.mark.comm.constants.ClassType;

/**
 * �����Լ�properties�����ļ��Ĺ�����
 * @author ���
 * @since 2017��7��22�� ����12:35:33
 * @version MARK 0.0.1
 */
public class PropertyParser {
	private static final String SETPREFIX = "set";
	
	public static <T> T parseProperties(String fileName, Class<T> type){
		
		T obj = null;
		try {
			InputStream ins = ClassLoader.getSystemResourceAsStream(fileName);
			Properties properties = new Properties();
			properties.load(ins);
			obj = type.newInstance();
			
			Map<String, Field> fieldMap = new HashMap<String, Field>();
			for(Field field:type.getDeclaredFields()){
				String fieldName = field.getName();
				String methodName = SETPREFIX + firstToUperCase(fieldName);
				fieldMap.put(methodName, field);
			}
			for(Method method: type.getDeclaredMethods()){
				Field field = fieldMap.get(method.getName());
				if(null != field){
					String paramTypeName = method.getParameterTypes()[0].getName();
					switch (ClassType.typeOf(paramTypeName)) {
						case INTEGER:
							method.invoke(obj, Integer.parseInt(properties.getProperty(field.getName())));
							break;
						case LONG:
							method.invoke(obj, Long.parseLong(properties.getProperty(field.getName())));
							break;
						default:
							method.invoke(obj, properties.getProperty(field.getName()));
							break;
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	
	/**
	 * ����ĸ��д
	 * @author ���
	 * @since 2017��7��22�� ����11:42:30
	 * @version MARK 0.0.1
	 */
	private static String firstToUperCase(String str){
//		str = str.substring(0, 1).toUpperCase()+str.substring(1);
//		return str;
		//ֱ��ͨ������char��������ĸasiiת����Ч��Ҫ�ߺܶ�
		char[] carry = str.toCharArray();
		carry[0] -= 32;
		return String.valueOf(carry);
	}
	
	public static void main(String[] args) {
		DBconfig config = parseProperties("dbproperties.properties", DBconfig.class);
		System.out.println(JsonConvertUtil.serializeObj(config));
	}

}
