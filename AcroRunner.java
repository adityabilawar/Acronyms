package Acronyms;

import java.io.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class AcroRunner
{
	public static void main( String args[] ) throws IOException
	{
		/*
		 * Part A
		 */
//		Acronyms a = new Acronyms();
//		FileReader file = new FileReader(new File("H:\\workspace2021\\Maps\\src\\Acronyms\\acro.dat"));
//		BufferedReader br = new BufferedReader(file);
//		int num = Integer.parseInt(br.readLine());
//		for(int i =0; i < num; i++) {
//			a.putEntry(br.readLine());
//		}
//		System.out.println("====\tMAP CONTENTS\t====\n");
//		System.out.println(a);
//		br.readLine();
//		String convert = "";
//		for(int i =0; i < 3; i++) {
//			convert+=br.readLine() + "\n";
//		}
//		System.out.println("\n\n====\tREAD LINES\t====\n");
//		System.out.println(a.convert(convert));
		
		/*
		 * Part B
		 */
		Acronyms b = new Acronyms();
		FileReader file1 = new FileReader(new File("acro4.dat"));
		BufferedReader br1 = new BufferedReader(file1);
		int num1 = Integer.parseInt(br1.readLine());
		for(int i =0; i < num1; i++) {
			b.putEntry(br1.readLine());
		}
		System.out.println("====\tMAP CONTENTS\t====\n");
		System.out.println(b);
		//br1.readLine();
		String convert1 = "";
//		for(int i =0; i < 10; i++) {
//			convert1+=br1.readLine() + " ";
//		}
		while(br1.ready()) {
			convert1+=br1.readLine() + " ";
			//System.out.println(convert1);
		}
		System.out.println("\n\n====\tENCODING ACRONYMS\t====\n");
		System.out.println(b.encode(convert1));
	}
}