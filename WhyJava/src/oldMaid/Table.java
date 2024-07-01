package oldMaid;

import java.util.ArrayList;

public class Table {
	
	// 捨てられたカードを保持しておくためのリスト
	private ArrayList disposedCards = new ArrayList();
	
	// カードを捨てる
	public void disposeCard(Card handCard[]) {
		for(int i = 0; i < handCard.length; i++) {
			// 捨てられたカードを表示する
			System.out.print(handCard[i] + " ");
		}
		System.out.println("を捨てました");
		
		// 捨てられたカードはリストに追加して保持しておく
		disposedCards.add(handCard);
	}
	
}
