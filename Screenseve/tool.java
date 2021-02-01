package Screenseve;
import java.awt.AWTException;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



//toolクラスはオーバライドされる関数をまとめているクラスです。
class tool extends JFrame {
	//インスタンス生成
	getscreen screensizeget = new getscreen();
	screensave screensave1 = new screensave();
	String pathname;

	//ウィンドウ関数
	public static void window(int x,int y) {//xとyはウィンドウのサイズです
		JFrame frame = new JFrame("ウィンドウ表示");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//4種類の終了オプションがある
		frame.setSize(x,y);//ウィンドウの設定（横幅 , 高さ）
		frame.setVisible(true);//true=見える、false=透明化
	}

	//警告ダイアログ関数
	public static void popmenu(String txt){
	//JFrame frame = new JFrame();
	JOptionPane.showMessageDialog(null, txt);
	}

	//ボタン関数

	public tool() {//
		screensizeget.screen();
		setBounds(screensizeget.getScreenwidth()/3,screensizeget.getScreenHeight()/3, 400, 100);
		setTitle("java screen images");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		JButton b = new JButton("画面保存");

		//ボタンをフレームに追加
		add(b);

		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {//←このかっこの中にボタンが押された時の処理を書く

				try {
					//モニターサイズ設定
					//screensizeget.screen();
					//キャプチャーサイズ設定
					Rectangle bounds = new Rectangle(0,0,screensizeget.getScreenwidth(),screensizeget.getScreenHeight());

					//これで画面キャプチャー
					Robot robot = new Robot();
					BufferedImage image = robot.createScreenCapture(bounds);

					//ファイルのフォーマット指定
					SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HHmm_SS");

					//保存先設定
					//String dirName = "C:\\Users\\Fujitsu2018\\Desktop";
					String dirName = screensave1.getString();

					//ファイル名設定
					String fileName = "" + format.format(new Date()) + ".jpg";
					ImageIO.write(image, "jpg", new File(dirName,fileName));

					JOptionPane.showMessageDialog(null,"画像を保存しました");

				}catch(AWTException ee) {
					ee.printStackTrace();
				}catch(IOException ee){
					ee.printStackTrace();
				}
			}
		});
		//可視化ウィンドウ
			setVisible(true);
		}
}
