package backCoteAxim;

public class problem05 {
    public static void main(String[] args) {
        Employee one = new Permanent();
        Employee two = new Salesman();
        one.sabun = 1;
        one .name = "yong";
        two.sabun = 2;
        two.name = "jun";

        one.printinfo();
        two.printinfo();
    }
}

abstract class Employee{
    int sabun;
    String name;
    abstract int getSalary();

    void printinfo(){
        System.out.println("사번 "+sabun+"봉급 "+getSalary()+name);
    }
}

class Permanent extends Employee{
    int getSalary(){
        return 100;
    }
}
class Salesman extends Permanent{
    int getSalary(){
        return 10+super.getSalary();
    }
}
