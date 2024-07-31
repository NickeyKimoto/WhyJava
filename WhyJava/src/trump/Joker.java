package trump;

/*
*クラス名：Joker
*概要：カードクラスを継承したジョーカーを表すクラス
*作成者：N.Kimoto
*作成日：2024/07/02
*/
public class Joker extends Card {

	/*
	*コンストラクタ名：Joker
	*概要：フィールドを初期化する
	*引数：なし
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public Joker() {

		// フィールドを初期化する(初期値はそれぞれ0)
		super(0, 0);

	}

	/*
	*関数名：setCardNumber
	*概要：数字を変更する
	*引数：数字(int型)
	*戻り値：カードの数字(int型)
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public void setCardNumber(int cardNumber) {

		// 数字を変更する
		this.cardNumber = cardNumber;

	}

	/*
	*関数名：setCardSuit
	*概要：スートを変更する
	*引数：数字(int型)
	*戻り値：カードの数字(int型)
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public void setCardSuit(int cardSuit) {

		// スートを変更する
		this.cardSuit = cardSuit;

	}

	/*
	*関数名：toString
	*概要：カードを文字列で表現する
	*引数：なし
	*戻り値：カード(String型)
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public String toString() {

		// JKとして返却
		return "JK";

	}

}
