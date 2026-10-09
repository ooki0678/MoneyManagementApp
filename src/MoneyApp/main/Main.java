package MoneyApp.main;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

import MoneyApp.function.Function;
import MoneyApp.menu.List;
import MoneyApp.menu.Menu;
import MoneyApp.menu.Setting;
import MoneyApp.money.Money;

public class Main {
	public static void main(String[] args) {
		ArrayList<Money> moneylist = new ArrayList<>();
		Function.Load(moneylist);
		Function function = new Function(moneylist);

		Scanner scan = new Scanner(System.in);
		while (true) {
			int menu = Menu.showMain();
			switch (menu) {
			case 1:
				int list = List.showList();
				switch (list) {
				case 1:
					System.out.println("========================" + "\n"
							+ "   リスト" + "\n"
							+ "========================");
					function.List(scan);
					break;
				case 2:
					System.out.println("========================" + "\n"
							+ "   追加" + "\n"
							+ "========================");
					function.Add(scan);
					break;
				case 3:
					System.out.println("========================" + "\n"
							+ "   編集" + "\n"
							+ "========================");
					function.Edit(scan);
					break;
				case 4:
					System.out.println("========================" + "\n"
							+ "   消去" + "\n"
							+ "========================");
					function.Delete(scan);
					break;
				case 0:
					System.out.println("メニューに戻ります。");
					break;
				}
				break;
			case 2:
				System.out.println("========================" + "\n"
						+ "   検索" + "\n"
						+ "========================");
				function.Search(scan);
				break;
			case 3:
				int setting = Setting.showSetting();
				switch (setting) {
				case 1:
					System.out.println("========================" + "\n"
							+ "   ログイン" + "\n"
							+ "========================");
					//					if () {
					//					System.out.println("====================" + "\n"
					//							+ "   ログアウト" + "\n"
					//							+ "====================");
					//					}
					break;
				case 2:
					System.out.println("========================" + "\n"
							+ "   困ったら" + "\n"
							+ "========================");
					break;
				case 0:
					System.out.println("メニューに戻ります。");
					break;
				}
				break;
			case 0:
				function.Save(moneylist);
				System.out.println("終了しました！");

				//GitのPersonal Access Token の有効期限の残り日数を表示している。
				System.out.println();
				LocalDate today = LocalDate.now();// 今日の日付
				LocalDate deadline = LocalDate.of(2026, 11, 6);// 有効期限
				long days = ChronoUnit.DAYS.between(today, deadline);// 今日から提出期限まで何日あるか

				System.out.println("GitのPersonal Access Tokenの有効期限まであと " + days + " 日です。");
				return;
			default:
				System.out.println("エラーが発生しましたメニューに戻ります。");
			}
		}
	}
}
