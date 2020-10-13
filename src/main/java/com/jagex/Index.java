package com.jagex;

public class Index {

    static Class395 aClass395_3684 = new Class395();
    static boolean aBool3692;
    static int anInt3689;
    ReferenceTable referenceTable;
    Object[] archives;
    Object[][] archiveFiles;
    JS5FileWorker aClass327_3690;
    boolean aBool3685;
    int loadType;

    public Index(JS5FileWorker js5fileworker_1, boolean bool_2, int i_3) {
        if (i_3 >= 0 && i_3 <= 2) {
            aClass327_3690 = js5fileworker_1;
            aBool3685 = bool_2;
            loadType = i_3;
        } else {
            throw new IllegalArgumentException("");
        }
    }

    public static int method5693(CharSequence charsequence_0, int i_2, byte[] bytes_3, int i_4) {
        int i_6 = i_2;
        for (int i_7 = 0; i_7 < i_6; i_7++) {
            char var_8 = charsequence_0.charAt(i_7);
            if (var_8 > 0 && var_8 < 128 || var_8 >= 160 && var_8 <= 255) {
                bytes_3[i_7 + i_4] = (byte) var_8;
            } else if (var_8 == 8364) {
                bytes_3[i_7 + i_4] = -128;
            } else if (var_8 == 8218) {
                bytes_3[i_7 + i_4] = -126;
            } else if (var_8 == 402) {
                bytes_3[i_7 + i_4] = -125;
            } else if (var_8 == 8222) {
                bytes_3[i_7 + i_4] = -124;
            } else if (var_8 == 8230) {
                bytes_3[i_7 + i_4] = -123;
            } else if (var_8 == 8224) {
                bytes_3[i_7 + i_4] = -122;
            } else if (var_8 == 8225) {
                bytes_3[i_7 + i_4] = -121;
            } else if (var_8 == 710) {
                bytes_3[i_7 + i_4] = -120;
            } else if (var_8 == 8240) {
                bytes_3[i_7 + i_4] = -119;
            } else if (var_8 == 352) {
                bytes_3[i_7 + i_4] = -118;
            } else if (var_8 == 8249) {
                bytes_3[i_7 + i_4] = -117;
            } else if (var_8 == 338) {
                bytes_3[i_7 + i_4] = -116;
            } else if (var_8 == 381) {
                bytes_3[i_7 + i_4] = -114;
            } else if (var_8 == 8216) {
                bytes_3[i_7 + i_4] = -111;
            } else if (var_8 == 8217) {
                bytes_3[i_7 + i_4] = -110;
            } else if (var_8 == 8220) {
                bytes_3[i_7 + i_4] = -109;
            } else if (var_8 == 8221) {
                bytes_3[i_7 + i_4] = -108;
            } else if (var_8 == 8226) {
                bytes_3[i_7 + i_4] = -107;
            } else if (var_8 == 8211) {
                bytes_3[i_7 + i_4] = -106;
            } else if (var_8 == 8212) {
                bytes_3[i_7 + i_4] = -105;
            } else if (var_8 == 732) {
                bytes_3[i_7 + i_4] = -104;
            } else if (var_8 == 8482) {
                bytes_3[i_7 + i_4] = -103;
            } else if (var_8 == 353) {
                bytes_3[i_7 + i_4] = -102;
            } else if (var_8 == 8250) {
                bytes_3[i_7 + i_4] = -101;
            } else if (var_8 == 339) {
                bytes_3[i_7 + i_4] = -100;
            } else if (var_8 == 382) {
                bytes_3[i_7 + i_4] = -98;
            } else if (var_8 == 376) {
                bytes_3[i_7 + i_4] = -97;
            } else {
                bytes_3[i_7 + i_4] = 63;
            }
        }
        return i_6;
    }

    public static IComponentDefinitions getIComponentDefinitions(int interfaceId, int slotId) {
        IComponentDefinitions ifDef = IComponentDefinitions.getDefs(interfaceId);
        if (slotId == -1)
            return ifDef;
        if (ifDef != null && ifDef.slotChildren != null && slotId < ifDef.slotChildren.length)
            return ifDef.slotChildren[slotId];
        return null;
    }

