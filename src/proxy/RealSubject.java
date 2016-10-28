package proxy;

/**
 * 真实类
 * Created by huyongqiang on 2016/10/28.
 */
public class RealSubject implements Subject {
    @Override
    public void Request() {
        // TODO Auto-generated method stub
        System.out.println("RealSubject");
    }
}