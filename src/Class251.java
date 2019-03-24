import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;

public final class Class251 {

	static int exitY;

	static int exitX;

	static Class194 aClass194_3103;

	static int[][] directions = new int[128][128];

	static int[][] distances = new int[128][128];

	static int[] bufferX = new int[4096];

	static int[] bufferY = new int[4096];

	Class251() throws Throwable {
		throw new Error();
	}

	public static void handleCommand(String string_0, boolean bool_1, boolean bool_2) {
		try {
			label381: {
				if (!string_0.equalsIgnoreCase("commands") && !string_0.equalsIgnoreCase("help")) {
					if (string_0.equalsIgnoreCase("cls")) {
						Class179.anInt2227 = 0;
						Class179.anInt2223 = 0;
						return;
					}
					if (string_0.equalsIgnoreCase("displayfps")) {
						client.aBool7176 = !client.aBool7176;
						if (client.aBool7176) {
							Class209.printConsoleMessage("FPS on", -1478532172);
						} else {
							Class209.printConsoleMessage("FPS off", -318501716);
						}
						return;
					}
					if (!string_0.equals("renderer")) {
						if (string_0.equals("heap")) {
							Class209.printConsoleMessage("Heap: " + Engine.MAX_MEMORY + "MB", -845757732);
							return;
						}
						if (string_0.equalsIgnoreCase("getcamerapos")) {
							CoordGrid coordgrid_27 = IndexLoaders.MAP_REGION_DECODER.getCoordGrid();
							Class209.printConsoleMessage("Pos: " + VertexNormal.myPlayer.plane + "," + ((Class31.anInt361 >> 9) + coordgrid_27.x >> 6) + "," + ((Class246.anInt3029 >> 9) + coordgrid_27.y >> 6) + "," + ((Class31.anInt361 >> 9) + coordgrid_27.x & 0x3f) + "," + ((Class246.anInt3029 >> 9) + coordgrid_27.y & 0x3f) + " Height: " + (Class504.method8389(Class31.anInt361, Class246.anInt3029, VertexNormal.myPlayer.plane, (byte) 22) - Class109_Sub1.anInt9384), -2096324041);
							Class209.printConsoleMessage("Look: " + VertexNormal.myPlayer.plane + "," + (coordgrid_27.x + Class96_Sub13.anInt9368 >> 6) + "," + (coordgrid_27.y + OutgoingLoginPacket.anInt4280 >> 6) + "," + (coordgrid_27.x + Class96_Sub13.anInt9368 & 0x3f) + "," + (coordgrid_27.y + OutgoingLoginPacket.anInt4280 & 0x3f) + " Height: " + (Class504.method8389(Class96_Sub13.anInt9368, OutgoingLoginPacket.anInt4280, VertexNormal.myPlayer.plane, (byte) 2) - Class121.anInt1527), -2049086171);
							return;
						}
						break label381;
					}
					Class168 class168_4 = Renderers.SOFTWARE_RENDERER.method8392();
					Class209.printConsoleMessage("Toolkit ID: " + Class393.preferences.currentToolkit.getValue(174476725), -199774023);
					Class209.printConsoleMessage("Vendor: " + class168_4.anInt2052, -1266717403);
					Class209.printConsoleMessage("Name: " + class168_4.aString2051, -2120239732);
					Class209.printConsoleMessage("Version: " + class168_4.anInt2045, -1689852117);
					Class209.printConsoleMessage("Device: " + class168_4.aString2053, -1211113537);
					Class209.printConsoleMessage("Driver Version: " + class168_4.aLong2049, -598072423);
					return;
				}
				Class209.printConsoleMessage("commands - This command", -1128292172);
				Class209.printConsoleMessage("cls - Clear console", -1305824571);
				Class209.printConsoleMessage("displayfps - Toggle FPS and other information", -1028056987);
				Class209.printConsoleMessage("renderer - Print graphics renderer information", -895621363);
				Class209.printConsoleMessage("heap - Print java memory information", -770815394);
				Class209.printConsoleMessage("getcamerapos - Print location and direction of camera for use in bug reports", -2142075960);
				return;
			}
		} catch (Exception exception_19) {
			Class209.printConsoleMessage(Message.ERROR_EXECUTING_COMMAND.translate(Class223.CURRENT_LANGUAGE, -927245115), -314816204);
			return;
		}
		if (Class496.aClass496_5813 != Class90.aClass496_952 || client.rights >= 2) {
			try {
				if (string_0.equalsIgnoreCase("wm1")) {
					Class440.method7373(1, -1, -1, false, (byte) 111);
					if (Class158.windowedMode() == 1) {
						Class209.printConsoleMessage("Success", -1081042103);
					} else {
						Class209.printConsoleMessage("Failure", -1679059179);
					}
					return;
				}
				if (string_0.equalsIgnoreCase("wm2")) {
					Class440.method7373(2, -1, -1, false, (byte) 71);
					if (Class158.windowedMode() == 2) {
						Class209.printConsoleMessage("Success", -268796037);
					} else {
						Class209.printConsoleMessage("Failure", -693309543);
					}
					return;
				}
				if (Class475.supportsFullScreen && string_0.equalsIgnoreCase("wm3")) {
					Class440.method7373(3, 1024, 768, false, (byte) 71);
					if (Class158.windowedMode() == 3) {
						Class209.printConsoleMessage("Success", -1837857918);
					} else {
						Class209.printConsoleMessage("Failure", -223811881);
					}
					return;
				}
				if (string_0.startsWith("clipmask")) {
					Class209.printConsoleMessage("[" + VertexNormal.myPlayer.localX + ", " + VertexNormal.myPlayer.localY + "]:" + IndexLoaders.MAP_REGION_DECODER.getClipMap(VertexNormal.myPlayer.plane).map[VertexNormal.myPlayer.localX][VertexNormal.myPlayer.localY], -354697449);
				}
				int i_6;
				int i_10;
				if (string_0.startsWith("dumpitems")) {
					for (i_10 = 0; i_10 < 24806; i_10++) {
						int[] ints_23 = IndexLoaders.ITEM_INDEX_LOADER.getItemDefinitions(i_10, 1).getSprite(Class182.HARDWARE_RENDERER, Renderers.SOFTWARE_RENDERER, 1, 1, -13623264, false, 0, Renderers.FONT_RENDERER, VertexNormal.myPlayer.playerAppearance, (short) 1);
						try {
							i_6 = (int) Math.sqrt((double) ints_23.length) - 1;
							BufferedImage bufferedimage_25 = new BufferedImage(36, 32, 2);
							bufferedimage_25.setRGB(0, 0, i_6, i_6, ints_23, 0, i_6);
							for (int i_8 = 0; i_8 < i_6; i_8++) {
								for (int i_9 = 0; i_9 < i_6; i_9++) {
									bufferedimage_25.setRGB(i_9, i_8, ints_23[i_8 * 36 + i_9]);
								}
							}
							File file_11 = new File("./items/" + i_10 + ".png");
							ImageIO.write(bufferedimage_25, "png", file_11);
						} catch (Exception exception_17) {
							exception_17.printStackTrace();
						}
					}
					return;
				}
				if (string_0.startsWith("setlobby ")) {
					i_10 = -1;
					Object obj_22 = null;
					string_0 = string_0.substring(9);
					i_6 = string_0.indexOf(32);
					if (i_6 == -1) {
						Class209.printConsoleMessage("Failure", -208040475);
						return;
					}
					try {
						i_10 = Integer.parseInt(string_0.substring(0, i_6));
					} catch (NumberFormatException numberformatexception_14) {
						;
					}
					if (i_10 == -1) {
						Class209.printConsoleMessage("Failure", -1955711283);
						return;
					}
					String string_7 = string_0.substring(i_6 + 1).trim() + ".runescape.com";
					Class496.method8314(string_7, i_10);
					Class209.printConsoleMessage("Success", -226741800);
					return;
				}
				if (string_0.equalsIgnoreCase("tk0")) {
					ParticleProducer.method11500(0, false);
					if (Class393.preferences.currentToolkit.getValue(-491393282) == 0) {
						Class209.printConsoleMessage("Success", -1340836055);
						Class393.preferences.setValue(Class393.preferences.aClass468_Sub18_8214, 0, -1122635532);
						Class190.savePreferences((byte) 68);
						client.aBool7175 = false;
					} else {
						Class209.printConsoleMessage("Failure", -344734779);
					}
					return;
				}
				if (string_0.equalsIgnoreCase("tk1")) {
					ParticleProducer.method11500(1, false);
					if (Class393.preferences.currentToolkit.getValue(-1821997083) == 1) {
						Class209.printConsoleMessage("Success", -364086081);
						Class393.preferences.setValue(Class393.preferences.aClass468_Sub18_8214, 1, -1690467164);
						Class190.savePreferences((byte) 47);
						client.aBool7175 = false;
					} else {
						Class209.printConsoleMessage("Failure", -716939990);
					}
					return;
				}
				if (string_0.equalsIgnoreCase("tk2")) {
					ParticleProducer.method11500(2, false);
					if (Class393.preferences.currentToolkit.getValue(2070272351) == 2) {
						Class209.printConsoleMessage("Success", -1794668716);
						Class393.preferences.setValue(Class393.preferences.aClass468_Sub18_8214, 2, -259704912);
						Class190.savePreferences((byte) 17);
						client.aBool7175 = false;
					} else {
						Class209.printConsoleMessage("Failure", -822814139);
					}
					return;
				}
				if (string_0.equalsIgnoreCase("tk3")) {
					ParticleProducer.method11500(3, false);
					if (Class393.preferences.currentToolkit.getValue(389435618) == 3) {
						Class209.printConsoleMessage("Success", -832737067);
						Class393.preferences.setValue(Class393.preferences.aClass468_Sub18_8214, 3, 1626226442);
						Class190.savePreferences((byte) 28);
						client.aBool7175 = false;
					} else {
						Class209.printConsoleMessage("Failure", -129081346);
					}
					return;
				}
				if (string_0.equalsIgnoreCase("tk5")) {
					ParticleProducer.method11500(5, false);
					if (Class393.preferences.currentToolkit.getValue(-889180352) == 5) {
						Class209.printConsoleMessage("Success", -1022184236);
						Class393.preferences.setValue(Class393.preferences.aClass468_Sub18_8214, 5, -1654618197);
						Class190.savePreferences((byte) 119);
						client.aBool7175 = false;
					} else {
						Class209.printConsoleMessage("Failure", -1885199360);
					}
					return;
				}
				if (string_0.equalsIgnoreCase("clientdrop")) {
					if (client.gameState == 13) {
						Class151.method2592((byte) 34);
					} else if (client.gameState == 18) {
						client.aClass184_7475.aBool2298 = true;
					}
					return;
				}
				int i_13;
				if (string_0.equalsIgnoreCase("breakcon")) {
					BufferedConnectionContext[] arr_26 = client.aClass184Array7220;
					for (i_13 = 0; i_13 < arr_26.length; i_13++) {
						BufferedConnectionContext class184_28 = arr_26[i_13];
						if (class184_28.getConnection() != null) {
							class184_28.getConnection().method3320((byte) 52);
						}
					}
					Class119.JS5_STANDARD_REQUESTER.method5543();
					return;
				}
				if (string_0.startsWith("getclientvarpbit")) {
					i_10 = Integer.parseInt(string_0.substring(17));
					Class209.printConsoleMessage("varpbit=" + Class158_Sub1.PLAYER_VAR_PROVIDER.method241(i_10, -632025668), -1998632005);
					return;
				}
				if (string_0.startsWith("getclientvarp")) {
					i_10 = Integer.parseInt(string_0.substring(14));
					Class209.printConsoleMessage("varp=" + Class158_Sub1.PLAYER_VAR_PROVIDER.method240(i_10, 127032296), -2108704386);
					return;
				}
				String[] arr_24;
				if (string_0.startsWith("directlogin")) {
					arr_24 = MovingAnimation.method12681(string_0.substring(12), ' ');
					if (arr_24.length == 2) {
						Class2.method257(arr_24[0], arr_24[1]);
					}
					return;
				}
				if (string_0.startsWith("snlogin ")) {
					arr_24 = MovingAnimation.method12681(string_0.substring(8), ' ');
					i_13 = Integer.parseInt(arr_24[0]);
					Class282_Sub1.method11614(i_13);
					return;
				}
				File file_20;
				if (string_0.startsWith("setoutput ")) {
					file_20 = new File(string_0.substring(10));
					if (file_20.exists()) {
						file_20 = new File(string_0.substring(10) + "." + TextureDetails.time() + ".log");
						if (file_20.exists()) {
							Class209.printConsoleMessage("file already exists!", -2041307357);
							return;
						}
					}
					if (TextureDefinition.aFileOutputStream9481 != null) {
						TextureDefinition.aFileOutputStream9481.close();
						TextureDefinition.aFileOutputStream9481 = null;
					}
					try {
						TextureDefinition.aFileOutputStream9481 = new FileOutputStream(file_20);
					} catch (FileNotFoundException filenotfoundexception_15) {
						Class209.printConsoleMessage("Could not create " + file_20.getName(), -1294344572);
					} catch (SecurityException securityexception_16) {
						Class209.printConsoleMessage("Cannot write to " + file_20.getName(), -425204708);
					}
					return;
				}
				if (string_0.equals("closeoutput")) {
					if (TextureDefinition.aFileOutputStream9481 != null) {
						TextureDefinition.aFileOutputStream9481.close();
					}
					TextureDefinition.aFileOutputStream9481 = null;
					return;
				}
				if (string_0.startsWith("runscript ")) {
					file_20 = new File(string_0.substring(10));
					if (!file_20.exists()) {
						Class209.printConsoleMessage("No such file", -445176938);
						return;
					}
					byte[] bytes_5 = Class153.method2621(file_20, 1265044571);
					if (bytes_5 == null) {
						Class209.printConsoleMessage("Failed to read file", -1589533875);
						return;
					}
					String[] arr_12 = MovingAnimation.method12681(Class122.method2110(Class282_Sub17_Sub7.method15439(bytes_5), '\r', ""), '\n');
					Class341.method6074(arr_12, 1579654554);
				}
				if (client.gameState == 13) {
					TCPPacket tcpmessage_21 = Class271.method4828(OutgoingPacket.aClass379_4612, client.aClass184_7475.isaac, 704086040);
					tcpmessage_21.buffer.writeByte(string_0.length() + 3);
					tcpmessage_21.buffer.writeByte(bool_1 ? 1 : 0);
					tcpmessage_21.buffer.writeByte(bool_2 ? 1 : 0);
					tcpmessage_21.buffer.writeString(string_0);
					client.aClass184_7475.queuePacket(tcpmessage_21);
				}
			} catch (Exception exception_18) {
				Class209.printConsoleMessage(Message.ERROR_EXECUTING_COMMAND.translate(Class223.CURRENT_LANGUAGE, -1449846660), -1151783606);
				return;
			}
		}
		if (client.gameState != 13) {
			Class209.printConsoleMessage(Message.UNKNOWN_DEV_COMMAND.translate(Class223.CURRENT_LANGUAGE, -1344246012) + string_0, -1444759652);
		}
	}

