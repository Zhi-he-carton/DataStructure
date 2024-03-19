package ch02;


/**
 * 
 * 不带头结点的单链表及其基本操作
 * 
 */
public class LinkList2 implements IList {

	public Node head;// 单链表的首结点指针

	// 构造函数
	public LinkList2() {
		head = null;
	}

	// 将一个已经存在的单链表置成空表
	public void clear() {
		head = null;
	}

	// 判断当前单链表是否为空
	public boolean isEmpty() {
		return head == null;
	}

	// 求单链表中的数据元素个数并由函数返回其值
	public int length() {
		Node p = head;// 初始化,p指向首结点,length为计数器
		int length = 0;
		while (p != null) {// 从首结点向后查找，直到p为空
			p = p.next;// 指向后继结点
			++length;// 长度增1
		}
		return length;
	}

	// 读取单链表中的第i个数据元素
	public Object get(int i) throws Exception {
		Node p = head;// 初始化,p指向首结点,j为计数器
		int j = 0;
		while (p != null && j < i) {// 从首结点向后查找，直到p指向第i个元素或p为空
			p = p.next;// 指向后继结点
			++j;// 计数器的值增1
		}
		if (j > i || p == null) // i小于0或者大于表长减1
			throw new Exception("第" + i + "个元素不存在");// 输出异常

		return p.data;// 返回元素p
	}

	// 在单链表中第i个数据元素之前插入一个值为x的数据元素
	public void insert(int i, Object x) throws Exception {
		Node s = new Node(x);
		if (i == 0) { // 插入位置为表头
			s.next=head;
			head = s;
			return;
		}

		Node p = head;
		int j = 0;// 第i个结点前驱的位置
		while (p != null && j < i - 1) {// 寻找i个结点的前驱
			p = p.next;
			++j;
		}
		if (j > i - 1 || p == null)
			throw new Exception("插入位置不合理");

		// 插入位置为表的中间或表尾
		s.next=p.next;
		p.next=s;
	}

	// 将线性表中第i个数据元素删除。其中i取值范围为：0≤i≤length()- 1,如果i值不在此范围则抛出异常
	public void remove(int i) throws Exception {
		Node p = head;// 初始化p为首结点,j为计数器
		Node q = null; // 用来记录p的前驱结点
		int j = 0;
		while (p != null && j < i) {// 寻找i个结点
			q = p;
			p = p.next;
			++j;// 计数器的值增1
		}
		if (j > i || p == null) // i小于0或者大于表长减1
			throw new Exception("删除位置不合理");// 输出异常

		if (q == null)
			head = null;// 删除首结点
		else
			q.next=p.next;// 删除其他结点
	}

	// 实现删除单链表中数据域值等于x的第一个结点的操作。若删除成功，则返回被删除结点的位置；否则，返回-1。
	public int remove(Object x) {
		Node p = head;// 初始化,p指向首结点
		Node q=null;  //q用来记录p的前驱结点
        int j = 0; //j为计数器
		while (p != null && !p.data.equals(x)) {// 从单链表中的首结点元素开始查找，直到p.data指向元素x或到达单链表的表尾
			 q=p;
             p = p.next;// 指向下一个元素
			 ++j;// 计数器的值增1
		 }
		if (p!=null&&q==null) //删除的是单链表中的首结点
             head=p.next;
        else if (p != null) {// 删除的是单链表中的非首结点
			   q.next=p.next;
		     }
        else
			 return -1;//值为x的结点在单链表中不存在
	    return j;
    }


	// 在不带头结点的单链表中查找值为x的元素，如果找到，则函数返回该元素在线性表中的位置，否则返回-1
	public int indexOf(Object x) {
		Node p = head;// 初始化,p指向首结点,j为计数器
		int j = 0;
		while (p != null && !p.data.equals(x)) {// 从单链表中的首结点元素开始查找，直到p.data指向元素x或到达单链表的表尾
			p = p.next;// 指向下一个元素
			++j;// 计数器的值增1
		}
		if (p != null)// 如果p指向表中的某一元素
			return j;// 返回x元素在顺序表中的位置
		else
			return -1;// x元素不在顺序表中
	}

	// 输出线性表中的数据元素
	public void display() {
		Node node = head;// 取出带头结点的单链表中的首结点元素
		while (node != null) {
			System.out.print(node.data + " ");// 输出数据元素的值
			node = node.next;// 取下一个结点
		}
		System.out.println();// 换行
	}

}
