package ch03;

/**
 * 
 * 充当优先队列结点类Node的数据域data
 * 
 */
public class PriorityQData {
	public Object elem;// 结点的值

	public int priority;// 结点的优先级

	// 构造函数
	public PriorityQData(Object elem, int priority) {
		this.elem = elem;
		this.priority = priority;
	}
	
}
