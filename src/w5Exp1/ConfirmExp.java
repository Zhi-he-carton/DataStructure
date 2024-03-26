package w5Exp1;

import java.util.Scanner;
import ch03.CircleSqQueue;
import ch03.LinkQueue;
public class ConfirmExp {
    public static void main(String[] args) throws Exception{
        CircleSqQueue Q1 = new CircleSqQueue(100);
        LinkQueue Q2 = new LinkQueue();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入队列的长度：");
        int n = sc.nextInt();
        System.out.println("PLease enter the elements in the queue");
        for (int i = 0; i <n; i++){
            int data = sc.nextInt();
            Q1.offer(data);
            Q2.offer(data);
        }
        System.out.println("The elements in the established order queue is (from" +
                "front to the rear):");
        Q1.display();
        System.out.println("\nThe elements in the established Linkqueue is " +
                "from front to the rear:");
        Q2.display();
        System.out.println("\nPlease enter the element waiting to offer");
        int x = sc.nextInt();
        Q1.offer(x);
        System.out.println("The elements in the established circle order queue is (from" +
                "front to the rear) after offering:");
        Q1.display();
        Q2.offer(x);
        System.out.println("\nThe elements in the established Link queue is (from" +
                "front to the rear offering):");
        Q2.display();
        Object t1 = Q1.poll();
        Object t2 = Q2.poll();
        if(t1 != null && t2!= null){
            System.out.println("\n the first element in the popped circle queue is: " + t1);
            System.out.println("\n the first element in the popped link queue is: " + t2);
            System.out.println("\n the element in the circle queue after popping");
            Q1.display();
            System.out.println("\nthe elements in the popped Link queue is (from front to the rear):");
            Q2.display();

        }
    }
}
