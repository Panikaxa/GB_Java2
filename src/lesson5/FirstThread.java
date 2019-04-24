package lesson5;

public class FirstThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < ProgramLauncher.HALF; i++) {
            ProgramLauncher.tempArray1[i] = (float) (ProgramLauncher.tempArray1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
