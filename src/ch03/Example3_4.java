package ch03;

/**
 * 
 * 【例3-4】栈与递归问题：编程实现汉诺塔问题求解问题
 * 
 */
public class Example3_4 {
	private int c = 0;// 全局变量，对搬动计数

	// 将塔座x上按直径由小到大且自上而下的编号为1至n的n个圆盘按规则移到塔座z上，y用作辅助塔座
	public void hanoi(int n, char x, char y, char z) {
		if (n == 1) {
			move(x, 1, z); // 将编号为1的圆盘从x移到z
		} else {
			hanoi(n - 1, x, z, y);// 将x上编号为1至n-1的圆盘移到y，z作辅助塔
			move(x, n, z);// 将编号为n的圆盘从x移到z
			hanoi(n - 1, y, x, z);// 将y上编号为1至n-1的圆盘移到z，x作辅助塔
		}
	}

	// 移动操作，将编号为n的圆盘从x移到z
	public void move(char x, int n, char z) {
		System.out.println("第" + ++c + "次移动： " + n + "号圆盘，" + x + "->" + z);
	}

	public static void main(String[] args) {
		Example3_4 h = new Example3_4();
		h.hanoi(3, 'x', 'y', 'z');// 对于圆盘数量为3进行移动
	}
}

// 调试结果：
// 第1次移动： 1号圆盘，x->z
// 第2次移动： 2号圆盘，x->y
// 第3次移动： 1号圆盘，z->y
// 第4次移动： 3号圆盘，x->z
// 第5次移动： 1号圆盘，y->x
// 第6次移动： 2号圆盘，y->z
// 第7次移动： 1号圆盘，x->z
