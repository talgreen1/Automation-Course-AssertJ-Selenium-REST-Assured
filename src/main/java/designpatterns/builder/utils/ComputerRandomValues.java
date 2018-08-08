package designpatterns.builder.utils;

import java.util.Random;

public class ComputerRandomValues {
    private static Random rnd = new Random();

    public static int randomDiskSize(){
        return rnd.nextInt(5000);
    }
    public static boolean randomWifiEnabled() {
        return randomBoolean();
    }

    public static boolean randomSoundCardEnabled() {
        return randomBoolean();
    }

    public static boolean randomBluetoothEnabled() {
        return randomBoolean();
    }

    private static boolean randomBoolean() {
        return rnd.nextBoolean();
    }
}
