package com.irving.mark.comm.config;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * һЩ������ ������Ϣ�࣬�������л��Լ��������ļ�
 * @author ���
 * @since 2017��7��22�� ����12:34:22
 * @version MARK 0.0.1
 */
public class BaseConfig implements Serializable{

	private static final long serialVersionUID = -8261901621253025180L;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
