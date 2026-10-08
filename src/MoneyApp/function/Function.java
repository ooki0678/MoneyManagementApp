package MoneyApp.function;

import java.io.BufferedWriter;
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
				bw.write("========================"
						+ "項目" + money.getProductltem() + "\n"
						+ "商品名" + money.getProduct()
						+ "値段" + money.getPrice() + "\n"
						+ "購入日" + money.getYear() + "/" + money.getMonth() + "/" + money.getDay());
				bw.newLine();
			}
			bw.close();

		} catch (IOException e) {
			System.out.println("保存に失敗しました");
		}
	}

	//	更新　
	public void Load() {

	}

	//	リスト
	public void List(Scanner scan) {

	}

	//	追加　
	public void Add(Scanner scan) {

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
