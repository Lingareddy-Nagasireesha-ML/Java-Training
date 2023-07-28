public class MyClass implements InterfaceA, InterfaceB{
    @Override
    public void commonMethod() {
        //you can call whatever method you want.
        InterfaceB.super.commonMethod();
        InterfaceA.super.commonMethod();
    }
}
