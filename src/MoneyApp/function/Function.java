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
	//Money型のArrayList
	ArrayList<Money> moneylist = new ArrayList<>();

	//コンストラクター
	public Function(ArrayList<Money> moneylist) {
		super();
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

			System.out.println("保存完了");

		} catch (IOException e) {
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
		int nonber = 1;
		for (Money money : moneylist) {
			System.out.println(nonber + "：" + money.getProduct());
			nonber++;
		}
		System.out.println("========================");

		System.out.print("選択：");
		int select = scan.nextInt();
		scan.nextLine();
		if (select == 0) {
			return;
		}
		System.out.println();

		System.out.println("========================\n"
				+ "詳細" + "\n"
				+ "========================");
		Money money = moneylist.get(select - 1);
		money.moneyIndication();

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
		scan.nextLine();
		System.out.print("購入年：");
		int Year = scan.nextInt();
		scan.nextLine();
		System.out.print("購入月：");
		int Month = scan.nextInt();
		scan.nextLine();
		System.out.print("購入日：");
		int Day = scan.nextInt();
		scan.nextLine();
		System.out.println("========================");

		moneylist.add(new Money(Productltem, Product, Price, Year, Month, Day));

	}

	//	検索
	public void Search(Scanner scan) {

	}

	//	編集
	public void Edit(Scanner scan) {

	}

	//	消去
	public void Delete(Scanner scan) {

	}
}
