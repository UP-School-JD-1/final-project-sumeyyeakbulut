public class Waiter extends Thread{

    private final int id;
    private final Restaurant restaurant;

    public Waiter(int id, Restaurant restaurant) {
        this.id = id;
        this.restaurant = restaurant;
    }

    public void takeOrder(){
        System.out.println("Waiter taking order of ");
    }
    public void serveOrder(){

    }

    @Override
    public void run() {

        takeOrder();
        //chief run olcak
        serveOrder();


    }
}