    public int getCrc() {
        if (!referenceTableLoaded()) {
            throw new IllegalStateException("");
        } else {
            return referenceTable.headerCrc;
        }
    }

    synchronized boolean archiveExists(int scriptId) {
        if (!referenceTableLoaded()) {
            return false;
        } else if (scriptId >= 0 && scriptId < referenceTable.fileCounts.length && referenceTable.fileCounts[scriptId] != 0) {
            return true;
        } else if (aBool3692) {
            throw new IllegalArgumentException(Integer.toString(scriptId));
        } else {
            return false;
        }
    }

    synchronized boolean fileExists(int scriptId, int i_2) {
        if(scriptId == 787) {
            scriptId = scriptId;
        }
        if (!referenceTableLoaded()) {
            return false;
        } else if (scriptId >= 0 && i_2 >= 0 && scriptId < referenceTable.fileCounts.length && i_2 < referenceTable.fileCounts[scriptId]) {
            return true;
        } else if (aBool3692) {
            throw new IllegalArgumentException(scriptId + " " + i_2);
        } else {
            return false;
        }
    }

    synchronized void requestArchive(int i_1) {
        if (aBool3685) {
            archives[i_1] = aClass327_3690.method5804(i_1);
        } else {
            archives[i_1] = JS5Manager.method5493(aClass327_3690.method5804(i_1));
        }
    }

    void method5606(int i_1) {
        aClass327_3690.method5805(i_1);
    }

    public byte[] getFile(int scriptId, int i_2) {
        return getFile(scriptId, i_2, null);
    }

    public boolean validFile(String string_1) {
        if (!referenceTableLoaded()) {
            return false;
        } else {
            string_1 = string_1.toLowerCase();
            int i_2 = referenceTable.archiveName.method865(AbstractRenderer.method8696(string_1));
            return i_2 >= 0;
        }
    }

    public int getArchiveId(String string_1) {
        if (!referenceTableLoaded()) {
            return -1;
        } else {
            string_1 = string_1.toLowerCase();
            int i_2 = referenceTable.archiveName.method865(AbstractRenderer.method8696(string_1));
            return !archiveExists(i_2) ? -1 : i_2;
        }
    }

    public synchronized boolean isValid() {
        if (!referenceTableLoaded()) {
            return false;
        } else {
            boolean bool_1 = true;
            for (int i_2 = 0; i_2 < referenceTable.validArchiveIds.length; i_2++) {
                int i_3 = referenceTable.validArchiveIds[i_2];
                if (archives[i_3] == null) {
                    requestArchive(i_3);
                    if (archives[i_3] == null) {
                        bool_1 = false;
                    }
                }
            }
            return bool_1;
        }
    }

    synchronized int method5613(int i_1) {
        return !archiveExists(i_1) ? 0 : (archives[i_1] != null ? 100 : aClass327_3690.method5806(i_1));
    }

    public synchronized int getCompletion() {
        if (!referenceTableLoaded()) {
            return 0;
        } else {
            int i_1 = 0;
            int i_2 = 0;
            int i_3;
            for (i_3 = 0; i_3 < archives.length; i_3++) {
                if (referenceTable.validFileIdSizes[i_3] > 0) {
                    i_1 += 100;
                    i_2 += method5613(i_3);
                }
            }
            if (i_1 == 0) {
                return 100;
            } else {
                i_3 = i_2 * 100 / i_1;
                return i_3;
            }
        }
    }

    public synchronized byte[] getFile(int i_1) {
        if (!referenceTableLoaded()) {
            return null;
        } else if (referenceTable.fileCounts.length == 1) {
            return getFile(0, i_1);
        } else if (!archiveExists(i_1)) {
            return null;
        } else if (referenceTable.fileCounts[i_1] == 1) {
            return getFile(i_1, 0);
        } else {
            throw new RuntimeException();
        }
    }

    public synchronized int[] getValidFileIds(int i_1) {
        if (!archiveExists(i_1)) {
            return null;
        } else {
            int[] ints_2 = referenceTable.validFileIds[i_1];
            if (ints_2 == null) {
                ints_2 = new int[referenceTable.validFileIdSizes[i_1]];
                for (int i_3 = 0; i_3 < ints_2.length; ints_2[i_3] = i_3++) {
                }
            }
            return ints_2;
        }
    }

