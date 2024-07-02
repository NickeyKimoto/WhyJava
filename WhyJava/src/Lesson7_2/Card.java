package Lesson7_2;

/*
*クラス名：Card
*概要：カードの情報を管理するクラス
*作成者：N.Kimoto
*作成日：2024/07/01
*/
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
	
	/*
	*コンストラクタ名：Card
	*概要：フィールドを初期化する
	*引数：スート(int型)、数字(int型)
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/07/01
	*/
	public Card(int cardSuit, int cardNumber) {
		// カードのスートを表すフィールドを初期化
		this.cardSuit = cardSuit;
		// カードの数字を表すフィールドを初期化
		this.cardNumber = cardNumber;
	}
	
	/*
	*関数名：getCardNumber
	*概要：数字を見る
	*引数：なし
	*戻り値：カードの数字(int型)
	*作成者：N.Kimoto
	*作成日：2024/07/01
	*/
	public int getCardNumber() {
		// カードの数字を返却
		return cardNumber;
	}
	
	/*
	*関数名：toString
	*概要：カードを文字列で表現する
	*引数：なし
	*戻り値：カード(String型)
	*作成者：N.Kimoto
	*作成日：2024/07/01
	*/
	public String toString() {
		// 返却する文字列を初期化
		StringBuffer numberString = new StringBuffer();
		
		// そのカードがジョーカーではない場合
		if (cardNumber > 0) {
			// スートによって代入する文字列を変更
			switch (cardSuit) {
			// スペードの場合
			case SUIT_SPADE :
				// 文字列にSを追加
				numberString.append("S");
				// 次の処理に進む
				break;
				
			// ダイヤの場合
			case SUIT_DIAMOND :
				// 文字列にDを追加
				numberString.append("D");
				// 次の処理に進む
				break;
				
			// クラブの場合
			case SUIT_CLUB :
				// 文字列にCを追加
				numberString.append("C");
				// 次の処理に進む
				break;
				
			// ハートの場合
			case SUIT_HEART :
				// 文字列にHを追加
				numberString.append("H");
				// 次の処理に進む
				break;
				
			// それ以外の場合
			default :
				// 何もせず次の処理に進む
				break;
			}
			
			// カードの数字が1であることを表す定数を宣言
			final int CARD_NUMBER_ONE = 1;
			// カードの数字が10であることを表す定数を宣言
			final int CARD_NUMBER_TEN = 10;
			// カードの数字が11であることを表す定数を宣言
			final int CARD_NUMBER_EREVEN = 11;
			// カードの数字が12であることを表す定数を宣言
			final int CARD_NUMBER_TWELVE = 12;
			// カードの数字が13であることを表す定数を宣言
			final int CARD_NUMBER_THIRTEEN = 13;
			
			// 数字によって加える文字列を変更
			switch (cardNumber) {
			// 数字が1の場合
			case CARD_NUMBER_ONE :
				// 文字列にAを追加
				numberString.append("A");
				// 処理を抜ける
				break;
				
			// 数字が10の場合
			case CARD_NUMBER_TEN :
				// 文字列にTを追加
				numberString.append("T");
				// 処理を抜ける
				break;
				
			// 数字が11の場合
			case CARD_NUMBER_EREVEN :
				// 文字列にJを追加
				numberString.append("J");
				// 処理を抜ける
				break;
				
			// 数字が12の場合
			case CARD_NUMBER_TWELVE :
				// 文字列にQを追加
				numberString.append("Q");
				// 処理を抜ける
				break;
				
			// 数字が13の場合
			case CARD_NUMBER_THIRTEEN :
				// 文字列にKを追加
				numberString.append("K");
				// 処理を抜ける
				break;
				
			// 数字がそれ以外の場合
			default :
				// その数字をそのまま文字列に追加
				numberString.append(cardNumber);
				// 処理を抜ける
				break;
			}
			
		// カードがジョーカーの場合
		} else {
			// 文字列にJKを追加
			numberString.append("JK");
		}
		
		// 文字列を返却
		return numberString.toString();
		
	}

}
