package Lesson5_2;

/*
*クラス名：Player
*概要：ジャンケンのプレーヤーを表すクラス
*作成者：N.Kimoto
*作成日：2024/06/28
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
	
	// プレイヤーの名前を表すフィールドを宣言
	private String playerName;
	// プレイヤーの勝利数を表すフィールドを宣言
	private int winCount = 0;
	// 戦略を表すフィールドを宣言
	private Tactics jankenTactics;
	
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
	
	/*
	*関数名：setTactics
	*概要：プレイヤーに戦略を伝える
	*引数：戦略(Tactics型)
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/06/28
	*/
	public void setTactics(Tactics jankenTactics) {
		
		// プレイヤーに戦略を伝える
		this.jankenTactics = jankenTactics;
		
	}
	
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
		int playerHand = jankenTactics.readTactics();
		
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
