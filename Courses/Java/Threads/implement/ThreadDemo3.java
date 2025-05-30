import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyCallable implements Callable<String> {
    @Override
    public String call() {
        return "线程运行完成：" + Thread.currentThread().getName();
    }
}

public class ThreadDemo3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> c = new MyCallable();
        FutureTask<String> ft = new FutureTask<>(c);
        Thread t = new Thread(ft);
        t.start();

        // 获取返回值（阻塞等待）
        String result = ft.get();
        System.out.println("线程返回值：" + result);
    }
}