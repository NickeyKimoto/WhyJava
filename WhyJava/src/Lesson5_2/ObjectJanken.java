package Lesson5_2;

/*
*クラス名：ObjectJanken
*概要：ジャンケンを開始する
*作成者：N.Kimoto
*作成日：2024/06/28
*/
public class ObjectJanken {

	/*
	*関数名：main
	*概要：ジャンケンを開始する
	*引数：なし
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/06/28
	*/
	public static void main(String[] args) {
		
		// 審判のインスタンス生成
		Judge judgePerson = new Judge();
		
		// プレイヤー1(村田さん)の生成
		Player playerMurata = new Player("村田さん");
		// 村田さんに渡す戦略クラスを生成する
		Tactics murataTactics = new CyclicTactics();
		// 村田さんに戦略クラスを渡す
		playerMurata.setTactics(murataTactics);
		
		// プレイヤー2(山田さん)の生成
		Player playerYamada = new Player("山田さん");
		// 山田さんに渡す戦略クラスを生成する
		Tactics yamadaTactics = new CyclicTactics();
		// 山田さんに戦略クラスを渡す
		playerYamada.setTactics(yamadaTactics);
		
		// 村田さんと山田さんをプレイヤーとしてジャンケンを開始する
		judgePerson.startJanken(playerMurata, playerYamada);
		
	}

}
