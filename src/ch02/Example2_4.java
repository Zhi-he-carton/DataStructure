package ch02;

/**
 * 
 * （2）建立一个单链表，然后删除单链表中"多余"的数据元素，即使操作之后的单链表中所有元素的值都不相同，最后输出删除后的单链表中各个数据元素。
 * 
 */
public class Example2_4 {
	public static void main(String[] args) throws Exception {
		System.out.println("请输入10个单链表中的10个结点值：");
		LinkList L = new LinkList(10, true);// 从表头到表尾顺序建立一个表长为10的单链表

		System.out.println("删除重复结点前单链表中各个结点值为：");
		L.display();

		removeRepeatElem(L);
		System.out.println("删除重复结点后单链表中各个结点值为：");// 输出
		L.display(); // 输出删除重复结点后单链表中所有的数据元素
	}

	// 删除单链表中"多余"的数据元素
	private static void removeRepeatElem(LinkList L) throws Exception {
		Node p = L.head.next, q;// 初始化,p指向首结点
		while (p != null) {// 从首结点向后查找，直到p为空
			int order = L.indexOf(p.data);// 记录p在单链表中的位置
			q = p.next;
			while (q != null) {
				if ((p.data).equals(q.data))// 删除重复数据结点
					L.remove(order + 1);
				else
					++order;
				q = q.next;
			}
			p = p.next;
		}
	}

}
// 运行结果如下：
// 请输入10个单链表中的数据结点：
// s d s a r a e r v a
// 删除重复结点前单链表中各个数据元素：
// s d s a r a e r v a
// 删除重复结点后单链表中各个数据元素：
// s d a r e v
