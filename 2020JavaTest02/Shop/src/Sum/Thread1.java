package Sum;

//用继承方式，重写run函数
public class Thread1 extends Thread {
    protected long ans=0;
    protected int Start,End;
    protected int x;

    public long getAns( ) {
        return ans;
    }

    //构造器
    public Thread1( int start , int end , int x ) {
        Start = start;
        End = end;
        this.x = x;
    }

    @Override
    public void run( ) {
        for (int i = Start; i < End; i++) {
            if ( Main.contain( i,x )) {
                ans += i;
            }
        }
    }
}
