package com.github.vantony;

import com.example.simple.DaysOfWeek;
import com.example.simple.SimpleProto;
import com.example.simple.Weekday;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class SimpleMain {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        SimpleProto.Builder builder = SimpleProto.newBuilder();
        builder.setId(42);
        builder.setName("Simple Name");
        builder.setIsSimple(true);

        // simple fields
        builder.setId(42)
                .setName("Simple Name")
                .setIsSimple(true)
                .addSampleList(10).addSampleList(12)
                .addAllSampleList(Arrays.asList(1, 2, 3));

        System.out.println(builder.toString());
        SimpleProto simpleProtoMessage = builder.build();

        try {
            FileOutputStream outputStream = new FileOutputStream("simple_message.bin");
            simpleProtoMessage.writeTo(outputStream);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("simple_message.bin");
            SimpleProto messageFromFile = SimpleProto.parseFrom(fileInputStream);
            System.out.println("Message from file: " + messageFromFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Weekday.Builder weekdayBuilder = Weekday.newBuilder();
        weekdayBuilder.setDay(DaysOfWeek.MONDAY)
                .setId(1);

        Weekday weekday = weekdayBuilder.build();
        System.out.println(weekday);


    }
}
