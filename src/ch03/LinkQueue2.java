package ch03;

import ch02.CircleLinkList;
import ch02.Node;

/**
 * 
 * 链队列类(采用带头结点的循环链表来表示队列)
 * 
 */
public class LinkQueue2 implements IQueue {

	private Node rear;// 队尾的引用，指向队尾元素

	private CircleLinkList cList;

	// 链队列类的构造函数
	public LinkQueue2() {
		cList = new CircleLinkList();
		rear = cList.head;
	}

	// 将一个已经存在的队列置成空
	public void clear() {
		rear = cList.head;

	}

	// 判断队列是否为空
	public boolean isEmpty() {
		return rear.equals(cList.head);
	}

	// 返回队列中的数据元素个数
	public int length() {
		return cList.length();
	}

	// 把指定的元素插入队列
	public void offer(Object o) throws Exception {
		cList.insert(length(), o);
		rear = new Node(cList.get(length() - 1));
	}

	// 查看队列的头而不移除它，返回队列顶对象，如果此队列为空，则返回 null
	public Object peek() {
		if (!isEmpty())
			try {
				return cList.get(0);
			} catch (Exception e) {
				return null;
			}
		else
			return null;
	}

	// 移除队列的头并作为此函数的值返回该对象，如果此队列为空，则返回 null
	public Object poll() {
		if (!isEmpty())
			try {
				Object t = cList.get(0);// 记录移除前的队首元素
				cList.remove(0);
				return t;
			} catch (Exception e) {
				return null;
			}
		else
			return null;
	}

	// 打印函数，打印所有队列中的元素(队列头到队列尾)
	public void display() {
		if (!isEmpty()) {
			cList.display();
		} else {
			System.out.println("此队列为空");
		}
	}
}
