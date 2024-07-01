package oldMaid;

public class Player {
	
	// 進行約
	private Master gameMaster;
	// テーブル
	private Table gameTable;
	// 自分の手札
	private Hand myHand = new Hand();
	// 名前
	private String myName;
	
	// コンストラクタ
	public Player(String myName, Master gameMaster, Table gameTable) {
		this.myName = myName;
		this.gameMaster = gameMaster;
		this.gameTable = gameTable;
	}
	
	// 順番を指名する
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
		} else {
			// 現在の手札を表示する
			System.out.println(this + ":残りの手札は" + myHand + "です");
		}
	}
	
	// 手札を見せる
	public Hand showHand() {
		// もしこの時点で手札が残り1枚ならば上がりとなるので宣言する
		if (myHand.getNumberOfCards() == 1) {
			gameMaster.declareWin(this);
		}
		
		// 見せる前にシャッフルする
		myHand.shuffle();
		
		return myHand;
	}
	
	// カードを受け取る
	public void receiveCard(Card playingCard) {
		// 引いたカードを自分の手札に加え、同じ数のカードがあったら捨てる
		dealCard(playingCard);
	}
	
	// カードを自分の手札に加え、同じ数のカードがあったら捨てる
	private void dealCard(Card PlayingCard) {
		// カードを自分の手札に加える
		myHand.addCard(PlayingCard);
		// 今加えたカードと同じカードを探す
		Card[] sameCards = myHand.findSameNumberCard();
		
		// 同じカードの組み合わせが存在した場合
		if (sameCards != null) {
			// テーブルへカードを捨てる
			System.out.print(this + ":");
			gameTable.disposeCard(sameCards);
		}
	}
	
	// プレイヤーの名前を返す
	public String toString() {
		return myName;
	}

}
