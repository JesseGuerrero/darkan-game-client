package com.jagex;

import com.Loader;
import com.jagex.clans.settings.ClanSettings;

public class Node_Sub17_Sub6 extends Node_Sub17 {

    boolean aBool10016;
    byte aByte10015;
    byte aByte10014;
    byte aByte10017;
    byte aByte10018;
    Class348 this$0;

    Node_Sub17_Sub6(Class348 class348_1) {
        this$0 = class348_1;
    }

    static byte[] method15438(byte[] scriptArchive) {
        try {
            JagexNode scriptArchiveNode = new JagexNode(scriptArchive);
            int i_3 = scriptArchiveNode.readUnsignedByte();
            int i_4 = scriptArchiveNode.readInt();
            if (i_4 >= 0 && (Index.anInt3689 == 0 || i_4 <= Index.anInt3689)) {
                if (i_3 == 0) {
                    byte[] bytes_5 = new byte[i_4];
                    scriptArchiveNode.readBytes(bytes_5, 0, i_4);
                    return bytes_5;
                } else {
                    int packedScriptInfoLength = scriptArchiveNode.readInt();
                    if (packedScriptInfoLength < 0 || Index.anInt3689 != 0 && packedScriptInfoLength > Index.anInt3689) {
                        throw new RuntimeException();
                    } else {
                        byte[] packedScript = new byte[packedScriptInfoLength];
                        if (i_3 == 1) {
                            Class471.method7828(packedScript, packedScriptInfoLength, scriptArchive);
                        } else {
                            Class395 class395_7 = Index.aClass395_3684;
                            synchronized (Index.aClass395_3684) {
                                Index.aClass395_3684.fillScript(scriptArchiveNode, packedScript);
                            }
                        }
                        return packedScript;
                    }
                }
            } else {
                throw new RuntimeException();
            }
        } catch (Throwable throwable_10) {
            if (Loader.DISABLE_XTEA_CRASH) {
                return new byte[100];
            } else {
                throw new RuntimeException();
            }
        }
    }

    @Override
    void method12253(JagexNode rsbytebuffer_1) {
        aBool10016 = rsbytebuffer_1.readUnsignedByte() == 1;
        aByte10015 = rsbytebuffer_1.readByte();
        aByte10014 = rsbytebuffer_1.readByte();
        aByte10017 = rsbytebuffer_1.readByte();
        aByte10018 = rsbytebuffer_1.readByte();
    }

    @Override
    void method12252(ClanSettings class61_1) {
        class61_1.allowGuests = aBool10016;
        class61_1.talkRank = aByte10015;
        class61_1.kickRank = aByte10014;
        class61_1.lootshareRank = aByte10017;
        class61_1.coinShare = aByte10018;
    }

    @Override
    void method12251(ClanSettings class61_1) {
        class61_1.allowGuests = aBool10016;
        class61_1.talkRank = aByte10015;
        class61_1.kickRank = aByte10014;
        class61_1.lootshareRank = aByte10017;
        class61_1.coinShare = aByte10018;
    }

    @Override
    void method12249(JagexNode rsbytebuffer_1) {
        aBool10016 = rsbytebuffer_1.readUnsignedByte() == 1;
        aByte10015 = rsbytebuffer_1.readByte();
        aByte10014 = rsbytebuffer_1.readByte();
        aByte10017 = rsbytebuffer_1.readByte();
        aByte10018 = rsbytebuffer_1.readByte();
    }

    @Override
    void method12257(JagexNode rsbytebuffer_1) {
        aBool10016 = rsbytebuffer_1.readUnsignedByte() == 1;
        aByte10015 = rsbytebuffer_1.readByte();
        aByte10014 = rsbytebuffer_1.readByte();
        aByte10017 = rsbytebuffer_1.readByte();
        aByte10018 = rsbytebuffer_1.readByte();
    }

    @Override
    void method12250(JagexNode rsbytebuffer_1) {
        aBool10016 = rsbytebuffer_1.readUnsignedByte() == 1;
        aByte10015 = rsbytebuffer_1.readByte();
        aByte10014 = rsbytebuffer_1.readByte();
        aByte10017 = rsbytebuffer_1.readByte();
        aByte10018 = rsbytebuffer_1.readByte();
    }

    @Override
    void method12256(ClanSettings class61_1) {
        class61_1.allowGuests = aBool10016;
        class61_1.talkRank = aByte10015;
        class61_1.kickRank = aByte10014;
        class61_1.lootshareRank = aByte10017;
        class61_1.coinShare = aByte10018;
    }

    @Override
    void method12258(ClanSettings class61_1) {
        class61_1.allowGuests = aBool10016;
        class61_1.talkRank = aByte10015;
        class61_1.kickRank = aByte10014;
        class61_1.lootshareRank = aByte10017;
        class61_1.coinShare = aByte10018;
    }

    @Override
    void method12254(ClanSettings class61_1) {
        class61_1.allowGuests = aBool10016;
        class61_1.talkRank = aByte10015;
        class61_1.kickRank = aByte10014;
        class61_1.lootshareRank = aByte10017;
        class61_1.coinShare = aByte10018;
    }

    @Override
    void method12255(ClanSettings class61_1) {
        class61_1.allowGuests = aBool10016;
        class61_1.talkRank = aByte10015;
        class61_1.kickRank = aByte10014;
        class61_1.lootshareRank = aByte10017;
        class61_1.coinShare = aByte10018;
    }
}
