package step1;

/**
 * Created by zengpeng on 2017/12/25.
 */


/**
 * Created by zengpeng on 2017/12/25.
 */
public class MyLinkedList {

    private Node first;//头结点，不存数据
    private Node last;//指向链表的最后一个节点
    private int size;

    public MyLinkedList() {
        size = 0;
        first = new Node(0, null);
        last = first;
    }

    /**
     * 添加到链表尾部
     *
     * @param item
     */
    public void add(int item) {
        Node newNode = new Node(item, null);
        last.next = newNode;
        last = newNode;
        ++size;
    }

    /**
     * 添加数据item到指定位置index
     * index从0开始
     *
     * @param index
     * @param item
     */
    public void add(int index, int item) {
        checkPosIndex(index);
        Node elem = new Node(item, null);
        Node p = first;
        while (p.next != null && index > 0) {
            p = p.next;
            --index;
        }
        elem.next = p.next;
        p.next = elem;
        ++size;
    }

    /**
     * 删除指定位置index处的元素并返回, index从0开始
     *
     * @param index
     * @return
     */
    public int remove(int index) {
        checkPosIndex(index);

        Node p = first;
        while (p.next != null && index > 0) {
            p = p.next;
            --index;
        }
        int x = p.next.item;
        p.next = p.next.next;
        --size;
        return x;
    }

    public int size() {
        return size;
    }

    private void checkPosIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    //结点内部类
    private static class Node {
        int item;
        Node next;

        Node(int item, Node next) {
            this.item = item;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(0, 1);
        list.add(5);
        list.add(7);
        list.add(-1);
        list.add(0, 3);
        list.add(2, 4);
        list.add(-6);
        list.remove(6);
        list.add(33);
        while (list.size() > 0) {
            System.out.println(list.remove(0));
        }
    }
}
