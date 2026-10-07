package MoneyApp.menu;

import java.util.Scanner;

public class Setting {
	public static int showSetting() {
		Scanner scan = new Scanner(System.in);
		System.out.println("========================");
		System.out.println("   設定");
		System.out.println("========================");
		System.out.println("１：ログイン");
		//		System.out.println("１：ログアウト");
		System.out.println("２：困ったら");
		System.out.println("０：戻る");
		System.out.println("========================");
		System.out.print("選択：");
		return scan.nextInt();
	}
}
