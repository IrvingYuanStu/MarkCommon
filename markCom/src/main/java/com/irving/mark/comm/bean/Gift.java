package com.irving.mark.comm.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 抽奖奖品实体类
 * @author irving
 * @since 2017年7月23日 下午9:41:33
 * @version MARK 0.0.1
 */
public class Gift {
	
	private int id;			//奖品Id
	private String name;	//奖品名称
	private double prob;	//获奖概率
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getProb() {
		return prob;
	}
	public void setProb(double prob) {
		this.prob = prob;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
