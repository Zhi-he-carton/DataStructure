package w2Exp1;


class Student{
    String number,name,sex,phoneNumber,address;
    int score;

    public Student(String number, String name, String sex, String phoneNumber, String address) {
        this.number = number;
        this.name = name;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    @Override
    public String toString(){
        return ("Number:" + this.number + ' '+
                "Name:"+this.name+ ' '+
                "Sex:" + this.sex+ ' '+
                "PhoneNumber:" + this.phoneNumber+ ' '+
                "Address:" + this.address);
    }

}

class StudentAddress{
    private Student[] listElem; // 线性表存储空间
    private int curLen;

    public StudentAddress(int maxSize) {
       curLen = 0;
       listElem = new Student[maxSize];
    }

    public void insert(int i, Student student) throws Exception{
        if(curLen == listElem.length)
            throw new Exception("顺序表已满");
        if(i > curLen | i < 0)
            throw  new Exception("插入位置不合法");
        for (int j = curLen; j > i; j--)
            listElem[j] = listElem[j - 1];// 插入位置及之后的元素后移

        listElem[i] = student; // 插入x
        curLen++;// 表长度增1

    }

    public int numberOf(String number){
        int j = 0;// j为计数器
        while (j < curLen && !listElem[j].number.equals(number))
            // 从顺序表中的首结点开始查找，直到listElem[j]指向元素x或到达顺序表的表尾
            j++;
        if (j < curLen)// 判断j的位置是否位于表中
            return j; // 返回x元素在顺序表中的位置
        else
            return -1;// x元素不在顺序表中
    }

    public int nameOf(String name){
        int j = 0;// j为计数器
        while (j < curLen && !listElem[j].name.equals(name))
            // 从顺序表中的首结点开始查找，直到listElem[j]指向元素x或到达顺序表的表尾
            j++;
        if (j < curLen)// 判断j的位置是否位于表中
            return j; // 返回x元素在顺序表中的位置
        else
            return -1;// x元素不在顺序表中
    }
    public void edit(String number, int score){
        listElem[numberOf(number)].score = score;

    }

    public void remove(int index) throws Exception{
        if(index<0 || index > curLen)
            throw new Exception("Position is illegal");
        for(int i = index; i< curLen - 1 ; i++)
            listElem[i] = listElem[i+1];

        curLen--;
    }

    public Student get(int index) {
        return listElem[index];
    }

    public void display(){
        System.out.println("------------------------------------------------------------------");
        for (int i = 0; i< curLen; i++)
            System.out.println(listElem[i]);
        System.out.println("------------------------------------------------------------------");
    }
}




public class ApplicationExp {
    public static void main(String[] args) throws Exception{
        Student student1 = new Student("2008001","Alam","F",
                "13305731238","浙江省嘉兴市");
        Student student2 = new Student("2008002","Danie","M",
                "0573-82283288","浙江省嘉兴市");
        Student student3 = new Student("2008003","Bill","M",
                "13305732222","江西省抚州市");
        Student student4 = new Student("2008004","Peter","M",
                "13305734444","安徽省蚌埠市");
        StudentAddress SA = new StudentAddress(4);
        SA.insert(0,student1);
        SA.insert(1,student2);
        SA.insert(2,student3);
        SA.insert(3,student4);
        System.out.println(SA.get(SA.numberOf("2008001")));
        SA.edit("2008001", 100);
        SA.remove(SA.numberOf("2008002"));
        SA.display();
        SA.remove(SA.nameOf("Bill"));
        SA.display();
    }
}
