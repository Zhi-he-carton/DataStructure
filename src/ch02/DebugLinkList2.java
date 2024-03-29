package ch02;


/**
 * 
 * 对不带头结点单链表及其基本操作进行调试
 * 
 */
public class DebugLinkList2 {
	public static void main(String[] args) throws Exception {
		// --------初始化单链表中各个元素--------
		LinkList2 L = new LinkList2();
		for (int i = 0; i <= 8; i++)
			L.insert(i, i);
		System.out.println("单链表中各个数据元素：");
		L.display(); // 输出单链表中所有的数据元素

		// --------调用length()求顺序表的长度--------
		System.out.println("单链表的长度:" + L.length());// 输出顺序表的长度

		// --------调用get(int i)取出第i个元素--------
		if (L.get(2) != null)// 取第二个元素
			System.out.println("单链表中第2个元素:" + L.get(2));

		// --------调用indexOf(Object x)查找x元素所在的位置--------
		int order = L.indexOf("c");// 求出数据元素字符串c在顺序表中的位置
		if (order != -1)
			System.out.println("单链表中值为字符串c的数据元素的位置为：" + order);// 输出数据元素c的位置
		else
			System.out.println("字符'c'不在此单链表中");

		// --------调用remove(int i)删除数据元素--------
		L.remove(2); // 删除第二个数据元素
		System.out.println("删除第二个数据元素后单链表中各个数据元素：");
		L.display();

		// --------调用 insert(int i, Object x)插入数据元素--------
		L.insert(2, 'd');// 在单链表的第三个位置插入数据元素d
		System.out.println("在2的位置插入数据元素d后单链表中各个数据元素：");
		L.display(); // 输出单链表中所有的数据元素

		// --------调用L.clear()将顺序表置空--------
		L.clear();
		System.out.println("将单链表置空后，再次打印表中的元素:");

		// --------调用isEmpty()判断顺序表是否为空--------
		if (L.isEmpty())
			System.out.println("单链表为空");
		else {
			System.out.println("单链表不为空,单链表中各个数据元素：");
			L.display();
		}
	}

}

// 调试结果：
// 单链表中各个数据元素：
// 0 1 2 3 4 5 6 7 8
// 单链表的长度:9
// 单链表中第2个元素:2
// 字符'c'不在此单链表中
// 删除第二个数据元素后单链表中各个数据元素：
// 0 1 3 4 5 6 7 8
// 在2的位置插入数据元素d后单链表中各个数据元素：
// 0 1 d 3 4 5 6 7 8
// 将单链表置空后，再次打印表中的元素:
// 单链表为空
