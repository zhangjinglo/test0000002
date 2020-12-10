package Sum;
import java.util.Scanner;


public class Main {

    public static void main( String[] args ) {
        long answer=0;
        System.out.println("请输入数字：" );
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int threadNum=50;//用50个线程来计算
        int eachLength=1000000000/threadNum;//每个区间的数字长度
        Thread1[] arr = new Thread1[threadNum];//线程对象数组
        //初始化每个线程对象要计算的区间
        for (int i = 0; i < threadNum; i++) {
            arr[i]=new Thread1(i*eachLength,(i+1)*eachLength,x);
        }
        //开始跑
        for (int i = 0; i < threadNum; i++) {
            arr[i].start();
        }
        //把要跑的线程全join，以免计算用的线程还没跑完主线程main就输出了，结果是错的
        for (int i = 0; i < threadNum; i++) {
            try{
                arr[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace( );
            }
        }
        //把每个跑完的线程的计算结果相加
        for (int i = 0; i < threadNum; i++) {
            answer+=arr[i].getAns();
        }
        System.out.println(answer );

        /*没用多线程要跑30+s，用多线程可以到10s左右
        for (long i = 1; i < 1000000000; i++) {
            if (contain(i, x)) answer += i;
        }
        System.out.println(answer );*/
    }

    public static boolean contain( long num , int x ) {
        return String.valueOf( num ).contains( String.valueOf( x ) );
    }
}
