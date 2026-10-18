package MoneyApp.function;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import MoneyApp.money.Money;

public class Function {
	//moneylistを保持するフィールド
	ArrayList<Money> moneylist;

	// コンストラクタ
	public Function(ArrayList<Money> moneylist) {
		this.moneylist = moneylist;
	}

	//	保存
	public static void Save(ArrayList<Money> moneylist) {

		try {
			BufferedWriter bw = new BufferedWriter(
					new FileWriter("money.txt"));

			for (Money money : moneylist) {

				bw.write(
						money.getProductltem() + ","
								+ money.getProduct() + "," +
								+money.getPrice() + "," +
								+money.getYear() + "," +
								+money.getMonth() + "," +
								+money.getDay());

				bw.newLine();
			}

			bw.close();
			System.out.println();
			System.out.println("保存完了");

		} catch (IOException e) {
			System.out.println();
			System.out.println("保存に失敗しました");
		}
	}

	//	更新　
	public static void Load(ArrayList<Money> moneylist) {

		try {
			BufferedReader br = new BufferedReader(
					new FileReader("money.txt"));

			String line;

			while ((line = br.readLine()) != null) {

				String[] data = line.split(",");

				String productltem = data[0];
				String product = data[1];
				int price = Integer.parseInt(data[2]);
				int year = Integer.parseInt(data[3]);
				int month = Integer.parseInt(data[4]);
				int day = Integer.parseInt(data[5]);

				Money money = new Money(
						productltem,
						product,
						price,
						year,
						month,
						day);

				moneylist.add(money);
			}

			br.close();

			System.out.println();
			System.out.println("読み込みました！");

		} catch (IOException e) {
			System.out.println();
			System.out.println("読み込みに失敗しました。");
		}
	}

	//	リスト
	public void List(Scanner scan) {
		if (moneylist.isEmpty()) {
			System.out.println("該当するものがありません。");
			return;
		}

		System.out.println("========================");
		int nonberList = 1;
		for (Money money : moneylist) {
			System.out.println(nonberList + "：" + money.getProduct());
			nonberList++;
		}
		System.out.println("0：戻る");
		System.out.println("========================");
		System.out.print("選択：");
		int selectList = scan.nextInt();
		System.out.println();

		if (selectList == 0) {
			return;
		}
		System.out.println();

		System.out.println("========================\n"
				+ "   詳細\n"
				+ "========================");
		Money money = moneylist.get(selectList - 1);
		money.moneyIndication();
		System.out.println();

	}

	//	追加　
	public void Add(Scanner scan) {
		System.out.println("========================");
		System.out.print("項目：");
		String Productltem = scan.next();

		System.out.print("商品名：");
		String Product = scan.next();

		System.out.print("値段：");
		int Price = scan.nextInt();

		System.out.print("購入年：");
		int Year = scan.nextInt();

		System.out.print("購入月：");
		int Month = scan.nextInt();

		System.out.print("購入日：");
		int Day = scan.nextInt();
		System.out.println("========================");
		moneylist.add(new Money(Productltem, Product, Price, Year, Month, Day));
		System.out.println("項目" + "：" + Productltem + "\n"
				+ "商品名" + "：" + Product + "\n"
				+ "値段" + "：" + Price + "円" + "\n"
				+ "購入日" + "：" + Year + "/" + Month + "/" + Day + "\n"
				+ "========================");
		System.out.println("追加完了");
		System.out.println();

	}

	//	検索
	public void Search(Scanner scan) {
		System.out.print("検索：");
		String keyword = scan.next();

		// ① 検索結果を集める
		ArrayList<Money> results = new ArrayList<>();

		for (Money money : moneylist) {
			if (money.getProduct().equals(keyword)) {
				results.add(money);
			}
		}

		// ② 検索結果があるか確認
		if (results.isEmpty()) {
			System.out.println("該当するものがありません。");
			return;
		}

		// ③ 検索結果を表示
		System.out.println("========================");

		for (int i = 0; i < results.size(); i++) {
			System.out.println((i + 1) + "："
					+ results.get(i).getProduct());
		}

		System.out.println("0：戻る");
		System.out.println("========================");
		System.out.print("選択：");

		int selectSearch = scan.nextInt();

		if (selectSearch == 0) {
			System.out.println("メニューに戻ります。");
			return;
		}

		// ④ 選択した商品の詳細を表示
		if (selectSearch < 1 || selectSearch > results.size()) {
			System.out.println("無効な番号です。");
			return;
		}

		Money selectedMoney = results.get(selectSearch - 1);
		selectedMoney.moneyIndication();
	}

