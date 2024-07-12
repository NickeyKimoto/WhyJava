package Lesson4_1;

/*
*クラス名：ObjectJanken
*概要：ジャンケンを開始する(エラー)
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
		// 審判(齊藤さん)のインスタンス生成
		Judge judgeSaito = new Judge();
		// プレイヤー1(村田さん)の生成
		Murata playerMurata = new Murata("村田さん");
		// プレイヤー1(山田さん)の生成
		Yamada playerYamada = new Yamada("山田さん");
		
		// 村田さんと山田さんをプレイヤーとしてジャンケンを開始する
		judgeSaito.startJanken(playerMurata, playerYamada);

	}

}
