package Scratch;



abstract class cd extends a {

}
abstract class a {

}






interface  parent{
    abstract int hello();
}
interface x extends parent{
    @Override
   default int hello(){
    return 1;
}
}
interface y extends parent{
    @Override
    default int hello(){
        return 2;
    }
}
public class Daimond implements x,y{
    public static void main(String[] args) {
        Daimond d = new Daimond();
        d.hello();
    }
    @Override
    public int hello() {
        System.out.println(x.super.hello());
        System.out.println(y.super.hello());
        return 0;
    }


}
