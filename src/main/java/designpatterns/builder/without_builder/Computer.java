package designpatterns.builder.without_builder;

public class Computer {

    private String CPU;
    private int memory;
    private int hdSize;
    private boolean bluetoothEnabled;
    private boolean soundCardEnabled;
    private boolean wifiEnabled;

    public Computer() {
    }

    public Computer(String CPU, int memory, int hdSize, boolean haveBluetooth, boolean soundCardEnabled, boolean wifiEnabled) {
        this.CPU = CPU;
        this.memory = memory;
        this.hdSize = hdSize;
        this.bluetoothEnabled = haveBluetooth;
        this.soundCardEnabled = soundCardEnabled;
        this.wifiEnabled = wifiEnabled;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getHdSize() {
        return hdSize;
    }

    public void setHdSize(int hdSize) {
        this.hdSize = hdSize;
    }

    public boolean isBluetoothEnabled() {
        return bluetoothEnabled;
    }

    public void setBluetoothEnabled(boolean bluetoothEnabled) {
        this.bluetoothEnabled = bluetoothEnabled;
    }

    public boolean isSoundCardEnabled() {
        return soundCardEnabled;
    }

    public void setSoundCardEnabled(boolean soundCardEnabled) {
        this.soundCardEnabled = soundCardEnabled;
    }

    public boolean isWifiEnabled() {
        return wifiEnabled;
    }

    public void setWifiEnabled(boolean wifiEnabled) {
        this.wifiEnabled = wifiEnabled;
    }
}
