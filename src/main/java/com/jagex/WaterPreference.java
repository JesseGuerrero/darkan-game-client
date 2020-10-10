package com.jagex;

public class WaterPreference extends Preference {

    public WaterPreference(int i_1, GamePreferences class282_sub54_2) {
        super(i_1, class282_sub54_2);
    }

    public WaterPreference(GamePreferences class282_sub54_1) {
        super(class282_sub54_1);
    }

    public void method12918() {
        if (screenType < 0 && screenType > 2) {
            screenType = getDefaultValue();
        }
    }

    @Override
    int getDefaultValue() {
        return 1;
    }

    public int getValue() {
        return screenType;
    }

    @Override
    void setValue(int i_1) {
        screenType = i_1;
    }

    public int method7784(int i_1) {
        return i_1 != 0 && manager.groundBlending.method12762() != 1 ? 2 : 1;
    }

    @Override
    public int checkValid(int i_1) {
        return i_1 != 0 && manager.groundBlending.method12762() != 1 ? 2 : 1;
    }

    public boolean method12923() {
        return true;
    }
}
