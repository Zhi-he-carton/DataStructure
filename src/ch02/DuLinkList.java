package ch02;

import java.util.Scanner;

/**
 * 
 * 双向循环链表及其基本操作
 * 
 */
public class DuLinkList implements IList {
	public DuLNode head;// 双向循环链表的头结点

	// 双向链表的构造函数
	public DuLinkList() {
		head = new DuLNode(); // 初始化头结点
		head.prior=head;// 初始化头结点的前驱和后继
		head.next=head;
	}

	// 从表尾到表头逆向建立双向链表的算法。其中n为该双向链表的元素个数
	public DuLinkList(int n) throws Exception {
		this();
		Scanner sc = new Scanner(System.in);// 构造用于输入的对象
		for (int j = 0; j < n; j++)
			insert(0, sc.next());// 生成新结点,插入到表头
	}

	// 在双向循环链表的第i个数据元素之前插入一个值为x的数据元素，i等于表长时，p指向头结点；i大于表长时，p=NULL。
	// 其中i取值范围为：0≤i≤length()。当i=0时表示在表头插入一个数据元素x,当i=length()时表示在表尾插入一个数据元素x
	public void insert(int i, Object x) throws Exception {
		DuLNode p = head.next;// 初始化,p指向首结点,j为计数器
		int j = 0;
		while (!p.equals(head) && j < i) {// 寻找插入位置i
			p = p.next;// 指向后继结点
			++j;// 计数器的值增1
		}

		if (j != i && !p.equals(head)) // i小于0或者大于表长
			throw new Exception("插入位置不合理");// 输出异常

		DuLNode s = new DuLNode(x);// 生成新结点
		p.prior.next=s;
		s.prior=p.prior;
		s.next=p;
		p.prior=s;
	}

	// 将双向循环链表中第i个数据元素删除。其中i 取值范围为：0≤i≤ength()-1
	public void remove(int i) throws Exception {
		DuLNode p = head.next;// 初始化,p指向首节点结点,j为计数器
		int j = 0;
		while (!p.equals(head) && j < i) {// 寻找删除位置i
			p = p.next;// 指向后继结点
			++j;// 计数器的值增1
		}

		if (j != i) // i小于0或者大于表长减1
			throw new Exception("删除位置不合理");// 输出异常

		p.prior.next=p.next;
		p.next.prior=p.prior;
	}

	// 将一个已经存在的双向循环链表置成空表
	public void clear() {
		head.prior=head;
		head.next=head;
	}

	// 判断当前双向循环链表是否为空
	public boolean isEmpty() {
		return head.equals(head.next);
	}

	// 读取双向循环链表中的第i个数据元素
	public Object get(int i) throws Exception {
		DuLNode p = head.next;// 初始化,p指向首结点,j为计数器
		int j = 0;
		while (!p.equals(head) && j < i) {// 从首结点向后查找，直到p指向第i个元素或p指向头结点
			p = p.next;// 指向后继结点
			++j;// 计数器的值增1
		}
		if (j > i || p.equals(head)) { // i小于0或者大于表长减1
			throw new Exception("第" + i + "个元素不存在");// 输出异常
		}
		return p.data;// 返回元素p
	}

	// 求双向循环链表中的数据元素个数并由函数返回其值
	public int length() {
		DuLNode p = head.next;// 初始化,p指向首结点,length为计数器
		int length = 0;
		while (!p.equals(head)) {// 从首结点向后查找，直到p指向头结点
			p = p.next;// 指向后继结点
			++length;// 长度增1
		}
		return length;
	}

	// 在双向循环链表中查找值为x的元素，如果找到，则函数返回该元素在线性表中的位置，否则返回-1
	public int indexOf(Object x) {
		DuLNode p = head.next;// 初始化,p指向首结点,j为计数器
		int j = 0;
		while (!p.equals(head) && !p.data.equals(x)) {// 从链表中的首结点元素开始查找，直到p.data指向元素x或到达链表的表尾
			p = p.next;// 指向下一个元素
			++j;// 计数器的值增1
		}
		if (!p.equals(head))// 如果p指向表中的某一元素
			return j;// 返回x元素在顺序表中的位置
		else
			return -1;// x元素不在顺序表中
	}

	public void display() {
		DuLNode node = head.next;// 取出带头结点的双向链表中的首结点
		while (!node.equals(head)) {
			System.out.print(node.data + " ");// 输出数据元素的值
			node = node.next;
		}
		System.out.println();
	}

	public DuLNode getHead() {
		return head;
	}

	public void setHead(DuLNode head) {
		this.head = head;
	}

}
