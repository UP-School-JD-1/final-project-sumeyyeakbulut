import enums.DrinkEnum;
import enums.FoodEnum;

public class Customer extends Thread {

    private final int number;
    private final Restaurant restaurant;
    String name;
    private boolean sitToTable = false;

    public Customer(int number, Restaurant restaurant) {
        this.number = number;
        this.restaurant = restaurant;
        this.name = " Number:" + number;
    }

    public void giveOrder(){
        FoodEnum food = restaurant.chooseMeal();
        DrinkEnum drink = restaurant.chooseDrink();
        System.out.println(name + " customer " + food.getName() + " gave the order.");
        System.out.println(name + " customer " + drink.name() + " gave the order.");

        for (; ; ) {
            boolean flag = false;
            for (Chief chief : restaurant.getChiefList())

                if (chief.isAvailable()) {
                    chief.makeMeal(food);
                    flag = true;
                    break;
                }
            if (flag)
                break;
        }

        try {
            sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double priceToPay = food.getPrice() + drink.getPrice();

        System.out.println(name + " customer " + priceToPay + " will payed.");
        restaurant.addMoneyToCash(priceToPay);
    }

    @Override
    public void run() {

        System.out.println(name + " customer entered the restaurant. ");
        while (!sitToTable) {
            sitToTable = restaurant.setCustomerToTable(this);
        }
        giveOrder();
        restaurant.unsetCustomersToTable(this);
    }


}

