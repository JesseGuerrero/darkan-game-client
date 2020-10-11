package com.jagex;

import com.Getlineonce;

import java.awt.*;

public enum ModeWhere {

    LIVE("LIVE", 0),
    BUILD_LIVE("BUILDLIVE", 3),
    RC("RC", 1),
    WIP("WIP", 2),
    INT_BETA("INTBETA", 4);

    public final String name;
    public final int id;

    ModeWhere(String string_1, int i_2) {
        name = string_1;
        id = i_2;
    }

    public static Frame method7852(Class470 class470_0, int width, int height, int i_3) {
        int i_31 = i_3;
        width = 1920;
        height = 1080;
        if (i_31 == 0) {
            Class467[] resolutionProfiles = Class386.method6671(class470_0);
            if (resolutionProfiles == null) {
                return null;
            }

            boolean matchesRes = false;

            for (int i = 0; i < resolutionProfiles.length; i++) {
                if (resolutionProfiles[i].resWidth == width && height == resolutionProfiles[i].resHeight && (!matchesRes || resolutionProfiles[i].anInt5573 > 0)) {
                    i_31 = resolutionProfiles[i].anInt5573;
                    matchesRes = true;
                }
            }
            if (!matchesRes) {
                return null;//dont make a frame
            }
        }

        Frame fullscreenFrame = new Frame("Darkan Full Screen");
        fullscreenFrame.setResizable(false);
        class470_0.method7808(fullscreenFrame, width, height, i_31, 0);
        return fullscreenFrame;
    }

    static byte method7853(int i_0, int i_1) {
        return (byte) (i_0 != ObjectType.WALL_INTERACT.id ? 0 : ((i_1 & 0x1) == 0 ? 1 : 2));
    }

}
