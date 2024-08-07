package Lesson9_6;

// トランプゲームワークフレームのカードクラスをインポート
import trump.Card;
// トランプゲームワークフレームの手札クラスをインポート
import trump.Hand;
// トランプゲームワークフレームの進行役クラスをインポート
import trump.Master;
// トランプゲームワークフレームのプレイヤークラスをインポート
import trump.Player;
// トランプゲームワークフレームのルールクラスをインポート
import trump.Rule;
// トランプゲームワークフレームのテーブルクラスをインポート
import trump.Table;

/*
*クラス名：OldMaidPlayer
*概要：ババ抜きのプレイヤーを表すクラス
*作成者：N.Kimoto
*作成日：2024/07/03
*/
public class OldMaidPlayer extends Player {

	/*
	*コンストラクタ名：OldMaidPlayer
	*概要：フィールドを初期化する
	*引数：プレイヤーの名前(String型), 進行役(Master型), ゲームをしているテーブル(Table型), ルール(Rule型)
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/07/03
	*/
	public OldMaidPlayer(String playerName, Master gameMaster, Table gameTable,
			Rule gameRule) {

		// それぞれのフィールドを初期化
		super(playerName, gameMaster, gameTable, gameRule);

	}

	/*
	*関数名：receiveCard
	*概要：カードを配る
	*引数：受け取った(Card型)
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/07/03
	*/
	public void receiveCard(Card PlayingCard) {

		// カードを自分の手札に加える
		myHand.addCard(PlayingCard);
		// 今加えたカードと同じカードを探す
		Card[] sameCards = gameRule.findCandidate(myHand, gameTable);

		// 同じカードの組み合わせが存在した場合
		if (sameCards != null) {

			// テーブルへカードを捨てたことを表示
			System.out.print(this + ":");
			// テーブルへカードを捨てる
			gameTable.putCard(sameCards);

		}

	}

	/*
	*関数名：nominatePlayer
	*概要：順番を指名する
	*引数：次のプレイヤー(Player型)
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/07/03
	*/
	public void nominatePlayer(Player nextPlayer) {

		// 次のプレイヤーに手札を出してもらう
		Hand nextHand = ((OldMaidPlayer) nextPlayer).showHand();
		// 相手の手札からカードを一枚引く
		Card pickedCard = nextHand.pickCard(0);
		// 引いた結果を表示
		System.out.println(this + ":" + nextPlayer + "さんから " + pickedCard + "を引きました");
		// 引いたカードを手札に加える
		myHand.addCard(pickedCard);

		// 今加えたカードと同じカードを探す
		Card[] sameCards = gameRule.findCandidate(myHand, gameTable);

		// 同じカードの組み合わせが存在した場合
		if (sameCards != null) {

			// テーブルへカードを捨てたことを表示
			System.out.print(this + ":");
			// テーブルへカードを捨てる
			gameTable.putCard(sameCards);

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
		
		// 上がれる手札の枚数
		final int FINISH_HAND_NUMBER = 0;

		// もしこの時点で手札が残り1枚の場合
		if (nextHand.getNumberOfCards() == FINISH_HAND_NUMBER) {

			// 上がりを宣言する
			gameMaster.declareWin(nextPlayer);

		}

	}

	/*
	*関数名：showHand
	*概要：手札を見せる
	*引数：なし
	*戻り値：手札(Hand型)
	*作成者：N.Kimoto
	*作成日：2024/07/03
	*/
	public Hand showHand() {

		// 見せる前にシャッフルする
		myHand.shuffle();

		// 手札を返却する
		return myHand;

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
