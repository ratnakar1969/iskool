package com.edu.iskool.util;

public interface TestInterface {
	//Abstract Function
	int calcValue(int x,int y);
	
	//Default Function
	default void getValue()
	{
		System.out.println("Show Value");
	}

}
