package designpatterns.builder.with_classic_builder_inner_class;

public class Computer {

    //Required parameters
    private String cpu;
    private int memory;

    //Optional parameters
    private int diskSize;
    private boolean isBluetoothEnabled;
    private boolean isSoundCardEnabled;
    private boolean isWifiEnabled;

    public static ComputerBuilder getBuilder(String cpu, int memory){
        return new ComputerBuilder(cpu, memory);
    }
    private Computer(ComputerBuilder builder) {
        this.cpu=builder.cpu;
        this.memory=builder.memory;
        this.diskSize = builder.diskSize;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
        this.isSoundCardEnabled = builder.isSoundCardEnabled;
        this.isWifiEnabled = builder.isWifiEnabled;

    }

    public String getCpu() {
        return cpu;
    }

    public int getMemory() {
        return memory;
    }

    public int getdiskSize() {
        return diskSize;
    }


    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }


    public boolean isSoundCardEnabled() {
        return isSoundCardEnabled;
    }


    public boolean isWifiEnabled() {
        return isWifiEnabled;
    }

    public static class ComputerBuilder {

        //Required parameters
        private String cpu;
        private int memory;

        //Optional parameters
        private int diskSize;
        private boolean isBluetoothEnabled;
        private boolean isSoundCardEnabled;
        private boolean isWifiEnabled;

        public ComputerBuilder(String cpu, int memory){
            this.cpu = cpu;
            this.memory = memory;
        }

        public ComputerBuilder withDiskSize (int diskSize){
            this.diskSize = diskSize;
            return this;
        }

        public ComputerBuilder withBluetoothEnalbed (boolean isBluetoothEnabled){
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public ComputerBuilder withsoundCardEnabled (boolean isSoundCardEnabled){
            this.isSoundCardEnabled = isSoundCardEnabled;
            return this;
        }

        public ComputerBuilder withsoundwifiEnabled(boolean isWifiEnabled) {
            this.isWifiEnabled = isWifiEnabled;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }

    }

}
