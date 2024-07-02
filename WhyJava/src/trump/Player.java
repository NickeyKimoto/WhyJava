package trump;

/*
*クラス名：Player
*概要：プレイヤーを表す抽象クラス
*作成者：N.Kimoto
*作成日：2024/07/02
*/
public abstract class Player {
	
	// テーブルを表すフィールドを宣言
	protected Table gameTable;
	// 自分の手札を表すフィールドを宣言
	protected Hand myHand = new Hand();
	// 名前を表すフィールドを宣言
	protected String myName;
	// 進行役を表すフィールドを宣言
	protected Master gameMaster;
	// ルールを表すフィールドを宣言
	protected Rule gameRule;
	
	/*
	*コンストラクタ名：Player
	*概要：フィールドを初期化する
	*引数：名前(String型), 進行役(Master型), テーブル(Table型), ルール(Rule型)
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public Player(String myName, Master gameMaster, Table gameTable, Rule gameRule) {
		// 名前を表すフィールドを初期化
		this.myName = myName;
		// 進行役を表すフィールドを初期化
		this.gameMaster = gameMaster;
		// テーブルを表すフィールドを初期化
		this.gameTable = gameTable;
		// ルールを表すルールを初期化
		this.gameRule = gameRule;
	}
	
	/*
	*関数名：nominatePlayer
	*概要：順番を指名する
	*引数：次のプレイヤー(Player型)
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public abstract void nominatePlayer(Player nextPlayer);
	
	/*
	*関数名：receiveCard
	*概要：カードを受け取る
	*引数：受け取るカード(Card型)
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public void receiveCard(Card playingCard) {
		// 引いたカードを自分の手札に加える
		myHand.addCard(playingCard);
	}
	
	/*
	*関数名：toString
	*概要：プレイヤーの名前を返す
	*引数：なし
	*戻り値：プレイヤーの名前(String型)
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public String toString() {
		// プレイヤーの名前を返す
		return myName;
	}

}
