package w3Exp1;

import ch02.*;

public class ApplicationExp {
    public ApplicationExp() throws Exception {
    }

    private static CircleLinkList createCircle(int num) throws Exception{
        CircleLinkList linkList = new CircleLinkList();
        int i = 0;
        while(i < num){
            linkList.insert(i,i+1);
            i++;
        }
        return linkList;
    }

    private static void Johnson(CircleLinkList linkList, int k) throws Exception{
        CircleLinkList dead = new CircleLinkList();
        int length = linkList.length();
        int d = length/2;
        int num = k -1;
        Node p = linkList.head;
        while (length > d){
            if(p.next == linkList.head) {
                p = p.next;
                continue;
            }
            if(num == 0){
                dead.insert(0, p.next.data);
                p.next = p.next.next;
                num = k -1;
                length--;
            }
            else {
                p = p.next;
                num--;
            }
        }
        System.out.println("这是死掉的人：");
        dead.display();
        System.out.println("这是活着的人：");
        linkList.display();
    }

    public static void main(String[] args) throws Exception{
        CircleLinkList linklist = createCircle(30);
        Johnson(linklist, 9);
    }
}

