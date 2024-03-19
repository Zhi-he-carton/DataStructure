package ch02;

/**
 *
 * 实验一 顺序表的基本操作
 *
 */

public class SX1_SqList {
	private Object[] listElem; // 线性表存储空间

	private int curLen; // 当前长度

	// 顺序表的构造函数，构造一个存储空间容量为maxSize的线性表
	public SX1_SqList(int maxSize) {
		curLen = 0; // 置顺序表的当前长度为0
		listElem = new Object[maxSize];// 为顺序表分配maxSize个存储单元
	}

	// 在线性表的第i个数据元素之前插入一个值为x的数据元素。其中i取值范围为：0≤i≤length()。如果i值不在此范围则抛出异常,当i=0时表示在表头插入一个数据元素x,当i=length()时表示在表尾插入一个数据元素x
	public void insert(int i, Object x) throws Exception {
		if (curLen == listElem.length) // 判断顺序表是否已满
			throw new Exception("顺序表已满");// 输出异常

		if (i < 0 || i > curLen) // i小于0或者大于表长
			throw new Exception("插入位置不合理");// 输出异常

		for (int j = curLen; j > i; j--)
			listElem[j] = listElem[j - 1];// 插入位置及之后的元素后移

		listElem[i] = x; // 插入x
		curLen++;// 表长度增1
	}

	// 将线性表中第i个数据元素删除。其中i取值范围为：0≤i≤length()- 1,如果i值不在此范围则抛出异常
	public void remove(int i) throws Exception {
		if (i < 0 || i > curLen - 1) // i小于1或者大于表长减1
			throw new Exception("删除位置不合理");// 输出异常

		for (int j = i; j < curLen - 1; j++)
			listElem[j] = listElem[j + 1];// 被删除元素之后的元素左移

		curLen--; // 表长度减1
	}

	// 输出线性表中的数据元素
	public void display() {
		for (int j = 0; j < curLen; j++)
			System.out.print(listElem[j] + " ");
		System.out.println();// 换行

	}

	public int indexOf(Object i) {
		int j = 0;
		while (j < curLen&&!listElem[j].equals(i))
			j++;
		if (j<curLen)
			return j;
		else
			return -1;//indexOf查找函数
	}

	public Object[] getListElem() {
		return listElem;
	}

	public int getCurLen() {
		return curLen;
	}

	public void setCurLen(int curLen) {
		this.curLen = curLen;
	}
}