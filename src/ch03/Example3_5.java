package ch03;

/**
 * 
 * 解素数环问题。即将1-n的 n个自然数排列成环形，使得每相邻两数之和为素数，构成一个素数环
 * 
 */
import ch02.SqList;

public class Example3_5 {
	// 判断正整数是否为素数
	public boolean isPrime(int num) {
		if (num == 1)// 整数1返回false
			return false;
		Double n = Math.sqrt(num);// 求平方根
		for (int i = 2; i <= n.intValue(); i++)
			if (num % i == 0)// 模为0返回false
				return false;
		return true;
	}

	// 求n个正整数的素数环，并以顺序表返回
	public SqList makePrimeRing(int n) throws Exception {
		if (n % 2 != 0)// n为奇数则素数环不存在
			throw new Exception("素数环不存在！");
		SqList L = new SqList(n);// 构造一个顺序表
		L.insert(0, 1);// 初始化顺序表的首节点为1
		LinkQueue Q = new LinkQueue();// 构造一个链队列
		for (int i = 2; i <= n; i++)
			// 初始化链队列
			Q.offer(i);
		return insertRing(L, Q, 2, n);// 返回素数环
	}

	// 在一个顺序表中插入第m个数，使其与顺序表中第m - 1个数的和为素数，如果m等于n则还要满足第m个数与1的和也为素数。程序返回顺序表
	public SqList insertRing(SqList L, LinkQueue Q, int m, int n)
			throws NumberFormatException, Exception {
		int count = 0;// 记录遍历队列中的元素个数，防止在一次循环中重复遍历
		while (!Q.isEmpty() && count <= n - m) {// 队列非空，且未重复遍历队列
			int p = (Integer) Q.poll();
			int q = (Integer) L.get(L.length() - 1);// 取出顺序表中的最后一个元素
			if (m == n) {// 为队列中的最后一个元素
				if (isPrime(p + q) && isPrime(p + 1)) {// 满足素数环的条件
					L.insert(L.length(), p);// 插入到顺序表尾
					return L;
				} else
					// 不满足素数环条件
					Q.offer(p);
			} else if (isPrime(p + q)) {// 未遍历到队列的最后一个元素,且满足素数环条件
				L.insert(L.length(), p);// 插入到顺序表尾
				if (insertRing(L, Q, m + 1, n) != null)// 递归调用函数，如果返回值不为空，即已成功找到素数环，则返回
					return L;
				L.remove(L.length() - 1);// 移除顺序表表尾元素
				Q.offer(p);
			} else
				Q.offer(p);// 加入的队列尾部
			++count;// 遍历次数增1
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		Example3_5 r = new Example3_5();// 构造素数环对象
		SqList L = r.makePrimeRing(6);// 求素数环
		for (int i = 0; i < L.length(); i++)
			System.out.print(L.get(i) + " ");
		
	}
}

// 程序运行结果：
// 1 4 3 2 5 6
