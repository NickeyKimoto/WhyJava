package Lesson5_2;

/*
*クラス名：Murata
*概要：Playerクラスを継承した手の出し方が異なるクラス
*作成者：N.Kimoto
*作成日：2024/06/28
*/
public class Murata extends Player {
		
	/*
	*コンストラクタ名：Murata
	*概要：プレイヤーの名前を初期化
	*引数：名前(String型)
	*作成者：N.Kimoto
	*作成日：2024/06/27
	*/
	public Murata(String playerName) {
		
		// プレイヤーの名前を引数の名前で初期化
		super(playerName);
		
	}
	
	/*
	*関数名：showHand
	*概要：ジャンケンの手を出す(必ずグーを出す)
	*引数：なし
	*戻り値：ジャンケンの手を表す定数(int型)
	*作成者：N.Kimoto
	*作成日：2024/06/27
	*/
	public int showHand() {
		
		// 出す手を返却
		return HAND_STONE;
		
	}

}
