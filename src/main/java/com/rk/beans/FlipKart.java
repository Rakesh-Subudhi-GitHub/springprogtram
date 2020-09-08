package com.rk.beans;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class FlipKart {
	
	//property
	private Courier courier;
	
	public FlipKart() {

		System.out.println("Flipkart 0 param cons");
	}
	
	@Autowired
	//@Qualifier("dtdc")
	@Qualifier("bDart")
	//by method called
	public void assign(Courier courier)
	{
		System.out.println("by calling method asigined(-)");
		this.courier=courier;
		
	}
	//b.method
	public String shopping(String[]items,float[]price)
	{
		
		System.out.println("FlipKart.shopping()");
		
		float billamt=0.0f;
		int oid=0;
		String msg=null;
		
		//calculate bill amt
		for(float p:price)
		{
			billamt=billamt+p;
		}//for
		
		//generet order id randomly
		oid=new Random().nextInt(1000);
		
		//use courier id for delivering the product
		msg=courier.deliver(oid);
		
		//return courier details or order id return
		return Arrays.toString(items)+"are purchaes having prices "+Arrays.toString(price)+"bill amt is "+billamt+"---"+msg;
	
	}//method
}
