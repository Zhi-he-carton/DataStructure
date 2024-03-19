package ch02;

/**
 * 
 * 顺序线性表及其基本操作
 * 
 */
public class SqList implements IList {
	private Object[] listElem; // 线性表存储空间

	private int curLen; // 当前长度

	// 顺序表的构造函数，构造一个存储空间容量为maxSize的线性表
	public SqList(int maxSize) {
		curLen = 0; // 置顺序表的当前长度为0
		listElem = new Object[maxSize];// 为顺序表分配maxSize个存储单元
	}

	// 将一个已经存在的线性表置成空表
	public void clear() {
		curLen = 0; // 置顺序表的当前长度为0

	}

	// 判断当前线性表中数据元素个数是否为0,若为0则函数返回true，否则返回false
	public boolean isEmpty() {
		return curLen == 0;
	}
	
	
	// 求线性表中的数据元素个数并由函数返回其值
	public int length() {
		return curLen; // 返回顺序表的当前长度
	}

	// 读取到线性表中的第i个数据元素并由函数返回其值。其中i取值范围为：0≤i≤length()-1,如果i值不在此范围则抛出异常
	public Object get(int i) throws Exception {
		if (i < 0 || i > curLen - 1) // i小于0或者大于表长减1
			throw new Exception("第" + i + "个元素不存在"); // 输出异常

		return listElem[i]; // 返回顺序表中第i个数据元素
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

	// 返回线性表中首次出现指定元素的索引，如果列表不包含此元素，则返回 -1
	public int indexOf(Object x) {
		int j = 0;// j为计数器
		while (j < curLen && !listElem[j].equals(x))
			// 从顺序表中的首结点开始查找，直到listElem[j]指向元素x或到达顺序表的表尾
			j++;
		if (j < curLen)// 判断j的位置是否位于表中
			return j; // 返回x元素在顺序表中的位置
		else
			return -1;// x元素不在顺序表中
	}

	// 输出线性表中的数据元素
	public void display() {
		for (int j = 0; j < curLen; j++)
			System.out.print(listElem[j] + " ");
		System.out.println();// 换行

	}

	// 实现对顺序表就地逆置
	public void reverse() {
		for (int i = 0,j=curLen-1; i < j; i++,j--) {
			Object temp = listElem[i];
			listElem[i] = listElem[j];
			listElem[j] = temp;
		}
	}

	// 实现对顺序表右移k位
	public void shit(int k) {
		int n=curLen,p=0,i,j,l;
        Object temp;
     	for(i=1;i<=k;i++)
          if(n%i==0&&k%i==0) //求n和k的最大公约数p
              p=i;
        for(i=0;i<p;i++){
           j=i;
           l=(i+n-k)%n;
           temp=listElem[i];
           while(l!=i){
             listElem[j]=listElem[l];
             j=l;
             l=(j+n-k)%n;
           }// 循环右移一步
        listElem[j]=temp;
        }
    }

}
