package Lesson9_5;

import trump.Card;
import trump.Hand;
import trump.Rule;
import trump.Table;

public class FantanRule implements Rule {
	
	/*
	*関数名：findCandidate
	*概要：現在の手札とテーブルから、テーブルに出しうるカードの
	*組み合わせを探す
	*引数：手札(hand型), 現在のテーブル(table型)
	*戻り値：見つかったカードの組み合わせ(Card型配列)
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public Card[] findCandidate(Hand myHand, Table gameTable) {
		
		// 返却するカード型配列を初期化(ない場合はNULLを返す)
		Card[] placeCard = null;
		// 手札の枚数を取得
		int numberOfHand = myHand.getNumberOfCards();
		
		// 枚数分探す
		for(int i = 0; i < numberOfHand; i++) {
			
			// 調査対象となるカードを初期化
			Card specifyCard = myHand.lookCard(i);
			
			// 調査対象の数字を取得
			int specifyCardNumber = specifyCard.getCardNumber();
			// 調査対象のスートを取得
			int specifyCardSuit = specifyCard.getCardSuit();
			
			// テーブルに置いたときの右隣のカードの数字にするための定数
			final int SHIFT_RIGHT_NUMBER = 1;
			// テーブルに置いたときの左隣のカードの数字にするための定数
			final int SHIFT_LEFT_NUMBER = -1;
			// カードの数字の最小値
			final int MINIMUM_CARD_NUMBER = 1;
			// カードの数字の最大値
			final int MAXIMUM_CARD_NUMBER = 13;
			
			// 調査対象カードの右隣の数字を初期化
			int rightCardNumber = (specifyCardNumber == MAXIMUM_CARD_NUMBER) ? 
					MINIMUM_CARD_NUMBER : specifyCardNumber + SHIFT_RIGHT_NUMBER;
			// 調査対象カードの左隣の数字を初期化
			int leftCardNumber = (specifyCardNumber == MINIMUM_CARD_NUMBER) ?
					MAXIMUM_CARD_NUMBER : specifyCardNumber + SHIFT_LEFT_NUMBER;
			
			// 調査する位置を初期化
			Card[][] checkPlace = gameTable.getCards();
			
			// 調査対象のカードの左右どちらかにカードがある場合
			if (checkPlace[specifyCardSuit-1][rightCardNumber-1] != null
					|| checkPlace[specifyCardSuit-1][leftCardNumber-1] != null) {
				// 配列の要素数
				final int ELEMENT_COUNT = 1;
				// 返却する配列の要素数を設定
				placeCard = new Card[ELEMENT_COUNT];
				// 配列にそのカードを格納
				placeCard[0] = myHand.pickCard(i);
				
			}
			
		}
		
		// 見つかったカードの組み合わせを返却
		return placeCard;
		
	}

}
