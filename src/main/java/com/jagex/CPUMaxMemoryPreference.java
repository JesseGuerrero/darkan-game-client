package com.jagex;

public class CPUMaxMemoryPreference extends Preference {

    public CPUMaxMemoryPreference(int i_1, GamePreferences class282_sub54_2) {
        super(i_1, class282_sub54_2);
    }

    public CPUMaxMemoryPreference(GamePreferences class282_sub54_1) {
        super(class282_sub54_1);
    }

    public void method12648() {
        if (screenType < 0 && screenType > 4) {
            screenType = getDefaultValue();
        }

    }

    @Override
    int getDefaultValue() {
        return manager.getProcessorSpecs().getProcessorCount() > 1 ? 4 : 2;
    }

    void method7780(int i_1) {
        screenType = -754033619 * i_1 * -859024475;
    }

    @Override
    int checkValid(int i_1) {
        return 1;
    }

    int method7784() {
        return 1;
    }

    int method7786() {
        return manager.getProcessorSpecs().getProcessorCount() > 1 ? 4 : 2;
    }

    int method7787() {
        return manager.getProcessorSpecs().getProcessorCount() > 1 ? 4 : 2;
    }

    public int getValue() {
        return screenType;
    }

    @Override
    void setValue(int i_1) {
        screenType = i_1;
    }

}
