package Assignment;

import java.util.LinkedList;
import java.util.Queue;

class Person{
    public
    String name;
    String city;
    Person(String name, String city){
        this.name = name;
        this.city = city;
    }
}

class Controlsys{
    private
    Queue<Person> CA = new LinkedList<>();
    Queue<Person> CB = new LinkedList<>();
    int bridgeInUse = 1; //this token stands for if token is availaible with A or not

    Controlsys(Queue<Person> mainq){
        for(Person P : mainq){
            if(P.city.equals("A")){
                CA.add(P);
            }
            else{
                CB.add(P);
            }
        }

    }

    synchronized void CityA() {
        while (!CA.isEmpty()) {
            while (bridgeInUse != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            Person p = CA.poll();
            if (p != null) {
                System.out.println(p.name + " from City A is crossing...");
                System.out.println(p.name + " has crossed to City B.");
            }

            bridgeInUse = 1; // token moves to B
            notifyAll();     // wake up CityB thread
        }
    }

    synchronized void CityB(){
        while (!CB.isEmpty()) {
            while (bridgeInUse != 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            Person p = CB.poll();
            if (p != null) {
                System.out.println(p.name + " from City B is crossing...");
                System.out.println(p.name + " has crossed to City A.");
            }

            bridgeInUse = 0;
            notifyAll();
        }
    }


}

public class bridgeCross {
    public static void main(String[] args) throws Exception {
        Queue<Person> qp = new LinkedList<>();

        qp.add(new Person("A1", "A"));
        qp.add(new Person("A2", "A"));
        qp.add(new Person("B1", "B"));
        qp.add(new Person("A3", "A"));
        qp.add(new Person("B2", "B"));
        qp.add(new Person("B3", "B"));

        Controlsys cs = new Controlsys(qp);

        Thread t1 = new Thread(() -> cs.CityA());
        Thread t2 = new Thread(() -> cs.CityB());

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
