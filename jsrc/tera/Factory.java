package tera;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class Factory {
	private Factory(){ }		//インスタンス化を行わない
	public static Object load(String key) {

		Object obj = null;

		try {   
			
			Properties prop = new Properties();
			
			// プロパティファイルを読み込む
			prop.load(new FileInputStream("tera/calc.properties"));

			// キーに対応した文字列を取得します
			String name = prop.getProperty(key);

			// 指定された名前のクラスに対応したClassクラスの
			// インスタンスを取得する（名前は完全限定名であること）
			Class<?> c = Class.forName(name);

			// Classクラスのインスタンスを利用して
			// 対応するクラスのインスタンス化を行う
			// （内部的に引数のないコンストラクタを呼び出す）
            //Java9以降では単独使用が推奨されない
			obj = c.getDeclaredConstructor().newInstance();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}catch(InstantiationException e){
			e.printStackTrace();
		}catch(IllegalAccessException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
        }

		return obj;
	}
}

