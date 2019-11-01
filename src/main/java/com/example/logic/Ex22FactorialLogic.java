package com.example.logic;

import org.springframework.stereotype.Component;

@Component
public class Ex22FactorialLogic {
	
	public int getFactorial(int num) {
		if(num==0) { 
			return 1;
		} 
		
		int answer = 1;
		for (int i = num; i > 0; i--) {
			answer *= i;
		}
		return answer;
	}

}