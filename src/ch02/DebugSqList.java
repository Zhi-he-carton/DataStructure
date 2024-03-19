package ch02;

/**
 * 
 * 对顺序线性表及其基本操作进行调试
 * 
 */
public class DebugSqList {
	public static void main(String[] args) throws Exception {
		// --------调用构造函数--------
		SqList L = new SqList(10); // 构造一个10个存储空间的顺序表

		// --------调用 insert(int i, Object x)插入数据元素--------
		for (int i = 0; i <= 8; i++) // 对该顺序表的前9个元素进行赋值，分别为0、1、2...8
			L.insert(i, i);

		// --------调用length()求顺序表的长度--------
		System.out.println("顺序表的长度:" + L.length());// 输出顺序表的长度

		// --------调用get(int i)取出第i个元素--------
		System.out.println("顺序表中各个数据元素:");// 输出
		L.display();
		
		// --------调用indexOf(Object x)查找x元素所在的位置--------
		int order = L.indexOf(8);// 求出数据元素8在顺序表中的位置
		if (order != -1)
			System.out.println("顺序表中值为8的数据元素的位置为：" + order);// 输出
		else
			System.out.println("8不在此单链表中");

		// --------调用remove(int i)删除数据元素表--------
		L.remove(4);// 删除第5个数据元素
		System.out.println("顺序表中删除第4个数据元素后，表的长度：" + L.length());// 输出
		System.out.println("顺序表中删除第4个数据元素后，剩余的数据元素：");// 输出
		L.display();

		// --------调用insert(int i, Object x)把数据元素x插入到i的位置--------
		L.insert(5, 5);
		System.out.println("顺序表中在5的位置前插入数据元素5后，表的长度：" + L.length());
		System.out.println("顺序表中在5的位置前插入数据元素5后，表中的数据元素：");
		L.display();

		
		// --------调用L.clear()将顺序表置空--------
		L.clear();
		System.out.println("将顺序表置空后，再次打印表中的元素：");
		L.display();

		// --------调用isEmpty()判断顺序表是否为空--------
		if (L.isEmpty())
			System.out.println("顺序表为空");
		else
			System.out.println("顺序表不为空");

	}
}

// 运行结果如下：
//顺序表的长度:9
//顺序表中各个数据元素:
//0 1 2 3 4 5 6 7 8 
//顺序表中值为8的数据元素的位置为：8
//顺序表中删除第4个数据元素后，表的长度：8
//顺序表中删除第4个数据元素后，剩余的数据元素：
//0 1 2 3 5 6 7 8 
//顺序表中在5的位置前插入数据元素5后，表的长度：9
//顺序表中在5的位置前插入数据元素5后，表中的数据元素：
//0 1 2 3 5 5 6 7 8 
//将顺序表置空后，再次打印表中的元素：
//
//顺序表为空
