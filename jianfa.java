00000000
package com.atguigu.homework;
/**
 * 1、（字符流+缓冲流）读取一个文本文件，每行都追加一个“好”，在文件结尾再追加“完毕”。
 */
import java.io.*;

public class TestReader {
	public static final String PATHNAME="src\\data.txt";
	public static void main(String[] args) {
		test2();
	}
	
	public static void test2(){
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new FileReader(PATHNAME));
			String line;
			StringBuilder sb = new StringBuilder();
			while((line = br.readLine()) != null){
				sb.append(line+" 好\r\n");
			}
			sb.append("完毕");
			
			bw = new BufferedWriter(new FileWriter(PATHNAME));
			bw.write(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(br != null)
				br.close();
				if(bw != null)
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void test1(){
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src\\data.txt"));
			StringBuilder sb = new StringBuilder();
			String str = null;
			while((str = br.readLine()) != null){
				sb.append(str+" 好\n");
			}
			sb.append("完毕");
			System.out.println(sb.toString());
			
		} catch (IOException e) {
			
		}finally{
			try {
				if(br != null)
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
