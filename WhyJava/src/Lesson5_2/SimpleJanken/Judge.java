package Lesson5_2.SimpleJanken;

/*
*クラス名：Judge
*概要：ジャンケンの審判を表すクラス
*作成者：N.Kimoto
*作成日：2024/06/27
*/
public class Judge {
	
	/*
	*関数名：startJanken
	*概要：ジャンケンを開始する
	*引数：二人のプレイヤー(Player型)
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/06/27
	*/
	public void startJanken(Player firstPlayer, Player secondPlayer) {
		// ジャンケン開始を宣言する
		System.out.println("【ジャンケン開始】\n");
		
		// ジャンケンを行う回数を表す定数を宣言
		final int NUMBER_OF_MATCHES = 3;
		// 何戦目かを表す表記に直す定数を宣言
		final int adjustNotation = 1;
		// ジャンケンを3回行う
		for (int i = 0; i < NUMBER_OF_MATCHES; i++) {
			// 何戦目か表示する
			System.out.println("【" + (i + adjustNotation) + "回戦目】");

			// プレイヤーの手を見て、どちらが勝ちかを判定する
			Player gameWinner = judgeJanken(firstPlayer, secondPlayer);
			// 勝者がいる場合
			if (gameWinner != null) {
				// 勝者を表示する
				System.out.println("\n" + gameWinner.getPlayerName() + "が勝ちました!\n");

				// 勝ったプレイヤーに結果を伝える
				gameWinner.notifyResult(true);
			// 勝者がいない場合
			} else { 
				// 引き分けであることを表示
				System.out.println("引き分けです!\n");
			}
		}

		// ジャンケンの終了を宣言する
		System.out.println("【ジャンケン終了】\n");
		// 最終的な勝者を判定する
		Player finalWinner = judgeFinalWinner(firstPlayer, secondPlayer);

		// 結果を表示
		System.out.print(
		firstPlayer.getWinCount() + "対" + secondPlayer.getWinCount() + "で");

		// 勝者がいる場合
		if (finalWinner != null) {
			// 勝者を発表
			System.out.println(finalWinner.getPlayerName() + "の勝ちです!\n");
		// 引き分けの場合
		} else {
			// 引き分けであることを発表
			System.out.println("引き分けです\n");
		}
	}

	/*
	*関数名：judgeJanken
	*概要：「ジャンケン・ポン!」と声をかけ、プレイヤーの手を見て、どちらが勝ちかを判定する
	*引数：二人のプレイヤー(Player型)
	*戻り値：勝者(Player型)
	*作成者：N.Kimoto
	*作成日：2024/06/27
	*/
	private Player judgeJanken(Player firstPlayer, Player secondPlayer)
	{
		// 勝者を初期化
		Player gameWinner = null;

		// プレイヤー1のジャンケンの手を出す
		int firstPlayerHand = firstPlayer.showHand();

		// プレイヤー2のジャンケンの手を出す
		int secondPlayerHand = secondPlayer.showHand();

		// プレイヤー1のジャンケンの手を表示する
		printHand(firstPlayerHand);
		// それぞれの手を比較する表記を表示する
		System.out.print(" vs. ");
		// プレイヤー2のジャンケンの手を表示する
		printHand(secondPlayerHand);
		// 改行する
		System.out.print("\n");

		// プレイヤー1が勝つ場合
		if ((firstPlayerHand == Player.HAND_STONE && secondPlayerHand == Player.HAND_SCISSORS)
				|| (firstPlayerHand == Player.HAND_SCISSORS && secondPlayerHand == Player.HAND_PAPER)
				|| (firstPlayerHand == Player.HAND_PAPER && secondPlayerHand == Player.HAND_STONE)) {
			// 勝者はプレイヤー1である
			gameWinner = firstPlayer;
			
		// プレイヤー2が勝つ場合
		}else if ((firstPlayerHand == Player.HAND_STONE && secondPlayerHand == Player.HAND_PAPER)
				|| (firstPlayerHand == Player.HAND_SCISSORS && secondPlayerHand == Player.HAND_STONE)
				|| (firstPlayerHand == Player.HAND_PAPER && secondPlayerHand == Player.HAND_SCISSORS)) {
			// 勝者はプレイヤー2である
			gameWinner = secondPlayer;
		}

		// 勝者を返却し、どちらでもない場合は引き分け(nullを返す)
		return gameWinner;
	}

	/*
	*関数名：judgeFinalWinner
	*概要：最終的な勝者を判定する
	*引数：二人のプレイヤー(Player型)
	*戻り値：最終的な勝者(Player型)
	*作成者：N.Kimoto
	*作成日：2024/06/27
	*/
	private Player judgeFinalWinner(Player firstPlayer, Player secondPlayer) {
		// 最終的な勝者を初期化
		Player finalWinner = null;

		// プレイヤー1から勝利数を聞く
		int firstPlayerWinCount = firstPlayer.getWinCount();

		// プレイヤー2から勝利数を聞く
		int secondPlayerWinCount = secondPlayer.getWinCount();

		// プレイヤー1の勝利数が多い場合
		if (firstPlayerWinCount > secondPlayerWinCount) {
			// プレイヤー1の勝利
			finalWinner = firstPlayer;
			
			// プレイヤー2の勝利数が多い場合
		} else if (firstPlayerWinCount < secondPlayerWinCount) {
			// プレイヤー2の勝利
			finalWinner = secondPlayer;
		}

		// 最終的な勝者を返却(どちらでもない場合はnullを返却)
		return finalWinner;
	}

	/*
	*関数名：printHand
	*概要：ジャンケンの手を表示する
	*引数：ジャンケンの手(int型)
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/06/27
	*/
	private void printHand(int playerHand) {
		// 出す手によって表示を変える
		switch (playerHand) {
		// グーの場合
		case Player.HAND_STONE :
			// グーを表示
			System.out.print("グー");
			// 処理を終了する
			break;
		// チョキの場合
		case Player.HAND_SCISSORS :
			// チョキを表示
			System.out.print("チョキ");
			// 処理を終了する
			break;
		// パーの場合
		case Player.HAND_PAPER :
			// パーを表示
			System.out.print("パー");
			// 処理を終了する
			break;
		// その他の値の場合
		default :
			// 何も表示しない
			break;
		}
	}

}
