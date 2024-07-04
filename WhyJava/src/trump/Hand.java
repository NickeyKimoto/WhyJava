package trump;

//ArrayListクラスをインポート
import java.util.ArrayList;

/*
*クラス名：Hand
*概要：手札を表すクラス
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
	*関数名：lookCard
	*概要：カードを見る
	*引数：カードの位置(int型)
	*戻り値：指定された位置のカード(Card型)
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public Card lookCard(int cardPosition) {
		
		// 指定された位置のカードを初期化
		Card lookingCard = null;
		
		// 指定した位置が有効範囲内の場合
		if ((0 <= cardPosition) && (cardPosition < handCards.size())) {
			
			// 指定された位置のカードを取得
			lookingCard = (Card)handCards.get(cardPosition);
			
		}
		
		// 指定された位置のカードを返却
		return lookingCard;
		
	}
	
	/*
	*関数名：pickCard
	*概要：カードを引く
	*引数：カードの位置(int型)
	*戻り値：引いたカード(Card型)
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public Card pickCard(int cardPosition) {
		
		// 引いたカードを初期化
		Card pickedCard = null;
		
		// 指定した位置が有効範囲内の場合
		if ((0 <= cardPosition) && (cardPosition < handCards.size())) {
			
			// 指定した位置からカードを引く
			pickedCard = (Card)handCards.remove(cardPosition);
			
		}
		
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
