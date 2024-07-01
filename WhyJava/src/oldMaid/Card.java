package oldMaid;

public class Card {
	
	// ジョーカーを表す定数
	public static final int CARD_JOKER = 0;
	// スペードを表す定数
	public static final int SUIT_SPADE = 1;
	// ダイヤを表す定数
	public static final int SUIT_DIAMOND = 2;
	// クラブを表す定数
	public static final int SUIT_CLUB = 3;
	// ハートを表す定数
	public static final int SUIT_HEART = 4;
	
	// スートを表すフィールドを宣言
	private int cardSuit;
	// カードの示す数を表すフィールドを宣言
	private int cardNumber;
	
	// コンストラクタ
	public Card(int cardSuit, int cardNumber) {
		this.cardSuit = cardSuit;
		this.cardNumber = cardNumber;
	}
	
	// 数字を見る
	public int getCardNumber() {
		return cardNumber;
	}
	
	// カードを文字列で表現する
	public String toString() {
		StringBuffer numberString = new StringBuffer();
		
		if (cardNumber > 0) {
			switch (cardSuit) {
			case SUIT_SPADE :
				numberString.append("S");
				break;
				
			case SUIT_DIAMOND :
				numberString.append("D");
				break;
				
			case SUIT_CLUB :
				numberString.append("C");
				break;
				
			case SUIT_HEART :
				numberString.append("H");
				break;
				
			default :
				break;
			}
			
			switch (cardNumber) {
			case 1 :
				numberString.append("A");
				break;
				
			case 10 :
				numberString.append("T");
				break;
				
			case 11 :
				numberString.append("J");
				break;
				
			case 12 :
				numberString.append("Q");
				break;
				
			case 13 :
				numberString.append("K");
				break;
				
			default :
				numberString.append(cardNumber);
				break;
			}
			
		} else {
			// ジョーカーを表す
			numberString.append("JK");
		}
		
		return numberString.toString();
		
	}

}
