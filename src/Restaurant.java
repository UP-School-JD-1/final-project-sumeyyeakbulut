import enums.DrinkEnum;
import enums.FoodEnum;
import enums.SoupEnum;

import java.util.ArrayList;
import java.util.Random;

public class Restaurant {

    private final ArrayList<Table> tableList;
    private final ArrayList<Chief> chiefList;
    private final ArrayList<Waiter> waiterList;
    private double cash;

    private static int availableTableCount;

    public Restaurant(int tableCount) {

        tableList = new ArrayList<>();
        for (int i = 0; i < tableCount; i++) {
            tableList.add(new Table(i));
        }
        availableTableCount = tableCount;

        chiefList = new ArrayList<>();
        for (int i = 0; i < tableCount / 2; i++) {
            chiefList.add(new Chief(i));
        }

        waiterList = new ArrayList<>();
        for (int i = 0; i < tableCount / 2; i++) {
            waiterList.add(new Waiter(i, this));
        }
    }

    public void addMoneyToCash(double money) {
        this.cash += money;
    }

    public double getCash() {
        return cash;
    }

    public ArrayList<Chief> getChiefList() {
        return chiefList;
    }

    public boolean setCustomerToTable(Customer customer) {

        if (availableTableCount > 0)
            for (Table table : tableList)
                synchronized (table) {
                    if (!table.isFlag()) {
                        table.setCustomer(customer);
                        table.setFlag(true);
                        System.out.println(customer.name + " customer sat at table "
                                + table.getNumber());
                        availableTableCount--;
                        return true;
                    }
                }
        else {
            System.out.println(customer.name + " customer cant sit down! All tables are full!");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    public void unsetCustomersToTable(Customer customer) {

        for (Table table : tableList) {
            synchronized (table) {
                if (table.getCustomer() == customer) {

                    System.out.println();
                    table.setCustomer(null);
                    table.setFlag(false);
                    System.out.println(customer.name + " customer "
                            + table.getNumber() + " left the table.");
                    availableTableCount++;
                }
            }
        }


    }

    public FoodEnum chooseMeal() {

        FoodEnum meal;
        Random r = new Random();
        int i = r.nextInt(6);

        switch (i) {
            case 1:
                meal = SoupEnum.DOMATES;
                break;
            case 2:
                meal = SoupEnum.EZOGELIN;
                break;
            case 3:
                meal = SoupEnum.MERCIMEK;
                break;
            case 4:
                meal = SoupEnum.TAVUK;
                break;
            default:
                meal = SoupEnum.MANTAR;
                break;
        }

        return meal;
    }

    public DrinkEnum chooseDrink(){

        DrinkEnum drinkEnum;
        Random r = new Random();
        int i = r.nextInt(8);

        switch (i) {
            case 1:
                drinkEnum = DrinkEnum.FANTA;
                break;
            case 2:
                drinkEnum = DrinkEnum.CAY;
                break;
            case 3:
                drinkEnum = DrinkEnum.KOLA;
                break;
            case 4:
                drinkEnum = DrinkEnum.LIMONATA;
                break;
            case 5:
                drinkEnum = DrinkEnum.SODA;
                break;
            case 6:
                drinkEnum = DrinkEnum.PORTAKAL_SUYU;
                break;
            default:
                drinkEnum = DrinkEnum.SU;
                break;
        }

        return drinkEnum;
    }

}