    public int containersCount() {
        return !referenceTableLoaded() ? -1 : referenceTable.fileCounts.length;
    }

    public synchronized void clearFiles(int i_1) {
        if (archiveExists(i_1) && archiveFiles != null) {
            archiveFiles[i_1] = null;
        }
    }

    public int method5623(int i_1) {
        if (!referenceTableLoaded()) {
            return -1;
        } else {
            int i_3 = referenceTable.archiveName.method865(i_1);
            return !archiveExists(i_3) ? -1 : i_3;
        }
    }

    public int filesCount(int i_1) {
        return !archiveExists(i_1) ? 0 : referenceTable.fileCounts[i_1];
    }

    public boolean method5625(String string_1, String string_2) {
        if (!referenceTableLoaded()) {
            return false;
        } else {
            string_1 = string_1.toLowerCase();
            string_2 = string_2.toLowerCase();
            int i_4 = referenceTable.archiveName.method865(AbstractRenderer.method8696(string_1));
            if (i_4 < 0) {
                return false;
            } else {
                int i_5 = referenceTable.namedFiles[i_4].method865(AbstractRenderer.method8696(string_2));
                return i_5 >= 0;
            }
        }
    }

    public synchronized byte[] getFileByName(String string_1, String string_2) {
        if (!referenceTableLoaded()) {
            return null;
        } else {
            string_1 = string_1.toLowerCase();
            string_2 = string_2.toLowerCase();
            int i_4 = referenceTable.archiveName.method865(AbstractRenderer.method8696(string_1));
            if (!archiveExists(i_4)) {
                return null;
            } else {
                int i_5 = referenceTable.namedFiles[i_4].method865(AbstractRenderer.method8696(string_2));
                return getFile(i_4, i_5);
            }
        }
    }

    boolean method5627(String string_1, String string_2) {
        if (!referenceTableLoaded()) {
            return false;
        } else {
            string_1 = string_1.toLowerCase();
            string_2 = string_2.toLowerCase();
            int i_4 = referenceTable.archiveName.method865(AbstractRenderer.method8696(string_1));
            if (!archiveExists(i_4)) {
                return false;
            } else {
                int i_5 = referenceTable.namedFiles[i_4].method865(AbstractRenderer.method8696(string_2));
                return load(i_4, i_5);
            }
        }
    }

    public boolean method5628(String string_1) {
        int i_3 = getArchiveId("");
        return i_3 != -1 ? method5627("", string_1) : method5627(string_1, "");
    }

    public boolean method5629(String string_1) {
        if (!referenceTableLoaded()) {
            return false;
        } else {
            string_1 = string_1.toLowerCase();
            int i_3 = referenceTable.archiveName.method865(AbstractRenderer.method8696(string_1));
            return loadArchive(i_3);
        }
    }

    public void method5630(String string_1) {
        if (referenceTableLoaded()) {
            string_1 = string_1.toLowerCase();
            int i_3 = referenceTable.archiveName.method865(AbstractRenderer.method8696(string_1));
            method5606(i_3);
        }
    }

    public int method5631(String string_1) {
        if (!referenceTableLoaded()) {
            return 0;
        } else {
            string_1 = string_1.toLowerCase();
            int i_3 = referenceTable.archiveName.method865(AbstractRenderer.method8696(string_1));
            return method5613(i_3);
        }
    }

    synchronized boolean referenceTableLoaded() {
        if (referenceTable == null) {
            referenceTable = aClass327_3690.getReferenceTable();
            if (referenceTable == null) {
                return false;
            }
            archives = new Object[referenceTable.archiveCount];
            archiveFiles = new Object[referenceTable.archiveCount][];
        }
        return true;
    }

