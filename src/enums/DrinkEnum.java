package enums;

public enum DrinkEnum implements ProductEnum{

    SU("Su", 3),
    SODA("Soda",8),
    KOLA("Kola",10),
    FANTA("Fanta",10),
    LIMONATA("Limonata",15),
    PORTAKAL_SUYU("Portakal Suyu",10),
    CAY("Çay",4.5);

    private double price;
    private String name;

    DrinkEnum(String name, double price){
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return this.name = name;
    }

}
