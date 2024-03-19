package ch02;

/**
 * 
 * 学生成绩查询系统继承于顺序表,包含了查找、删除、插入以及创建学生管理系统，输出系统中学生信息的功能
 * 
 */

import java.util.Scanner;

public class StudentManagSystem extends SqList {

	// 按顺序构造顺序表，其中参数maxSize指的是顺序表的最大存储空间容量
	public StudentManagSystem(int maxSize, int n) throws Exception {
		super(maxSize);
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= n; i++) {// 创建n个顺序表结点
			StudentNode node = new StudentNode(sc); // 创建顺序表中的结点
			if (node != null)
				insert(node); // 插入到顺序表的表尾
			else
				i--; // 如果创建结点不成功，则不计数
		}
	}

	// 覆盖父类的get方法，从顺序表中取出指定学号的学生信息，并返回一个StudentNode对象
	public StudentNode get(int number) throws Exception {
		for (int i = 0; i < length(); i++) { // 遍历整个顺序表
			StudentNode node = (StudentNode) super.get(i);// 调用父类的get方法
			if (node.number == number)
				return node;// 包含指定的学号，返回该学生的信息
		}
		throw new Exception("学号" + number + "不存在");// 拋出异常
	}

	// 重载了父类insert方法在顺序表的表尾插入一个学生信息
	public void insert(StudentNode node) throws Exception {
		super.insert(this.length(), node); // 调用父类的insert方法
	}

	// 覆盖父类的remove方法
	public void remove(int number) throws Exception {
		for (int i = 0; i < length(); i++) {// 遍历整个顺序表
			StudentNode node = (StudentNode) super.get(i);// 取出第i项
			if (node.number == number) {
				super.remove(i);// 去除第i项
				return;
			}
		}
		throw new Exception("学号" + number + "不存在");// 拋出异常
	}

	// 重载父类display()方法，输出顺序表中的学生信息
	public void display() {
		for (int i = 0; i < length(); i++) {// 遍历顺序表
			try {
				StudentNode node = (StudentNode) super.get(i);
				displayNode(node);
			} catch (Exception e) {}
		}
	}

	// 打印单个结点的信息
	public void displayNode(StudentNode node) {
		System.out.println("学号： " + node.number + " 姓名：" + node.name
				+ " 性别： " + node.sex + " 大学英语成绩：" + node.english
				+ " 高等数学成绩： " + node.math);
	}

	// 主函数，用于功能调试
	public static void main(String[] args) throws Exception {
		int maxSize = 1000;// 设定最大存储空间容量
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入学生的总数： ");
		int n = sc.nextInt();
		System.out.println("请按学号、姓名、性别、大学英语和高等数学的顺序输入学生信息： ");
		StudentManagSystem L = new StudentManagSystem(maxSize, n);// 新建顺序表
		L.display();

		System.out.println("请输入需要查询学生的学号： ");
		L.displayNode(L.get(sc.nextInt())); // 取出成功，则输出该学生的信息

		System.out.println("请输入需要删除学生的学号： "); // 输出
		L.remove(sc.nextInt());// 删除指定学号的项
		System.out.println("删除成功！");
		L.display();

		System.out.println("请输入需要增加的学生信息:"); // 输出
		L.insert(new StudentNode(sc)); // 在顺序表插入指定的项
		L.display(); // 输出
	}
}

// 运行结果
// 请输入学生的总数：
// 6
// 请按学号、姓名、性别、大学英语和高等数学的顺序输入学生信息：
// 2008001 Alan F 93 88
// 2008002 Danie M 75 69
// 2008003 Helen M 56 77
// 2008004 Bill F 87 90
// 2008005 Peter M 79 86
// 2008006 Amy F 68 75
// 学号： 2008001 姓名：Alan 性别： F 大学英语成绩：93.0 高等数学成绩： 88.0
// 学号： 2008002 姓名：Danie 性别： M 大学英语成绩：75.0 高等数学成绩： 69.0
// 学号： 2008003 姓名：Helen 性别： M 大学英语成绩：56.0 高等数学成绩： 77.0
// 学号： 2008004 姓名：Bill 性别： F 大学英语成绩：87.0 高等数学成绩： 90.0
// 学号： 2008005 姓名：Peter 性别： M 大学英语成绩：79.0 高等数学成绩： 86.0
// 学号： 2008006 姓名：Amy 性别： F 大学英语成绩：68.0 高等数学成绩： 75.0
// 请输入需要查询学生的学号：
// 2008004
// 学号： 2008004 姓名：Bill 性别： F 大学英语成绩：87.0 高等数学成绩： 90.0
// 请输入需要删除学生的学号：
// 2008006
// 删除成功！
// 学号： 2008001 姓名：Alan 性别： F 大学英语成绩：93.0 高等数学成绩： 88.0
// 学号： 2008002 姓名：Danie 性别： M 大学英语成绩：75.0 高等数学成绩： 69.0
// 学号： 2008003 姓名：Helen 性别： M 大学英语成绩：56.0 高等数学成绩： 77.0
// 学号： 2008004 姓名：Bill 性别： F 大学英语成绩：87.0 高等数学成绩： 90.0
// 学号： 2008005 姓名：Peter 性别： M 大学英语成绩：79.0 高等数学成绩： 86.0
// 请输入需要增加的学生信息:
// 2008006 Amy F 68 75
// 学号： 2008001 姓名：Alan 性别： F 大学英语成绩：93.0 高等数学成绩： 88.0
// 学号： 2008002 姓名：Danie 性别： M 大学英语成绩：75.0 高等数学成绩： 69.0
// 学号： 2008003 姓名：Helen 性别： M 大学英语成绩：56.0 高等数学成绩： 77.0
// 学号： 2008004 姓名：Bill 性别： F 大学英语成绩：87.0 高等数学成绩： 90.0
// 学号： 2008005 姓名：Peter 性别： M 大学英语成绩：79.0 高等数学成绩： 86.0
// 学号： 2008006 姓名：Amy 性别： F 大学英语成绩：68.0 高等数学成绩： 75.0

