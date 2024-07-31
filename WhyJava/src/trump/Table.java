package trump;

/*
*インターフェース名：Table
*概要：テーブルを表すインターフェース
*作成者：N.Kimoto
*作成日：2024/07/02
*/
public interface Table {

	/*
	*関数名：putCard
	*概要：カードを置く
	*引数：置くカード(Card型配列)
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public void putCard(Card[] placeCard);

	/*
	*関数名：getCards
	*概要：カードを見る
	*引数：なし
	*戻り値：置かれたカード(Card型配列)
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public Card[][] getCards();

}
