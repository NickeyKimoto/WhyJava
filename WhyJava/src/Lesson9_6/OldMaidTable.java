package Lesson9_6;

// ArrayListクラスをインポート
import java.util.ArrayList;

//トランプゲームワークフレームのカードクラスをインポート
import trump.Card;
//トランプゲームワークフレームのテーブルクラスをインポート
import trump.Table;

/*
*クラス名：OldMaidTable
*概要：ババ抜きのテーブルを表すクラス
*作成者：N.Kimoto
*作成日：2024/07/03
*/
public class OldMaidTable implements Table {
	
	// 捨てられたカードを保持しておくためのリスト
	private ArrayList putCard = new ArrayList();
	// カードを並べるテーブルを表す2次元配列を宣言
	private Card[][] oldMaidTable = new Card[Card.SUIT_NUMBER][Card.CARD_NUMBER];
	
	/*
	*関数名：putCard
	*概要：テーブルにカードを捨てる
	*引数：捨てる(Card型配列)
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/07/03
	*/
	public void putCard(Card[] discardCard) {
		
		// 取得したカードを捨てるカードを捨てる
		for(int i = 0; i < discardCard.length; i++) {
			
			// 捨てるカードのスートを取得
			int cardSuit = discardCard[0].getCardSuit();
			// 捨てるカードの数字を取得
			int cardNumber = discardCard[0].getCardNumber();
			
			// カードを捨てる
			oldMaidTable[--cardSuit][--cardNumber] = discardCard[0];
			
			// 捨てられたカードを表示する
			System.out.print(discardCard[i] + " ");
			// 捨てられたカードはリストに追加して保持しておく
			putCard.add(discardCard);
		}
		
		// 捨てたカードを表示
		System.out.println("を捨てました");
		
	}
	
	/*
	*関数名：getCards
	*概要：テーブルに捨てたカードを返却
	*引数：なし
	*戻り値：捨てたカード(Card型配列)
	*作成者：N.Kimoto
	*作成日：2024/07/03
	*/
	public Card[][] getCards() {
		
		// テーブルを返却
		return oldMaidTable;
		
	}
	
	/*
	*関数名：toString
	*概要：テーブルを表す文字列を返す
	*引数：なし
	*戻り値：テーブル(String型)
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public String toString() {
		
		// 返却する文字列を初期化
		StringBuffer numberString = new StringBuffer();
		
		// 文字列にそのスートの列のカードを追加
		for(int i = 0; i < oldMaidTable.length; i++) {
			
			// 文字列にそのスートの数字のカードを追加
			for(int j = 0; j < oldMaidTable[i].length; j++) {
				
				// カードが置かれていた場合
				if (oldMaidTable[i][j] != null) {
					
					// 文字列にカードを追加
					numberString.append(oldMaidTable[i][j]);
					
				// カードが置かれていなかった場合
				} else {
					
					// 置かれていないことを表す表記を追加
					numberString.append("..");
				}
				
				// 間隔を空けるためのスペースを追加
				numberString.append(" ");
			}
			
			// そのスートが終わり次第改行する
			numberString.append("\n");
		}
		
		// テーブルを表す文字列を返却
		return numberString.toString();
	}

}
