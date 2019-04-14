package lesson2;

public class Main {
    public static void main(String[] args) {
        String[][] array = { {"1", "2", "3", "4"},
                             {"1", "2", "3", "4"},
                             {"1", "2", "3", "4"},
                             {"1", "ы", "3", "4"}, };
        try{
            System.out.println("The sum of the elements of the array: " + sumElementOfArray(array));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

    }

    public static int sumElementOfArray(String[][] array) throws MyArrayDataException, MyArraySizeException{
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array.length != 4 || array[i].length != 4)
                throw new MyArraySizeException("MyArraySizeException: Invalid array dimension");
            for (int j = 0; j < array.length ; j++) {
                if (!isInt(array[i][j]))
                    throw MyArrayDataException.forInputElement(i, j);
                sum += Integer.parseInt(array[i][j]);
            }
        }
        return sum;
    }

    public static boolean isInt(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
