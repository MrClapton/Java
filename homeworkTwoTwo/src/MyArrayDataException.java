public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(String message, int i, int j) {
        super(message + "( " + i + ", " + j + " )");
    }
}
