package enums;

public enum MainDishEnum implements FoodEnum{
    HUNKAR_BEGENDI("Hünkar Beğendi",45, 300),
    BEYTI("Beyti",45,300),
    ADANA_KEBAP("Adana Kebab",35, 250),
    URFA_KEBAB("Urfa Kebab",35, 250),
    TEPSI_KEBABI("Testi Kebabı",50, 300);

    private double price;
    private long prepareTime;
    private String name;

    MainDishEnum(String name, double price, long prepareTime){
        this.price = price;
        this.prepareTime = prepareTime;
        this.name = name;
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
        return name;
    }

    public void getName(String name) {
        this.name = name;
    }

}
