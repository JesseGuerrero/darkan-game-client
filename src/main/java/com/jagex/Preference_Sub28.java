package com.jagex;

public class Preference_Sub28 extends Preference {

    public static int LASTLOGINLDAY;

    public Preference_Sub28(int i_1, GamePreferences class282_sub54_2) {
        super(i_1, class282_sub54_2);
    }

    public Preference_Sub28(GamePreferences class282_sub54_1) {
        super(class282_sub54_1);
    }

    public int method7784() {
        return 1;
    }

    public void method12959() {
        if (screenType != 1 && screenType != 0) {
            screenType = getDefaultValue();
        }

    }

    @Override
    int getDefaultValue() {
        return 1;
    }

    int method7787() {
        return 1;
    }

    @Override
    public int checkValid(int i_1) {
        return 1;
    }

    @Override
    void setValue(int i_1) {
        screenType = i_1;
    }

    void method7780(int i_1) {
        screenType = -754033619 * i_1 * -859024475;
    }

    int method7786() {
        return 1;
    }

    public boolean method12964() {
        return true;
    }

    public int method12966() {
        return screenType;
    }

}
