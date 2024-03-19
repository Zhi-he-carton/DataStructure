package w3Exp1;


import ch02.*;

import java.util.Scanner;

public class ConfirmExp {

    private static void create(LinkList L){
        Scanner sc = new Scanner(System.in);
        System.out.println("输入链表中的各个元素，以0为止结束");
        for(int x = sc.nextInt(); x != 0; x = sc.nextInt()) {
            try {
                L.insert(0, x);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        LinkList L = new LinkList();
        create(L);
        System.out.println("建立的单链表为：");
        L.display();
        System.out.println("请输入插入的位置i");
        int i = sc.nextInt();
        System.out.println("请输入待插入的数据值x");
        int x = sc.nextInt();
        L.insert(i, x);
        System.out.println("请输入待删除的位置：");
        i = sc.nextInt();
        L.remove(i);
        System.out.println("删除后的链表为：");
        L.display();
        System.out.println("输入待查找的查找值：");
        i = sc.nextInt();
        Object o = L.get(i);
        System.out.println("此单链表中第" + i + "个节点的元素值为"+ o);
    }
}
