package Lesson5_2.SimpleJanken;

public class CyclicTactics implements Tactics {
	
	// グーを表す定数を宣言
	public static final int HAND_STONE = 0;
	// チョキを表す定数を宣言
	public static final int HAND_SCISSORS = 1;
	// パーを表す定数を宣言
	public static final int HAND_PAPER = 2;
	// プレイヤーの手を表す変数の初期値を表す定数を宣言
	public static final int DEFAULT_HAND = -1;
	// プレイヤーの手を表す変数を宣言
	int playerHand = DEFAULT_HAND;
	// プレイヤーの手の種類数を表す定数を宣言
	public static final int NUMBER_OF_TYPE_HAND = 3;
	
	/*
	*関数名：main
	*概要：グー・チョキ・パーと順番に出す戦略を読む
	*引数：なし
	*戻り値：指定した手(int型)
	*作成者：N.Kimoto
	*作成日：2024/07/01
	*/
	public int readTactics() {
		// 次の手に変える
		playerHand++;
		// 出す手を計算し、返却
		return playerHand % NUMBER_OF_TYPE_HAND;
	}

}
