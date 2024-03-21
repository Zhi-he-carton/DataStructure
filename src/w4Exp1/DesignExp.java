package w4Exp1;

import ch03.LinkStack;

import java.util.Scanner;


class StackElem {
    public int m;
    public int n;

    public StackElem(int m, int n) {
        this.m = m;
        this.n = n;
    }
}
public class DesignExp {
    private static int Ackerman(int m, int n){
        LinkStack Lstack = new LinkStack();
        StackElem elem = new StackElem(m,n);
        StackElem temp;
        int i = 0;
        Lstack.push(elem);
        while (!Lstack.isEmpty()){
            temp = (StackElem) Lstack.pop();
            if((temp.m != 0) && (temp.n != 0)){
                StackElem elem1 = new StackElem(temp.m, temp.n - 1);
                temp.m--;
                Lstack.push(temp);
                Lstack.push(elem1);
                continue;
            }
            if ((temp.m !=0)&&(temp.n == 0)){
                temp.m--;
                temp.n++;
                Lstack.push(temp);
                continue;
            }
            else {
                i = temp.n+1;
                if (Lstack.isEmpty())
                    break;
                else{
                    temp = (StackElem) Lstack.pop();
                    temp.n = i;
                    Lstack.push(temp);
                }

            }
        }
        return i;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(Ackerman(sc.nextInt(), sc.nextInt()));
    }
}
