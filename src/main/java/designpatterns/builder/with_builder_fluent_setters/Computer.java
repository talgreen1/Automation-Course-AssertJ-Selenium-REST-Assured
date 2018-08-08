package designpatterns.builder.with_builder_fluent_setters;

import designpatterns.builder.utils.ComputerRandomValues;

public class Computer {

    //Required parameters
    private String cpu;
    private int memory;

    //Optional parameters
    private int diskSize;
    private boolean isBluetoothEnabled;
    private boolean isSoundCardEnabled;
    private boolean isWifiEnabled;

    public Computer(String cpu, int memory) {
        this.cpu = cpu;
        this.memory = memory;
    }

    public Computer setRandomValues() {
        this.diskSize = ComputerRandomValues.randomDiskSize();
        this.isBluetoothEnabled = ComputerRandomValues.randomBluetoothEnabled();
        this.isSoundCardEnabled = ComputerRandomValues.randomSoundCardEnabled();
        this.isWifiEnabled = ComputerRandomValues.randomWifiEnabled();
        return this;
    }


    public Computer setCPU(String cpu) {
        this.cpu = cpu;
        return this;
    }

    public Computer setMemory(int memory) {
        this.memory = memory;
        return this;
    }

    public Computer setDiskSize(int diskSize) {
        this.diskSize = diskSize;
        return this;
    }

    public Computer setBluetoothEnabled(boolean isBluetoothEnabled) {
        this.isBluetoothEnabled = isBluetoothEnabled;
        return this;
    }

    public Computer setSoundCardEnabled(boolean isSoundCardEnabled) {
        this.isSoundCardEnabled = isSoundCardEnabled;
        return this;
    }


    public Computer setWifiEnabled(boolean isWifiEnabled) {
        this.isWifiEnabled = isWifiEnabled;
        return this;
    }

    public String getCPU() {
        return cpu;
    }

    public int getMemory() {
        return memory;
    }


    public int getHdSize() {
        return diskSize;
    }


    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }

    public boolean isWifiEnabled() {
        return isWifiEnabled;
    }

    public boolean isSoundCardEnabled() {
        return isSoundCardEnabled;
    }


    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", memory=" + memory +
                ", diskSize=" + diskSize +
                ", isBluetoothEnabled=" + isBluetoothEnabled +
                ", isSoundCardEnabled=" + isSoundCardEnabled +
                ", isWifiEnabled=" + isWifiEnabled +
                '}';
    }
}
