package ch02;

import java.util.Scanner;

/**
 * 【例2.2】编程实现查找线性表（0，1，2，…，n-1）中第i（1≤i≤n-1）个数据元素的直接前驱，并输出其值。要求在顺序表上实现。
 */

public class Example2_2 {
	public static void main(String[] args) throws Exception {
		int n = 10;
		SqList L = new SqList(80); // 构造一个具有80个存储单元的空顺序表
		for (int i = 0; i < n; i++)
			L.insert(i, i);
		System.out.println("请输入i的值：");
		int i = new Scanner(System.in).nextInt();
		if (0 < i && i < n) {
			Object x = L.get(i - 1); // 读取到顺序表中第i个元素的前驱
			System.out.println("第" + i + "个元素的直接前驱是： " + x);
		} else
			System.out.println("第" + i + "个元素的直接前驱不存在!");
	}
}
// 运行结果：
// 请输入i的值：
// 9
// 第9个元素的直接前驱是： 8
