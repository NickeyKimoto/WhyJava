package Lesson7_2;

/*
*クラス名：PlayOldMaid
*概要：ババ抜きをする
*作成者：N.Kimoto
*作成日：2024/07/01
*/
public class PlayOldMaid {

	/*
	*関数名：main
	*概要：ババ抜きをする
	*引数：なし
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public static void main(String[] args) {
		// 進行役の生成
		Master gameMaster = new Master();
		// テーブルの生成
		Table gameTable = new Table();
		// プレイヤー村田の生成
		Player playerMurata = new Player("村田", gameMaster, gameTable);
		// プレイヤー山田の生成
		Player playerYamada = new Player("山田", gameMaster, gameTable);
		// プレイヤー齊藤の生成
		Player playerSaito = new Player("齊藤", gameMaster, gameTable);
		
		// 進行役へプレイヤー村田を登録
		gameMaster.registerPlayer(playerMurata);
		// 進行役へプレイヤー山田を登録
		gameMaster.registerPlayer(playerYamada);
		// 進行役へプレイヤー齊藤を登録
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
	*戻り値：53枚のトランプ(Hand型)
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	private static Hand createTrump() {
		// 生成するトランプを初期化
		Hand playingCards = new Hand();
		// 数字の最小値となる定数を宣言
		final int MINIMUM_NUMBER_OF_CARDS = 1;
		// 数字の最大値となる定数を宣言
		final int MAXIMUM_NUMBER_OF_CARDS = 13;
		// 各スート53枚のカードを生成する
		for(int i = MINIMUM_NUMBER_OF_CARDS; i <= MAXIMUM_NUMBER_OF_CARDS; i++) {
			// スートがクラブのカードを生成
			playingCards.addCard(new Card(Card.SUIT_CLUB, i));
			// スートがダイヤのカードを生成
			playingCards.addCard(new Card(Card.SUIT_DIAMOND, i));
			// スートがハートのカードを生成
			playingCards.addCard(new Card(Card.SUIT_HEART, i));
			// スートがスペースのカードを生成
			playingCards.addCard(new Card(Card.SUIT_SPADE, i));
		}
		
		// ジョーカーの作成
		playingCards.addCard(new Card(0, Card.CARD_JOKER));
		
		// 生成したトランプを返却
		return playingCards;
	}

}
