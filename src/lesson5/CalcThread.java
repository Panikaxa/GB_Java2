package lesson5;

public class CalcThread extends Thread {
    private float[] tempArray;

    public CalcThread(float[] tempArray){
        this.tempArray = tempArray;
    }
    @Override
    public void run() {
        for (int i = 0; i < ProgramLauncher.getHALF(); i++) {
            tempArray[i] = ProgramLauncher.calc(i);
        }
    }

    public float[] getTempArray() {
        return tempArray;
    }
}
