package ch02;

/**
 * 
 * 多项式的结点,作为链表(LNode)的数据元素(data)
 * 
 */
public class PolynNode {
	public double coef; // 系数

	public int expn; // 指数

	public PolynNode(double coef, int expn) { // 构造函数
		this.coef = coef;
		this.expn = expn;
	}

}
