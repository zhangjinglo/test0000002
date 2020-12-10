public class SetMeal {
    String mealName;
    double mealPrice;
    String friedChickenName;
    Drinks drinks;

    public SetMeal( String mealName , double mealPrice , String friedChickenName , Drinks drinks ) {
        this.mealName = mealName;
        this.mealPrice = mealPrice;
        this.friedChickenName = friedChickenName;
        this.drinks = drinks;
    }

    @Override
    public String toString( ) {
        return "SetMeal{" +
                "套餐名='" + mealName + '\'' +
                ", 套餐价格=" + mealPrice +
                ", 炸鸡名='" + friedChickenName + '\'' +
                ", 饮料=" + drinks +
                '}';
    }
}
