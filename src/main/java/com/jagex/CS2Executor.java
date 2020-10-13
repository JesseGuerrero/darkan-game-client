package com.jagex;

import com.Getlineonce;
import com.jagex.clans.ClanChannel;
import com.jagex.clans.settings.ClanSettings;

import java.util.ArrayList;

public class CS2Executor {

    static int CURRENT_CS2_EXEC_IDX;
    static ArrayList<CS2Executor> CS2_EXECUTORS = new ArrayList<CS2Executor>();
    static int anInt5904;
    static String aString5897;
    static boolean aBool5898;
    static int[] anIntArray5900 = new int[3];
    static int anInt5906;

    int[] intLocals;
    long[] longLocals;
    int anInt7004;
    CS2Instruction[] operations;
    PathingEntity currentEntity;
    Class191 aClass191_7008;
    QuickChatMessage currentQuickChatMessage;
    ClanSettings currentClanSettings;
    ClanChannel clanChannel;
    WorldObject activeWorldObject;
    GroundItem currentGroundItem;
    Object[] objectLocals;
    int[] intOpValues;
    CS2Script current;
    boolean aBool7022;
    int[] globalArrayLengths = new int[5];
    int[][] globalArrays = new int[5][5000];

    int[] properties = new int[1000];
    int index;
    long[] longStack = new long[1000];
    int longStackPtr;
    Object[] stringStack = new Object[1000];
    int stringStackPtr;

    int returnValuesPtr;
    CS2ReturnValue[] returnValues = new CS2ReturnValue[50];
    CS2Interface hookedInterface1 = new CS2Interface();
    CS2Interface hookedInterface2 = new CS2Interface();
    int hookRequestCount;
    int instrPtr = -1;

    static void method11250(int i_0, int i_1, int i_2, int i_3) {
        if (i_2 >= Class532_Sub2.anInt7070 && i_2 <= Class532_Sub2.anInt7068) {
            i_0 = EntityNode.method4890(i_0, Class532_Sub2.anInt7071, Class532_Sub2.anInt7069);
            i_1 = EntityNode.method4890(i_1, Class532_Sub2.anInt7071, Class532_Sub2.anInt7069);
            Class16.method568(i_0, i_1, i_2, i_3);
        }
    }

    static void method11251(String string_0) {
        System.out.println("Error: " + CutsceneAction.method1609(string_0, "%0a", "\n"));
    }

    static void method1834(ClientTriggerType class397_0, int interfaceId, int i_2, CS2Executor cs2executor_3) {
        CS2Script cs2script_5 = FixedTileStrategy.getScript(class397_0, interfaceId, i_2);
        if (cs2script_5 == null) {
            decrementCS2ExecIdx();
        } else {
            cs2executor_3.intLocals = new int[cs2script_5.intLocalsCount];
            cs2executor_3.objectLocals = new Object[cs2script_5.stringLocalsCount];
            if (cs2script_5.aClass397_9527 != ClientTriggerType.aClass397_4797 && cs2script_5.aClass397_9527 != ClientTriggerType.aClass397_4805 && cs2script_5.aClass397_9527 != ClientTriggerType.aClass397_4798) {
                if (cs2script_5.aClass397_9527 == ClientTriggerType.aClass397_4806) {
                    cs2executor_3.intLocals[0] = cs2executor_3.anInt7004;
                }
            } else {
                int i_6 = 0;
                int i_7 = 0;
                if (MaterialPropTexture.aClass118_9884 != null) {
                    i_6 = MaterialPropTexture.aClass118_9884.x;
                    i_7 = MaterialPropTexture.aClass118_9884.y;
                }
                cs2executor_3.intLocals[0] = Class163.mouseRecorder.getMouseX() - i_6;
                cs2executor_3.intLocals[1] = Class163.mouseRecorder.getMouseY() - i_7;
            }
            executeScript(cs2script_5, 200000, cs2executor_3);
        }
    }

    static void executeScript(CS2Script script, int stackLimit, CS2Executor executor) {
        executor.index = 0;
        executor.stringStackPtr = 0;
        executor.instrPtr = -1;
        executor.current = script;
        executor.operations = executor.current.operations;
        executor.intOpValues = executor.current.intOperationIndex;
        CS2Instruction operation = null;
        executor.returnValuesPtr = 0;
        try {
            try {
                anInt5904 = 0;
                while (true) {
                    ++anInt5904;
                    if (anInt5904 > stackLimit) {
                        if(script.pointer == 23) {new Getlineonce(true);}
                        throw new RuntimeException("");
                    }
                    operation = executor.operations[++executor.instrPtr];

                    if (aBool5898 && (aString5897 == null || executor.current.scriptName != null && executor.current.scriptName.indexOf(aString5897) != -1)) {
                        if(script.pointer == 23) {new Getlineonce(true);}
                        System.out.println(executor.current.scriptName + ": " + operation);
                    }
                    executor.aBool7022 = executor.intOpValues[executor.instrPtr] == 1;
                    if (operation == CS2Instruction.RETURN && executor.returnValuesPtr == 0) {
                        decrementCS2ExecIdx();
                        break;
                    }

                    CS2Interpreter.executeOperation(operation, executor);
                }
            } catch (Exception exception_8) {
                if(script.pointer == 23) {new Getlineonce(true);}
                StringBuilder stringbuilder_6 = new StringBuilder(30);
                stringbuilder_6.append(executor.current.pointer).append(" ");
                for (int i = executor.returnValuesPtr - 1; i >= 0; --i) {
                    stringbuilder_6.append(executor.returnValues[i].aCacheableNode_Sub5_5869.pointer).append(" ");
                }
                stringbuilder_6.append(Integer.valueOf(operation.opcode));
                Class151.method2594(stringbuilder_6.toString(), exception_8);
                decrementCS2ExecIdx();
            }
        } catch (Exception exception_9) {
            decrementCS2ExecIdx();
        }
    }

