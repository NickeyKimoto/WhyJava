package Lesson7_2;

// ArrayListクラスをインポート
import java.util.ArrayList;

/*
*クラス名：Table
*概要：ババ抜きを行うテーブルを管理するクラス
*作成者：N.Kimoto
*作成日：2024/07/01
*/
public class Table {
	
	// 捨てられたカードを保持しておくためのリストを初期化
	private ArrayList disposedCards = new ArrayList();
	
	/*
	*関数名：disposeCard
	*概要：カードを捨てる
	*引数：捨てるカード(Card型配列)
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public void disposeCard(Card handCard[]) {
		// 配列に格納されたカードを捨てる
		for(int i = 0; i < handCard.length; i++) {
			// 捨てられたカードを表示する
			System.out.print(handCard[i] + " ");
		}
		
		// 捨てたことを表示
		System.out.println("を捨てました");
		
		// 捨てられたカードはリストに追加して保持しておく
		disposedCards.add(handCard);
	}
	
}
