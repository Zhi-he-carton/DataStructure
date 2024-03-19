package ch02;

/**
 * 
 * （1）建立一个顺序表，然后查找顺序表中第一个出现的值为z的数据元素，并输出其在表中的位置。
 * 
 */
public class Example2_1 {
	public static void main(String[] args) throws Exception {
		SqList L = new SqList(10); // 构造一个10个存储空间的顺序表
		L.insert(0, 'a'); // 初始化数序表中的前5个元素
		L.insert(1, 'z');
		L.insert(2, 'd');
		L.insert(3, 'm');
		L.insert(4, 'z');

		// 在顺序表中查找值为z的元素，如果找到，则函数返回该元素在顺序中的第次出现的位置，否则返回-1
		int order = L.indexOf('z');
		if (order != -1) // 顺序表中是否包含值为'z'的元素
			System.out.println("顺序表中第一次出现的值为'z'的数据元素的位置为：" + order);
		else
			System.out.println("此顺序表中不包含值为'z'的数据元素！");
	}
}

// 运行结果如下：
// 顺序表中第一次出现的值为'z'的数据元素的位置为：1

