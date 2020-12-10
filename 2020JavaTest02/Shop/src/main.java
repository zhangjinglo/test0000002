import java.time.LocalDate;

public class main {
    public static void main( String[] args ) {
        Juice newJuice = new Juice( "珍珠奶茶" , 10 , LocalDate.of( 2020 , 12 , 9 ) );
        Beer newBeer = new Beer( "雪花" , 10 , LocalDate.of( 2020 , 12 , 6 ) , 35 );
        West2FriedChickenRestauran restauran = new West2FriedChickenRestauran( );
        restauran.setBalance( 100 );
        //先给这家店进货奶茶和啤酒各1
        restauran.restock( newBeer );
        restauran.restock( newJuice );
        restauran.sell( "不辣鸡奶茶套餐" );
        restauran.sell( "辣鸡啤酒套餐" );
        //再看看奶茶啤酒卖完后，再调用sell的反应
        try {
            restauran.sell( "不辣鸡奶茶套餐" );
        } catch (DrinksSoldOutException e) {
            System.out.println( e.getMessage( ) );
        }
        //再看看进货钱不够的情况
        Juice newJuice1 = new Juice( "珍珠奶茶" , 10000 , LocalDate.of( 2020 , 12 , 9 ) );
        try {
            restauran.restock( newJuice1 );
        } catch (OverdraftBalanceException e) {
            System.out.println( e.getMessage( ) );
        }
    }
}
