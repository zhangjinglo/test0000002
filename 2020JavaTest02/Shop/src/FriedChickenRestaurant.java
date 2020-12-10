public interface FriedChickenRestaurant {
    //出售套餐，参数可能要改
    void sell( String mealName );

    //批量进货
    void restock( Drinks drinks );

    void use( Drinks drinks );
}
