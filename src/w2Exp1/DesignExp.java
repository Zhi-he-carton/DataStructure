package w2Exp1;

import w2Exp1.ch02.*;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class DesignExp {
    public static void main(String[] args) throws Exception {
        System.out.println("Please Enter the maxsize of Sqlist A B");
        int maxsize = new Scanner(System.in).nextInt();
        SqList A = create(maxsize);
        SqList B = create(maxsize);
        SqList C = create(maxsize);
        System.out.print("A:");;A.display();
        System.out.println();
        System.out.print("B:");;B.display();
        System.out.println();
        System.out.print("C:");;C.display();
        System.out.println();
        removePublic(A,B,C);
        System.out.print("A:");;A.display();
        System.out.println();
    }


    private static SqList create(int maxsize) throws Exception {
        SqList list = new SqList(maxsize);
        System.out.println("Please Eneter the elm of this Sqlist");
        for (int i = 0; i < maxsize; i++) {
            int elm = new Scanner(System.in).nextInt();
            if (list.isEmpty()) {
                list.insert(0, elm);
                continue;
            }
            for (int x = 0; x < list.length(); x++) {
                if (elm <= (int) list.get(x)) {
                    list.insert(x, elm);
                    break;
                }
                if (elm >= (int) list.get(x) && x == list.length() - 1) {
                    list.insert(x + 1, elm);
                    break;
                }
            }
        }
        return list;

    }

    private static void removePublic(SqList A, SqList B,SqList C) throws Exception{
        int i =0, j = 0, k = 0;
        while (j< B.length() && i< C.length()){
            if ((int)B.get(j) < (int)C.get(k))
                j++;
            else if ((int)B.get(j) > (int)C.get(i))
                i++;
            else {
                while (i < A.length()&&(int)A.get(i)<(int)B.get(j)){
                    i++;
                }
                if (i < A.length()&&(int)A.get(i) == (int)B.get(j))
                    A.remove(i);
                j++;
                k++;
            }//我只能说这是非常优秀的代码，真的非常优秀，下面的是我自己实现的
        }
    }


}

