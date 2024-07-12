package Lesson4_2.SimpleJanken;

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
		// 審判(齊藤さん)のインスタンス生成
		Judge saito = new Judge();
		// プレイヤー1(村田さん)の生成
		Player murata = new Murata("村田さん");
		// プレイヤー1(山田さん)の生成
		Player yamada = new Yamada("山田さん");
		
		// 村田さんと山田さんをプレイヤーとしてジャンケンを開始する
		saito.startJanken(murata, yamada);
	}

}
