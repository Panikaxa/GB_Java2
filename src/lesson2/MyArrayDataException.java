package lesson2;

public class MyArrayDataException extends Exception {

    public MyArrayDataException(String message){
        super(message);
    }

    static MyArrayDataException forInputElement(int i, int j) {
        return new MyArrayDataException("MyArrayDataException: " +
                "Array element is not a number : [" + i + "]" + "[" + j + "]");
    }
}
