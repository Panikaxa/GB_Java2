package lesson5;

public class ProgramLauncher {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    static float[] array = new float[SIZE];
    static float[] tempArray1 = new float[HALF];
    static float[] tempArray2 = new float[HALF];

    public static void main(String[] args) {
        fillArray();
        simpleCalc();
        fillArray();
        threadCalc();
    }

    private static void simpleCalc(){
        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long timeFinish = System.currentTimeMillis();
        System.out.println("simpleCalc execution time: " + (timeFinish - timeStart) + " ms");
    }

    private static void threadCalc(){
        long timeStart = System.currentTimeMillis();
        System.arraycopy(array, 0, tempArray1, 0, HALF);
        System.arraycopy(array, HALF, tempArray2, 0, HALF);
        new FirstThread().start();
        new SecondThread().start();
        System.arraycopy(tempArray1, 0, array, 0, HALF);
        System.arraycopy(tempArray2, 0, array, HALF, HALF);
        long timeFinish = System.currentTimeMillis();
        System.out.println("threadCalc execution time: " + (timeFinish - timeStart) + " ms");
    }

    private static void fillArray(){
        for (int i = 0; i < SIZE; i++) {
            array[i] = 1;
        }
    }
}
