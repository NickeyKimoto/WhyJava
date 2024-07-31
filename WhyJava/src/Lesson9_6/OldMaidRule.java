package Lesson9_6;

//トランプゲームワークフレームのカードクラスをインポート
import trump.Card;
//トランプゲームワークフレームの手札クラスをインポート
import trump.Hand;
//トランプゲームワークフレームのルールクラスをインポート
import trump.Rule;
//トランプゲームワークフレームのテーブルクラスをインポート
import trump.Table;

/*
*クラス名：OldMaidRule
*概要：ババ抜きのルールを表すクラス
*作成者：N.Kimoto
*作成日：2024/07/03
*/
public class OldMaidRule implements Rule {
	
	/*
	*関数名：findCandidate
	*概要：テーブルに出すカードの組み合わせを探す
	*引数：自分の手札(Hand型), ゲームをしているテーブル(Table型)
	*戻り値：見つかったカードの組み合わせ(Card型配列)
	*作成者：N.Kimoto
	*作成日：2024/07/03
	*/
	public Card[] findCandidate(Hand myHand, Table gameTable) {
		
		// 手札の枚数を取得
		int numberOfCards = myHand.getNumberOfCards();
		// 返却するカード型配列を初期化(ない場合はNULLを返す)
		Card[] discardCard = null;
		
		// 最後に追加されたカードに合わせる
		final int ADJUST_LAST_CARD = -1;
		// 最後に追加されたカードを取得する
		int lastIndex = numberOfCards + ADJUST_LAST_CARD;
		
		// 同じ数のカードを探す
		OUTER : for (int i = lastIndex; i >= 0; i--) {
			// 手札のカード1枚を初期化
			Card playingCard = myHand.lookCard(i);
			
			// カードを比較する
			for (int j = i - 1; j >= 0; j--) {
			
				// 比較する対象のカードを宣言
				Card comparisonCard= myHand.lookCard(j);
				
				// 同じ数のカードが見つかった場合
				if (playingCard.getCardNumber() == comparisonCard.getCardNumber()) {
					
					// 返却する配列の要素数
					final int ELEMENT_COUNT = 2;
					// 返却するカード型配列の要素数を設定
					discardCard = new Card[ELEMENT_COUNT];
					// インデックス番号を表す数字を格納した配列を宣言
					int[] indexNumber = {0, 1};
					
					// 最後に追加されたカードを返却するカード型配列に格納
					discardCard[indexNumber[0]] = myHand.pickCard(i);
					// 同じ数字を持つカードを返却するカード型配列に格納
					discardCard[indexNumber[1]] = myHand.pickCard(j);
					// 探索を終了する
					break OUTER;
					
				}
			}
		}
		
		// 見つかったカードの組み合わせを返却
		return discardCard;
		
	}

}