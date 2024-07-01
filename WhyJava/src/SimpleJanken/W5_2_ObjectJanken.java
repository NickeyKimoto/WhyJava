package SimpleJanken;

/*
*クラス名：W5_2_ObjectJanken
*概要：ジャンケンを開始する
*作成者：N.Kimoto
*作成日：2024/06/28
*/
public class W5_2_ObjectJanken {

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
		W5_1_Player murata = new W5_1_Player("村田さん");
		// 村田さんに渡す戦略クラスを生成する
		W5_1_Tactics murataTactics = new RandomTactics();
		// 村田さんに戦略クラスを渡す
		murata.setTactics(murataTactics);
		
		// プレイヤー1(山田さん)の生成
		W5_1_Player yamada = new W5_1_Player("山田さん");
		// 山田さんに渡す戦略クラスを生成する
		W5_1_Tactics yamadaTactics = new RandomTactics();
		// 山田さんに戦略クラスを渡す
		yamada.setTactics(yamadaTactics);
		
		// 村田さんと山田さんをプレイヤーとしてジャンケンを開始する
		judgePerson.startJanken(murata, yamada);
	}

}
