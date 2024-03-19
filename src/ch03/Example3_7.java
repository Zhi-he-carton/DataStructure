package ch03;

/**
 * 
 * 例3-7 设计一个程序模仿操作系统的进程管理问题。要求按进程服务优先级高的先服务、优先级相同的先到先服务的原则管理。
 * 
 */

public class Example3_7 {
	// 主函数
	public static void main(String[] args) {
		PriorityQueue pm = new PriorityQueue();// 构造一个对象
		pm.offer(new PriorityQData(1, 20));// 插入优先级队列
		pm.offer(new PriorityQData(2, 30));
		pm.offer(new PriorityQData(3, 20));
		pm.offer(new PriorityQData(4, 20));
		pm.offer(new PriorityQData(5, 40));
		pm.offer(new PriorityQData(6, 10));
		System.out.println("进程服务的顺序：");
		System.out.println("进程ID  进程优先级");// 打印
		while (!pm.isEmpty()) {// 从队头到队尾，输出结点的值和优先级
			PriorityQData p = (PriorityQData) pm.poll();// 移除队头元素，并返回其值
			System.out.println("  " + p.elem + "\t" + p.priority);// 输出
		}
	}
}
//
// 运行结果：
// 进程服务的顺序：
// 进程ID 进程优先级
// 6 10
// 1 20
// 3 20
// 4 20
// 2 30
// 5 40
