package enums;

public enum DessertEnum implements FoodEnum{

    PASTA("Pasta", 25, 300),
    BAKLAVA("Baklava",25, 400),
    KEK("Kek",20, 400);

    private double price;
    private long prepareTime;
    private String name;

    DessertEnum(String name, double price, long prepareTime){
        this.name = name;
        this.price = price;
        this.prepareTime = prepareTime;
    }
    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public long getPrepareTime() {
        return prepareTime;
    }

    @Override
    public String getName() {
        return this.name = name;
    }

}
