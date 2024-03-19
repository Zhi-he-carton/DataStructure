package ch02;

/**
 * 
 * 双向链表的结点
 * 
 */
public class DuLNode {
	public Object data;// 存放结点值

	public DuLNode prior; // 前驱结点的引用

	public DuLNode next; // 后继结点的引用

	public DuLNode() {// 无参数时的构造函数
		this(null);
	}

	public DuLNode(Object data) {// 构造值为data的结点
		this.data = data;
		this.prior = null;
		this.next = null;
	}

}
