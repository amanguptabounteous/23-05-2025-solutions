package Assignment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

class OEMethod{
    int count = 1;
    final int maxm;

    public OEMethod(int m){
        maxm = m;
    }

    public synchronized void printOdd() {
        while (count <= maxm) {
            if (count % 2 == 0) {
                try {
                    wait();
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            } else {
                System.out.println("Odd  Thread: " + count);
                count++;
                notify();
            }
        }
    }

    public synchronized void printEven() {
        while (count <= maxm) {
            if (count % 2 != 0) {
                try {
                    wait();
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            } else {
                System.out.println("Even Thread: " + count);
                count++;
                notify();
            }
        }
    }
}

public class OddEven{
    public static void main(String[] args) throws Exception {
        OEMethod om1 = new OEMethod(10);

        Thread oddThread = new Thread(() -> om1.printOdd());
        Thread evenThread = new Thread(() -> om1.printEven());

        oddThread.start();
        evenThread.start();
    }
}
