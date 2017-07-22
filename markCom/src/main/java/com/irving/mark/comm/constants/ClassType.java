package com.irving.mark.comm.constants;

public enum ClassType {
	
	INTEGER("int"),
	LONG("long"),
	
	NOTFOUND("notfound");

	private String type;
	
	private ClassType(String type){
		this.type = type;
	}
	
	public String getType(){
		return type;
	}
	
	public static ClassType typeOf(String type){
		for(ClassType ctype: ClassType.values()){
			if(ctype.getType().equals(type)){
				return ctype;
			}
		}
//		throw new IllegalArgumentException("no such classType, "+type);
		return NOTFOUND;
	}
}
