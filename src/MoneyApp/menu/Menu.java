package MoneyApp.menu;

import java.util.Scanner;

public class Menu {
	public static int showMain() {
		Scanner scan = new Scanner(System.in);
		System.out.println("========================");
		System.out.println("   お金管理アプリ");
		System.out.println("========================");
		System.out.println("１：一覧");
		System.out.println("２：検索");
		System.out.println("３：設定");
		System.out.println("０：終了");
		System.out.println("========================");
		System.out.print("選択：");
		return scan.nextInt();
	}
}
