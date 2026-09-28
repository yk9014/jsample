interface Eatable{
    void eat();
}

class Dog implements Eatable{
    public void eat(){
        System.out.println("ドッグフードを食べます");
    }
}

class InterfaceTest{
    public static void main(String[] args) {
        Eatable eatable = new Dog();
        eatable.eat();
    }
}

