package com.edu.iskool.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ISkoolTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> phones=new ArrayList<String>();
		phones.add("Samsung");
		phones.add("Nokia");
		phones.add("Redmi");
		phones.add("Asus");
		Consumer<String> phone=(p)->{System.out.println(p);};
		phones.forEach(phone);
		callInterface();

	}
	
	public static void callInterface()
	{
		TestInterface sum=(int x,int y)->x+y;
		System.out.println(sum.calcValue(4, 8));
		TestInterface prod=(int x,int y)->x*y;
		System.out.println(prod.calcValue(4, 9));
	}

}
