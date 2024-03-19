package w4Exp1;

import ch03.LinkStack;
import ch03.SqStack;

import java.util.Scanner;


public class ConfirmExp {
    public static void main(String[] args) throws Exception{
        SqStack Sq = new SqStack(100);
        LinkStack Sl = new LinkStack();
        Scanner sc = new Scanner(System.in);
        System.out.print("Please Enter the length ps the SqStack");
        int n = sc.nextInt();
        System.out.println("Please Enter the items");
        for(int i = 0; i<n; i++){
            int x = sc.nextInt();
            Sq.push(x);
            Sl.push(x);
        }
        System.out.println("The elements in the SqStack are(from the top to the bottom): ");
        Sq.display();
        System.out.println();
        System.out.println("The elements in the LinkStack are(from the top to the bottom)");
        Sl.display();
        System.out.println();
        System.out.println("Please enter the element to push");
        int e = sc.nextInt();
        Sq.push(e);
        Sl.push(e);
        System.out.println("The elements in SqStack after pushing is");
        Sq.display();
        System.out.println();
        System.out.println("The elements in SlStack after pushing is");
        Sl.display();
        System.out.println();
        System.out.println("The elements in SqStack after popping");
        Sq.pop();
        Sq.display();
        System.out.println();
        System.out.println("The elements in SlStack after popping");
        Sl.pop();
        Sl.display();
    }
}
