package w2Exp1;
import w2Exp1.ch02.*;

import java.util.Scanner;

public class ConfirmExp {
    public static void main(String[] args) throws Exception{
        SX1_SqList L=new SX1_SqList(20);
        System.out.println("请输入顺序表的长度:");
        L.setCurLen(new Scanner(System.in).nextInt());
        System.out.println("请输入顺序表中的各个数据元素:");
        for(int i=0;i<L.getCurLen();i++)
            L.getListElem()[i]=new Scanner(System.in).nextInt();
        System.out.println("请输入待插入的位置i:");
        int i=new Scanner(System.in).nextInt();
        System.out.println("请输入待插入的数据值x:");
        int x=new Scanner(System.in).nextInt();
        L.insert(i, x);
        System.out.println("插入后的顺序表为:");
        L.display();
        System.out.println("请输入待删除元素的位置:");
        i=new Scanner(System.in).nextInt();
        L.remove(i);
        System.out.println("删除后的顺序表为:");
        L.display();
        System.out.println("请输入要查找的目标值:");
        i = new Scanner(System.in).nextInt();
        System.out.println("查找值所在的位置为" );
        System.out.println(L.indexOf(i));

    }
}
