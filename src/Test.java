import java.util.Scanner;
public class Test {
    public static void main(String []args){
        System.out.println("请输入用户名");
        Scanner in=new Scanner(System.in);
        String username=in.next();
        System.out.println("你输入的用户名为："+username);
        System.out.println("请输入密码");
        String password=in.next();
        System.out.println("你输入的用户名为："+password);
    }
}
