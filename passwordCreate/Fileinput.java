package passwordCreate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Fileinput {

	Fileinput() {

	}

	//パスワードを書き込む
	public void Fileinput(Character password) {
		try {
			File file = new File("C:\\Users\\\\Desktop\\password.txt");
			FileWriter fileopen = new FileWriter(file, true);//trueだと最後尾に追加、falseだと先頭に追加
			fileopen.write(password);
			fileopen.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
