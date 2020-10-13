package com.jagex;

public class CS2Script extends CacheableNode {

    public ClientTriggerType aClass397_9527;
    public int intLocalsCount;
    public int stringLocalsCount;
    public int longLocalsCount;
    public int intArgsCount;
    public int stringArgsCount;
    public int longArgsCount;
    public IterableNodeMap[] switchMaps;
    public String scriptName;
    public CS2Instruction[] operations;
    public Object[] stringOperationIndex;
    public int[] intOperationIndex;
    public long[] longOperationIndex;

    public CS2Script(JagexNode scriptInfo) {
        int i_2 = decodeHeader(scriptInfo);
        int opIndex = 0;

        for (; scriptInfo.index < i_2; opIndex++) {
            CS2Instruction operation = getOpcode(scriptInfo);
            setOperationsIndex(scriptInfo, opIndex, operation);
        }

    }

    CS2Instruction getOpcode(JagexNode scriptInfo) {
        int opCode = scriptInfo.readJagexNode();
        CS2Instruction operation = CS2Instruction.getByOpcode(opCode);
        if (operation != null) {
            return operation;
        } else {
            throw new RuntimeException("");
        }
    }

    int decodeHeader(JagexNode scriptInfo) {
        scriptInfo.index = scriptInfo.buffer.length - 2;
        int i_2 = scriptInfo.readJagexNode();
        int i_3 = scriptInfo.buffer.length - 2 - i_2 - 16;
        scriptInfo.index = i_3;
        int i_4 = scriptInfo.readInt();
        intLocalsCount = scriptInfo.readJagexNode();
        stringLocalsCount = scriptInfo.readJagexNode();
        longLocalsCount = scriptInfo.readJagexNode();
        intArgsCount = scriptInfo.readJagexNode();
        stringArgsCount = scriptInfo.readJagexNode();
        longArgsCount = scriptInfo.readJagexNode();
        int i_5 = scriptInfo.readUnsignedByte();
        if (i_5 > 0) {
            switchMaps = new IterableNodeMap[i_5];

            for (int i_6 = 0; i_6 < i_5; i_6++) {
                int i_7 = scriptInfo.readJagexNode();
                IterableNodeMap iterablenodemap_8 = new IterableNodeMap(Utils.nextPowerOfTwo(i_7));
                switchMaps[i_6] = iterablenodemap_8;

                while (i_7-- > 0) {
                    int i_9 = scriptInfo.readInt();
                    int i_10 = scriptInfo.readInt();
                    iterablenodemap_8.put(new IntNode(i_10), i_9);
                }
            }
        }

        scriptInfo.index = 0;
        scriptName = scriptInfo.readNullString();
        operations = new CS2Instruction[i_4];
        return i_3;
    }

    void setOperationsIndex(JagexNode scriptInfo, int opIndex, CS2Instruction operation) {
        int scriptLength = operations.length;
        if (operation == CS2Instruction.PUSH_STRING) {
            if (stringOperationIndex == null) {
                stringOperationIndex = new String[scriptLength];
            }

            String scriptText = scriptInfo.readString();
            if (scriptText.toLowerCase().contains("runescape")) {
                scriptText = scriptText.replace("runescape", "Darkan");
                scriptText = scriptText.replace("RuneScape", "Darkan");
                scriptText = scriptText.replace("Runescape", "Darkan");
            }

            stringOperationIndex[opIndex] = scriptText.intern();
        } else if (operation == CS2Instruction.PUSH_LONG) {
            if (longOperationIndex == null) {
                longOperationIndex = new long[scriptLength];
            }

            longOperationIndex[opIndex] = scriptInfo.readLong();
        } else {
            if (intOperationIndex == null) {
                intOperationIndex = new int[scriptLength];
            }

            if (operation.hasIntConstant) {
                intOperationIndex[opIndex] = scriptInfo.readInt();
            } else {
                intOperationIndex[opIndex] = scriptInfo.readUnsignedByte();
            }
        }

        operations[opIndex] = operation;
    }

}