    synchronized boolean method5638(int scriptId, int i_2, int[] ints_3) {
        if(scriptId == 787) {
            scriptId = scriptId;
        }
        if (!archiveExists(scriptId)) {
            return false;
        } else if (archives[scriptId] == null) {
            return false;
        } else {
            int fileCount = referenceTable.validFileIdSizes[scriptId];
            int[] ints_6 = referenceTable.validFileIds[scriptId];
            if (archiveFiles[scriptId] == null) {
                archiveFiles[scriptId] = new Object[referenceTable.fileCounts[scriptId]];
            }
            Object[] arr_7 = archiveFiles[scriptId];
            boolean bool_8 = true;
            for (int i = 0; i < fileCount; i++) {
                int i_10;
                if (ints_6 == null) {
                    i_10 = i;
                } else {
                    i_10 = ints_6[i];
                }
                if (arr_7[i_10] == null) {
                    bool_8 = false;
                    break;
                }
            }
            if (!bool_8) {
                byte[] scriptArchive;
                if (ints_3 == null || ints_3[0] == 0 && ints_3[1] == 0 && ints_3[2] == 0 && ints_3[3] == 0) {
                    scriptArchive = QuickChatMessage.castScriptArchive(archives[scriptId], false);
                } else {
                    scriptArchive = QuickChatMessage.castScriptArchive(archives[scriptId], true);
                    JagexNode rsbytebuffer_23 = new JagexNode(scriptArchive);
                    rsbytebuffer_23.method13249(ints_3, rsbytebuffer_23.buffer.length);
                }
                byte[] scriptInfo = Node_Sub17_Sub6.method15438(scriptArchive);//TODO: How is a script Archive Unpacked?
                if (aBool3685) {
                    archives[scriptId] = null;
                }
                int i_11;
                if (fileCount > 1) {
                    int i_12;
                    JagexNode rsbytebuffer_13;
                    int i_15;
                    int i_16;
                    int i_17;
                    int i_18;
                    int i_19;
                    if (loadType != 2) {
                        i_11 = scriptInfo.length;
                        --i_11;
                        i_12 = scriptInfo[i_11] & 0xff;
                        i_11 -= i_12 * fileCount * 4;
                        rsbytebuffer_13 = new JagexNode(scriptInfo);
                        int[] ints_14 = new int[fileCount];
                        rsbytebuffer_13.index = i_11;
                        for (i_15 = 0; i_15 < i_12; i_15++) {
                            i_16 = 0;
                            for (i_17 = 0; i_17 < fileCount; i_17++) {
                                i_16 += rsbytebuffer_13.readInt();
                                ints_14[i_17] += i_16;
                            }
                        }
                        byte[][] bytes_24 = new byte[fileCount][];
                        for (i_16 = 0; i_16 < fileCount; i_16++) {
                            bytes_24[i_16] = new byte[ints_14[i_16]];
                            ints_14[i_16] = 0;
                        }
                        rsbytebuffer_13.index = i_11;
                        i_16 = 0;
                        for (i_17 = 0; i_17 < i_12; i_17++) {
                            i_18 = 0;
                            for (i_19 = 0; i_19 < fileCount; i_19++) {
                                i_18 += rsbytebuffer_13.readInt();
                                System.arraycopy(scriptInfo, i_16, bytes_24[i_19], ints_14[i_19], i_18);
                                ints_14[i_19] += i_18;
                                i_16 += i_18;
                            }
                        }
                        for (i_17 = 0; i_17 < fileCount; i_17++) {
                            if (ints_6 == null) {
                                i_18 = i_17;
                            } else {
                                i_18 = ints_6[i_17];
                            }
                            if (loadType == 0) {
                                arr_7[i_18] = JS5Manager.method5493(bytes_24[i_17]);
                            } else {
                                arr_7[i_18] = bytes_24[i_17];
                            }
                        }
                    } else {
                        i_11 = scriptInfo.length;
                        --i_11;
                        i_12 = scriptInfo[i_11] & 0xff;
                        i_11 -= i_12 * fileCount * 4;
                        rsbytebuffer_13 = new JagexNode(scriptInfo);
                        int i_25 = 0;
                        i_15 = 0;
                        rsbytebuffer_13.index = i_11;
                        for (i_16 = 0; i_16 < i_12; i_16++) {
                            i_17 = 0;
                            for (i_18 = 0; i_18 < fileCount; i_18++) {
                                i_17 += rsbytebuffer_13.readInt();
                                if (ints_6 == null) {
                                    i_19 = i_18;
                                } else {
                                    i_19 = ints_6[i_18];
                                }
                                if (i_19 == i_2) {
                                    i_25 += i_17;
                                    i_15 = i_19;
                                }
                            }
                        }
                        if (i_25 == 0) {
                            return true;
                        }
                        byte[] bytes_26 = new byte[i_25];
                        i_25 = 0;
                        rsbytebuffer_13.index = i_11;
                        i_17 = 0;
                        for (i_18 = 0; i_18 < i_12; i_18++) {
                            i_19 = 0;
                            for (int i_20 = 0; i_20 < fileCount; i_20++) {
                                i_19 += rsbytebuffer_13.readInt();
                                int i_21;
                                if (ints_6 == null) {
                                    i_21 = i_20;
                                } else {
                                    i_21 = ints_6[i_20];
                                }
                                if (i_21 == i_2) {
                                    System.arraycopy(scriptInfo, i_17, bytes_26, i_25, i_19);
                                    i_25 += i_19;
                                }
                                i_17 += i_19;
                            }
                        }
                        arr_7[i_15] = bytes_26;
                    }
                } else {
                    if (ints_6 == null) {
                        i_11 = 0;
                    } else {
                        i_11 = ints_6[0];
                    }
                    if (loadType == 0) {
                        arr_7[i_11] = JS5Manager.method5493(scriptInfo);
                    } else {
                        arr_7[i_11] = scriptInfo;
                    }
                }
            }
            return true;
        }
    }

