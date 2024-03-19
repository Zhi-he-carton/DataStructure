package ch03;
/**
 * 
 * 对在带有头结点的单链表上实现的栈及其基本操作进行调试
 * 
 */
public class DebugLinkStack {
	public static void main(String[] args) {
		LinkStack S = new LinkStack();// 初始化一个新的栈
		for (int i = 1; i <= 10; i++)
			// 初始化栈中的元素，其中元素个数为10
			S.push(i);
		System.out.println("栈中各元素为(栈顶到栈底)：");
		S.display();// 打印栈中元素(栈顶到栈底)）
		System.out.println();
		
		if (!S.isEmpty())
			System.out.println("栈非空！");

		System.out.println("栈的长度为： " + S.length());// 输出栈的长度
		System.out.println("栈顶元素为： " + S.peek().toString());// 输出栈顶元素

		System.out.println("去除栈顶元素后，栈中各元素为(栈顶到栈底)：  ");
		S.pop();// 删除元素
		S.display();// 打印栈中元素
		System.out.println();

		System.out.println("去除栈中剩余的所有元素！ 进行中。。。");
		S.clear(); // 清除栈中的元素

		if (S.isEmpty())// 栈空，输出
			System.out.println("栈为空!");
	}
}

// 调试结果：
// 栈中各元素为(栈顶到栈底)：
// 10 9 8 7 6 5 4 3 2 1
// 栈非空！
// 栈的长度为： 10
// 栈顶元素为： 10
// 去除栈顶元素后，栈中各元素为(栈顶到栈底)：
// 9 8 7 6 5 4 3 2 1
// 去除栈中剩余的所有元素！ 进行中。。。
// 栈为空!
