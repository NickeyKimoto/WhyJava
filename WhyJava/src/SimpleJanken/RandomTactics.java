package SimpleJanken;

import Lesson5_2.SimpleJanken.Tactics;

public class RandomTactics implements Tactics {
	
	// グーを表す定数を宣言
	public static final int HAND_STONE = 0;
	// チョキを表す定数を宣言
	public static final int HAND_SCISSORS = 1;
	// パーを表す定数を宣言
	public static final int HAND_PAPER = 2;
	// 乱数の範囲を表す変数を宣言
	public static final int RANDOM_RANGE = 3;
	// グーの範囲を表す変数を宣言
	public static final double STONE_RANGE = 1.0;
	// チョキの範囲を表す変数を宣言
	public static final double SCISSORS_RANGE = 2.0;
	// パーの範囲を表す変数を宣言
	public static final double PAPER_RANGE = 3.0;
	
	public int readTactics() {
		// プレイヤーの手を表す変数を宣言
		int playerHand = 0;
		// 乱数を格納するための変数を宣言
		double randomValue = 0;
		
		// 0以上出す手の数未満の少数として乱数を得る
		randomValue = Math.random() * RANDOM_RANGE;
		
		// 乱数が0.0以上1.0未満の場合
		if (randomValue < STONE_RANGE) {
			// プレイヤーの手をグーにする
			playerHand = HAND_STONE;
			// プレイヤーの手を表示する
			System.out.print("グー");
		// 乱数が1.0以上2.0未満の場合
		} else if (randomValue < SCISSORS_RANGE) {
			// プレイヤーの手をチョキにする
			playerHand = HAND_SCISSORS;
			// プレイヤーの手を表示する
			System.out.print("チョキ");
		// 乱数が2.0以上3.0未満の場合
		} else if (randomValue < PAPER_RANGE) {
			// プレイヤーの手をパーにする
			playerHand = HAND_PAPER;
			// プレイヤーの手を表示する
			System.out.print("パー");
		}
		// 出す手を返却
		return playerHand;
	}

}
