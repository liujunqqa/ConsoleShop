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
                    System.out.print("商品编号:"+products[i].getId()+"\t");
                    System.out.print("商品名:"+products[i].getName()+"\t");
                    System.out.print("商品价格:"+products[i].getPricr()+"\t");
                    System.out.println("商品描述:"+products[i].getMs()+"\t");
                }
                boolean h=true;
                int count = 0;
                Product product1[] = new Product[4];
                while (h) {
                    System.out.println("请输入商品的ID进行购买");
                    String vb = in.next();
                    ReadeUserExcel readeUserExcel1 = new ReadeUserExcel();
                    k2 = null;
                    k2 = Class.forName("Test").getResourceAsStream("/Product.xlsx");
                    Product product = readProductExcel.readProductId(vb, k2);
                    if (product != null) {
                        product1[count] = product;
                        count = count + 1;
                        System.out.println("加入成功，选择下列操作:1.继续加入 2.查看购物车 3.退出");
                        int answer=in.nextInt();
                        if(answer==1){
                            for(int i=0;i<products.length;i++){
                                System.out.print("商品编号"+products[i].getId()+"\t");
                                System.out.print("商品名"+products[i].getName()+"\t");
                                System.out.print("商品价格"+products[i].getPricr()+"\t");
                                System.out.println("商品描述"+products[i].getMs()+"\t");
                            }

                        }
                        else if(answer==2){
                            for(int i=0;i<count;i++) {
                                System.out.print(product1[i].getId() + "\t");
                                System.out.print(product1[i].getName() + "\t");
                                System.out.print(product1[i].getPricr() + "\t");
                                System.out.println(product1[i].getMs() + "\t");
                            }
                                System.out.println("查询成功，是否继续购买：1.是 2.否");
                                int b=in.nextInt();
                                if(b==1){
                                    answer=1;
                                }
                                else if(b==2){
                                    answer=3;
                                }

                        }
                        else if (answer==3){
                            h=false;
                        }
                    }
                }
            } else {
                System.out.println("登录失败");
            }
        }

    }
}
