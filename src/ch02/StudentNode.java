package ch02;

import java.util.Scanner;

/**
 * 
 * 学生成绩查询系统的结点,作为顺序表的数据元素(listElem[i])
 * 
 */
public class StudentNode {
	public int number; // 学号

	public String name; // 姓名

	public String sex; // 性别

	public double english; // 大学英语成绩

	public double math; // 高等数学成绩

	public StudentNode() { // 无参数时的构造函数
		this(0, null, null, 0.0, 0.0);
	}

	public StudentNode(int number, String name, String sex, double english,
			double math) { // 有参数时的构造函数
		this.number = number;
		this.name = name;
		this.sex = sex;
		this.english = english;
		this.math = math;
	}

	public StudentNode(Scanner sc) {
		this(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble(), sc
				.nextDouble());
	}
	
}
