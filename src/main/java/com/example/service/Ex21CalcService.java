package com.example.service;

import org.springframework.stereotype.Component;

@Component
public class Ex21CalcService {
	
	public int add(int num1,int num2) {
		return num1+num2;
	}
	
	public int sub(int num1,int num2) {
		return num1-num2;
	}
	
	public int multi(int num1,int num2) {
		return num1*num2;
	}
	
	public int div(int num1,int num2) {
		return num1/num2;
	}

}
