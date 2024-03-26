package w5Exp1;

import ch03.CircleSqQueue;
import ch02.LinkList;

import java.util.Scanner;


public class DesignExp {
    private static void fibonacci(int n, int k) throws Exception{
        if (n <= k){
            System.out.println("invalid value");
            return;
        }
        CircleSqQueue cs = new CircleSqQueue(k+2);
        LinkList ls = new LinkList();
        for(int i = 0; i < k-2; i++)
            cs.offer(0);
        cs.offer(1);cs.offer(1);//初始化列表

        for(int i = 0; i<n; i++){
            int temp = 0;
            Object[] queue = cs.getQueueElem();
            for (int j = cs.getFront(); j != cs.getRear();j = (j+1)%queue.length) {
                temp += (int)queue[j];
            }
            cs.offer(temp);
            ls.insert((int)cs.poll());
        }
        ls.display();

    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the length and the order of the fibonacci");
        fibonacci(sc.nextInt(), sc.nextInt());
    }
}
