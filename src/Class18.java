
/* Class18 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.math.BigInteger;

public class Class18 {
	static BigInteger LOGIN_EXPONENT = new BigInteger("65537");
	static BigInteger LOGIN_MODULUS = new BigInteger("117525752735533423040644219776209926525585489242340044375332234679786347045466594509203355398209678968096551043842518449703703964361320462967286756268851663407950384008240524570966471744081769815157355561961607944067477858512067883877129283799853947605780903005188603658779539811385137666347647991072028080201");
	public static BigInteger UPDATE_SERVER_EXPONENT = new BigInteger("65537");
	public static BigInteger UPDATE_SERVER_MODULUS = new BigInteger("117525752735533423040644219776209926525585489242340044375332234679786347045466594509203355398209678968096551043842518449703703964361320462967286756268851663407950384008240524570966471744081769815157355561961607944067477858512067883877129283799853947605780903005188603658779539811385137666347647991072028080201");

	static {
		new BigInteger("10001", 16);
		new BigInteger("807cbacd7aeed99f09c78c88a305f4fc15532249469ed4d45cbcc3cec47912a8b7e94cc9cb92d8ec33002fa8855a6c84794a4ea6144d4940a5c0da5e7668e045", 16);
	}

	Class18() throws Throwable {
		throw new Error();
	}

	static void method571(short i) {
		Class180.aClass229_2245.method3863(1106684848);
	}

	static final void method572(CS2Executor class527, int i) {
		boolean bool = true;
		String string = (String) (class527.objectStack[(class527.anInt7000 -= 1476624725) * 1806726141]);
		if (client.aBool7310) {
			try {
				Object object = Class361.aClass361_4181.method6254(new Object[] { string }, (byte) -31);
				if (object != null) {
					bool = ((Boolean) object).booleanValue();
				}
			} catch (Throwable throwable) {
				/* empty */
			}
		}
		class527.intStack[(class527.intStackPtr += 141891001) * 1942118537 - 1] = bool ? 1 : 0;
	}

	static void renderInformation(GraphicalRenderer renderer, NodeCollection areas, int i, int i_0_, byte i_1_) {
		Class346.aClass482_4049.method8118(-449430209);
		if (!Class291_Sub1.aBool8027) {
			for (Class282_Sub36 class282_sub36 = (Class282_Sub36) areas.head((byte) 59); null != class282_sub36; class282_sub36 = (Class282_Sub36) areas.next(-319423268)) {
				WorldMapAreaDefs defs = (Class291_Sub1.aClass218_3456.getWorldMapDefs(-1798678621 * class282_sub36.anInt7991, -113762832));
				if (Class282_Sub16.method12248(defs, -852702638)) {
					boolean bool = WorldMapAreaDefs.renderIconsAndNames(renderer, class282_sub36, defs, i, i_0_, 238178071);
					if (bool) {
						Class282_Sub39.method13297(renderer, class282_sub36, defs, -502532321);
					}
				}
			}
		}
	}

	static void method574(short i) {
		/* empty */
	}
}
