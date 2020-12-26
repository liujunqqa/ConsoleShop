import java.io.File;
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
        File file=new File();
        ReadeExcel readeExcel=new ReadeExcel();
        User user[]=readeExcel.readExcel(file);
        int l=0;
        for(int i=0;i<user.length;i++){
            if(user[i].getUsername().equals(username)){
                System.out.println("登录成功");
                l=1;
            }
        }
        if(l==1){
            System.out.println("登录成功");
        }
        else {
            System.out.println("登录失败");
        }

    }
}
