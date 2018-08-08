package designpatterns.builder.with_builder_fluent_setters;

import javax.sound.midi.Soundbank;

public class App {
    public static void main(String[] args) {
        Computer comp1 = new Computer("Intel", 2048)
                .setDiskSize(500)
                .setBluetoothEnabled(true);

        Computer comp2 = new Computer("AMD", 1024).setRandomValues();
        Computer comp3 = new Computer("AMD", 1024).setRandomValues().setDiskSize(555);



        System.out.println("comp1: " + comp1);
        System.out.println("comp2: " + comp2);
        System.out.println("comp3: " + comp3);
    }
}
