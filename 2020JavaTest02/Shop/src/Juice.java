import java.time.LocalDate;

public class Juice extends Drinks {

    public Juice( String drinkName , double cost , LocalDate PD ) {
        super( drinkName , cost , PD , 2 );
    }

    @Override
    public String toString( ) {
        return "Juice{" +
                "drinkName='" + drinkName + '\'' +
                ", cost=" + cost +
                ", PD=" + PD +
                ", EXP=" + EXP +
                '}';
    }
}