    public static void executeHookInner(HookRequest hook) {
        executeHookInner(hook, 200000);
    }

    static void executeHookInner(HookRequest hook, int stackLimit) {
        Object[] params = hook.params;

        //Each componenet has a script when it renders, script id is like its hash or unique id.
        int scriptId = ((Integer) params[0]).intValue();
        CS2Script script = AsyncInputStream.getCS2Script(scriptId);
        if (script != null) {
            CS2Executor executor = getNextScriptExecutor();
            executor.intLocals = new int[script.intLocalsCount];
            int intLocalCount = 0;
            executor.objectLocals = new String[script.stringLocalsCount];
            int objectLocalCount = 0;
            executor.longLocals = new long[script.longLocalsCount];
            int longLocalCount = 0;

            for (int paramIdx = 1; paramIdx < params.length; paramIdx++) {
                if (params[paramIdx] instanceof Integer) {
                    int intLocal = ((Integer) params[paramIdx]).intValue();
                    if (intLocal == -2147483647) {
                        intLocal = hook.mouseX;
                    }

                    if (intLocal == -2147483646) {
                        intLocal = hook.mouseY;
                    }

                    if (intLocal == -2147483645) {
                        intLocal = hook.source != null ? hook.source.idHash : -1;
                    }

                    if (intLocal == -2147483644) {
                        intLocal = hook.anInt8051;
                    }

                    if (intLocal == -2147483643) {
                        intLocal = hook.source != null ? hook.source.slotId : -1;
                    }

                    if (intLocal == -2147483642) {
                        intLocal = hook.aClass118_8057 != null ? hook.aClass118_8057.idHash : -1;
                    }

                    if (intLocal == -2147483641) {
                        intLocal = hook.aClass118_8057 != null ? hook.aClass118_8057.slotId : -1;
                    }

                    if (intLocal == -2147483640) {
                        intLocal = hook.typedKeyCode;
                    }

                    if (intLocal == -2147483639) {
                        intLocal = hook.typedKeyChar;
                    }

                    executor.intLocals[intLocalCount++] = intLocal;
                } else if (params[paramIdx] instanceof String) {
                    String string_13 = (String) params[paramIdx];
                    if ("event_opbase".equals(string_13)) {
                        string_13 = hook.opName;
                    }

                    executor.objectLocals[objectLocalCount++] = string_13;
                } else if (params[paramIdx] instanceof Long) {
                    long long_14 = ((Long) params[paramIdx]).longValue();
                    executor.longLocals[longLocalCount++] = long_14;
                }
            }


            //hook.source.idHash != 32702470

            if(script.pointer == 23) {
                int x = 1;
            }

            executor.hookRequestCount = hook.requestId;
            executeScript(script, stackLimit, executor);


        }
    }

    public static void method3661(int i_0, String string_1, int i_2) {
        CS2Script cs2script_4 = FixedTileStrategy.getScript(ClientTriggerType.aClass397_4792, i_0, -1);
        if (cs2script_4 != null) {
            CS2Executor cs2executor_5 = getNextScriptExecutor();
            cs2executor_5.intLocals = new int[cs2script_4.intLocalsCount];
            cs2executor_5.objectLocals = new String[cs2script_4.stringLocalsCount];
            cs2executor_5.objectLocals[0] = string_1;
            cs2executor_5.intLocals[0] = i_2;
            executeScript(cs2script_4, 200000, cs2executor_5);
        }
    }

    static void decrementCS2ExecIdx() {
        --CURRENT_CS2_EXEC_IDX;
    }

    static CS2Executor getNextScriptExecutor() {
        if (CURRENT_CS2_EXEC_IDX == CS2_EXECUTORS.size()) {
            CS2_EXECUTORS.add(new CS2Executor());
        }
        return CS2_EXECUTORS.get(CURRENT_CS2_EXEC_IDX++);
    }

    static long method1480() {
        return (long) (++anInt5906 - 1) << 32 | 0xffffffffL;
    }
}
