package oldMaid;

//作るもの
//
//ババ抜きプレイヤー
//・順番を指名する　実装
//完了・カードを受け取る　実装
//・手札を出す
//
//ババ抜きルール
//完了・テーブルに出すカードの組み合わせを探す　実装
//
//ババ抜きテーブル
//完了・カードを置く(捨てる)　実装
//完了・カードを見る　実装

public class PlayOldMaid {

	public static void main(String[] args) {
		// 進行役の生成
		Master gameMaster = new Master();
		// テーブルの生成
		Table gameTable = new Table();
		// プレイヤーの生成
		Player playerMurata = new Player("村田", gameMaster, gameTable);
		Player playerYamada = new Player("山田", gameMaster, gameTable);
		Player playerSaito = new Player("齊藤", gameMaster, gameTable);
		
		// 進行役へプレイヤーを登録
		gameMaster.registerPlayer(playerMurata);
		gameMaster.registerPlayer(playerYamada);
		gameMaster.registerPlayer(playerSaito);
		
		// トランプを生成
		Hand playingCards = createTrump();
		// ゲームの準備をする
		gameMaster.prepareGame(playingCards);
		// ゲームを開始する
		gameMaster.startGame();
	}
	
	// 53枚のトランプを生成する
	private static Hand createTrump() {
		Hand playingCards = new Hand();
		
		// 各スート53枚のカードを生成する
		for(int i = 1; i <= 13; i++) {
			playingCards.addCard(new Card(Card.SUIT_CLUB, i));
			playingCards.addCard(new Card(Card.SUIT_DIAMOND, i));
			playingCards.addCard(new Card(Card.SUIT_HEART, i));
			playingCards.addCard(new Card(Card.SUIT_SPADE, i));
		}
		
		// ジョーカーの作成
		playingCards.addCard(new Card(0, Card.CARD_JOKER));
		
		return playingCards;
	}

}