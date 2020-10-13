package com.jagex;

import com.Loader;

import java.awt.*;
import java.util.Date;

public class SkyboxIndexLoader {

    public static FontMetrics aClass414_3438;
    LRUCache aClass229_3437 = new LRUCache(16);
    Index aClass317_3436;

    public SkyboxIndexLoader(Index index_3) {
        aClass317_3436 = index_3;
        aClass317_3436.filesCount(SharedConfigsType.SKYBOX.id);
    }

    static void method5083(long long_0) {
        Class407.aCalendar4846.setTime(new Date(long_0));
    }

    public static Interface getInterface(int interfaceId, int[] xteas, Interface currentInter, boolean unreactive) {
        Interface interfaceObj = currentInter;
        if (!Class388.INTERFACE_INDEX.loadArchive(interfaceId)) {
            return null;
        } else {
            int componentSize = Class388.INTERFACE_INDEX.filesCount(interfaceId);
            IComponentDefinitions[] interComponents;
            if (componentSize == 0) {
                interComponents = new IComponentDefinitions[0];
            } else if (interfaceObj == null) {
                interComponents = new IComponentDefinitions[componentSize];
            } else {
                interComponents = interfaceObj.components;
            }
            if (interfaceObj == null) {
                interfaceObj = new Interface(unreactive, interComponents);
            } else {
                interfaceObj.components = interComponents;
                interfaceObj.isUnreactive = unreactive;
            }

            boolean becameLogin = false;
            for (int i = 0; i < componentSize; i++) {
                if (interfaceObj.components[i] == null) {
                    byte[] bytes_8 = Class388.INTERFACE_INDEX.getFile(interfaceId, i, xteas);
                    if (bytes_8 != null) {
                        IComponentDefinitions component = interfaceObj.components[i] = new IComponentDefinitions();
                        component.idHash = i + (interfaceId << 16);
                        component.readValues(new JagexNode(bytes_8));


                        /*
                        * 746 Resizable interface
                        * 744 Login interface
                        * 548 Fixed interface
                        * 906 Lobby interface
                        * */

                        if(interfaceId == 667 && component.type == ComponentType.CONTAINER && component.onLoadScript != null) {
//                            System.out.println(i + " : ;;;" + component.onLoadScript[0]);
                            if(i == 6) {
//                                component.hidden = true;
                            }
                        }

                        if(interfaceId == 667) {
                            if(component.type == ComponentType.CONTAINER) {


//                                System.out.println(i);
//                                component.transparency = 1;
                            }

                        }

//                        System.out.println(interfaceId);
                        //Game Window inteface, fixed
                        if((component.idHash == 48889904 && interfaceId == 548)) {
                            component.baseHeight=0;
                            component.hidden = true;

                        }

                        //Game Window Interface, not fixed
                        if(component.idHash == 48889904 && interfaceId !=548) {
                            component.basePositionY = 0;
                            component.baseHeight = 0;
                            component.hidden = false;
                            Loader.inGame = true;
                        }

                        //if we are in the login screen
                        if(interfaceId == 744) {
                            becameLogin = true;
                            Loader.client_panel.setPreferredSize(new Dimension(765, 553));
                        }

                        //Lobby/Fixed Window interface Hashes. Lobby and fixed share the same hashes
                        if(component.idHash == 59375616 || component.idHash == 35913932 || component.idHash == 59768835 || component.idHash == 38600709) {
                            component.basePositionY = 0;

                            //if you enter the lobby you must resize
                            Loader.client_panel.setPreferredSize(new Dimension(765, 503));

                            Dimension frameSize = Loader.clientFrame.getSize();

                            //592 is default frame height, if we are at default and we are at first login and we are in lobby
                            if(Loader.firstLobby == true && frameSize.height == 592) {
                                Loader.firstLobby = false;
                                Loader.clientFrame.setSize(frameSize.width, 503);
                                Loader.clientFrame.pack();
                            }

                        }

                        //Banner at top hashes
                        if(component.idHash == 59375617 || component.idHash == 48890095 || component.idHash == 35913730) {
                            component.baseHeight = 0;
                        }

                        //Always make sure lobby is tight, 50 is what is left over
                        if(interfaceId == 906 && component.baseHeight == 50) {
                                component.baseHeight = 0;
                        }

                    }

                }
            }
            if(interfaceId == 667) {
                interfaceObj = interfaceObj;

            }
            return interfaceObj;
        }
    }

    public void method5068() {
        LRUCache softcache_3 = aClass229_3437;
        synchronized (aClass229_3437) {
            aClass229_3437.method3858(5);
        }
    }

    public void method5070() {
        LRUCache softcache_2 = aClass229_3437;
        synchronized (aClass229_3437) {
            aClass229_3437.method3859();
        }
    }

    public void method5071() {
        LRUCache softcache_2 = aClass229_3437;
        synchronized (aClass229_3437) {
            aClass229_3437.method3863();
        }
    }

    SkyboxDefinitions method5072(int i_1) {
        LRUCache softcache_4 = aClass229_3437;
        SkyboxDefinitions class207_3;
        synchronized (aClass229_3437) {
            class207_3 = (SkyboxDefinitions) aClass229_3437.get(i_1);
        }
        if (class207_3 != null) {
            return class207_3;
        } else {
            Index index_5 = aClass317_3436;
            byte[] bytes_10;
            synchronized (aClass317_3436) {
                bytes_10 = aClass317_3436.getFile(SharedConfigsType.SKYBOX.id, i_1);
            }
            class207_3 = new SkyboxDefinitions();
            if (bytes_10 != null) {
                class207_3.method3549(new JagexNode(bytes_10));
            }
            LRUCache softcache_9 = aClass229_3437;
            synchronized (aClass229_3437) {
                aClass229_3437.put(class207_3, i_1);
                return class207_3;
            }
        }
    }

    public Class247 method5077(int i_1, int i_2, int i_3, int i_4, SunIndexLoader class45_5) {
        Class334[] arr_7 = null;
        SkyboxDefinitions class207_8 = method5072(i_1);
        if (class207_8.anIntArray2655 != null) {
            arr_7 = new Class334[class207_8.anIntArray2655.length];
            for (int i_9 = 0; i_9 < arr_7.length; i_9++) {
                SunDefinitions class38_10 = class45_5.method914(class207_8.anIntArray2655[i_9]);
                arr_7[i_9] = new Class334(class38_10.anInt395, class38_10.anInt402, class38_10.anInt401, class38_10.anInt397, class38_10.anInt399, class38_10.anInt396, class38_10.anInt404, class38_10.aBool400, class38_10.anInt403, class38_10.anInt398, class38_10.anInt405);
            }
        }
        return new Class247(class207_8.anInt2653, arr_7, class207_8.anInt2654, i_2, i_3, i_4, class207_8.aClass204_2656, class207_8.anInt2657);
    }
}
