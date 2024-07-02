package Lesson7_2;

/*
*クラス名：Player
*概要：プレイヤーの情報を管理するクラス
*作成者：N.Kimoto
*作成日：2024/07/01
*/
public class Player {
	
	// 進行役を表すフィールドを宣言
	private Master gameMaster;
	// テーブルを表すフィールドを宣言
	private Table gameTable;
	// 自分の手札を表すフィールドを宣言
	private Hand myHand = new Hand();
	// 名前を表すフィールドを宣言
	private String myName;
	
	/*
	*コンストラクタ名：Player
	*概要：フィールドを初期化する
	*引数：名前(String型), 進行役(Master型), テーブル(Table型)
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public Player(String myName, Master gameMaster, Table gameTable) {
		// 名前を表すフィールドを初期化
		this.myName = myName;
		// 進行役を表すフィールドを初期化
		this.gameMaster = gameMaster;
		// テーブルを表すフィールドを初期化
		this.gameTable = gameTable;
	}
	
	/*
	*関数名：nominatePlayer
	*概要：順番を指名する
	*引数：次のプレイヤー(Player型)
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public void nominatePlayer(Player nextPlayer) {
		// 次のプレイヤーに手札を出してもらう
		Hand nextHand = nextPlayer.showHand();
		// 相手の手札からカードを一枚引く
		Card pickedCard = nextHand.pickCard();
		// 引いた結果を表示
		System.out.println(this + ":" + nextPlayer + "さんから " + pickedCard + "を引きました");
		
		// 手札が0になったかどうか調べる
		if (myHand.getNumberOfCards() == 0) {
			// 進行役に上がりを宣言する
			gameMaster.declareWin(this);
		// 手札が残っている場合
		} else {
			// 現在の手札を表示する
			System.out.println(this + ":残りの手札は" + myHand + "です");
		}
	}
	
	/*
	*関数名：showHand
	*概要：手札を見せる
	*引数：なし
	*戻り値：自分の手札(Hand型)
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public Hand showHand() {
		// 上がりの基準となる枚数を表す定数を宣言
		final int STANDARD_FINISH_NUMBER_OF_CARDS = 1;
		// この時点で手札が残り1枚の場合
		if (myHand.getNumberOfCards() == STANDARD_FINISH_NUMBER_OF_CARDS) {
			// あがりを宣言する
			gameMaster.declareWin(this);
		}
		
		// 見せる前にシャッフルする
		myHand.shuffle();
		
		// 手札を見せる
		return myHand;
	}
	
	/*
	*関数名：receiveCard
	*概要：カードを受け取る
	*引数：受け取るカード(Card型)
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public void receiveCard(Card playingCard) {
		// 引いたカードを自分の手札に加え、同じ数のカードがあったら捨てる
		dealCard(playingCard);
	}
	
	/*
	*関数名：dealCard
	*概要：カードを自分の手札に加え、同じ数のカードがあったら捨てる
	*引数：受け取るカード(Card型)
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	private void dealCard(Card PlayingCard) {
		// カードを自分の手札に加える
		myHand.addCard(PlayingCard);
		// 今加えたカードと同じカードを探す
		Card[] sameCards = myHand.findSameNumberCard();
		
		// 同じカードの組み合わせが存在した場合
		if (sameCards != null) {
			// そのカードを表示
			System.out.print(this + ":");
			// テーブルへカードを捨てる
			gameTable.disposeCard(sameCards);
		}
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
