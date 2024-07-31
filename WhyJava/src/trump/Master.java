package trump;

//ArrayListクラスをインポート
import java.util.ArrayList;

/*
*クラス名：Master
*概要：進行役を表すクラス
*作成者：N.Kimoto
*作成日：2024/07/02
*/
public class Master {
	
	// ゲームに参加する参加者を保持するためのリストを表すフィールドを宣言
	private ArrayList gamePlayers = new ArrayList();
	
	/*
	*関数名：prepareGame
	*概要：ゲームの準備をする
	*引数：ゲームに使用するカード(Hand型)
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/07/01
	*/
	public void prepareGame(Hand playingCards) {
		
		// カードを配ると宣言する
		System.out.println("【カードを配ります】");
		
		// トランプをシャッフルする
		playingCards.shuffle();
		// トランプの枚数を取得する
		int numberOfCards = playingCards.getNumberOfCards();
		// プレイヤーの人数を取得する
		int numberOfPlayers = gamePlayers.size();
		
		// 各プレイヤーに順番にカードを配る
		for(int i = 0; i < numberOfCards; i++) {
			
			// カードから1枚引く
			Card drawnCard = playingCards.pickCard(0);
			// 各プレイヤーに順番にカードを配る
			Player gamePlayer = (Player) gamePlayers.get(i % numberOfPlayers);
			// それぞれのプレイヤーは配られたカードを手札に加える
			gamePlayer.receiveCard(drawnCard);
			
		}
		
	}
	
	/*
	*関数名：startGame
	*概要：ゲームを開始する
	*引数：なし
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/07/01
	*/
	public void startGame() {
		
		// ゲームを開始すると宣言する
		System.out.println("【ゲームを開始します】");
		
		// プレイヤーの最低人数の基準を表す定数を宣言
		final int LOW_STANDARD_PLAYER_NUMBER = 1;
		// プレイヤーの人数を取得する
		for(int i = 0; gamePlayers.size() > LOW_STANDARD_PLAYER_NUMBER; i++) {
			
			// プレイヤーの順番を初期化する
			int playerIndex = i % gamePlayers.size();
			// 次のプレイヤーの順番に調整する定数を宣言
			final int ADJUST_ORDER_NEXT_PLAYER = 1;
			// 次のプレイヤーの順番を表す変数を初期化する
			int nextPlayerIndex = (i + ADJUST_ORDER_NEXT_PLAYER) % gamePlayers.size();
			
			// 指名するプレイヤーの取得
			Player nominatePlayer = (Player) gamePlayers.get(playerIndex);
			// 次のプレイヤーの取得
			Player nextNominatePlayer = (Player) gamePlayers.get(nextPlayerIndex);
			
			// 指名するプレイヤーを表示
			System.out.println("\n" + nominatePlayer + "さんの番です");
			// プレイヤーを指名する
			nominatePlayer.nominatePlayer(nextNominatePlayer);
			
		}
		
		// プレイヤーが上がって残り1名になるとループを抜ける
		System.out.println("【ゲームを終了しました】");
		
	}
	
	/*
	*関数名：declareWin
	*概要：上がりを宣言する
	*引数：勝者(Player型)
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public void declareWin(Player gameWinner) {
		
		// 上がったプレイヤーを表示
		System.out.println(gameWinner + "さんが上がりました！");
		// 上がったプレイヤーをリストから外す
		deregisterPlayer(gameWinner);

	}
	
	/*
	*関数名：registerPlayer
	*概要：ゲームに参加するプレイヤーを登録する
	*引数：参加希望者(Player型)
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public void registerPlayer(Player gameParticipants) {
		
		// リストに参加者を追加する
		gamePlayers.add(gameParticipants);
		
	}
	
	/*
	*関数名：registerPlayer
	*概要：プレイヤーを登録から削除する
	*引数：削除するプレイヤー(Player型)
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/07/02
	*/
	public void deregisterPlayer(Player gameParticipants) {
		
		// プレイヤーをリストから外す
		gamePlayers.remove(gamePlayers.indexOf(gameParticipants));
        
		// 敗者が決まる基準となる定数を宣言
		final int STANDARD_DECISION_LOSER = 1;
		// 残りプレイヤーが1人になった場合
        if (gamePlayers.size() == STANDARD_DECISION_LOSER) {
        	
        	// ゲームの敗者を初期化
        	Player loserPlayer = (Player)gamePlayers.get(0);
        	// 敗者を表示
        	System.out.println("  " + loserPlayer + "さんの負けです！");
        	
        }
        
	}

}