    public synchronized byte[] getFile(int scriptId, int i_2, int[] ints_3) {
        if (!fileExists(scriptId, i_2)) {
            return null;
        } else {
            byte[] scriptInfo = null;
            if (archiveFiles[scriptId] == null || archiveFiles[scriptId][i_2] == null) {
                boolean bool_5 = method5638(scriptId, i_2, ints_3);
                if (!bool_5) {
                    requestArchive(scriptId);
                    bool_5 = method5638(scriptId, i_2, ints_3);
                    if (!bool_5) {
                        return null;
                    }
                }
            }
            if (archiveFiles[scriptId] == null) {
                throw new RuntimeException("");
            } else {
                if (archiveFiles[scriptId][i_2] != null) {
                    scriptInfo = QuickChatMessage.castScriptArchive(archiveFiles[scriptId][i_2], false);
                    if (scriptInfo == null) {
                        throw new RuntimeException("");
                    }
                }
                if (scriptInfo != null) {
                    if (loadType == 1) {
                        archiveFiles[scriptId][i_2] = null;
                        if (referenceTable.fileCounts[scriptId] == 1) {
                            archiveFiles[scriptId] = null;
                        }
                    } else if (loadType == 2) {
                        archiveFiles[scriptId] = null;
                    }
                }
                return scriptInfo;
            }
        }
    }

    public synchronized boolean loadArchive(int i_1) {
        if (!archiveExists(i_1)) {
            return false;
        } else if (archives[i_1] != null) {
            return true;
        } else {
            requestArchive(i_1);
            return archives[i_1] != null;
        }
    }

    public synchronized boolean loadFile(int i_1) {
        if (!referenceTableLoaded()) {
            return false;
        } else if (referenceTable.fileCounts.length == 1) {
            return load(0, i_1);
        } else if (!archiveExists(i_1)) {
            return false;
        } else if (referenceTable.fileCounts[i_1] == 1) {
            return load(i_1, 0);
        } else {
            throw new RuntimeException();
        }
    }

    public void method5676(boolean bool_1) {
        if (referenceTableLoaded()) {
            if (bool_1) {
                referenceTable.nameHashes = null;
                referenceTable.archiveName = null;
            }
            referenceTable.fileNameHashes = null;
            referenceTable.namedFiles = null;
        }
    }

    public synchronized boolean load(int i_1, int i_2) {
        if (!fileExists(i_1, i_2)) {
            return false;
        } else if (archiveFiles[i_1] != null && archiveFiles[i_1][i_2] != null) {
            return true;
        } else if (archives[i_1] != null) {
            return true;
        } else {
            requestArchive(i_1);
            return archives[i_1] != null;
        }
    }
}
