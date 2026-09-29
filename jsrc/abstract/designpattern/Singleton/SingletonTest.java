class Singleton{
	//インスタンスを格納するための変数を
	//クラス変数で用意する
	private static Singleton uniqueInstance=null;
	
	//サブクラスから呼び出せるようにprotectedにする
	//つまり同一パッケージの外部のクラスからはnewできてしまう
	protected Singleton(){}

	//外部のクラスからでも呼び出せるようにpublicとしておく
	public static Singleton getInstance(){
		//クラス変数にインスタンスが格納されているかどうか判定する
		if(uniqueInstance==null){
			//まだインスタンスが生成されていない場合は
			//インスタンスの生成を行う
			uniqueInstance=new Singleton();
		}
		
		return uniqueInstance;
	}
	//インスタンスメソッド
	public void show() {
		//サブクラスでオーバーライドする
	}
}
class OraDbSingleton extends Singleton{
	//インスタンスを格納するための変数をサブクラスでも用意する
	private static Singleton uniqueInstance=null;

	private OraDbSingleton(){	}

	//外部のクラスからでも呼び出せるようにpublicとしておく
	public static Singleton getInstance(){
		//クラス変数にインスタンスが格納されているかどうか判定する
		if(uniqueInstance==null){
			//まだインスタンスが生成されていない場合は
			//インスタンスの生成を行う
			uniqueInstance=new OraDbSingleton();
		}
		return uniqueInstance;
	}
	//オーバーライド
	public void show() {
		System.out.println("Oracle用のSingleton");
	}
}
class SingletonTest {
	public static void main(String[] args) {
		Singleton s1=OraDbSingleton.getInstance();
		Singleton s2=OraDbSingleton.getInstance();
		
		//同じインスタンスかどうかチェックする
		System.out.println(s1==s2);
		
		s1.show();
		s2.show();
	}
}
