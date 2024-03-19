package ch03;

import ch02.Node;

/**
 * 
 * 在单链表上实现的栈及其基本操作
 * 
 */
public class LinkStack implements IStack {

	private Node top; // 栈顶元素的引用

	// 将一个已经存在的栈置成空
	public void clear() {
		top = null;
	}

	// 测试栈是否为空
	public boolean isEmpty() {
		return top == null;
	}

	// 求栈中的数据元素个数并由函数返回其值
	public int length() {
		Node p = top;// 初始化,p指向栈顶结点,length为计数器
		int length = 0;
		while (p != null) {// 从栈顶结点向后查找，直到p指向栈顶结点
			p = p.next;// 指向后继结点
			++length;// 长度增1
		}
		return length;
	}

	// 查看栈顶对象而不移除它，返回栈顶对象
	public Object peek() {
		if (!isEmpty())
			return top.data;// 返回栈顶元素
		else
			return null;
	}

	// 移除栈顶对象并作为此函数的值返回该对象
	public Object pop() {
		if (!isEmpty()) {
			Node p = top;// p指向栈顶结点
			top = top.next;
			return p.data;
		} else
			return null;
	}

	// 把项压入栈顶
	public void push(Object x) {
		Node p = new Node(x); // 构造一个新的结点
		p.next=top;
		top = p;// 改变栈顶结点
	}

	// 打印函数，打印所有栈中的元素(栈顶到栈底)
	public void display() {
		Node p = top; // p指向栈顶结点，q指向p的下一结点
		while (p != null) {// 打印所有非空的结点
			System.out.print((p.data.toString() + " ")); // 打印
			p = p.next;// 指向p下一元素
		}
	}
}
