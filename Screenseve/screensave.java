package Screenseve;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class screensave extends JFrame implements ActionListener{
	JLabel label;
	static ArrayList<String>array = new ArrayList<String>(1);
	int counta = 0;


	public static void main(String[] args) {
		screensave frame = new screensave();

		//ファイル閉じてプログラム終了処理
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ウィンドウの位置x,y ウィンドウサイズx,y
		frame.setBounds(400, 400, 300, 200);
		frame.setTitle("保存先選択");
		frame.setVisible(true);

		//return array.get(0);

	}
		screensave(){//ボタンの配置、レイアウト
		//インスタンス生成,引数ボタンのテキスト
		JButton button = new JButton("file select");
		button.addActionListener(this);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(button);

		label = new JLabel();

		JPanel labelPanel = new JPanel();
		labelPanel.add(label);

		getContentPane().add(labelPanel, BorderLayout.CENTER);
		getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
	}


	public void actionPerformed(ActionEvent e) {//ボタンが押された時の処理
		JFileChooser filechooser = new JFileChooser("C:\\");
		filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		int selected = filechooser.showSaveDialog (this);
		if(selected == filechooser.showSaveDialog(this)) {
			File file = filechooser.getSelectedFile();
			label.setText(file.getAbsolutePath());//パスをゲットする

				if(array.size() == 0) {
					array.add(file.getAbsolutePath());
				}
				else {
					for(int i=0;array.size()>i; i++) {
						array.remove(i);
					}
					array.add(file.getAbsolutePath());
				}

				if(counta < 1){//ツールは一度のみ
					new tool();
					counta++;
				}
				System.out.println(array.get(0));

		}
	}
	public String getString() {
		return array.get(0);
	}
}
