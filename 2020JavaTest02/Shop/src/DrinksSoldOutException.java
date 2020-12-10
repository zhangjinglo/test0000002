public class DrinksSoldOutException extends RuntimeException {
    public DrinksSoldOutException( ) {
    }

    public DrinksSoldOutException( String message ) {
        super( message );
    }
}
