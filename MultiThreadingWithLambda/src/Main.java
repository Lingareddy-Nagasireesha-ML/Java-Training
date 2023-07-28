// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

            Runnable obj1= () -> {
                for(int i=1;i<=100;i++) {
                    System.out.println("hello");
                    try {
                        Thread.sleep(10);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            };

        Runnable obj2= () -> {
            for(int i=1;i<=100;i++) {
                System.out.println("hi");
                try {
                    Thread.sleep(10);
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
        };

        Thread t1=new Thread(obj1);
        Thread t2=new Thread(obj2);

        t1.start();
        t2.start();
    }
}