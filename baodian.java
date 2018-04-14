package com.atguigu.homework;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * 5. 使用输入流读取试题文件，每次显示试题文件中的一道题目。读取到字符“*”时暂停读取，等待用户从键盘输入答案。用户做完全部题目后。程序给出用户的得分。（可以将试题文件先提前复制到某文件，然后再写程序）
1）	试题内容如下：
(1)北京奥运是什么时间开幕的？
   A.2008-08-08  B. 2008-08-01 
C.2008-10-01 D. 2008-07-08
********************
(2)下列哪个国家不属于亚洲？
   A.沙特  B.印度 C.巴西  D.越南
********************
(3)下列哪个国家最爱足球？
   A.刚果  B.越南 C.老挝  D.巴西
********************
(4)下列哪种动物属于猫科动物？
   A.鬣狗  B.犀牛 C.大象 D.狮子
********************

2）程序运行如下：
(1)北京奥运是什么时间开幕的？
   A.2008-08-08  B. 2008-08-01 
C.2008-10-01 D. 2008-07-08
输入选择的答案（A、B、C、D）：A
(2)下列哪个国家不属于亚洲？
   A.沙特  B.印度 C.巴西  D.越南
输入选择的答案（A、B、C、D）：
 *
 */
public class TestInputStream {

	public static void main(String[] args) throws Exception {
		Scanner input  = new Scanner(System.in);
		char[] answers={'A','C','D','D'};
		//1.创建流对象
		BufferedReader br = new BufferedReader(new FileReader("src\\question.txt"));
		//2.读取
		int score = 0;
		String line;
		int count = 0;
		while((line = br.readLine()) != null){
			if(line.contains("***")){//是否以xx开始
				System.out.print("输入选择的答案（A、B、C、D）:");
				char key = input.next().toUpperCase().charAt(0);
				if(answers[count++] == key){
					score += 25;
				}
				continue;
			}
			System.out.println(line);
		}
		//3.关闭
		br.close();
		System.out.println("成绩："+score);
		
	}
	
}
