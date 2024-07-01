package oldMaid;

import java.util.ArrayList;

public class Master {
	
	private ArrayList gamePlayers = new ArrayList();
	
	// ゲームの準備をする
	public void prepareGame(Hand playingCards) {
		System.out.println("【カードを配ります】");
		
		// トランプをシャッフルする
		playingCards.shuffle();
		// トランプの枚数を取得する
		int numberOfCards = playingCards.getNumberOfCards();
		// プレイヤーの人数を取得する
		int numberOfPlayers = gamePlayers.size();
		
		for(int i = 0; i < numberOfCards; i++) {
			
			// カードから1枚引く
			Card drawnCard = playingCards.pickCard();
			// 各プレイヤーに順番にカードを配る
			Player gamePlayer = (Player) gamePlayers.get(i % numberOfPlayers);
			gamePlayer.receiveCard(drawnCard);
			
		}
	}
	
	// ゲームを開始する
	public void startGame() {
		System.out.println("【ババ抜きを開始します】");
		
		// プレイヤーの人数を取得する
		for(int i = 0; gamePlayers.size() > 1; i++) {
			int playerIndex = i % gamePlayers.size();
			int nextPlayerIndex = (i + 1) % gamePlayers.size();
			
			// 指名するプレイヤーの取得
			Player nominatePlayer = (Player) gamePlayers.get(playerIndex);
			// 次のプレイヤーの取得
			Player nextNominatePlayer = (Player) gamePlayers.get(nextPlayerIndex);
			
			// プレイヤーを指名する
			System.out.println("\n" + nominatePlayer + "さんの番です");
			nominatePlayer.nominatePlayer(nextNominatePlayer);
		}
		
		// プレイヤーが上がって残り1名になるとループを抜ける
		System.out.println("【ババ抜きを終了しました】");
	}
	
	// 上がりを宣言する
	public void declareWin(Player gameWinner) {
		// 上がったプレイヤー
		System.out.println(gameWinner + "さんが上がりました！");
		
		// 上がったプレイヤーをリストから外す
		gamePlayers.remove(gamePlayers.indexOf(gameWinner));
		
		// 残りプレイヤーが1人になったときは敗者を表示する
		if (gamePlayers.size() == 1) {
			Player gameLoser = (Player) gamePlayers.get(0);
			System.out.println(gameLoser + "さんの負けです！");
		}
	}
	
	// ゲームに参加するプレイヤーを登録する
	public void registerPlayer(Player gameParticipants) {
		// リストに参加者を追加する
		gamePlayers.add(gameParticipants);
	}

}
