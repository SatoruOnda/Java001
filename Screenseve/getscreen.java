package Screenseve;

import java.awt.Dimension;
import java.awt.Toolkit;

public class getscreen {

	int screenWidth = 0;
	int screenHeight = 0;

	public void screen() {

		//インスタンス作成
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();

		screenWidth = screensize.width;
		screenHeight = screensize.height;

		System.out.println(screenWidth + ", " + screenHeight);
	}
	public int getScreenwidth() {
		return screenWidth;
	}
	public int getScreenHeight() {
		return screenHeight;
	}
}
