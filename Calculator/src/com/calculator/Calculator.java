package com.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {

	static String[] input = new String[3];
	public static void main(String args[])
	{
		int counter = 0;
		System.out.println("Welcome to a command line calculator. 2 Numbers and an operand can"
				+ "be entered in any sequence. To end the program type Q or q.");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		do {
			 try {
				input[counter] = reader.readLine();
				if(input[counter] .equals("Q") || input[counter].equals("q"))
				{
					System.out.println("Thank you");
					break;
				}
				if(counter==2)
				{
					counter=-1;
					System.out.println(performOperation(input));
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			counter++; 
			
			
		}while(true);
		
	}
	private static int performOperation(String[] input) {
		int result =0 ;
		char operation = detectOperation(input);
		try {
			if(operation!= ' ')
			{
				int[] operands = detectOperands(input);
				switch(operation) {
					case '+' : return (operands[0]+operands[1]);
					case '-' : return (operands[0]-operands[1]);
					case '*' : return (operands[0]*operands[1]);
					case '/' : return (operands[0]/operands[1]);
				}
			}
			
		}catch(Exception e)
		{
			System.out.println("Exception Occurred "+e.getMessage());
		}
		
		return result;
	}
	private static int[] detectOperands(String[] input) {
		int[] operands = new int[2];
		int counter=0;
		for(int i=0;i<input.length;i++)
		{
			try {
				int num = Integer.parseInt(input[counter]);
				operands[counter++] = num;
				
			}catch(Exception e) {
				counter++;
			}
		}
		return operands;
	}
	private static char detectOperation(String[] input) {
		for(int i=0;i<input.length;i++)
		{
			if(input[i].equals("+") || input[i].equals("-") || input[i].equals("*")|| input[i].equals("/"))
				return input[i].charAt(0);
		}
		return ' ';
			
	}
}
