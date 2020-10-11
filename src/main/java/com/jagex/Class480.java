package com.jagex;

public class Class480 {

    static char[] aCharArray5716 = new char[64];

    static char[] aCharArray5717;

    static int[] anIntArray5715;

    static {
        int i_0;
        for (i_0 = 0; i_0 < 26; i_0++) {
            aCharArray5716[i_0] = (char) (i_0 + 65);
        }
        for (i_0 = 26; i_0 < 52; i_0++) {
            aCharArray5716[i_0] = (char) (i_0 + 97 - 26);
        }
        for (i_0 = 52; i_0 < 62; i_0++) {
            aCharArray5716[i_0] = (char) (i_0 + 48 - 52);
        }
        aCharArray5716[62] = 43;
        aCharArray5716[63] = 47;
        aCharArray5717 = new char[64];
        for (i_0 = 0; i_0 < 26; i_0++) {
            aCharArray5717[i_0] = (char) (i_0 + 65);
        }
        for (i_0 = 26; i_0 < 52; i_0++) {
            aCharArray5717[i_0] = (char) (i_0 + 97 - 26);
        }
        for (i_0 = 52; i_0 < 62; i_0++) {
            aCharArray5717[i_0] = (char) (i_0 + 48 - 52);
        }
        aCharArray5717[62] = 42;
        aCharArray5717[63] = 45;
        anIntArray5715 = new int[128];
        for (i_0 = 0; i_0 < anIntArray5715.length; i_0++) {
            anIntArray5715[i_0] = -1;
        }
        for (i_0 = 65; i_0 <= 90; i_0++) {
            anIntArray5715[i_0] = i_0 - 65;
        }
        for (i_0 = 97; i_0 <= 122; i_0++) {
            anIntArray5715[i_0] = i_0 - 97 + 26;
        }
        for (i_0 = 48; i_0 <= 57; i_0++) {
            anIntArray5715[i_0] = i_0 - 48 + 52;
        }
        int[] ints_2 = anIntArray5715;
        anIntArray5715[43] = 62;
        ints_2[42] = 62;
        int[] ints_1 = anIntArray5715;
        anIntArray5715[47] = 63;
        ints_1[45] = 63;
    }

    Class480() throws Throwable {
        throw new Error();
    }

    public static void method8043() {
        String string_1 = Class445.aString5384 != null ? Class445.aString5384 : MapAreaDefinitions.method3741();
        WorldMapDef.method14788(string_1, false, client.aBool7158);
    }

    static void method8044(IComponentDefinitions[] interComponenents, IComponentDefinitions component, boolean bool_2) {
        int width = component.scrollWidth != 0 ? component.scrollWidth : component.width;
        int height = component.scrollHeight != 0 ? component.scrollHeight : component.height;
        InteractableObject.method16099(interComponenents, component.idHash, width, height, bool_2);
        if (component.itemSlots != null) {
            InteractableObject.method16099(component.itemSlots, component.idHash, width, height, bool_2);
        }
        SubInterface class282_sub44_6 = (SubInterface) client.OPEN_INTERFACES.get(component.idHash);
        if (class282_sub44_6 != null) {
            Class442.method7403(class282_sub44_6.interfaceId, width, height, bool_2);
        }
        if (component == client.GAME_SCREEN_INTERFACE) {
            int playerCount = Class197.NUM_PLAYER_INDICES;
            int[] playerIndex = Class197.PLAYER_INDICES;
            for (int i = 0; i < playerCount; i++) {
                PlayerEntity player = client.players[playerIndex[i]];
                if (player != null) {
                    player.method15795(width, height, bool_2);
                }
            }
            for (int i = 0; i < client.NPC_UPDATE_INDEX; i++) {
                int i_10 = client.NPC_UPDATE_INDICES[i];
                ObjectNode class282_sub47_11 = (ObjectNode) client.NPC_MAP.get(i_10);
                if (class282_sub47_11 != null) {
                    ((PathingEntity) class282_sub47_11.anObject8068).method15795(width, height, bool_2);
                }
            }
        }
    }

    public static MapSize getMapSize(int i_0) {
        MapSize[] arr_2 = MapSize.values();
        for (int i_3 = 0; i_3 < arr_2.length; i_3++) {
            MapSize class106_4 = arr_2[i_3];
            if (i_0 == class106_4.index) {
                return class106_4;
            }
        }
        return null;
    }
}
