package ch02;

/**
 * 
 * （3）将两个有序的单链表LＡ（有m个元素）和LＢ（有n个元素）其元素均以从小到大的升序排列，合并成一个有序单链表LA
 * 
 */

import java.util.Scanner;

public class Example2_5 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);// 构造用于输入的对象
		int m = 0, n = 0;// 初始化LA的元素个数m，LB中的元素个数n
		System.out.println("请输入LA中结点的个数：");
		m = sc.nextInt();
		System.out.println("请按非递减的方式输入" + m + "个数字：");
		LinkList LA = new LinkList(m, true);// 用尾插法顺序建立单链表

		System.out.println("请输入LB中结点的个数：");
		n = sc.nextInt();
		System.out.println("请按非递减的方式输入" + n + "个数字：");
		LinkList LB = new LinkList(n, true);// 用尾插法顺序建立单链表

		System.out.println("将单链表LA和LB归并后，新的单链表LA中的各个结点为：");// 输出
		mergeList_L(LA, LB).display();
	}

	// 归并两个按值非递减排列的带头结点的单链线性表LA和LB，得到新的带头结点单链表LA，LA元素也按值非递减排列，并返回LA
	public static LinkList mergeList_L(LinkList LA, LinkList LB) {
		Node pa = LA.head.next;// 初始化，pa为LA的首结点
		Node pb = LB.head.next;// 初始化，pb为LB的首结点
		Node pc = LA.head;// 用LA的头结点，初始化pc
		int da, db;// 元素值所对应的浮点数
		while (pa != null && pb != null) {// pa和pb同时非空
			da = Integer.valueOf(pa.data.toString());// 把字符串转化成浮点数
			db = Integer.valueOf(pb.data.toString());// 把字符串转化成浮点数
			if (da <= db) {
				pc.next=pa;// 将LA中的结点加入到新的LA中
				pc = pa;
				pa = pa.next;
			} else {
				pc.next=pb;// 将LB中的结点加入到新的LA中
				pc = pb;
				pb = pb.next;
			}
		}
		pc.next=(pa != null ? pa : pb); // 插入剩余结点
		return LA;
	}
}

// 运行结果如下：
// 请输入LA中的元素的个数：
// 4
// 请按非递减的方式输入4个数字：
// 6 10 11 12
// 请输入LB中的元素的个数：
// 5
// 请按非递减的方式输入5个数字：
// 3 5 12 34 45
// 将单链表LA和LB归并后，新的单链表LA中的各个数据元素：
// 3 5 6 10 11 12 12 34 45
