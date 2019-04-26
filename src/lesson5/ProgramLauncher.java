package lesson5;

public class ProgramLauncher {
    private static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    private static float[] array = new float[SIZE];

    public static void main(String[] args) {
        fillArray();
        simpleCalc();
        fillArray();
        threadCalc();
    }

    private static void simpleCalc(){
        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            array[i] = calc(i);
        }
        long timeFinish = System.currentTimeMillis();
        System.out.println("simpleCalc execution time: " + (timeFinish - timeStart) + " ms");
    }

    private static void threadCalc(){
        float[] tempArray = new float[HALF];
        long timeStart = System.currentTimeMillis();
        System.arraycopy(array, 0, tempArray, 0, HALF);
        CalcThread firstThread = new CalcThread(tempArray);
        System.arraycopy(array, HALF, tempArray, 0, HALF);
        CalcThread secondThread = new CalcThread(tempArray);

        firstThread.start();
        secondThread.start();
        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tempArray = firstThread.getTempArray();
        System.arraycopy(tempArray, 0, array, 0, HALF);
        tempArray = secondThread.getTempArray();
        System.arraycopy(tempArray, 0, array, HALF, HALF);
        long timeFinish = System.currentTimeMillis();
        System.out.println("threadCalc execution time: " + (timeFinish - timeStart) + " ms");
    }

    private static void fillArray(){
        for (int i = 0; i < SIZE; i++) {
            array[i] = 1;
        }
    }

    public static float calc(int i){
        return (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }
}
