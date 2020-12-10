import java.time.LocalDate;

abstract public class Drinks {
    protected String drinkName;
    protected double cost;
    protected LocalDate PD;//Production Date 生产日期
    protected int EXP;//expiration date 保质期

    public Drinks( String drinkName , double cost , LocalDate PD , int EXP ) {
        this.drinkName = drinkName;
        this.cost = cost;
        this.PD = PD;
        this.EXP = EXP;
    }

    //默认构造器
    /*public Drinks( ) {
    }*/

    //判断是否过期，若过期，返回true
    public boolean checkOutOfDate( ) {
        LocalDate date;
        LocalDate today = LocalDate.now( );
        date = this.PD.plusDays( this.EXP );//这个date是生产日期加上保质期后的日期
        // 比较该日期是否比参数日期晚（true为晚）
        // 若date比现在的日期晚，则还没过期，返回false
        if( date.isAfter( today ) ) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    abstract public String toString( );

}
