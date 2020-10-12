package com.jagex;

public class Class484 {

    Class484() throws Throwable {
        throw new Error();
    }

    static void initSizes(IComponentDefinitions component, int width, int height, boolean bool_3) {
        int compWidth = component.width;
        int compHeight = component.height;
        if (component.aspectWidthType == 0) {
            component.width = component.baseWidth;
        } else if (component.aspectWidthType == 1) {
            component.width = width - component.baseWidth;
        } else if (component.aspectWidthType == 2) {
            component.width = component.baseWidth * width >> 14;
        }
        if (component.aspectHeightType == 0) {
            component.height = component.baseHeight;
        } else if (component.aspectHeightType == 1) {
            component.height = height - component.baseHeight;
        } else if (component.aspectHeightType == 2) {
            component.height = height * component.baseHeight >> 14;
        }
        if (component.aspectWidthType == 4) {
            component.width = component.aspectX * component.height / component.aspectY;
        }
        if (component.aspectHeightType == 4) {
            component.height = component.width * component.aspectY / component.aspectX;
        }
        if (client.aBool7168 && (client.getIComponentSettings(component).settingsHash != 0 || component.type == ComponentType.CONTAINER)) {
            if (component.height < 5 && component.width < 5) {
                component.height = 5;
                component.width = 5;
            } else {
                if (component.height <= 0) {
                    component.height = 5;
                }
                if (component.width <= 0) {
                    component.width = 5;
                }
            }
        }
        if (component.contentType == IComponentDefinitions.CONTENT_TYPE_1337) {
            client.GAME_SCREEN_INTERFACE = component;
        }
        if (bool_3 && component.anObjectArray1271 != null && (compWidth != component.width || compHeight != component.height)) {
            HookRequest hookrequest_7 = new HookRequest();
            hookrequest_7.source = component;
            hookrequest_7.params = component.anObjectArray1271;
            client.PENDING_HOOK_REQUESTS.append(hookrequest_7);
        }
    }
}
