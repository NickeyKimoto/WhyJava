package Lesson9_5;

// トランプゲームワークフレームのマスタークラスをインポート
import trump.Master;

/*
*クラス名：FantanMaster
*概要：七並べの進行役を表すクラス
*作成者：N.Kimoto
*作成日：2024/07/03
*/
public class FantanMaster extends Master {
	
	// パスできる上限回数
	public static final int PASS_LIMIT = 3;
	
	/*
	*関数名：declaerPass
	*概要：パスを宣言する
	*引数：七並べのプレイヤー(FantanPlayer型)
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/07/03
	*/
	public void declaerPass(FantanPlayer gamePlayer) {
		
		// そのプレイヤーがパスをしたことを表示
		System.out.println(" " + gamePlayer + "さんは" + gamePlayer.getPass()
				+ "回目のパスをしました！");
		
		// パス回数が上限を超えた場合
		if (gamePlayer.getPass() > PASS_LIMIT) {
			
			// そのプレイヤーは負けであることを表示
			System.out.println(" " + gamePlayer + "さんは負けです！");
			// 負けたプレイヤーを参加者リストから除外する
			deregisterPlayer(gamePlayer);
			
		}
		
	}

}
