package com.jagex;

public class Preference_Sub14 extends Preference {

    public Preference_Sub14(GamePreferences class282_sub54_1) {
        super(class282_sub54_1);
    }

    public Preference_Sub14(int i_1, GamePreferences class282_sub54_2) {
        super(i_1, class282_sub54_2);
    }

    public void method12725() {
        if (preferenceValue < 0 || preferenceValue > 1) {
            preferenceValue = getDefaultValue();
        }

    }

    public boolean method12727() {
        return Class60.method1166(manager.currentToolkit.getValue());
    }

    @Override
    public int checkValid(int i_1) {
        return !Class60.method1166(manager.currentToolkit.getValue()) ? 3 : 1;
    }

    @Override
    void setValue(int i_1) {
        preferenceValue = i_1;
    }

    @Override
    int getDefaultValue() {
        return 1;
    }

    public int method7784() {
        return !Class60.method1166(manager.currentToolkit.getValue()) ? 3 : 1;
    }

    public int method12728() {
        return preferenceValue;
    }

    int method7786() {
        return 1;
    }

    int method7787() {
        return 1;
    }

    void method7780(int i_1) {
        preferenceValue = -754033619 * i_1 * -859024475;
    }

}
