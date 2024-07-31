package Lesson9_5;

// トランプゲームワークフレームの手札クラスをインポート
import trump.Card;
// トランプゲームワークフレームのカードクラスをインポート
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
*クラス名：PlayFantan
*概要：七並べをする
*作成者：N.Kimoto
*作成日：2024/07/03
*/
public class PlayFantan {

	/*
	*関数名：main
	*概要：七並べをする
	*引数：なし
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/07/03
	*/
	public static void main(String[] args) {

		// 進行役の生成
		Master fantanMaster = new FantanMaster();
		// テーブルの生成
		Table fantanTable = new FantanTable();
		// ルールの生成
		Rule fantanRule = new FantanRule();
		// 村田プレイヤーの生成
		Player playerMurata = new FantanPlayer("村田", fantanMaster, fantanTable, fantanRule);
		// 山田プレイヤーの生成
		Player playerYamada = new FantanPlayer("山田", fantanMaster, fantanTable, fantanRule);
		// 齊藤プレイヤーの生成
		Player playerSaito = new FantanPlayer("齊藤", fantanMaster, fantanTable, fantanRule);
		// 進行役へ村田プレイヤーを登録
		fantanMaster.registerPlayer(playerMurata);
		// 進行役へ山田プレイヤーを登録
		fantanMaster.registerPlayer(playerYamada);
		// 進行役へ齊藤プレイヤーを登録
		fantanMaster.registerPlayer(playerSaito);
		// トランプを生成
		Hand playingCards = createTrump();
		// ゲームの準備をする
		fantanMaster.prepareGame(playingCards);
		// ゲームを開始する
		fantanMaster.startGame();

	}

	/*
	*関数名：createTrump
	*概要：52枚のトランプを生成する
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

		// 各スート52枚のカードを生成する
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

		// 生成したカードを返却
		return playingCards;
	}

}
