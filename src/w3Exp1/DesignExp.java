package w3Exp1;

import ch02.*;

public class DesignExp {
    public static DuLinkList sort(DuLinkList L) throws Exception{
        DuLinkList r = new DuLinkList();
        DuLNode p = L.head.next;
        while (p.next != L.head){
            int elem = Integer.parseInt((String)p.data);
            if(elem <= 0) {
                r.insert(0, elem);
                p = p.next;
                p.prior.prior.next = p;
                p.prior = p.prior.prior;
            }
            else
                p = p.next;
        }
        r.head.prior.next = L.head.next;
        L.head.next.prior = r.head.prior;
        r.head.prior = p;
        p.next =r.head;
        return r;
    }

    public static void main(String[] args) throws Exception {
        DuLinkList dl = new DuLinkList(10);
        dl.display();
        dl = sort(dl);
        dl.display();
    }
}

