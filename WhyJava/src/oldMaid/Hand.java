package oldMaid;

import java.util.ArrayList;

public class Hand {
	
	// 手札にあるカードを保持するためのリスト
	private ArrayList handCards = new ArrayList();
	
	// カードを加える
	public void addCard(Card playingCard) {
		// カードリストの最後に追加する
		handCards.add(playingCard);
	}
	
	// カードを引く
	public Card pickCard() {
		Card pickedCard = (Card) handCards.remove(0);
		return pickedCard;
	}
	
	// シャッフルする
	public void shuffle() {
		// 手札の枚数を取得
		int handCardNumber = handCards.size();
		// カードを抜き出す位置
		int extractionPosition = 0;
		
		// カードをランダムに抜き取って最後に加える動作を繰り返す
		for (int i = 0; i < handCardNumber * 2; i++) {
			// ランダムな位置からカードを1枚抜き取る
			extractionPosition = (int) (Math.random() * handCardNumber);
			Card pickedCard = (Card) handCards.remove(extractionPosition);
			
			// 抜き取ったカードを最後に加える
			handCards.add(pickedCard);
			
		}
		
	}
	
	// 枚数を数える
	public int getNumberOfCards() {
		return handCards.size();
	}
	
	// 同じカードを探す
	public Card[] findSameNumberCard() {
		int numberOfCards = handCards.size();
		Card[] sameCards = null;
		
		// 手札にカードが1枚もない場合は何もしない
		if (numberOfCards > 0) {
			// 最後に追加されたカードを取得する
			int lastIndex = numberOfCards -1;
			Card lastAddedCard = (Card) handCards.get(lastIndex);
			
			// 最後に追加されたカードの数字を取得する
			int lastAddedCardNumber = lastAddedCard.getCardNumber();
			
			for (int i = 0; i < lastIndex; i++) {
				Card playingCard = (Card) handCards.get(i);
				
				if (playingCard.getCardNumber() == lastAddedCardNumber) {
					// 最後に追加されたカードと同じカードが見つかった場合
					// 見つかった組み合わせをsameCardsに格納し、ループを抜ける
					sameCards = new Card[2];
					sameCards[0] = (Card) handCards.remove(lastIndex);
					sameCards[1] = (Card) handCards.remove(i);
					
					break;
					
				}
			}
		}
		return sameCards;
	}
	
	// 手札にあるカードを文字列で表現する
	public String toString() {
		StringBuffer numberString = new StringBuffer();
		int handSize = handCards.size();
		if (handSize > 0) {
			for(int i = 0; i < handSize; i++) {
				Card playingCard = (Card) handCards.get(i);
				numberString.append(playingCard);
				numberString.append(" ");
			}
			
		}
		return numberString.toString();
	}

}
