package ch03;

/**
 * 
 * 优先队列类
 * 
 */
import ch02.Node;

public class PriorityQueue implements IQueue {
	private Node front;// 队头的引用

	private Node rear;// 队尾的引用，指向队尾元素

	// 优先队列类的构造函数
	public PriorityQueue() {
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
		PriorityQData pn = (PriorityQData) o;
		Node s = new Node(pn); // 构造一个新的结点
		if (front == null) // 队列为空
			front = rear = s;// 修改队列头尾结点
		else {
			Node p = front, q = front;
			while (p != null
					&& pn.priority>= ((PriorityQData) p.data)
							.priority) {// 新结点的值与队列结点中的元素的值相比较
				q = p;
				p = p.next;
			}
			if (p == null) {// p为空，表示遍历到了队列尾部
				rear.next=s;// 在队列中加入新结点
				rear = s;// 修改队尾指针
			} else if (p == front) {// p的优先级大于头结点的优先级
				s.next=front;
				front = s;// 修改头结点的值
			} else {// 新结点加入队列中部
				q.next=s;
				s.next=p;
			}

		}
	}

	// 查看队列的头而不移除它，返回队列顶对象，如果此队列为空，则返回 null
	public Object peek() {
		if (front == null)// 队列为空
			return null;
		else
			// 返回队列头结点的值
			return front.data;
	}

	// 移除队列的头并作为此函数的值返回该对象，如果此队列为空，则返回 null
	public Object poll() {
		if (front == null)// 队列为空
			return null;
		else {// 返回队列头结点的值，并修改队列头指针
			Node p = front;
			front = p.next;
			return p.data;
		}
	}

	// 打印函数，打印所有队列中的元素(队列头到队列尾)
	public void display() {
		if (!isEmpty()) {
			Node p = front;
			while (p != rear.next) {// 从对头到队尾
				PriorityQData q = (PriorityQData) p.data;
				System.out.println(q.elem + "      " + q.priority);// 打印
				p = p.next;
			}
		} else {
			System.out.println("此队列为空");// 打印
		}
	}

}
