package ch03;

/**
 * 
 * 【例3-3】表达式求值问题：编程实现算术表达式求值（包括将原表达式转换成后缀表达式及根据后缀表达式求值两个过程）
 * 
 */
public class Example3_3 {
	// 此函数将表达式变换为后缀表达式，把结果以字符串的形式返回，此函数的算法如下：
	// 1)检查表达式的下一元素。
	// 2)假如是个操作数，输出。
	// 3)假如是个开括号，将其压栈。
	// 4)假如是个运算符，则
	// i) 假如栈为空，将此运算符压栈。
	// ii) 假如栈顶是开括号，将此运算符压栈。
	// iii) 假如此运算符比栈顶运算符优先级高，将此运算符压入栈中。
	// iv) 否则栈顶运算符出栈并输出，重复步骤4。
	// 5)假如是个闭括号，栈中运算符逐个出栈并输出，直到遇到开括号。开括号出栈并丢弃。
	// 6)假如表达式还未完毕，跳转到步骤1。
	// 7)假如遍历表达式完毕，栈中剩余的所有操作符出栈并加到后缀表达式的尾部。

	public String convertToPostfix(String expression) throws Exception {
		LinkStack st = new LinkStack();// 用于存放函数运行过程中的括号和运算符（函数结束时此栈为空）
		String postfix = new String();// 用于输出的后缀表达式
		for (int i = 0; expression != null && i < expression.length(); i++) {
			char c = expression.charAt(i);// 指定索引处的 char 值
			if (' ' != c) {// 字符c不为空格
				if (isOpenParenthesis(c)) {
					st.push(c);// 为开括号，压栈
				} else if (isCloseParenthesis(c)) {// 为闭括号,栈中运算符逐个出栈并放入用于输出的栈，直到遇到开括号。开括号出栈并丢弃
					Character ac = (Character) st.pop();// 移除栈顶元素
					while (!isOpenParenthesis(ac.charValue())) {// 一直到为开括号为止
						postfix = postfix.concat(ac.toString());// 串联到后缀表达式的结尾
						ac = (Character) st.pop();
					}
				} else if (isOperator(c)) {// 为运算符
					if (!st.isEmpty()) {// 栈非空，取出栈中优先级高的操作符串联到后缀表达式的结尾
						Character ac = (Character) st.pop();
						while (ac != null
								&& priority(ac.charValue()) >= priority(c)) {// 优先级比较
							postfix = postfix.concat(ac.toString());// 串联到后缀表达式的结尾
							ac = (Character) st.pop();
						}

						if (ac != null) {// 如果最后一次取出的优先级低的操作符，重新压栈
							st.push(ac);
						}
					}
					st.push(c);
				} else {// 为操作数，串联到后缀表达式的结尾
					postfix = postfix.concat(String.valueOf(c));
				}
			}
		}

		while (!st.isEmpty()) {// 栈中剩余的所有操作符串联到后缀表达式的结尾
			postfix = postfix.concat(String.valueOf(st.pop()));// 串联到后缀表达式的结尾
		}

		return postfix;
	}

	// 对后缀表达式进行求值计算，此函数的算法如下：
	// 1)初始化一个空堆栈
	// 2)从左到右读入后缀表达式
	// i)如果字符是一个操作数，把它压入堆栈。
	// ii)如果字符是个操作符，弹出两个操作数，执行恰当操作，然后把结果压入堆栈。如果不能够弹出两个操作数，后缀表达式的语法就不正确。
	// 3)到后缀表达式末尾，从堆栈中弹出结果。若后缀表达式格式正确，那么堆栈应该为空。

	public double numberCalculate(String postfix) throws Exception {
		LinkStack st = new LinkStack();
		for (int i = 0; postfix != null && i < postfix.length(); i++) {
			char c = postfix.charAt(i);// 指定索引处的 char 值
			if (isOperator(c)) {// 当为操作符时
				// 取出两个操作数
				double d2 = Double.valueOf(st.pop().toString());
				double d1 = Double.valueOf(st.pop().toString());
				double d3 = 0;
				if ('+' == c) {// 加法运算
					d3 = d1 + d2;
				} else if ('-' == c) {// 加法运算
					d3 = d1 - d2;
				} else if ('*' == c) {// 乘法运算
					d3 = d1 * d2;
				} else if ('/' == c) {// 除法运算
					d3 = d1 / d2;
				} else if ('^' == c) {// 幂运算
					d3 = Math.pow(d1, d2);
				} else if ('%' == c) {
					d3 = d1 % d2;
				}
				st.push(d3);
			} else {// 当为操作数时
				st.push(c);
			}
		}
		return (Double) st.pop();// 返回运算结果
	}

	// 判断字符串是否为运算符
	public boolean isOperator(char c) {
		if ('+' == c || '-' == c || '*' == c || '/' == c || '^' == c
				|| '%' == c) {
			return true;
		} else {
			return false;
		}
	}

	// 判断字符串是否为开括号
	public boolean isOpenParenthesis(char c) {
		return '(' == c;
	}

	// 判断字符串是否为闭括号
	public boolean isCloseParenthesis(char c) {
		return ')' == c;
	}

	// 判断运算法的优先级
	public int priority(char c) {
		if (c == '^') {// 为幂运算
			return 3;
		}
		if (c == '*' || c == '/' || c == '%') {// 为乘、除、取模运算
			return 2;
		} else if (c == '+' || c == '-') {// 为加、减运算
			return 1;
		} else { // 其他
			return 0;
		}
	}

	public static void main(String[] args) throws Exception {
		Example3_3 p = new Example3_3();
		String postfix = p.convertToPostfix("(1 + 2)*(5 - 2)/2^2 + 5%3");// 转化为后缀表达式
		System.out.println("表达式的结果为： " + p.numberCalculate(postfix));// 对后缀表达式求值后，并输出
	}
}

// 调试结果：
// 表达式的结果为： 4.25

