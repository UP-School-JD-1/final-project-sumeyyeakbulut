import enums.FoodEnum;

public class Chief extends Thread {

    private final int id;
    private boolean available = true;


    public Chief(int id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void makeMeal(FoodEnum food){
        synchronized (this){
            System.out.println(" " + id + " Chief making meal.");
            available = false;
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" " + id + " Chief maked " + food.getName() + " meal.");
            available = true;
        }
    }

    @Override
    public void run() {

    }
}
