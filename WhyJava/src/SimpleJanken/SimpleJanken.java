package SimpleJanken;
/**
 * オブジェクト指向を使用しないジャンケンプログラム
 */

/*
*クラス名：SimpleJanken
*概要：ジャンケンをする
*作成者：N.Kimoto
*作成日：2024/06/27
*/
public class SimpleJanken {
	
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
	// 勝負数を表す変数を宣言
	public static final int NUMBER_OF_MATCHES = 3;

	/*
	*関数名：main
	*概要：ジャンケンをする
	*引数：なし
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/06/27
	*/
	public static void main(String[] args) {
		// ①プログラムが開始したことを表示する
		// プログラム開始メッセージを表示する
		System.out.println("【ジャンケン開始】\n");
		
		// 乱数を格納するための変数を宣言
		double randomValue = 0;
		
		// プレイヤー1の勝ち数
		int firstPlayerWinCount = 0;
		// プレイヤー2の勝ち数
		int secondPlayerWinCount = 0;
		
		// ジャンケンを3回実施する
		// ⑥勝負した回数を加算する
		// ⑦3回勝負が終わったか？
		// ジャンケンを指定回数繰り返す
		for(int i = 0; i < NUMBER_OF_MATCHES; i++) {
			// ②プレイヤー1が何を出すか決める
			// プレイヤー1の手を表す変数を宣言
			int firstPlayerHand = 0;
			
			// 0以上出す手の数未満の少数として乱数を得る
			randomValue = Math.random() * RANDOM_RANGE;
			
			// 乱数が0.0以上1.0未満の場合
			if (randomValue < STONE_RANGE) {
				// プレイヤー1の手をグーにする
				firstPlayerHand = HAND_STONE;
				// プレイヤー1の手を表示する
				System.out.print("グー");
			// 乱数が1.0以上2.0未満の場合
			} else if (randomValue < SCISSORS_RANGE) {
				// プレイヤー1の手をチョキにする
				firstPlayerHand = HAND_SCISSORS;
				// プレイヤー1の手を表示する
				System.out.print("チョキ");
			// 乱数が2.0以上3.0未満の場合
			} else if (randomValue < PAPER_RANGE) {
				// プレイヤー1の手をパーにする
				firstPlayerHand = HAND_PAPER;
				// プレイヤー1の手を表示する
				System.out.print("パー");
			}
		
			// ③プレイヤー2が何を出すか決める
			// プレイヤー2の手を表す変数を宣言
			int secondPlayerHand = 0;
			
			// 0以上出す手の数未満の少数として乱数を得る
			randomValue = Math.random() * RANDOM_RANGE;
			
			// 乱数が0.0以上1.0未満の場合
			if (randomValue < STONE_RANGE) {
				// プレイヤー2の手をグーにする
				secondPlayerHand = HAND_STONE;
				// プレイヤー2の手を表示する
				System.out.print("グー");
			// 乱数が1.0以上2.0未満の場合
			} else if (randomValue < SCISSORS_RANGE) {
				// プレイヤー2の手をチョキにする
				secondPlayerHand = HAND_SCISSORS;
				// プレイヤー2の手を表示する
				System.out.print("チョキ");
			// 乱数が2.0以上3.0未満の場合
			} else if (randomValue < PAPER_RANGE) {
				// プレイヤー2の手をパーにする
				secondPlayerHand = HAND_PAPER;
				// プレイヤー2の手を表示する
				System.out.print("パー");
			}
			
			// ④ どちらが勝ちかを判定し、結果を表示する
			// プレイヤー1が勝つ場合
			if ((firstPlayerHand == HAND_STONE) && (secondPlayerHand == HAND_SCISSORS)
			|| (firstPlayerHand == HAND_SCISSORS) && (secondPlayerHand == HAND_PAPER)
			|| (firstPlayerHand == HAND_PAPER) && (secondPlayerHand == HAND_STONE)) {
				// ⑤プレイヤー1の勝った回数を加算する
				firstPlayerWinCount++;
				// ジャンケンの結果を表示する
				System.out.println("\nプレイヤー1が勝ちました!\n");
			// プレイヤー2が勝つ場合
			} else if ((secondPlayerHand == HAND_STONE) && (firstPlayerHand == HAND_SCISSORS)
			|| (secondPlayerHand == HAND_SCISSORS) && (firstPlayerHand == HAND_PAPER)
			|| (secondPlayerHand == HAND_PAPER) && (firstPlayerHand == HAND_STONE)) {
				// ⑤プレイヤー2の勝った回数を加算する
				secondPlayerWinCount++;
				// ジャンケンの結果を表示する
				System.out.println("\nプレイヤー2が勝ちました!\n");
			// 引き分けの場合
			} else {
				// ジャンケンの結果を表示する
				System.out.println("\n引き分けです!\n");
			}
			
		}
		
		// ⑧最終的な勝者を判定し、画面に表示する
		System.out.println("【ジャンケン終了】\n");
		
		// プレイヤー1の勝ち数が多いとき
		if (firstPlayerWinCount > secondPlayerWinCount) {
			// プレイヤー1の勝ちを表示する
			System.out.println(firstPlayerWinCount + "対" + secondPlayerWinCount + "で"
			+ "プレイヤー1の勝ちです!\n");
		// プレイヤー2の勝ち数が多いとき
		} else if (firstPlayerWinCount < secondPlayerWinCount) {
			// プレイヤー2の勝ちを表示する
			System.out.println(firstPlayerWinCount + "対" + secondPlayerWinCount + "で"
			+ "プレイヤー2の勝ちです!\n");
		// プレイヤー1と2の勝ち数が同じとき
		} else if (firstPlayerWinCount == secondPlayerWinCount) {
			// プレイヤー1の勝ちを表示する
			System.out.println(firstPlayerWinCount + "対" + secondPlayerWinCount + "で"
			+ "引き分けです!\n");
		}
		
	}

}