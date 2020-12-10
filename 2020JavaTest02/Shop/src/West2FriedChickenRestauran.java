import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

public class West2FriedChickenRestauran implements FriedChickenRestaurant {
    private double balance;//餐厅账目余额

    public double getBalance( ) {
        return balance;
    }

    public void setBalance( double balance ) {
        this.balance = balance;
    }

    ArrayList<Juice> juiceList = new ArrayList<>( );
    ArrayList<Beer> beerList = new ArrayList<>( );
    static ArrayList<SetMeal> mealList = new ArrayList<>( );

    static {
        Juice newJuice = new Juice( "珍珠奶茶" , 10 , LocalDate.of( 2020 , 12 , 5 ) );
        Beer newBeer = new Beer( "雪花" , 10 , LocalDate.of( 2020 , 12 , 6 ) , 35 );
        mealList.add( new SetMeal( "辣鸡啤酒套餐" , 30 , "辣鸡" , newBeer ) );
        mealList.add( new SetMeal( "不辣鸡奶茶套餐" , 33 , "不辣鸡" , newJuice ) );
    }

    @Override
    public void use( Drinks drinks ) {
        if( drinks instanceof Juice ) {
            for (int i = 0; i < juiceList.size( ); i++) {
                if( juiceList.get( i ).drinkName.equals( drinks.drinkName ) && !juiceList.get( i ).checkOutOfDate( ) ) {
                    juiceList.remove( i );
                    System.out.println( "ok" );
                    return;
                }
            }
        } else if( drinks instanceof Beer ) {
            for (int i = 0; i < beerList.size( ); i++) {
                if( beerList.get( i ).drinkName.equals( drinks.drinkName ) && !beerList.get( i ).checkOutOfDate( ) ) {
                    beerList.remove( i );
                    //System.out.println("ok" );
                    return;
                }
            }
        }
        throw new DrinksSoldOutException( "抱歉，没有符合需求的饮品" );
    }

    @Override
    public void sell( String _mealName ) throws DrinksSoldOutException {
        for (SetMeal setMeal : mealList) {
            if( setMeal.mealName.equals( _mealName ) ) {
                this.use( setMeal.drinks );
                System.out.println( "成功卖出套餐：" + setMeal.toString( ) );
            }
        }
    }

    @Override
    public void restock( Drinks drinks ) throws OverdraftBalanceException {
        if( drinks instanceof Juice ) {
            if( drinks.cost > this.balance ) {
                throw new OverdraftBalanceException( "西二炸鸡店余额不足进货" + drinks.drinkName + "还差" + (drinks.cost - this.balance) + "元" );
            } else {
                this.juiceList.add( (Juice) drinks );
            }
        } else if( drinks instanceof Beer ) {
            if( drinks.cost > this.balance ) {
                throw new OverdraftBalanceException( "西二炸鸡店余额不足进货" + drinks.drinkName + "还差" + (drinks.cost - this.balance) + "元" );
            } else {
                this.beerList.add( (Beer) drinks );
            }
        }
    }
}
