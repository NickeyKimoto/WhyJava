package trump;

/*
*インターフェース名：Table
*概要：ルールを表すインターフェース
*作成者：N.Kimoto
*作成日：2024/07/02
*/
public interface Rule {
	
	/*
	*関数名：findCandidate
	*概要：現在の手札とテーブルから、テーブルに出しうるカードの
	*組み合わせを探す
	*引数：手札(hand型), 現在のテーブル(table型)
	*戻り値：見つかったカードの組み合わせ(Card型配列)
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public Card[] findCandidate(Hand myHand, Table gameTable);

}
