package com.jagex;

public class SoundLevelPreference extends Preference {

    public SoundLevelPreference(int i_1, GamePreferences class282_sub54_2) {
        super(i_1, class282_sub54_2);
    }

    public SoundLevelPreference(GamePreferences class282_sub54_1) {
        super(class282_sub54_1);
    }

    public void method12712() {
        if (preferenceValue < 0 && preferenceValue > 127) {
            preferenceValue = getDefaultValue();
        }
    }

    @Override
    int checkValid(int i_1) {
        return 1;
    }

    @Override
    void setValue(int i_1) {
        preferenceValue = i_1;
    }

    public int method12714() {
        return preferenceValue;
    }

    int method7786() {
        return 127;
    }

    int method7784() {
        return 1;
    }

    int method7787() {
        return 127;
    }

    @Override
    int getDefaultValue() {
        return 127;
    }

    void method7780(int i_1) {
        preferenceValue = -754033619 * i_1 * -859024475;
    }
}
