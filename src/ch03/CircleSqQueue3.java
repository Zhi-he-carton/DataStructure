package ch03;

/**
 * 
 * 循环顺序队列类(采用设置一个标志位的方法来区分循环队列的判空和判满)
 * 
 */
public class CircleSqQueue3 implements IQueue {
	private Object[] queueElem; // 队列存储空间

	private int front;// 队头的引用，若队列不空，指向队首元素
    private int rear;// 队尾的引用，若队列不空，指向队尾元素的下一个位置
    private int flag; // 队列判空与判满的标志量,当入列操作后其值置为1,出队操作后其值置为0

	// 循环队列类的构造函数
	public CircleSqQueue3(int maxSize) {
		queueElem = new Object[maxSize];// 为队列分配maxSize个存储单元
		front =rear= 0;// 队头、队尾初始化为0
        flag = 0;
		
	}

	// 将一个已经存在的队列置成空
	public void clear() {
		front = rear=0;
		flag = 0;

	}

	// 判断队列是否为空
	public boolean isEmpty() {
		return front==rear&&flag==0;
	}

	// 判断队列是否已满
	public boolean isFull() {
		return front==rear&&flag==1;
	}

	// 求队列中的数据元素个数并由函数返回其值
	public int length() {
		return (rear-front+queueElem.length)%queueElem.length;
	}

	// 把指定的元素x插入队列
	public void offer(Object x) throws Exception {
		if (isFull())// 队列满
			throw new Exception("队列已满");// 输出异常
		else {// 队列未满
			queueElem[rear] = x;// x赋给队尾元素
			rear = (rear + 1) % queueElem.length;// 修改队尾指针
            flag=1;  //修改标志位值
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
			flag=0; //修改标志位值
			return t;// 返回队首元素
		}
	}

	// 打印函数，打印所有队列中的元素(队首到队尾)
	public void display() {
		if (!isEmpty()) {
			// 从队首到队尾
            int i = front;
			do {
				System.out.print(queueElem[i].toString() + " ");
                i = (i + 1)% queueElem.length;}
            while(i!=rear);
		}
        else {
			System.out.println("此队列为空");
		}
	}
public static void main(String[] args) throws Exception {
		CircleSqQueue3 Q = new CircleSqQueue3(100);
		for (int i = 1; i <= 10; i++)
			// 初始化队列中的元素，其中元素个数为10
			Q.offer(i);
		System.out.println("队列中各元素为(队首到队尾)： ");
		Q.display();// 打印队列中元素（队首到队尾）
		System.out.println();
		if (!Q.isEmpty())// 队列非空，输出
			System.out.println("队列非空！");

		System.out.println("队列的长度为： " + Q.length());// 输出队列的长度
		System.out.println("队首元素为： " + Q.peek().toString());// 输出队首元素

		System.out.println("去除队首元素后，队列中各元素为(队首到队尾)：  ");
		Q.poll();// 删除元素
		Q.display();// 打印队列中元素
		System.out.println();

		System.out.println("去除队列中剩余的所有元素！ 进行中。。。"); // 输出
		Q.clear(); // 清除队列中的元素

		if (Q.isEmpty())// 队列空，输出
			System.out.println("队列已清空!");
	}
}

//测试运行结果:

//队列中各元素为(队首到队尾)：
//1 2 3 4 5 6 7 8 9 10
//队列非空！
//队列的长度为： 10
//队首元素为： 1
//去除队首元素后，队列中各元素为(队首到队尾)：
//2 3 4 5 6 7 8 9 10
//去除队列中剩余的所有元素！ 进行中。。。
//队列已清空!

