package MoneyApp.menu;

import java.util.Scanner;

public class List {
	public static int showList() {
		Scanner scan = new Scanner(System.in);
		System.out.println("========================");
		System.out.println("   一覧");
		System.out.println("========================");
		System.out.println("１：リスト");
		System.out.println("２：追加");
		System.out.println("３：編集");
		System.out.println("４：消去");
		System.out.println("０：戻る");
		System.out.println("========================");
		System.out.print("選択：");
		return scan.nextInt();
	}
}
