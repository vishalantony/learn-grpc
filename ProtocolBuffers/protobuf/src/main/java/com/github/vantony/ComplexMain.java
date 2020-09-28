package com.github.vantony;

import com.example.complex.ComplexMessage;
import com.example.complex.DummyMessage;
import com.example.tutorial.OneOfExample;

import java.util.Arrays;

public class ComplexMain {
    public static void main(String[] args) {
        ComplexMessage complexMessage =
                ComplexMessage
                        .newBuilder()
                        .setMainDummy(getDummy(10, "ten"))
                        .addAllOtherDummies(Arrays.asList(
                                getDummy(11, "eleven"),
                                getDummy(12, "twelve"),
                                getDummy(13, "thirteen")
                        )).build();

        System.out.println(complexMessage);

        OneOfExample.Classroom.Builder c = OneOfExample.Classroom.newBuilder();
        c.setClassroomId(123);
        c.putResults("Vishal", OneOfExample.Result.newBuilder().setName("Vishal").setGpa(4.0).build());
        c.putResults2("Vishal", OneOfExample.Result.newBuilder().setName("Vishal").setGpa(4.0).build());

        System.out.println(c.build());
    }

    private static DummyMessage getDummy(int id, String msg) {
        return DummyMessage
                .newBuilder()
                .setId(id)
                .setMsg(msg)
                .build();
    }
}
