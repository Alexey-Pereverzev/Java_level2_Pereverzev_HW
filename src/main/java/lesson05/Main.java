package lesson05;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;
    public static void main(String[] args) throws InterruptedException {
        float[] arr1 = new float[size];
        float[] arr2 = new float[size];
        for (int i = 0; i < size; i++) {
            arr1[i] = 1;
            arr2[i] = 1;
        }
        method1(arr1);
        method2(arr2);
    }


    public static void method1(float[] arr) {
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long b = System.currentTimeMillis();
        System.out.println(b-a);
    }


    public static void method2(float[] arr) throws InterruptedException {
        long a = System.currentTimeMillis();
        Thread thread1 = new Thread(() -> {
            float[] arr1 = new float[h];
            System.arraycopy(arr, 0, arr1, 0, h);
            for (int i = 0; i < h; i++) {
                arr1[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(arr1, 0, arr, 0, h);
        });
        Thread thread2 = new Thread(() -> {
            float[] arr2 = new float[size-h];
            System.arraycopy(arr, h, arr2, 0, size-h);
            for (int i = 0; i < size-h; i++) {
                arr2[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(arr2, 0, arr, h, size-h);
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        long b = System.currentTimeMillis();
        System.out.println(b-a);


    }
}
