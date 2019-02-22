/* Class392 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class InventoriesIndexLoader implements IndexLoader {
	Index configIndex;
	SoftCache cached = new SoftCache(64);
	public static int anInt4781;

	public InventoriesIndexLoader(Game class486, XLanguage class495, Index class317) {
		((InventoriesIndexLoader) this).configIndex = class317;
		((InventoriesIndexLoader) this).configIndex.filesCount((SharedConfigsType.INVENTORIES.id) * -71319279);
	}

	public InventoryDef getInventoryDef(int i, short i_0_) {
		InventoryDef def;
		synchronized (((InventoriesIndexLoader) this).cached) {
			def = ((InventoryDef) ((InventoriesIndexLoader) this).cached.get((long) i));
		}
		if (def != null)
			return def;
		byte[] is;
		synchronized (((InventoriesIndexLoader) this).configIndex) {
			is = (((InventoriesIndexLoader) this).configIndex.getFile(-71319279 * SharedConfigsType.INVENTORIES.id, i));
		}
		def = new InventoryDef();
		if (null != is)
			def.method15690(new RsByteBuffer(is), 1939942716);
		synchronized (((InventoriesIndexLoader) this).cached) {
			((InventoriesIndexLoader) this).cached.put(def, (long) i);
		}
		return def;
	}
	
	static final void method6738(CS2Executor class527, int i) {
		int i_1_ = (class527.intStack[(class527.intStackPtr -= 141891001) * 1942118537]);
		IComponentDefinitions class118 = Class117.method1981(i_1_, (byte) 91);
		Interface class98 = Class468_Sub8.aClass98Array7889[i_1_ >> 16];
		Class278_Sub1.method13450(class118, class98, class527, -51249694);
	}

	static void renderAreaText(GraphicalRenderer class505, Class282_Sub36 class282_sub36, WorldMapAreaDefs class220, int i, int i_2_, int i_3_, int i_4_, Class194 class194, byte i_5_) {
		int i_6_ = i_2_ - i_4_ / 2 - 5;
		int i_7_ = 2 + i_3_;
		if (0 != class220.anInt2726 * 1903100449)
			class505.method8425(i_6_, i_7_, i_4_ + 10, i_3_ + i * class194.method3173() - i_7_ + 1, class220.anInt2726 * 1903100449, (byte) -128);
		if (0 != class220.anInt2727 * 1542243419)
			class505.method8562(i_6_, i_7_, 10 + i_4_, i_3_ + i * class194.method3173() - i_7_ + 1, 1542243419 * class220.anInt2727, (byte) 4);
		int i_8_ = -2116785903 * class220.anInt2720;
		if (class282_sub36.aBool7989 && -1 != -1748609101 * class220.anInt2721)
			i_8_ = -1748609101 * class220.anInt2721;
		for (int i_9_ = 0; i_9_ < i; i_9_++) {
			String string = Class291_Sub1.aStringArray8024[i_9_];
			if (i_9_ < i - 1)
				string = string.substring(0, string.length() - 4);
			class194.method3178(class505, string, i_2_, i_3_, i_8_, true);
			i_3_ += class194.method3173();
		}
	}

	public static void method6740(Class117 class117, int i) {
		Class113.aClass117_1234 = class117;
	}

	static final void method6741(CS2Executor class527, int i) {
		int i_10_ = (class527.intStack[(class527.intStackPtr -= 141891001) * 1942118537]);
		class527.intStack[(class527.intStackPtr += 141891001) * 1942118537 - 1] = class527.aClass61_7010.anIntArray634[i_10_];
	}
}
