package w4Exp1;

import ch03.LinkStack;

class Node{
    public int x;
    public int y;
    public int dirt;
    private static final String[] direction = {"east","east", "south", "east", "north"};


    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.dirt = 1;
    }

    @Override
    public String toString() {
        return "Go " + direction[dirt - 1] + " at " + "x:" + ((Integer)x).toString() +
                " " +"y:" + ((Integer)y).toString() +"\n";
    }
}

public class ApplicationExp {
    private static final int[] xOffset = {1,0,-1,0};
    private static final int[] yOffset = {0,-1,0,1};
    public static void move(LinkStack stack){
        Node temp =  (Node)stack.pop();
        for(int i = temp.dirt;i <= 4; i++) {
            if (maze[temp.y + yOffset[i - 1]][temp.x + xOffset[i - 1]] == 0) {
                stack.push(temp);
                stack.push(new Node(temp.x + xOffset[i - 1], temp.y + yOffset[i - 1]));
                maze[temp.y][temp.x] = 2;
                temp.dirt = ++i;
                return;
            }
        }
            maze[temp.y][temp.x] = 0;
            temp.dirt = 4;
            if ((temp.x == 1) && (temp.y == 1)){
                System.out.println("没有通路");
                stack.push(new Node(8,9));
            }
//            if((i == 1)&&(maze[temp.x + 1][temp.y] == 0)){
//                temp.dirt = i;
//                stack.push(temp);
//                stack.push(new Node(temp.x + 1,temp.y));
//                maze[temp.x + 1][temp.y] = 2;
//                break;
//            }
//            if((i == 2)&&(maze[temp.x][temp.y - 1] == 0)){
//                temp.dirt = i;
//                stack.push(temp);
//                stack.push(new Node(temp.x,temp.y -1));
//                maze[temp.x][temp.y -1] = 2;
//                break;
//            }
//            if((i == 3)&&(maze[temp.x -1][temp.y] == 0)){
//                temp.dirt = i;
//                stack.push(temp);
//                stack.push(new Node(temp.x - 1,temp.y));
//                maze[temp.x - 1][temp.y] = 2;
//                break;
//            }
//            if((i == 4)&&(maze[temp.x][temp.y + 1] == 0)){
//                temp.dirt = i;
//                stack.push(temp);
//                stack.push(new Node(temp.x,temp.y + 1));
//                maze[temp.x][temp.y + 1] = 2;
//                break;
//            }

    }

    static int[][] maze =
            {
                    {1,1,1,1,1,1,1,1,1,1},
                    {1,0,0,1,0,0,0,1,0,1},
                    {1,0,0,1,0,0,0,1,0,1},
                    {1,0,0,0,0,1,1,0,1,1},
                    {1,0,1,1,1,0,0,1,0,1},
                    {1,0,0,0,1,0,0,0,0,1},
                    {1,0,1,0,0,0,1,0,1,1},
                    {1,0,1,1,1,1,0,0,1,1},
                    {1,1,1,0,0,0,1,0,1,1},
                    {1,1,1,0,0,0,0,0,0,1},
                    {1,1,1,1,1,1,1,1,1,1}
            }

            ;
    public static void main(String[] args) {
        LinkStack Lstack = new LinkStack();
        Node node = new Node(1,1);
        while ((node.x != 8)||(node.y != 9)){
            Lstack.push(node);
            move(Lstack);
            node = (Node) Lstack.pop();
        }
        Lstack.display();
    }
}
