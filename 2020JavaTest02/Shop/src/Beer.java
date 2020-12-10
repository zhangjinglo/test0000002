import java.time.LocalDate;

public class Beer extends Drinks {
    float AD;//alcohol degree 酒精度数

    public Beer( String drinkName , double cost , LocalDate PD , float ad ) {
        super( drinkName , cost , PD , 30 );
        this.AD = ad;
    }

    @Override
    public String toString( ) {
        return "Beer{" +
                "AD=" + AD +
                ", drinkName='" + drinkName + '\'' +
                ", cost=" + cost +
                ", PD=" + PD +
                ", EXP=" + EXP +
                '}';
    }

}
