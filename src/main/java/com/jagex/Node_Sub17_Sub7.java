package com.jagex;

import com.jagex.clans.settings.ClanSettings;

public class Node_Sub17_Sub7 extends Node_Sub17 {

    Class348 this$0;
    int anInt10019;
    byte aByte10020;

    Node_Sub17_Sub7(Class348 class348_1) {
        this$0 = class348_1;
        anInt10019 = -1;
    }

    public static String method15439(byte[] bytes_0) {
        return Utils.readString(bytes_0, 0, bytes_0.length);
    }

    @Override
    void method12258(ClanSettings class61_1) {
        class61_1.method1209(anInt10019 * -658188401 * 458516335, aByte10020);
    }

    @Override
    void method12252(ClanSettings class61_1) {
        class61_1.method1209(anInt10019 * -658188401 * 458516335, aByte10020);
    }

    @Override
    void method12251(ClanSettings class61_1) {
        class61_1.method1209(anInt10019, aByte10020);
    }

    @Override
    void method12257(JagexNode rsbytebuffer_1) {
        anInt10019 = rsbytebuffer_1.readJagexNode() * -658188401 * 458516335;
        aByte10020 = rsbytebuffer_1.readByte();
    }

    @Override
    void method12253(JagexNode rsbytebuffer_1) {
        anInt10019 = rsbytebuffer_1.readJagexNode() * -658188401 * 458516335;
        aByte10020 = rsbytebuffer_1.readByte();
    }

    @Override
    void method12254(ClanSettings class61_1) {
        class61_1.method1209(anInt10019 * -658188401 * 458516335, aByte10020);
    }

    @Override
    void method12250(JagexNode rsbytebuffer_1) {
        anInt10019 = rsbytebuffer_1.readJagexNode();
        aByte10020 = rsbytebuffer_1.readByte();
    }

    @Override
    void method12256(ClanSettings class61_1) {
        class61_1.method1209(anInt10019 * -658188401 * 458516335, aByte10020);
    }

    @Override
    void method12249(JagexNode rsbytebuffer_1) {
        anInt10019 = rsbytebuffer_1.readJagexNode() * -658188401 * 458516335;
        aByte10020 = rsbytebuffer_1.readByte();
    }

    @Override
    void method12255(ClanSettings class61_1) {
        class61_1.method1209(anInt10019 * -658188401 * 458516335, aByte10020);
    }

}
