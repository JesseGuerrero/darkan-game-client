package com.jagex;

import java.util.zip.Inflater;

public class Class395 {

    public static int b12FullIndex;
    Inflater deFlater;

    public static void method6772(int i_0, int i_1, int i_2, int i_3, int i_4) {
        if (i_0 >= Class532_Sub1.anInt7071 && i_1 <= Class532_Sub1.anInt7069 && i_2 >= Class532_Sub1.anInt7070 && i_3 <= Class532_Sub1.anInt7068) {
            CutsceneObject.method1564(i_0, i_1, i_2, i_3, i_4);
        } else {
            ProcessorSpecs.method7728(i_0, i_1, i_2, i_3, i_4);
        }

    }

    public byte[] method6764(byte[] bytes_1) {
        JagexNode rsbytebuffer_3 = new JagexNode(bytes_1);
        rsbytebuffer_3.index = bytes_1.length - 4;
        int i_4 = rsbytebuffer_3.method13085();
        byte[] bytes_5 = new byte[i_4];
        rsbytebuffer_3.index = 0;
        fillScript(rsbytebuffer_3, bytes_5);
        return bytes_5;
    }

    public void fillScript(JagexNode scriptArchiveNode, byte[] packedScript) {
        if (scriptArchiveNode.buffer[scriptArchiveNode.index] == 31 && scriptArchiveNode.buffer[scriptArchiveNode.index + 1] == -117) {
            if (deFlater == null) {
                deFlater = new Inflater(true);
            }

            try {
                deFlater.setInput(scriptArchiveNode.buffer, scriptArchiveNode.index + 10, scriptArchiveNode.buffer.length - (scriptArchiveNode.index + 8 + 10));
                deFlater.inflate(packedScript);
            } catch (Exception exception_5) {
                deFlater.reset();
                throw new RuntimeException("");
            }

            deFlater.reset();
        } else {
            throw new RuntimeException("");
        }
    }

}
