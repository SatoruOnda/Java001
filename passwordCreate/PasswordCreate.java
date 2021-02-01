package passwordCreate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class PasswordCreate {
	public static void main(String args[]) {
		ArrayList<Character> passstr = new ArrayList<Character>(10);

		//－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
		//パスワードを作成する
		Random random = new Random();
		//パスワードの長さ
		int passwordlength = 100;

		Letter letter = new Letter();

		//ランダムの数字1～62
		for (int i = 0; i < passwordlength; i++) {
			int txt = 0;
			//txtにランダムの数値を代入
			txt = random.nextInt(62) + 1;
			//レター関数にランダムの数値を渡す
			char passkey = letter.Letter(txt);
			//Letter関数で戻り値'あ'はエラーなので終了する
			if (passkey == 'あ') {
				return;
			}
			passstr.add(passkey);
		}

		//－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
		//ファイルに書き込む
		//passstr.add('d');
		Fileinput fileinput = new Fileinput();
		for (int i = 0; i < passwordlength; i++) {
			fileinput.Fileinput(passstr.get(i));
			//Fileinput fileinput = new Fileinput(passstr.get(i));
		}
		//改行挿入
		try {
			File file = new File("C:\\Users\\\\Desktop\\password.txt");
			FileWriter fileopen = new FileWriter(file, true);//trueだと最後尾に追加、falseだと先頭に追加
			fileopen.write("\n");
			fileopen.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("終了");
	}
}
