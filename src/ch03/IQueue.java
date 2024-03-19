package ch03;

/**
 * 
 * 队列的接口
 * 
 */
public interface IQueue {
	public void clear(); // 将一个已经存在的队列置成空

	public boolean isEmpty(); // 测试队列是否为空

	public int length();// 求队列中的数据元素个数并由函数返回其值

	public Object peek();// 查看队列的头而不移除它，返回队列顶对象，如果此队列为空，则返回 null

	public Object poll();// 移除队列的头并作为此函数的值返回该对象，如果此队列为空，则返回 null

	public void offer(Object o) throws Exception;// 把指定的元素插入队列

	public void display();// 打印函数，打印所有队列中的元素(队列头到队列尾)

}
