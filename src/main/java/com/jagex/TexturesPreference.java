package com.jagex;

public class TexturesPreference extends Preference {

    public TexturesPreference(GamePreferences class282_sub54_1) {
        super(class282_sub54_1);
    }

    public TexturesPreference(int i_1, GamePreferences class282_sub54_2) {
        super(i_1, class282_sub54_2);
    }

    static IComponentDefinitions method12880(IComponentDefinitions icomponentdefinitions_0) {
        IComponentDefinitions icomponentdefinitions_2 = client.method11634(icomponentdefinitions_0);
        if (icomponentdefinitions_2 == null) {
            icomponentdefinitions_2 = icomponentdefinitions_0.aClass118_1379;
        }

        return icomponentdefinitions_2;
    }

    int method7787() {
        return 1;
    }

    public void method12871() {
        if (manager.getGame() != Game.darkan) {
            screenType = 1;
        }

        if (screenType != 0 && screenType != 1) {
            screenType = getDefaultValue();
        }

    }

    @Override
    int getDefaultValue() {
        return 1;
    }

    public boolean method12872() {
        return manager.getGame() == Game.darkan;
    }

    @Override
    public int checkValid(int i_1) {
        return manager.getGame() == Game.darkan ? (i_1 != 0 && manager.groundBlending.method12762() != 1 ? 2 : 1) : 3;
    }

    public int method12873() {
        return screenType;
    }

    int method7786() {
        return 1;
    }

    public int method7784(int i_1) {
        return manager.getGame() == Game.darkan ? (i_1 != 0 && manager.groundBlending.method12762() != 1 ? 2 : 1) : 3;
    }

    void method7780(int i_1) {
        screenType = -754033619 * i_1 * -859024475;
    }

    @Override
    void setValue(int i_1) {
        screenType = i_1;
    }

}
