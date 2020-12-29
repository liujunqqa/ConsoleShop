import java.io.InputStream;
import java.util.Scanner;
public class Test {
    public static void main(String []args) throws ClassNotFoundException {
        int l = 0;
        while(l==0) {
            System.out.println("请输入用户名");
            Scanner in = new Scanner(System.in);
            String username = in.next();
            System.out.println("请输入密码");
            String password = in.next();
            /*File file=new File("C:\\Users\\lenovo\\IdeaProjects\\ConsoleShop\\src\\1.xlsx");**/
            InputStream kl = Class.forName("Test").getResourceAsStream("/User.xlsx");
            ReadeUserExcel readeExcel = new ReadeUserExcel();
            User user[] = readeExcel.readExcel(kl);
            for (int i = 0; i < user.length; i++) {
                if (user[i].getUsername().equals(username) && user[i].getPassword().equals(password)) {
                    l = 1;
                }
            }
            if (l == 1) {
                System.out.println("登录成功");
                ReadProductExcel readProductExcel=new ReadProductExcel();
                InputStream k2 = Class.forName("Test").getResourceAsStream("/Product.xlsx");
                Product[]products=readProductExcel.readProductExcel(k2);
                for(int i=0;i<products.length;i++){
                    System.out.print("商品编号"+products[i].getId()+"\t");
                    System.out.print("商品名"+products[i].getName()+"\t");
                    System.out.print("商品价格"+products[i].getPricr()+"\t");
                    System.out.println("商品描述"+products[i].getMs()+"\t");
                }
                int count=0;
                System.out.println("请输入商品的ID进行购买");
                String vb=in.next();
                ReadeUserExcel readeUserExcel1=new ReadeUserExcel();
                k2=null;
                k2=Class.forName("Test").getResourceAsStream("/Product.xlsx");
                Product product=readProductExcel.readProductId(vb,k2);
                if(product!=null){
                    Product product1[]=new Product[4];
                    product1[count]=product;
                    count=count+1;
                }
            } else {
                System.out.println("登录失败");
            }
        }

    }
}
