package w5Exp1;

import ch03.LinkQueue;

import java.util.*;

class Order{
    public String name;
    public int quantity;
    public int level;
    public String number;

    public Order(String name, int quantity, int level, String number) {
        this.name = name;
        this.quantity = quantity;
        this.level = level;
        this.number = number;
    }

    @Override
    public String toString() {
        return name+" order " + quantity +"tickets in " + level+ " class on " + number;
    }

    public boolean equals(Order obj) {
        return (obj.name.equals(name))&&(obj.quantity == quantity)&&(obj.level == level);
    }
}


class Route {
    public String destination;
    public String flightNumber;
    public String number;
    public int week;
    public int capacity;
    public int ticket;
    public LinkedList<Order> reserved;
    public LinkQueue candidate;

    public Route(String destination, String flightNumber, String number, int week,
                 int capacity, int ticket) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.number = number;
        this.week = week;
        this.capacity = capacity;
        this.ticket = ticket;
        this.reserved = new LinkedList<Order>();
        this.candidate = new LinkQueue();
    }

    @Override
    public String toString() {
        return "Route{" +
                "destination='" + destination + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", number='" + number + '\'' +
                ", week=" + week +
                ", capacity=" + capacity +
                ", ticket=" + ticket +
                '}'+'\n';
    }
}

class ticketSystem{
    private LinkedList<Route> route = new LinkedList<Route>();
    private static final String[] destination = {"Beijing","Shanghai","Guangzhou","Qinghuangdao", "Seoul","Osaka"};
    private static final int[] cap = {50, 100, 200, 500};
    public ticketSystem() {
      route.add(new Route(destination[0],"100","1111",1,10,5));
    }

    public ticketSystem(int capacity) {
        Random random = new Random();
        for(int i = 1; i<capacity; i++){
            int c =  cap[random.nextInt(0,3)];
            route.add(new Route(destination[random.nextInt(0,6)],
                    String.valueOf(random.nextInt(1000,9999)),
                    String.valueOf(random.nextInt(1000,9999)),
                    random.nextInt(0,6),
                    c,
                    c
                    ));
        }

    }

    public LinkedList<Route> search(String destination){
        LinkedList<Route> res = new LinkedList<Route>();
        Iterator<Route> x = route.descendingIterator();
        while (x.hasNext()){
            Route r = x.next();
            if((Objects.equals((String)r.destination, destination)))
                res.add(r);
        }
        return res;
    }

    public void orderTicket(Order order) {
        Iterator<Route> x = route.descendingIterator();
        Scanner sc = new Scanner(System.in);
        while (x.hasNext()) {
            Route r = x.next();
            if (r.number.equals(order.number) && (r.ticket >= order.quantity)) {
                r.reserved.add(order);
                r.ticket -= order.quantity;
                System.out.println("Order successfully");
                break;
            }
            if ((r.number.equals(order.number))){
                System.out.println("May I help you join to the candicate list? yes/no");
                if(sc.next().equals("yes")) {
                    r.candidate.offer(order);
                    System.out.println("candicate successful");
                }
                else {
                    System.out.println("Thank you");
                }
            }
        }
    }

    public void checkCandidate(Route route){
        Order first = (Order) route.candidate.peek();
        Scanner sc = new Scanner(System.in);
        do {
            Order p = (Order)route.candidate.poll();
            if(p.quantity <= route.ticket){
                System.out.println("Do you want to cash the candidate");
                if(sc.next().equals("yes")) {
                    route.reserved.add((Order) route.candidate.poll());
                    System.out.println("cash successfully");
                }
                else
                    route.candidate.offer(p);
                System.out.println("Thank you");
            }
        }while ((route.candidate.peek() != first)&&(route.candidate.peek() != null));
    }

    public void cancelTicker(Order order){
        Iterator<Route> x = route.descendingIterator();
        Scanner sc = new Scanner(System.in);
        while (x.hasNext()) {
            Route r = x.next();
            if ((r.number.equals(order.number))){
                Iterator<Order> iterator = r.reserved.descendingIterator();
                if (!iterator.hasNext())
                    break;
                Order canceled = iterator.next();
                while (!order.equals(canceled))
                    canceled = iterator.next();
                r.ticket += order.quantity;
                r.reserved.remove(order);
                checkCandidate(r);
            }
        }
    }
}
public class ApplicationExp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ticketSystem ticketSystem1 = new ticketSystem(10);
        System.out.println(ticketSystem1.search("Shanghai"));
        System.out.println(ticketSystem1.search("Beijing"));
        ticketSystem1.orderTicket(new Order("David", sc.nextInt(), 1,sc.next()));
        ticketSystem1.orderTicket(new Order("Lucy", sc.nextInt(), 1,sc.next()));
        ticketSystem1.cancelTicker(new Order("David", sc.nextInt(), 1,sc.next()));
    }
}
