package designpatterns.builder.with_classic_builder_inner_class;

public class App {

    public static void main(String[] args) {
        Computer comp1 = Computer.getBuilder("Intel", 2048).build();

        Computer comp2 = Computer.getBuilder("Intel", 2048)
        .withDiskSize(4000)
        .withBluetoothEnalbed(true).build();

    }
}
