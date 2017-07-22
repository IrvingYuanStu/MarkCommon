package com.irving.mark.comm.config;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 一些基础的 配置信息类，用来序列化自己的配置文件
 * @author 毅成
 * @since 2017年7月22日 下午12:34:22
 * @version MARK 0.0.1
 */
public class BaseConfig implements Serializable{

	private static final long serialVersionUID = -8261901621253025180L;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
