package ch03;

import java.util.Scanner;

// * 
// * 【例3-1】分隔符匹配问题：编写判断Java程序中分隔符是否匹配的程序。Java程序中有以下分隔符：圆括号“（”和“）”，方括号“[”和“]”，大括号“{”和“}”以及注释分隔符“/*”和“*/”
// * 

public class Example3_1 {
	private static final int LEFT = 0;// 记录分隔符为"左"分隔符

	private static final int RIGHT = 1;// 记录分隔符为"右"分隔符

	private static final int OTHER = 2;// 记录其他字符

	// 判断分隔符的类型，有三种"左"、"右"、"非法"
	public int verifyFlag(String str) {
		if ("(".equals(str) || "[".equals(str) || "{".equals(str)
				|| "/*".equals(str))// 左分隔符
			return LEFT;
		else if (")".equals(str) || "]".equals(str) || "}".equals(str)
				|| "*/".equals(str))// 右分隔符
			return RIGHT;
		else
			// 其他字符
			return OTHER;
	}

	// 匹配左分隔符str1和右分隔符str2，是否匹配
	public boolean matches(String str1, String str2) {
		if (("(".equals(str1) && ")".equals(str2))
				|| ("[".equals(str1) && "]".equals(str2))
				|| ("{".equals(str1) && "}".equals(str2))
				|| ("/*".equals(str1) && "*/".equals(str2)))// 匹配规则
			return true;
		else
			return false;
	}

	private boolean isLegal(String str) throws Exception {
		if (!"".equals(str) && str != null) {
			SqStack S = new SqStack(100);// 新建最大存储空间为100的顺序栈
			int length = str.length();
			for (int i = 0; i < length; i++) {
				char c = str.charAt(i);// 指定索引处的 char 值
				String t = String.valueOf(c);// 转化成字符串型
				if (i != length) {// c不是最后一个字符
					if (('/' == c && '*' == str.charAt(i + 1))
							|| ('*' == c && '/' == str.charAt(i + 1))) {// 是分隔符"/*"或"*/"
						t = t.concat(String.valueOf(str.charAt(i + 1)));// 与后一个字符相连
						++i;// 跳过一个字符
					}
				}
				if (LEFT == verifyFlag(t)) {// 为左分隔符
					S.push(t);// 压入栈
				} else if (RIGHT == verifyFlag(t)) {// 为右分隔符
					if (S.isEmpty() || !matches(S.pop().toString(), t)) {// 右分隔符与栈顶元素不匹配
						throw new Exception("错误：Java语句不合法！");// 输出异常
					}
				}
			}

			if (!S.isEmpty())// 栈中存在没有匹配的字符
				throw new Exception("错误：Java语句不合法！");// 输出异常

			return true;
		} else
			throw new Exception("错误：Java语句为空！");// 输出异常
	}

	public static void main(String[] args) throws Exception {
		Example3_1 e = new Example3_1();
		System.out.println("请输入分Java语句：");// 输出
		Scanner sc = new Scanner(System.in);
		if (e.isLegal(sc.nextLine()))
			System.out.println("Java语句合法!");// 输出
		else
			System.out.println("错误：Java语句不合法！");// 输出
	}
}

// 调试结果：
// 请输入分Java语句：
// a=b+(c+d)*(e-f);
// Java语句合法!

// 请输入分Java语句：
// s[4]=t[a[2]]+ u/((i+j)*k);
// Java语句合法!

// 请输入分Java语句：
// if (i!=(n[8]+1)) {p=7; /* initialize p */ q=p+2;}
// Java语句合法!

// 请输入分Java语句：
// a=(b+c/(d*e)*f;
// Exception in thread "main" java.lang.Exception: 错误：Java语句不合法！

// 请输入分Java语句：
// while (i!=(n[8]+1)] {p=7; /* initialize p */ q=p+2;}
// Exception in thread "main" java.lang.Exception: 错误：Java语句不合法！
