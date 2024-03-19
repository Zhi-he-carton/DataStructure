package ch03;

/**
 * 
 * 在顺序表上实现的栈及其基本操作
 * 
 */
public class SqStack implements IStack {

	private Object[] stackElem; // 栈存储空间

	private int top; // 非空栈中始终表示栈顶元素的下一个位置，当栈为空时其值为0

	// 栈的构造函数，构造一个存储空间容量为maxSize的栈
	public SqStack(int maxSize) {
		top = 0; // 初始化top为0
		stackElem = new Object[maxSize];// 为栈分配maxSize个存储单元
	}

	// 将一个已经存在的栈置成空
	public void clear() {
		top = 0;
	}

	// 测试栈是否为空
	public boolean isEmpty() {
		return top == 0;
	}

	// 求栈中的数据元素个数并由函数返回其值
	public int length() {
		return top;
	}

	// 查看栈顶对象而不移除它，返回栈顶对象
	public Object peek() {
		if (!isEmpty())// 栈非空
			return stackElem[top - 1]; // 栈顶元素
		else
			// 栈为空
			return null;
	}

	// 移除栈顶对象并作为此函数的值返回该对象
	public Object pop() {
		if (top == 0)// 栈为空
			return null;
		else {// 栈非空
			return stackElem[--top];// 修改栈顶指针，并返回栈顶元素
		}
	}

	// 把项压入栈顶
	public void push(Object o) throws Exception {
		if (top == stackElem.length)// 栈满
			throw new Exception("栈已满");// 输出异常
		else
			// 栈未满
			stackElem[top++] = o;// o赋给栈顶元素后，top增1
	}

	// 打印函数，打印所有栈中的元素(栈顶到栈底)
	public void display() {
		for (int i = top - 1; i >= 0; i--)
			System.out.print(stackElem[i].toString() + " ");// 打印
	}

}
