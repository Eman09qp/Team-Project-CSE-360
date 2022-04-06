import java.util.Random;


public class coupon {
    String ID = "";
    double discount = 0.0;
    Random rand = new Random();

    public coupon(double staffDiscount){
        ID = randID();
        discount = staffDiscount;
    }

    public String randID(){
        return String.valueOf((int)Math.floor(Math.random()*(1000000-2000000+1)+2000000));
    }

    public double getDiscount(){
        return discount;
    }

    public String getID(){
        return ID;
    }
}
