package com.jagex;

public class Class246 {

    public static int CAM_MOVE_ABSOLUTEY;
    static String[] aStringArray3028;

    Class246() throws Throwable {
        throw new Error();
    }

    public static FriendStatus getFriendStatus(int i_0) {
        FriendStatus[] arr_2 = Connection.method3343();
        for (int i_3 = 0; i_3 < arr_2.length; i_3++) {
            FriendStatus class461_4 = arr_2[i_3];
            if (i_0 == class461_4.id) {
                return class461_4;
            }
        }
        return null;
    }

    static void method4204(IComponentDefinitions component, int width, int height) {
        if (component.aspectXType == 0) {
            component.x = component.basePositionX;
        } else if (component.aspectXType == 1) {
            component.x = component.basePositionX + (width - component.width) / 2;
        } else if (component.aspectXType == 2) {
            component.x = width - component.width - component.basePositionX;
        } else if (component.aspectXType == 3) {
            component.x = component.basePositionX * width >> 14;
        } else if (component.aspectXType == 4) {
            component.x = (width - component.width) / 2 + (component.basePositionX * width >> 14);
        } else {
            component.x = width - component.width - (component.basePositionX * width >> 14);
        }
        if (component.aspectYType == 0) {
            component.y = component.basePositionY;
        } else if (component.aspectYType == 1) {
            component.y = (height - component.height) / 2 + component.basePositionY;
        } else if (component.aspectYType == 2) {
            component.y = height - component.height - component.basePositionY;
        } else if (component.aspectYType == 3) {
            component.y = height * component.basePositionY >> 14;
        } else if (component.aspectYType == 4) {
            component.y = (height - component.height) / 2 + (height * component.basePositionY >> 14);
        } else {
            component.y = height - component.height - (height * component.basePositionY >> 14);
        }
        if (client.aBool7168 && (client.getIComponentSettings(component).settingsHash != 0 || component.type == ComponentType.CONTAINER)) {
            if (component.x < 0) {
                component.x = 0;
            } else if (component.x + component.width > width) {
                component.x = width - component.width;
            }
            if (component.y < 0) {
                component.y = 0;
            } else if (component.height + component.y > height) {
                component.y = height - component.height;
            }
        }
    }
}
