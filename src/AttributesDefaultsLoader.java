/* Class424 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class AttributesDefaultsLoader {
	Index aClass317_5027;
	SoftCache aClass229_5028 = new SoftCache(64);
	static int anInt5029;

	public void method7067(int i) {
		synchronized (((AttributesDefaultsLoader) this).aClass229_5028) {
			((AttributesDefaultsLoader) this).aClass229_5028.method3863(1684780970);
		}
	}

	public void method7068(int i, int i_0_) {
		synchronized (((AttributesDefaultsLoader) this).aClass229_5028) {
			((AttributesDefaultsLoader) this).aClass229_5028.method3858(i, (byte) -89);
		}
	}

	public AttributesDefaultsLoader(Game class486, Language class495, Index class317) {
		((AttributesDefaultsLoader) this).aClass317_5027 = class317;
		if (((AttributesDefaultsLoader) this).aClass317_5027 != null)
			((AttributesDefaultsLoader) this).aClass317_5027.filesCount(SharedConfigsType.aClass120_1474.id * -71319279, -1867131018);
	}

	public AttributeDefault method7069(int i, byte i_1_) {
		AttributeDefault class437;
		synchronized (((AttributesDefaultsLoader) this).aClass229_5028) {
			class437 = ((AttributeDefault) ((AttributesDefaultsLoader) this).aClass229_5028.method3865((long) i));
		}
		if (null != class437)
			return class437;
		byte[] is;
		synchronized (((AttributesDefaultsLoader) this).aClass317_5027) {
			is = (((AttributesDefaultsLoader) this).aClass317_5027.getFile(-71319279 * SharedConfigsType.aClass120_1474.id, i, -1430082721));
		}
		class437 = new AttributeDefault();
		if (null != is)
			class437.method7315(new RsByteBuffer(is), 864887749);
		synchronized (((AttributesDefaultsLoader) this).aClass229_5028) {
			((AttributesDefaultsLoader) this).aClass229_5028.put(class437, (long) i);
		}
		return class437;
	}

	public void method7070(int i) {
		synchronized (((AttributesDefaultsLoader) this).aClass229_5028) {
			((AttributesDefaultsLoader) this).aClass229_5028.method3859(-299334668);
		}
	}

	public void method7071() {
		synchronized (((AttributesDefaultsLoader) this).aClass229_5028) {
			((AttributesDefaultsLoader) this).aClass229_5028.method3863(1001807600);
		}
	}

	public void method7072() {
		synchronized (((AttributesDefaultsLoader) this).aClass229_5028) {
			((AttributesDefaultsLoader) this).aClass229_5028.method3859(-826915308);
		}
	}

	public void method7073() {
		synchronized (((AttributesDefaultsLoader) this).aClass229_5028) {
			((AttributesDefaultsLoader) this).aClass229_5028.method3859(1356982144);
		}
	}

	public void method7074() {
		synchronized (((AttributesDefaultsLoader) this).aClass229_5028) {
			((AttributesDefaultsLoader) this).aClass229_5028.method3859(605689747);
		}
	}

	public void method7075(int i) {
		synchronized (((AttributesDefaultsLoader) this).aClass229_5028) {
			((AttributesDefaultsLoader) this).aClass229_5028.method3858(i, (byte) 60);
		}
	}

	public void method7076() {
		synchronized (((AttributesDefaultsLoader) this).aClass229_5028) {
			((AttributesDefaultsLoader) this).aClass229_5028.method3859(2040712126);
		}
	}

	public void method7077() {
		synchronized (((AttributesDefaultsLoader) this).aClass229_5028) {
			((AttributesDefaultsLoader) this).aClass229_5028.method3863(1462549727);
		}
	}

	public void method7078() {
		synchronized (((AttributesDefaultsLoader) this).aClass229_5028) {
			((AttributesDefaultsLoader) this).aClass229_5028.method3863(1794669600);
		}
	}

	public void method7079() {
		synchronized (((AttributesDefaultsLoader) this).aClass229_5028) {
			((AttributesDefaultsLoader) this).aClass229_5028.method3863(1515403340);
		}
	}

	static char method7080(char c, int i) {
		switch (c) {
		case '\u00d2':
		case '\u00d3':
		case '\u00d4':
		case '\u00d5':
		case '\u00d6':
		case '\u00f2':
		case '\u00f3':
		case '\u00f4':
		case '\u00f5':
		case '\u00f6':
			return 'o';
		case '\u00c7':
		case '\u00e7':
			return 'c';
		case '\u00df':
			return 'b';
		case '\u00ff':
		case '\u0178':
			return 'y';
		case '#':
		case '[':
		case ']':
			return c;
		case '\u00c8':
		case '\u00c9':
		case '\u00ca':
		case '\u00cb':
		case '\u00e8':
		case '\u00e9':
		case '\u00ea':
		case '\u00eb':
			return 'e';
		case '\u00d1':
		case '\u00f1':
			return 'n';
		case '\u00c0':
		case '\u00c1':
		case '\u00c2':
		case '\u00c3':
		case '\u00c4':
		case '\u00e0':
		case '\u00e1':
		case '\u00e2':
		case '\u00e3':
		case '\u00e4':
			return 'a';
		case ' ':
		case '-':
		case '_':
		case '\u00a0':
			return '_';
		default:
			return Character.toLowerCase(c);
		case '\u00d9':
		case '\u00da':
		case '\u00db':
		case '\u00dc':
		case '\u00f9':
		case '\u00fa':
		case '\u00fb':
		case '\u00fc':
			return 'u';
		case '\u00cd':
		case '\u00ce':
		case '\u00cf':
		case '\u00ed':
		case '\u00ee':
		case '\u00ef':
			return 'i';
		}
	}

	public static void method7081(byte i) {
		Class365.method6298(18, 1932929676);
		Class459.method7678(142230333);
		System.gc();
	}

	static final void method7082(CS2Executor class527, int i) {
		((CS2Executor) class527).intStack[(((CS2Executor) class527).anInt7012 += 141891001) * 1942118537 - 1] = Class393.aClass282_Sub54_4783.aClass468_Sub10_8215.method12691(-1233469498) == 1 ? 1 : 0;
	}

	static void method7083(CS2Executor class527, int i) {
		Class240 class240 = Class409.aClass242_4922.method4156((((CS2Executor) class527).intStack[((((CS2Executor) class527).anInt7012 -= 141891001) * 1942118537)]), -1396181317);
		((CS2Executor) class527).intStack[(((CS2Executor) class527).anInt7012 += 141891001) * 1942118537 - 1] = (class240.anIntArray2964 == null ? 0 : class240.anIntArray2964.length);
	}
}
