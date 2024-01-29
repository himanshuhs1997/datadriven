package DataDrivanExample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class fileWriteandReadexample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//FileWriter  ------text form
/*		
	FileWriter fw = new FileWriter("e://hello.txt");
	BufferedWriter bw = new BufferedWriter(fw);
	bw.write("hello world");
	bw.close();
	fw.close();
	*/
		
	 // FileReader
		/*
		FileReader fr = new FileReader("e://hello.txt");
		BufferedReader br= new BufferedReader(fr);
		String s="", s1="";
		while((s=br.readLine())!=null){
			s1=s1+s;
		}
		System.out.println(s1);
		br.close();
		fr.close();
		*/
		
//============================================================================
		// FileWriter ---- binary form
		
	/*	FileOutputStream fo = new FileOutputStream("e://hello1.txt");
		String s= "hello wold";
		byte arr[]= s.getBytes();
		fo.write(arr);
		fo.close();
		*/
		
		// FileReader------- binary
	
		/*
		FileInputStream fi = new FileInputStream("e://hello1.txt");
		byte arr[] = new byte[10];
		while(fi.read(arr)!=-1) {
			String s= new String(arr);
			System.out.println(s);
		}
		fi.close();
		*/
	}

}