	public static final int decodeLandscapeData(ObjectIndexLoader objectindexloader_0, byte[] bytes_1, int i_2, int i_3, int i_4, int i_5) {
		int i_7 = 0;
		RsByteBuffer rsbytebuffer_8 = new RsByteBuffer(bytes_1);
		int i_9 = -1;
		label56: while (true) {
			int i_10 = rsbytebuffer_8.readSmart2(-1436314957);
			if (i_10 == 0) {
				return i_7;
			}
			i_9 += i_10;
			int i_11 = 0;
			boolean bool_12 = false;
			while (true) {
				int i_13;
				while (!bool_12) {
					i_13 = rsbytebuffer_8.readUnsignedSmart(1841377249);
					if (i_13 == 0) {
						continue label56;
					}
					i_11 += i_13 - 1;
					int i_14 = i_11 & 0x3f;
					int i_15 = i_11 >> 6 & 0x3f;
					int i_16 = rsbytebuffer_8.readUnsignedByte() >> 2;
					int i_17 = i_15 + i_2;
					int i_18 = i_3 + i_14;
					if (i_17 > 0 && i_18 > 0 && i_17 < i_4 - 1 && i_18 < i_5 - 1) {
						ObjectDefinitions objectdefinitions_19 = objectindexloader_0.getObjectDefinitions(i_9);
						if (i_16 != SceneObjectType.GROUND_DECORATION.type || Class393.preferences.aClass468_Sub23_8202.method12897((byte) 59) != 0 || objectdefinitions_19.interactable != 0 || objectdefinitions_19.clipType == 1 || objectdefinitions_19.obstructsGround) {
							if (!objectdefinitions_19.method7968()) {
								++i_7;
							}
							bool_12 = true;
						}
					}
				}
				i_13 = rsbytebuffer_8.readUnsignedSmart(1964048281);
				if (i_13 == 0) {
					break;
				}
				rsbytebuffer_8.readUnsignedByte();
			}
		}
	}
}
