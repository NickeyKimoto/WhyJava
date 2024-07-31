package Lesson9_6;

// トランプゲームワークフレームのカードクラスをインポート
import trump.Card;
// トランプゲームワークフレームの手札クラスをインポート
import trump.Hand;
// トランプゲームワークフレームのジョーカークラスをインポート
import trump.Joker;
// トランプゲームワークフレームの進行役クラスをインポート
import trump.Master;
// トランプゲームワークフレームのプレイヤークラスをインポート
import trump.Player;
// トランプゲームワークフレームのルールクラスをインポート
import trump.Rule;
// トランプゲームワークフレームのテーブルクラスをインポート
import trump.Table;

/*
*クラス名：PlayOldMaid
*概要：ババ抜きを行うクラス
*作成者：N.Kimoto
*作成日：2024/07/03
*/
public class PlayOldMaid {

	/*
	*関数名：main
	*概要：ババ抜きを行う
	*引数：なし
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/07/03
	*/
	public static void main(String[] args) {
		
		// 進行役の生成
		Master gameMaster = new Master();
		// テーブルの生成
		Table gameTable = new OldMaidTable();
		// ルールの生成
		Rule oldMaidRule = new OldMaidRule();
		// プレイヤー村田さんの生成
		Player playerMurata = new OldMaidPlayer("村田", gameMaster, gameTable, oldMaidRule);
		// プレイヤー山田さんの生成
		Player playerYamada = new OldMaidPlayer("山田", gameMaster, gameTable, oldMaidRule);
		// プレイヤー齊藤さんの生成
		Player playerSaito = new OldMaidPlayer("齊藤", gameMaster, gameTable, oldMaidRule);

		// 進行役へ村田さんプレイヤーを登録
		gameMaster.registerPlayer(playerMurata);
		// 進行役へ山田さんプレイヤーを登録
		gameMaster.registerPlayer(playerYamada);
		// 進行役へ村齊藤田さんプレイヤーを登録
		gameMaster.registerPlayer(playerSaito);

		// トランプを生成
		Hand playingCards = createTrump();
		// ゲームの準備をする
		gameMaster.prepareGame(playingCards);
		// ゲームを開始する
		gameMaster.startGame();

	}

	/*
	*関数名：createTrump
	*概要：53枚のトランプを生成する
	*引数：なし
	*戻り値：生成したカード(Hand型)
	*作成者：N.Kimoto
	*作成日：2024/07/03
	*/
	private static Hand createTrump() {

		// 生成するカードを初期化
		Hand playingCards = new Hand();

		// 数字の最小値
		final int MINIMUM_CARD_NUMBER = 1;
		// 数字の最大値
		final int MAXIMUM_CARD_NUMBER = 13;

		// 各スート13枚のカードを生成する
		for (int i = MINIMUM_CARD_NUMBER; i <= MAXIMUM_CARD_NUMBER; i++) {
			
			// クラブのカードを生成
			playingCards.addCard(new Card(Card.SUIT_CLUB, i));
			// ダイヤのカードを生成
			playingCards.addCard(new Card(Card.SUIT_DIAMOND, i));
			// ハートのカードを生成
			playingCards.addCard(new Card(Card.SUIT_HEART, i));
			// スペードのカードを生成
			playingCards.addCard(new Card(Card.SUIT_SPADE, i));
			
		}

		// ジョーカーを生成する
		playingCards.addCard(new Joker());

		// 生成したカードを返却
		return playingCards;
		
	}

}
