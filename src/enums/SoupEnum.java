package enums;

public enum SoupEnum implements FoodEnum {

    MERCIMEK("Mercimek",7, 500),
    DOMATES("Domates",5, 500),
    EZOGELIN("Ezogelin",7, 500),
    MANTAR("Mantar",10, 500),
    TAVUK("Tavuk",15, 700);

    private double price;
    private long prepareTime;
    private String name;

    SoupEnum(String name, double price, long prepareTime){
        this.name = name;
        this.prepareTime = prepareTime;
        this.price = price;
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
