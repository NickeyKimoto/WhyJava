package Lesson9_2;

// Cardクラスをインポート
import trump.Card;

/*
*クラス名：FantanTable
*概要：七並べのテーブルを表すクラス
*作成者：N.Kimoto
*作成日：2024/07/02
*/
public class FantanTable {
	
	// カードを並べるテーブルを表す2次元配列を宣言
	private Card[][] fantanTable = new Card[Card.SUIT_NUMBER][Card.CARD_NUMBER];
	
	/*
	*関数名：putCard
	*概要：カードを置く
	*引数：置くカード(Card型配列)
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public void putCard(Card[] placeCard) {
		
		// 配置するカードのスートを取得
		int cardSuit = placeCard[0].getCardSuit();
		// 配置するカードの数字を取得
		int cardNumber = placeCard[0].getCardNumber();
		
		// カードを配置する
		fantanTable[--cardSuit][--cardNumber] = placeCard[0];
	}
	
	/*
	*関数名：getCards
	*概要：カードを見る
	*引数：なし
	*戻り値：テーブルに置かれたカード(Card型配列)
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public Card[][] getCards() {
		
		// テーブルを表示
		return fantanTable;
		
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
		for(int i = 0; i < fantanTable.length; i++) {
			
			// 文字列にそのスートの数字のカードを追加
			for(int j = 0; j < fantanTable[i].length; j++) {
				
				// カードが置かれていた場合
				if (fantanTable[i][j] != null) {
					
					// 文字列にカードを追加
					numberString.append(fantanTable[i][j]);
					
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
