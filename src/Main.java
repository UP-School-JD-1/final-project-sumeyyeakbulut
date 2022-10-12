import java.util.ArrayList;
import java.util.Random;

public class Main {
    private static Random random = new Random();

    public static void main(String[] args) {

        java.util.Scanner kb = new java.util.Scanner(System.in);
        System.out.print("Enter the table count of restaurant:");
        int tableCount = Integer.parseInt(kb.nextLine());

        System.out.print("Enter the customer count of restaurant:");
        int customerCount = Integer.parseInt(kb.nextLine());

        Restaurant restaurant = new Restaurant(tableCount);

        ArrayList<Customer> arrayList = new ArrayList<>(customerCount);
        for (int i = 0; i < customerCount; i++) {
            arrayList.add(new Customer(i, restaurant));
        }


        System.out.println(" Simulation just started!");
        arrayList.forEach(Thread::start);

        arrayList.forEach(customer -> {
            try {
                customer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(" Restaurant earn " + restaurant.getCash());
        System.out.println(" Simulation just ended!");
    }

}