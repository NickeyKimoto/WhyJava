package Lesson3_3.SimpleJanken;

/*
*クラス名：Player
*概要：ジャンケンのプレーヤーを表すクラス
*作成者：N.Kimoto
*作成日：2024/06/27
*/
public class Player {
	
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
	
	// フィールド
	// プレイヤーの名前を表すフィールドを宣言
	private String playerName;
	// プレイヤーの勝利数を表すフィールドを宣言
	private int winCount = 0;
	
	/*
	*コンストラクタ名：Player
	*概要：プレイヤーの名前を初期化
	*引数：名前(String型)
	*作成者：N.Kimoto
	*作成日：2024/06/27
	*/
	public Player(String playerName) {
		// プレイヤーの名前を引数の名前で初期化
		this.playerName = playerName;
	}
	
	// メソッド
	/*
	*関数名：showHand
	*概要：ジャンケンの手を出す
	*引数：なし
	*戻り値：ジャンケンの手を表す定数(int型)
	*作成者：N.Kimoto
	*作成日：2024/06/27
	*/
	public int showHand() {
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
	
	/*
	*関数名：notifyResult
	*概要：審判からの勝敗を聞く
	*引数：勝敗(boolean型)
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/06/27
	*/
public void notifyResult(boolean playerResult) {
		// プレイヤーが勝った場合
		if (playerResult == true) {
			// 勝利数をインクリメントする
			winCount++;
		}
	}
	
	/*
	*関数名：getWinCount
	*概要：自分の勝った回数を答える
	*引数：なし
	*戻り値：勝った回数(int型)
	*作成者：N.Kimoto
	*作成日：2024/06/27
	*/
	public int getWinCount() {
		// 勝った回数を返却
		return winCount;
	}
	
	/*
	*関数名：getPlayerName
	*概要：自分の名前を答える
	*引数：なし
	*戻り値：自分の名前(String型)
	*作成者：N.Kimoto
	*作成日：2024/06/27
	*/
	public String getPlayerName() {
		// 自分の名前を返却
		return playerName;
	}
	
}
