package Sync;

public class ThreadWaitTest {
    public static void main(String[]args) throws Exception {
        ThreadWaitTest a=new ThreadWaitTest();
        a.haha();
    }
    public synchronized void haha() throws Exception{
        this.wait();
    }
}