	//	編集
	public void Edit(Scanner scan) {
		if (moneylist.isEmpty()) {
			System.out.println("該当するものがありません。");
			System.out.println();
			return;
		}

		System.out.println();
		System.out.println("========================");
		int nonberEdit = 1;
		for (Money money : moneylist) {
			System.out.println(nonberEdit + "：" + money.getProduct());
			nonberEdit++;
		}
		System.out.println("0：戻る");
		System.out.println("========================");
		System.out.print("選択：");
		int selectEdit = scan.nextInt();
		System.out.println();
		if (selectEdit == 0) {
			return;
		}
		System.out.println();

		System.out.println("========================\n"
				+ "   詳細\n"
				+ "========================");

		Money money = moneylist.get(selectEdit - 1);
		money.moneyIndication();
		System.out.println();

		System.out.println("========================\n"
				+ "   編集方法" + "\n"
				+ "========================");
		System.out.println();

		System.out.println("========================");
		System.out.println("1：全編集");
		System.out.println("2：部分編集");
		System.out.println("0：戻る");
		System.out.println("========================");
		System.out.print("選択：");
		int Edit = scan.nextInt();
		System.out.println("編集完了");
		System.out.println();

		switch (Edit) {
		case 1:
			System.out.println("========================\n"
					+ "   全編集\n"
					+ "========================");
			System.out.println("========================");
			System.out.print("New項目：");
			String EditProductltem = scan.next();
			money.setProductltem(EditProductltem);
			System.out.print("New商品名：");
			String EditProduct = scan.next();
			money.setProduct(EditProduct);
			System.out.print("New値段：");
			int EditPrice = scan.nextInt();
			money.setPrice(EditPrice);
			System.out.print("New購入年：");
			int EditYear = scan.nextInt();
			money.setYear(EditYear);
			System.out.print("New購入月：");
			int EditMonth = scan.nextInt();
			money.setMonth(EditMonth);
			System.out.print("New購入日：");
			int EditDay = scan.nextInt();
			money.setDay(EditDay);
			System.out.println("========================");
			System.out.println();

			break;
		case 2:
			System.out.println("========================\n"
					+ "部分編集\n"
					+ "========================");
			System.out.println("========================");
			System.out.println("1：New項目");
			System.out.println("2：New商品名");
			System.out.println("3：New値段");
			System.out.println("4：New購入年");
			System.out.println("5：New購入月");
			System.out.println("6：New購入日");
			System.out.println("0：戻る");
			System.out.println("========================");
			System.out.print("選択：");
			int Edit2 = scan.nextInt();
			System.out.println();

			switch (Edit2) {
			case 1:
				System.out.println("========================\n"
						+ "   New項目\n"
						+ "========================");
				String Edit2Productltem = scan.next();
				money.setProductltem(Edit2Productltem);

				break;
			case 2:
				System.out.println("========================\n"
						+ "   New商品名\n"
						+ "========================");
				String Edit2Product = scan.next();
				money.setProduct(Edit2Product);
				break;
			case 3:
				System.out.println("========================\n"
						+ "   New値段\n"
						+ "========================");
				int Edit2Price = scan.nextInt();
				money.setPrice(Edit2Price);
				break;
			case 4:
				System.out.println("========================\n"
						+ "   New購入年\n"
						+ "========================");
				int Edit2Year = scan.nextInt();
				money.setYear(Edit2Year);
				break;
			case 5:
				System.out.println("========================\n"
						+ "   New購入月\n"
						+ "========================");
				int Edit2Month = scan.nextInt();
				money.setMonth(Edit2Month);
				break;
			case 6:
				System.out.println("========================\n"
						+ "   New購入日\n"
						+ "========================");
				int Edit2Day = scan.nextInt();
				money.setDay(Edit2Day);
				break;
			case 0:
				System.out.println("メニューに戻ります。");
				return;
			default:
				break;
			}

			break;
		case 0:
			System.out.println("メニューに戻ります。");
			return;
		default:
			break;
		}

	}

	//	消去
	public void Delete(Scanner scan) {
		if (moneylist.isEmpty()) {
			System.out.println("該当するものがありません。");
			return;
		}

		System.out.println("========================");
		int nonberDelete = 1;
		for (Money money : moneylist) {
			System.out.println(nonberDelete + "：" + money.getProduct());
			nonberDelete++;
		}
		System.out.println("0：戻る");
		System.out.println("========================");
		System.out.print("選択：");
		int selectDelete = scan.nextInt();
		scan.nextLine();
		System.out.println();
		if (selectDelete == 0) {
			return;
		}
		System.out.println();

		Money money = moneylist.get(selectDelete - 1);
		money.moneyIndication();
		System.out.println();

		System.out.println(money.getProduct() + "をほんとに消していいですか？");
		System.out.println("========================");
		System.out.println("1：はい");
		System.out.println("2：いいえ");
		System.out.println("========================");
		System.out.print("選択：");
		int selectDelete1 = scan.nextInt();

		if (selectDelete1 == 1) {
			moneylist.remove(money);
			System.out.println(money.getProduct() + "消去しました！。");
		} else {
			System.out.println(money.getProduct() + "の消去をやめて戻ります");
			return;
		}
	}

	//ログイン/ログアウト/会委員登録
}
