package designpatterns.builder.without_builder;

public class App {
    public static void main(String[] args) {
        Computer comp1 = new Computer("Intel", 2048, 500, false, true, true);

        Computer comp2 = new Computer();
        comp2.setCPU("AMD");
        comp2.setMemory(1024);
        comp2.setHdSize(1000);
        comp2.setBluetoothEnabled(false);
        comp2.setSoundCardEnabled(false);
        comp2.setWifiEnabled(false);

    }
}
