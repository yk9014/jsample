abstract class AbstractFactory {
	public static AbstractFactory getFactory(String name){
		//nameによって異なるConcreteFactoryを返す
		
		AbstractFactory factory=null;
		
		if(name.equals("1")){
			factory=new ConcreteFactory1();
		}else{
			factory=new ConcreteFactory2();
		}
		
		return factory;
	}
	public abstract AbstractProductA createProductA();
	public abstract AbstractProductB createProductB();
}

//具象Factory
class ConcreteFactory1 extends AbstractFactory {
	public AbstractProductA createProductA(){
		return new ProductA1();
	}
	public AbstractProductB createProductB(){
		return new ProductB1();
	}
}
class ConcreteFactory2 extends AbstractFactory {
	public AbstractProductA createProductA(){
		return new ProductA2();
	}

	public AbstractProductB createProductB(){
		return new ProductB2();
	}
}
//部品の抽象クラス
abstract class AbstractProductA {
	public abstract void operation();
}
abstract class AbstractProductB {
	public abstract void operation();
}
//部品の具象クラス
class ProductA1 extends AbstractProductA {
	public void operation(){
		System.out.println("A1");
	}
}
class ProductA2 extends AbstractProductA {
	public void operation(){
		System.out.println("A2");
	}
}
class ProductB1 extends AbstractProductB {
	public void operation(){
		System.out.println("B1");
	}
}
class ProductB2 extends AbstractProductB {
	public void operation(){
		System.out.println("B2");
	}
}
class Client {
	public void execute(String name){
		//ConcreteFactoryを取得する
		AbstractFactory factory=AbstractFactory.getFactory(name);

		//部品を取得する
		AbstractProductA a1=factory.createProductA();
		AbstractProductB b1=factory.createProductB();
		
		//それぞれのメソッドを呼び出す
		a1.operation();
		b1.operation();
	}
}
class AbstractFactoryTest{
	public static void main(String[] args){
		Client c=new Client();

		c.execute("1");
		c.execute("2");
	}
}
