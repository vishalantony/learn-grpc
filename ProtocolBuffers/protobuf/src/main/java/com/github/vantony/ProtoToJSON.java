package com.github.vantony;

import com.example.complex.ComplexMessage;
import com.example.complex.DummyMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

import java.util.Arrays;

public class ProtoToJSON {
    public static void main(String[] args) {
        ComplexMessage.Builder complexMessageBuilder = ComplexMessage
                .newBuilder()
                .setMainDummy(getDummy(10, "ten"))
                .addAllOtherDummies(Arrays.asList(
                        getDummy(11, "eleven"),
                        getDummy(12, "twelve"),
                        getDummy(13, "thirteen")
                ));

        ComplexMessage complexMessage = complexMessageBuilder.build();

        System.out.println(complexMessage);
        String jsonString = null;

        try {
            jsonString = JsonFormat.printer().print(complexMessage);
            System.out.println("Json format::\n" + jsonString);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

        ComplexMessage.Builder complexMessageBuilderFromJson = ComplexMessage
                .newBuilder();

        try {
            System.out.println("Building from Json::\n");
            JsonFormat.parser().ignoringUnknownFields().merge(jsonString,
                    complexMessageBuilderFromJson);
            System.out.println(complexMessageBuilderFromJson.build());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }

    private static DummyMessage getDummy(int id, String msg) {
        return DummyMessage
                .newBuilder()
                .setId(id)
                .setMsg(msg)
                .build();
    }
}
