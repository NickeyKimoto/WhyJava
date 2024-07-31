package Lesson9_5;

// トランプゲームワークフレームのカードクラスをインポート
import trump.Card;
// トランプゲームワークフレームの進行役クラスをインポート
import trump.Master;
// トランプゲームワークフレームのプレイヤークラスをインポート
import trump.Player;
// トランプゲームワークフレームのルールクラスをインポート
import trump.Rule;
// トランプゲームワークフレームのテーブルクラスをインポート
import trump.Table;

/*
*クラス名：FantanPlayer
*概要：七並べのプレイヤーを表すクラス
*作成者：N.Kimoto
*作成日：2024/07/03
*/
public class FantanPlayer extends Player {

	// パス回数
	private int passCount = 0;

	/*
	*コンストラクタ名：FantanPlayer
	*概要：フィールドを初期化する
	*引数：名前(String型),進行役(Master型), テーブル(Table型),ルール(Rule型)
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/07/03
	*/
	public FantanPlayer(String playerName, Master gameMaster, Table gameTable,
			Rule gameRule) {

		// それぞれのフィールドを初期化
		super(playerName, gameMaster, gameTable, gameRule);

	}

	/*
	*関数名：receiveCard
	*概要：カードを配る
	*引数：受け取った(カード型)
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/07/03
	*/
	public void receiveCard(Card playingCard) {

		// 数字が7のカード
		final int SEVEN_CARD = 7;

		// 受け取ったカードの数字が7ではない場合
		if (playingCard.getCardNumber() != SEVEN_CARD) {

			// カードを自分の手札に加える
			super.receiveCard(playingCard);

		// 受け取ったカードの数字が7の場合
		} else {

			// 受け取ったカードを置くカードの配列に格納
			Card[] sevenCard = { playingCard };
			// そのカードを置く
			gameTable.putCard(sevenCard);
			// 引いた結果を表示
			System.out.println(this + "さんが" + playingCard + "を置きました。");

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

		// 置くことができるカードを格納する配列を宣言
		Card[] placeCard = gameRule.findCandidate(myHand, gameTable);
		// 置けるカードがある場合
		if (placeCard != null) {

			// そのカードを置く
			gameTable.putCard(placeCard);
			// テーブルを表示する
			System.out.println(gameTable);

			// 手札がなくなった場合
			if (myHand.getNumberOfCards() == 0) {

				// 上がりを宣言する
				gameMaster.declareWin(this);

			// 手札がある場合
			} else {

				// 現在の手札を表示する
				System.out.println(this + ":残りの手札は" + myHand + "です");

			}

		// 置けるカードがない場合
		} else {

			// パス回数をカウントする
			passCount++;

			// パスを宣言する
			((FantanMaster) gameMaster).declaerPass(this);

			// パス回数が上限を超えた場合
			if (passCount > FantanMaster.PASS_LIMIT) {

				// 手札の枚数を取得
				int numberOfHand = myHand.getNumberOfCards();

				// 全ての手札を置く
				for (int i = 0; i < numberOfHand; i++) {

					// 手札を置く
					gameTable.putCard(new Card[] { myHand.pickCard(0) });

				}

				// ゲームから抜ける
				gameMaster.deregisterPlayer(nextPlayer);

			}

		}

	}

	/*
	*関数名：getPass
	*概要：パス回数をカウントする
	*引数：なし
	*戻り値：パス回数(int型)
	*作成者：N.Kimoto
	*作成日：2024/07/03
	*/
	public int getPass() {

		// パス回数を返却
		return passCount;

	}

}
