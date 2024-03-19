package ch03;

/**
 * 
 * 循环顺序队列类(采用设置一个计数器的方法来区分循环队列的判空和判满)
 * 
 */
public class CircleSqQueue2 implements IQueue {
	private Object[] queueElem; // 队列存储空间

	private int front;// 队头的引用，若队列不空，指向队首元素
    private int rear;// 队尾的引用，若队列不空，指向队尾元素的下一个位置
	private int count; // 计数器用来记录队列中的数据元素个数

	// 循环队列类的构造函数
	public CircleSqQueue2(int maxSize) {
		count = 0;
		front =rear= 0;// 队头、队尾初始化为0
		queueElem = new Object[maxSize];// 为队列分配maxSize个存储单元
	}

	// 将一个已经存在的队列置成空
	public void clear() {
		front = rear=0;
		count = 0;

	}

	// 判断队列是否为空
	public boolean isEmpty() {
		return count == 0;
	}

	// 判断队列是否已满
	public boolean isFull() {
		return count == queueElem.length;
	}

	// 求队列中的数据元素个数并由函数返回其值
	public int length() {
		return count;
	}

	// 把指定的元素插入队列
	public void offer(Object x) throws Exception {
		if (isFull())// 队列满
			throw new Exception("队列已满");// 输出异常
		else {// 队列未满
			queueElem[(front + count) % queueElem.length] = x;// x加入队尾
			++count;
		}
	}

	// 查看队列的头而不移除它，返回队列顶对象，如果此队列为空，则返回 null
	public Object peek() {
		if (isEmpty())// 队列为空
			return null;
		else
			return queueElem[front]; // 返回队首元素
	}

	// 移除队列的头并作为此函数的值返回该对象，如果此队列为空，则返回 null
	public Object poll() {
		if (isEmpty())// 队列为空
			return null;
		else {
			Object t = queueElem[front];// 取出队首元素
			front = (front + 1) % queueElem.length;// 更改队首的位置
			--count;
			return t;// 返回队首元素
		}
	}

	// 打印函数，打印所有队列中的元素(队首到队尾)
	public void display() {
		if (!isEmpty()) {
			// 从队首到队尾
			for (int i = front; i != (front + count) % queueElem.length; i = (i + 1)
					% queueElem.length)
				System.out.print(queueElem[i].toString() + " ");
		} else {
			System.out.println("此队列为空");
		}
	}
}
