package Lesson7_2;

// ArrayListクラスをインポート
import java.util.ArrayList;

/*
*クラス名：Hand
*概要：ババ抜きの手札を管理するクラス
*作成者：N.Kimoto
*作成日：2024/07/02
*/
public class Hand {
	
	// 手札にあるカードを保持するためのリストを表すフィールドを宣言
	private ArrayList<Card> handCards = new ArrayList<Card>();
	
	/*
	*関数名：addCard
	*概要：カードリストの最後に追加する
	*引数：加えるカード(Card型)
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public void addCard(Card playingCard) {
		// カードリストの最後に追加する
		handCards.add(playingCard);
	}
	
	/*
	*関数名：pickCard
	*概要：カードを引く
	*引数：なし
	*戻り値：引いたカード(Card型)
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public Card pickCard() {
		// 引いたカードを初期化
		Card pickedCard = (Card) handCards.remove(0);
		// 引いたカードを返却
		return pickedCard;
	}
	
	/*
	*関数名：shuffle
	*概要：シャッフルする
	*引数：なし
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public void shuffle() {
		// 手札の枚数を取得
		int handCardNumber = handCards.size();
		// カードを抜き出す位置を初期化
		int extractionPosition = 0;
		// シャッフルする回数を調整する定数を宣言
		final int REPEATS_SHUFFLE = 2;
		
		// カードをランダムに抜き取って最後に加える動作を繰り返す
		for (int i = 0; i < handCardNumber * REPEATS_SHUFFLE; i++) {
			// ランダムな位置からカードを1枚抜き取る
			extractionPosition = (int) (Math.random() * handCardNumber);
			// 引いたカードを初期化
			Card pickedCard = (Card) handCards.remove(extractionPosition);
			
			// 抜き取ったカードを最後に加える
			handCards.add(pickedCard);
			
		}
		
	}
	
	/*
	*関数名：getNumberOfCards
	*概要：枚数を数える
	*引数：なし
	*戻り値：枚数(int型)
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public int getNumberOfCards() {
		// 枚数を返却
		return handCards.size();
	}
	
	/*
	*関数名：findSameNumberCard
	*概要：数字が同じカードを探す
	*引数：なし
	*戻り値：数字が同じカード(Card型配列)
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public Card[] findSameNumberCard() {
		// 手札の枚数を初期化
		int numberOfCards = handCards.size();
		// 返却するカード型配列を初期化
		Card[] sameCards = null;
		
		// 手札にカードが1枚もない場合は何もしない
		if (numberOfCards > 0) {
			// 手札の最後のカードの位置に調整する定数を宣言
			final int ADJUST_CARD_LAST = -1;
			// 手札の最後のカードの位置を初期化
			int lastIndex = numberOfCards + ADJUST_CARD_LAST;
			// 最後に追加されたカードを手札の最後尾に追加
			Card lastAddedCard = (Card) handCards.get(lastIndex);
			
			// 最後に追加されたカードの数字を取得する
			int lastAddedCardNumber = lastAddedCard.getCardNumber();
			
			// 手札のカードの数字を調査
			for (int i = 0; i < lastIndex; i++) {
				// 1枚ずつ調べる
				Card playingCard = (Card) handCards.get(i);
				
				// そのカードの数字が最後に追加されたカードの数字と一致した場合
				if (playingCard.getCardNumber() == lastAddedCardNumber) {
					// 返却する配列の要素数を表す定数を宣言
					final int ELEMENT_COUNT = 2;
					// 配列のインデックス番号を表す数字を格納した配列を宣言
					final int[] INDEX_NUMBER = {0, 1};
					// 返却する配列の要素数を変更
					sameCards = new Card[ELEMENT_COUNT];
					// 最後に追加されたカードを返却する配列に追加
					sameCards[INDEX_NUMBER[0]] = (Card) handCards.remove(lastIndex);
					// 同じ数字を持つカードを返却する配列に追加
					sameCards[INDEX_NUMBER[1]] = (Card) handCards.remove(i);
					// 調査を終了する
					break;
					
				}
			}
		}
		// 同じ数字のカードをを返却
		return sameCards;
	}
	
	/*
	*関数名：toString
	*概要：手札にあるカードを文字列で表現する
	*引数：なし
	*戻り値：手札にあるカード(String型)
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public String toString() {
		// 返却する文字列を初期化
		StringBuffer numberString = new StringBuffer();
		// 手札の枚数を初期化
		int handSize = handCards.size();
		// 手札が1枚以上の場合
		if (handSize > 0) {
			// そのカードを順番に表示
			for(int i = 0; i < handSize; i++) {
				// 手札のカードを初期化
				Card playingCard = (Card) handCards.get(i);
				// そのカードの詳細を表示
				numberString.append(playingCard);
				// スペースを空ける
				numberString.append(" ");
			}
			
		}
		// 手札にあるカードを表す文字列を返却
		return numberString.toString();
	}

}
