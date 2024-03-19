package ch03;

import ch02.Node;

/**
 * 
 * 链队列类
 * 
 */

public class LinkQueue implements IQueue {
	private Node front;// 队头的引用

	private Node rear;// 队尾的引用，指向队尾元素

	// 链队列类的构造函数
	public LinkQueue() {
		front = rear = null;
	}

	// 将一个已经存在的队列置成空
	public void clear() {
		front = rear = null;

	}

	// 测试队列是否为空
	public boolean isEmpty() {
		return front == null;
	}

	// 求队列中的数据元素个数并由函数返回其值
	public int length() {
		Node p = front;
		int length = 0;// 队列的长度
		while (p != null) {// 一直查找到队尾
			p = p.next;
			++length;// 长度增1
		}
		return length;
	}

	// 把指定的元素插入队列
	public void offer(Object o) {
		Node p = new Node(o);// 初始化新的结点
		if (front != null) {// 队列非空
			rear.next=p;
			rear = p;// 改变队列尾的位置
		} else
			// 队列为空
			front = rear = p;
	}

	// 查看队列的头而不移除它，返回队列顶对象，如果此队列为空，则返回 null
	public Object peek() {
		if (front != null) // 队列非空
			return front.data;// 返回队列元素
		else
			return null;
	}

	// 移除队列的头并作为此函数的值返回该对象，如果此队列为空，则返回 null
	public Object poll() {
		if (front != null) { // 队列非空
			Node p = front;// p指向队列头结点
			front = front.next;
			if (p==rear)       //被删的结点是队尾结点
				rear=null;
			return p.data;// 返回队列头结点数据
		} else
			return null;
	}

	// 打印函数，打印所有队列中的元素(队列头到队列尾)
	public void display() {
		if (!isEmpty()) {
			Node p = front;
			while (p != rear.next) {// 从对头到队尾
				System.out.print(p.data.toString() + " ");
				p = p.next;
			}
		} else {
			System.out.println("此队列为空");
		}
	}

}
