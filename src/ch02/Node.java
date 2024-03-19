package ch02;

/**
 * 
 * 单链表的结点
 * 
 */
public class Node {
	public Object data; // 存放结点值

	public Node next; // 后继结点的引用

	public Node() { // 无参数时的构造函数
		this(null, null);
	}

	public Node(Object data) { // 构造值为data的结点
		this(data, null);
	}

	public Node(Object data, Node next) {
		this.data = data;
		this.next = next;
	}
}
