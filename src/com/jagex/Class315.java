package com.jagex;
import java.awt.Canvas;

import jaggl.OpenGL;

public class Class315 {

	Class315() throws Throwable {
		throw new Error();
	}

	public static GraphicalRenderer getOpenGLRenderer(Canvas canvas_0, Interface22 interface22_1, Index index_2, int i_3) {
		try {
			boolean bool_5 = GraphicalRenderer_Sub2.method13893();
			if (!bool_5) {
				throw new RuntimeException("");
			} else if (!Class362.getNativeLibraryLoader().loadLibrary("jaggl", -8022122)) {
				throw new RuntimeException("");
			} else {
				Class459.method7679(canvas_0, 1663051494);
				OpenGL opengl_6 = new OpenGL();
				long long_7 = opengl_6.init(canvas_0, 8, 8, 8, 24, 0, i_3);
				if (long_7 == 0L) {
					throw new RuntimeException("");
				} else {
					GraphicalRenderer_Sub2_Sub1 class505_sub2_sub1_9 = new GraphicalRenderer_Sub2_Sub1(opengl_6, canvas_0, long_7, interface22_1, index_2, i_3);
					class505_sub2_sub1_9.method14147();
					return class505_sub2_sub1_9;
				}
			}
		} catch (Throwable throwable_11) {
			throw new RuntimeException("");
		}
	}

}
