package ch02;

import java.util.Scanner;

/**
 * 
 * 多项式类继承于单链表
 * 
 */
public class PolynList extends LinkList {

	// 创建多项式有序链表
	public PolynList(int n) throws Exception {
		head.data=new PolynNode(0, -1); // 初始化头结点中的数据元素
		Scanner sc = new Scanner(System.in);// 构造用于输入的对象
		for (int i = 1; i <= n; i++) {// 输入n个元素的值
			double coef = sc.nextDouble(); // 系数值
			int expn = sc.nextInt(); // 指数值
			insert(new PolynNode(coef, expn));// 插入到有序链表
		}
	}

	// 按指数从小到大的顺序插入到多项式有序链表
	public void insert(PolynNode e) throws Exception {
		int j = 0;
		while (j < length()) {// 与有序链表中的已有项进行指数比较
			PolynNode t = (PolynNode) get(j);
			if (t.expn > e.expn)
				break;
			j++;
		}
		insert(j, e);// 调用父类的插入函数
	}

	// 判定函数，比较多项式中，两项的指数。依a的指数值小于、等于和大于b的指数值，分别返回-1,0和+1
	public int cmp(PolynNode a, PolynNode b) {
		if (a.expn < b.expn)// a、b的指数相比较
			return -1;
		else if (a.expn == b.expn)
			return 0;
		else
			return 1;
	}

	// 多项式加法：Pa = Pa + Pb,利用两个多项式的结点构成的"和多项式"，并返回LA
	public PolynList addPolyn(PolynList LA, PolynList LB) {
		Node ha = LA.head; // ha指向新形成链的尾结点
		Node qa = LA.head.next; // qa指向LA中需要计算的当前项
		Node qb = LB.head.next;// qb指向LB中需要计算的当前项
		while (qa != null && qb != null) { // qa、qb同时非空
			PolynNode a = (PolynNode) qa.data;
			PolynNode b = (PolynNode) qb.data;
			switch (cmp(a, b)) {
			case -1: // 多项式LA中当前结点的指数值小
				ha.next=qa;
				ha = qa;
				qa = qa.next;
				break;
			case 0: // 两者的指数值相等
				double sum = a.coef + b.coef; // 求系数的和
				if (sum != 0.0) { // 修改多项式LA中当前结点的系数值
					a.coef=sum;
					ha.next=qa;
					ha = qa;
					qa = qa.next; // 指向下一结点
					qb = qb.next;
				} else { // 删除多项式LA中的当前项
					qa = qa.next;// 指向下一结点
					qb = qb.next;
				}
				break;
			case 1: // 多项式LB当前结点的指数值小
				ha.next=qb;
				ha = qb;
				qb = qb.next;
				break;
			}
		}
		ha.next=(qa != null ? qa : qb); // 插入剩余结点
		return LA;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入A多项式的项数：");
		int m = sc.nextInt(); // 记录A多项式的项数
		System.out.println("请分别输入多项式A各项的系数和指数：");
		PolynList LA = new PolynList(m);

		System.out.println("请输入B多项式的项数：");
		int n = sc.nextInt();
		System.out.println("请分别输入多项式B各项的系数和指数：");
		PolynList LB = new PolynList(n);// 创建多项式LB

		LA = LA.addPolyn(LA, LB); // 对多项式LA、LB求和，并赋给LA
		System.out.println("求和后的多项式各项为： ");
		LA.display(); // 打印LA中的项
	}

	// 重载父类display()方法
	public void display() {
		for (int i = 0; i < length(); i++) {
			try {
				PolynNode e = (PolynNode) get(i);
				System.out.println("系数为： " + e.coef + " 指数为： "
						+ e.expn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

// 运行结果
// 请输入A多项式的项数：
// 5
// 请分别输入多项式A各项的系数和指数：
// 3 0
// 4 1
// 7 8
// 2 18
// 1 30
// 请输入B多项式的项数：
// 3
// 请分别输入多项式B各项的系数和指数：
// 5 1
// 6 3
// -7 8
// 求和后的多项式各项为：
// 系数为： 3.0 指数为： 0
// 系数为： 9.0 指数为： 1
// 系数为： 6.0 指数为： 3
// 系数为： 2.0 指数为： 18
// 系数为： 1.0 指数为： 30
