package ch03;

/**
 * 
 * 【例3-2】大数加法问题：编程实现两个大数的加法运算。所谓大数是指超过整数最大上限的数， 如18 452 543 389 943 209 752 345
 * 473和8 123 542 678 432 986 899 334相加。
 * （提示：可以把两个加数看成是数字字符串，将这些数的相应数字存储在两个堆栈中，并从栈中弹出数字执行加法）
 * 
 */
public class Example3_2 {

	// 求两个大数的和，加数和被加数以字符串的形式输入（允许大数中出现空格），计算的结果也以字符串的形式返回。
	public String add(String a, String b) throws Exception {
		LinkStack sum = new LinkStack();// 大数的和
		LinkStack sA = numSplit(a);// 加数字符串以单个字符的形式放入栈中
		LinkStack sB = numSplit(b);// 被加数字符串以字符的形式放入栈中
		int partialSum;// 对于两个位的求和
		boolean isCarry = false;// 进位标示
		while (!sA.isEmpty() && !sB.isEmpty()) {// 加数和被加数同时非空
			partialSum = (Integer) sA.pop() + (Integer) sB.pop();// 对于两个位求和，并在栈中去除加数和被加数中的该位
			if (isCarry) {// 低位进位
				partialSum++;// 进位加到此位上
				isCarry = false;// 重置进位标示
			}
			if (partialSum >= 10) {// 需要进位
				partialSum -= 10;
				sum.push(partialSum);
				isCarry = true;// 标示进位
			} else {// 位和不需要进位
				sum.push(partialSum);// 和放入栈中
			}
		}

		LinkStack temp = !sA.isEmpty() ? sA : sB;// 引用指向加数和被加数中非空栈
		while (!temp.isEmpty()) {
			if (isCarry) {// 如果在最后一次执行加法运算中，需要进位
				int t = (Integer) temp.pop();// 取出加数或被加数没有参加的位
				++t;// 进位加到此位上
				if (t >= 10) {// 需要进位
					t -= 10;
					sum.push(t);
				} else {
					sum.push(t);
					isCarry = false;// 重置进位标示
				}
			} else
				// 如果在最后一次执行加法运算中，不需要进位
				sum.push(temp.pop());// 把加数或被加数中非空的值放入和中
		}

		if (isCarry) {// 最高位需要进位
			sum.push(1);// 进位放入栈中
		}

		String str = new String();
		while (!sum.isEmpty())
			// 把栈中元素，转化成字符串
			str = str.concat(sum.pop().toString());
		return str;
	}

	// 字符串以单个字符的形式放入栈中，并去除字符串中空格，返回以单个字符为元素的栈
	public LinkStack numSplit(String str) throws Exception {
		LinkStack s = new LinkStack();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);// 指定索引处的 char 值
			if (' ' == c)// 去除空格
				continue;
			else if ('0' <= c && '9' >= c) // 数字放入栈中
				s.push(Integer.valueOf(String.valueOf(c)));
			else
				// 非法数字字符
				throw new Exception("错误：输入了非数字型字符!");
		}
		return s;
	}

	public static void main(String[] args) throws Exception {
		Example3_2 e = new Example3_2();
		System.out.println("两个大数的和为："
				+ e.add("18 452 543 389 943 209 752 345 473",
						"8 123 542 678 432 986 899 334"));// 输出运算结果
	}
}

// 调试结果：
// 两个大数的和为：18460666932621642739244807
