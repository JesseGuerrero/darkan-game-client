package com.jagex;

public class GraphicsPreference extends Preference {

    public GraphicsPreference(GamePreferences class282_sub54_1) {
        super(class282_sub54_1);
    }

    public GraphicsPreference(int i_1, GamePreferences class282_sub54_2) {
        super(i_1, class282_sub54_2);
    }

    public static void method12658() {
        Class150.method2580(-1, 255);
    }

    static boolean method12661(String string_0, int i_1) {
        return Class186.method3082(string_0, i_1, "openjs");
    }

    public void method12653() {
        if (screenType < 0 || screenType > 4) {
            screenType = getDefaultValue();
        }
    }

    @Override
    void setValue(int i_1) {
        screenType = i_1;
    }

    @Override
    int getDefaultValue() {
        return 0;
    }

    @Override
    int checkValid(int i_1) {
        return 1;
    }

    int method7784() {
        return 1;
    }

    public int method12654() {
        return screenType;
    }

    void method7780(int i_1) {
        screenType = -754033619 * i_1 * -859024475;
    }

    int method7786() {
        return 0;
    }

    int method7787() {
        return 0;
    }
}
