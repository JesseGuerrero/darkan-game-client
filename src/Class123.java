public class Class123 {

	boolean aBool1546 = false;
	Class476 aClass476_1541;
	MeshRasterizer aClass528_1544;
	boolean[] aBoolArray1553;
	Shadow aClass282_Sub50_Sub17_1551;
	ParticleSystem aClass539_1538;
	int anInt1548;
	boolean aBool1552 = false;
	boolean aBool1543 = false;
	int anInt1547 = -1;
	int anInt1554 = 0;
	ObjectIndexLoader aClass474_1536;
	int anInt1540;
	int anInt1555;
	int anInt1542;
	Class521_Sub1 aClass521_Sub1_1539;
	byte aByte1537;
	byte aByte1549;
	boolean aBool1550;
	Animation aClass456_1545;

	public void animate(int i_1, int i_2) {
		this.aBool1546 = true;
		this.method2124(false, i_1, 1, 1157413618);
	}

	int method2115(int i_1) {
		return this.anInt1554;
	}

	void method2116(Class476 class476_1, int i_2) {
		this.aClass476_1541 = class476_1;
		this.aClass528_1544 = null;
	}

	boolean method2117(int i_1) {
		return this.aBool1550;
	}

	void method2118(GraphicalRenderer graphicalrenderer_1, int i_2) {
		if (this.aClass282_Sub50_Sub17_1551 != null) {
			Vector3 vector3_3 = this.aClass521_Sub1_1539.method11166().aClass385_3595;
			IndexLoaders.MAP_REGION_DECODER.getSceneObjectManager(-1991984810).method3427(this.aClass282_Sub50_Sub17_1551, this.aByte1549, (int) vector3_3.x, (int) vector3_3.z, this.aBoolArray1553, (byte) -43);
			this.aBoolArray1553 = null;
			this.aClass282_Sub50_Sub17_1551 = null;
		}

	}

	void method2119(GraphicalRenderer graphicalrenderer_1, MeshRasterizer meshrasterizer_2, Matrix44Var matrix44var_3, int i_4, int i_5, int i_6, int i_7, boolean bool_8, int i_9) {
		Class87[] arr_10 = meshrasterizer_2.method11253();
		Class172[] arr_11 = meshrasterizer_2.method11274();
		if ((this.aClass539_1538 == null || this.aClass539_1538.aBool7132) && (arr_10 != null || arr_11 != null)) {
			ObjectDefinitions objectdefinitions_12 = this.aClass474_1536.getObjectDefinitions(this.anInt1540, 65280);
			if (objectdefinitions_12.toObjectIds != null) {
				objectdefinitions_12 = objectdefinitions_12.method8013((Interface42) (client.anInt7341 == 4 ? Class86.anInterface42_832 : Class158_Sub1.PLAYER_VAR_PROVIDER), (byte) -36);
			}

			if (objectdefinitions_12 != null) {
				this.aClass539_1538 = ParticleSystem.method11557(client.cycles, true);
			}
		}

		if (this.aClass539_1538 != null) {
			meshrasterizer_2.method11273(matrix44var_3);
			if (bool_8) {
				this.aClass539_1538.method11511(graphicalrenderer_1, (long) client.cycles, arr_10, arr_11, false);
			} else {
				this.aClass539_1538.method11512((long) client.cycles);
			}

			this.aClass539_1538.method11515(this.aByte1537, i_4, i_5, i_6, i_7);
		}

	}

	int method2121(byte b_1) {
		return -this.method2115(-771412764);
	}

	void method2124(boolean bool_1, int i_2, int i_3, int i_4) {
		int i_5 = i_2;
		boolean bool_6 = false;
		if (i_2 == -1) {
			ObjectDefinitions objectdefinitions_7 = this.aClass474_1536.getObjectDefinitions(this.anInt1540, 65280);
			ObjectDefinitions objectdefinitions_8 = objectdefinitions_7;
			if (objectdefinitions_7.toObjectIds != null) {
				objectdefinitions_7 = objectdefinitions_7.method8013((Interface42) (client.anInt7341 == 4 ? Class86.anInterface42_832 : Class158_Sub1.PLAYER_VAR_PROVIDER), (byte) 4);
			}

			if (objectdefinitions_7 == null) {
				return;
			}

			if (objectdefinitions_8 == objectdefinitions_7) {
				objectdefinitions_8 = null;
			}

			if (objectdefinitions_7.method7967((byte) 82)) {
				if (bool_1 && this.aClass456_1545.hasDefs() && objectdefinitions_7.method7979(this.aClass456_1545.method7597(-2131313079), -1433895387)) {
					return;
				}

				if (objectdefinitions_7.id != this.anInt1547) {
					bool_6 = objectdefinitions_7.aBool5702;
				}

				i_5 = objectdefinitions_7.method7977((byte) -48);
				if (objectdefinitions_7.method7976((short) 8704)) {
					i_3 = 0;
				} else {
					i_3 = 1;
				}
			} else if (objectdefinitions_8 != null && objectdefinitions_8.method7967((byte) 72)) {
				if (bool_1 && this.aClass456_1545.hasDefs() && objectdefinitions_8.method7979(this.aClass456_1545.method7597(-693467586), 512535535)) {
					return;
				}

				if (this.anInt1547 != objectdefinitions_7.id) {
					bool_6 = objectdefinitions_8.aBool5702;
				}

				i_5 = objectdefinitions_8.method7977((byte) 33);
				if (objectdefinitions_8.method7976((short) 8704)) {
					i_3 = 0;
				} else {
					i_3 = 1;
				}
			}
		}

		if (i_5 == -1) {
			this.aClass456_1545.method7569(-1, false, -2029510144);
		} else {
			this.aClass456_1545.method7571(i_5, 0, i_3, bool_6, -1486563257);
			this.anInt1548 = client.cycles;
			this.aBool1552 = false;
			this.aClass528_1544 = null;
		}

	}

	Class123(GraphicalRenderer graphicalrenderer_1, ObjectIndexLoader objectindexloader_2, ObjectDefinitions objectdefinitions_3, int i_4, int i_5, int i_6, int i_7, Class521_Sub1 class521_sub1_8, boolean bool_9, int i_10) {
		this.aClass474_1536 = objectindexloader_2;
		this.anInt1540 = objectdefinitions_3.id;
		this.anInt1555 = i_4;
		this.anInt1542 = i_5;
		this.aClass521_Sub1_1539 = class521_sub1_8;
		this.aBool1546 = i_10 != -1;
		this.aByte1537 = (byte) i_6;
		this.aByte1549 = (byte) i_7;
		this.aBool1543 = bool_9;
		this.aBool1550 = graphicalrenderer_1.method8402() && objectdefinitions_3.aBool5703 && !this.aBool1543;
		this.aClass456_1545 = new Class456_Sub2(class521_sub1_8, false);
		this.method2124(false, i_10, 1, 1157413618);
	}

	final MeshRasterizer method2132(GraphicalRenderer graphicalrenderer_1, int i_2, boolean bool_3, boolean bool_4, int i_5) {
		ObjectDefinitions objectdefinitions_6 = this.aClass474_1536.getObjectDefinitions(this.anInt1540, 65280);
		if (objectdefinitions_6.toObjectIds != null) {
			objectdefinitions_6 = objectdefinitions_6.method8013((Interface42) (client.anInt7341 == 4 ? Class86.anInterface42_832 : Class158_Sub1.PLAYER_VAR_PROVIDER), (byte) 31);
		}

		if (objectdefinitions_6 == null) {
			this.method2118(graphicalrenderer_1, 2015419671);
			this.anInt1547 = -1;
			return null;
		} else {
			if (!this.aBool1546 && this.anInt1547 != objectdefinitions_6.id) {
				this.method2124(true, -1, 0, 1157413618);
				this.aBool1552 = false;
				this.aClass528_1544 = null;
			}

			this.method2133(this.aClass521_Sub1_1539, 1031248161);
			if (bool_4) {
				bool_4 &= this.aBool1550 & !this.aBool1552 & Class393.preferences.aClass468_Sub2_8205.method12624((byte) -25) != 0;
			}

			if (bool_3 && !bool_4) {
				this.anInt1547 = objectdefinitions_6.id;
				return null;
			} else {
				Vector3 vector3_7 = this.aClass521_Sub1_1539.method11166().aClass385_3595;
				SceneObjectManager sceneobjectmanager_8 = IndexLoaders.MAP_REGION_DECODER.getSceneObjectManager(-2004926636);
				if (bool_4) {
					sceneobjectmanager_8.method3427(this.aClass282_Sub50_Sub17_1551, this.aByte1549, (int) vector3_7.x, (int) vector3_7.z, this.aBoolArray1553, (byte) -45);
					this.aBool1552 = false;
				}

				Ground class390_9 = sceneobjectmanager_8.aClass390Array2591[this.aByte1549];
				Ground class390_10;
				if (this.aBool1543) {
					class390_10 = sceneobjectmanager_8.aClass390Array2607[0];
				} else {
					class390_10 = this.aByte1549 < 3 ? sceneobjectmanager_8.aClass390Array2591[this.aByte1549 + 1] : null;
				}

				MeshRasterizer meshrasterizer_11 = null;
				if (this.aClass456_1545.hasDefs()) {
					if (bool_4) {
						i_2 |= 0x40000;
					}

					meshrasterizer_11 = objectdefinitions_6.method8012(graphicalrenderer_1, i_2, this.anInt1555 != 11 ? this.anInt1555 : 10, this.anInt1555 == 11 ? 4 + this.anInt1542 : this.anInt1542, class390_9, class390_10, (int) vector3_7.x, class390_9.averageHeight((int) vector3_7.x, (int) vector3_7.z, -2124588555), (int) vector3_7.z, this.aClass456_1545, this.aClass476_1541, 1502121981);
					if (meshrasterizer_11 != null) {
						if (bool_4) {
							if (this.aBoolArray1553 == null) {
								this.aBoolArray1553 = new boolean[4];
							}

							this.aClass282_Sub50_Sub17_1551 = meshrasterizer_11.ga(this.aClass282_Sub50_Sub17_1551);
							sceneobjectmanager_8.method3426(this.aClass282_Sub50_Sub17_1551, this.aByte1549, (int) vector3_7.x, (int) vector3_7.z, this.aBoolArray1553, (byte) -96);
							this.aBool1552 = true;
						}

						this.anInt1554 = meshrasterizer_11.YA();
						meshrasterizer_11.n();
					} else {
						this.aBoolArray1553 = null;
						this.aClass282_Sub50_Sub17_1551 = null;
						this.anInt1554 = 0;
					}

					this.aClass528_1544 = null;
				} else if (this.aClass528_1544 != null && (this.aClass528_1544.m() & i_2) == i_2 && this.anInt1547 == objectdefinitions_6.id) {
					meshrasterizer_11 = this.aClass528_1544;
				} else {
					if (this.aClass528_1544 != null) {
						i_2 |= this.aClass528_1544.m();
					}

					Class452 class452_12 = objectdefinitions_6.method8010(graphicalrenderer_1, i_2, this.anInt1555 != 11 ? this.anInt1555 : 10, this.anInt1555 == 11 ? 4 + this.anInt1542 : this.anInt1542, class390_9, class390_10, (int) vector3_7.x, class390_9.averageHeight((int) vector3_7.x, (int) vector3_7.z, -2029689654), (int) vector3_7.z, bool_4, this.aClass476_1541, 1886483873);
					if (class452_12 != null) {
						this.aClass528_1544 = meshrasterizer_11 = (MeshRasterizer) class452_12.anObject5443;
						if (bool_4) {
							this.aClass282_Sub50_Sub17_1551 = (Shadow) class452_12.anObject5444;
							this.aBoolArray1553 = null;
							sceneobjectmanager_8.method3426(this.aClass282_Sub50_Sub17_1551, this.aByte1549, (int) vector3_7.x, (int) vector3_7.z, (boolean[]) null, (byte) -31);
							this.aBool1552 = true;
						}

						this.anInt1554 = meshrasterizer_11.YA();
						meshrasterizer_11.n();
					} else {
						this.aBoolArray1553 = null;
						this.aClass282_Sub50_Sub17_1551 = null;
						this.aClass528_1544 = null;
						this.anInt1554 = 0;
					}
				}

				this.anInt1547 = objectdefinitions_6.id;
				return meshrasterizer_11;
			}
		}
	}

	void method2133(Class521_Sub1 class521_sub1_1, int i_2) {
		if (this.aClass456_1545.hasDefs()) {
			if (this.aClass456_1545.method7627(client.cycles - this.anInt1548, -1604815652)) {
				if (Class393.preferences.aClass468_Sub2_8205.method12624((byte) -127) == 2) {
					this.aBool1552 = false;
				}

				if (this.aClass456_1545.method7580(487845582)) {
					this.aClass456_1545.method7567(-1, (short) 8960);
					this.aBool1546 = false;
					this.method2124(false, -1, 0, 1157413618);
				}
			}
		} else {
			this.method2124(false, -1, 0, 1157413618);
		}

		this.anInt1548 = client.cycles;
	}

	void method2136(GraphicalRenderer graphicalrenderer_1, byte b_2) {
		this.method2132(graphicalrenderer_1, 262144, true, true, -1384937123);
	}

	public static int method2149(int i_0) {
		if (IndexReference.anInt1039 == -1) {
			IndexReference[] arr_1 = Class158_Sub1.method13767(-1513831265);

			for (int i_2 = 0; i_2 < arr_1.length; i_2++) {
				IndexReference indexreference_3 = arr_1[i_2];
				if (indexreference_3.indexId > IndexReference.anInt1039) {
					IndexReference.anInt1039 = indexreference_3.indexId;
				}
			}

			++IndexReference.anInt1039;
		}

		return IndexReference.anInt1039;
	}

	static final void method2150(CS2Executor cs2executor_0, byte b_1) {
		int i_2 = cs2executor_0.intStack[--cs2executor_0.intStackPtr];
		IComponentDefinitions icomponentdefinitions_3 = Class117.method1981(i_2, (byte) 53);
		Interface interface_4 = Class468_Sub8.aClass98Array7889[i_2 >> 16];
		NamedFileReference.method869(icomponentdefinitions_3, interface_4, cs2executor_0, -1209481120);
	}

	static final void method2151(CS2Executor cs2executor_0, int i_1) {
		cs2executor_0.intStackPtr -= 2;
		int i_2 = cs2executor_0.intStack[cs2executor_0.intStackPtr];
		int i_3 = cs2executor_0.intStack[cs2executor_0.intStackPtr + 1];
		ParamDefinitions attributedefault_4 = IndexLoaders.ITEM_DEFAULTS.method7069(i_3, (byte) 0);
		if (attributedefault_4.method7319(1555061388)) {
			cs2executor_0.stringStack[++cs2executor_0.stringStackPtr - 1] = IndexLoaders.aClass421_2658.method7036(i_2, -1979038944).method14751(i_3, attributedefault_4.typeName, 1092559999);
		} else {
			cs2executor_0.intStack[++cs2executor_0.intStackPtr - 1] = IndexLoaders.aClass421_2658.method7036(i_2, 1053782715).method14750(i_3, attributedefault_4.defaultInt, (byte) 53);
		}

	}

	public static void method2152(int i_0, int i_1) {
		Class282_Sub37 class282_sub37_2 = (Class282_Sub37) Class492.aClass465_5774.get((long) i_0);
		if (class282_sub37_2 != null) {
			class282_sub37_2.aBool7995 = !class282_sub37_2.aBool7995;
			class282_sub37_2.aClass278_Sub1_8001.method4924(class282_sub37_2.aBool7995, -1401371611);
		}

	}

	static final void method2153(CS2Executor cs2executor_0, int i_1) {
		cs2executor_0.intStack[++cs2executor_0.intStackPtr - 1] = Class9.anInt113;
	}

}
