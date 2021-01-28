import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Test {
    public static void main(String []args) throws ClassNotFoundException {
        Map<Integer,Integer>map=new HashMap<Integer, Integer>();
        Map<Integer,Integer>map1=new HashMap<Integer, Integer>();
        Map<Integer,Integer>map2=new HashMap<Integer, Integer>();
        int l = 0;//标记循环条件
        int userlocal = 0;
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
                    userlocal=i;
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
                    System.out.println("请输入商品数量");
                    String vb1 = in.next();
                    ReadeUserExcel readeUserExcel1 = new ReadeUserExcel();
                    k2 = null;
                    k2 = Class.forName("Test").getResourceAsStream("/Product.xlsx");
                    Product product = readProductExcel.readProductId(vb, k2);
                    if (product != null) {
                        product1[count] = product;
                        map1.put(Integer.parseInt(vb),(int)product.getPricr()*Integer.parseInt(vb1));
                        count = count + 1;
                        map.put(Integer.parseInt(vb),Integer.parseInt(vb1));
                        System.out.println("加入成功，选择下列操作:1.继续加入 2.查看购物车 3.提交订单 4.退出");
                        int answer=in.nextInt();
                        if(answer==1){
                            for(int i=0;i<products.length;i++){
                                System.out.print("商品编号:"+products[i].getId()+"\t");
                                System.out.print("商品名:"+products[i].getName()+"\t");
                                System.out.print("商品价格:"+products[i].getPricr()+"\t");
                                System.out.println("商品描述:"+products[i].getMs()+"\t");
                            }

                        }
                        else if(answer==2){
                            for(int i=0;i<count;i++) {
                                System.out.print(product1[i].getId() + "\t");
                                System.out.print(product1[i].getName() + "\t");
                                System.out.print(product1[i].getPricr() + "\t");
                                System.out.println(product1[i].getMs() + "\t");
                            }

                                    System.out.println("查询成功，请选择下列操作：1.继续购买 2.提交订单 3.退出");
                                    int b=in.nextInt();
                                    answer=1;
                                if(b==1){
                                    h=true;

                                }
                                else if (b==2){
                                    Order order=new Order();
                                    order.setUser(user[userlocal]);
                                    order.setProduct(product1);
                                    order.setCount(map);
                                    order.setSumpay(map1);
                                    order.setPayment(map1);
                                    MakeOrderExcel(order,count);
                                    h=false;

                                }
                                else if(b==3){
                                    h=false;
                                }

                        }
                        else if (answer==3){
                            Order order=new Order();
                            order.setUser(user[userlocal]);
                            order.setProduct(product1);
                            order.setCount(map);
                            order.setSumpay(map1);
                            MakeOrderExcel(order,count);
                            h=false;
                        }
                        else if (answer==4){
                            h=false;
                        }
                    }
                }
            } else {
                System.out.println("登录失败");
            }
        }

    }
    public static void MakeOrderExcel(Order order,int count){
        /* String outputFile = "D:\\Order.xls";**/
        String outputFile="C:\\Users\\俊\\Desktop\\ConsoleShop\\src\\Order.xls";
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("用户订单");
            HSSFRow row = sheet.createRow((short)0);
            String[]kk={"用户编号","商品编号","商品数量","总价格","实付价格","订单时间"};
            for(int i=0;i<kk.length;i++){
                HSSFCell cell01 = row.createCell((short)i);
                cell01.setCellValue(kk[i]);
            }
            for(int k=0;k<count;k++) {
                HSSFRow row1 = sheet.createRow((short) k+1);
                for (int j = 0; j < 6; j++) {
                    HSSFCell cell01 = row1.createCell((short) j);
                    int opq=Integer.parseInt(order.getProduct()[k].getId());
                    if (j == 0) {
                        cell01.setCellValue(order.getUser().getUsername());
                    } else if (j == 1) {

                       /*String  bn = order.getProduct()[0].getId();

                    if (count>1){
                        for (int y = 1; y < count; y++) {
                            bn = bn +","+ order.getProduct()[y].getId() ;
                        }
                    }
                    cell01.setCellValue(bn);**/
                        cell01.setCellValue(order.getProduct()[k].getId());
                    } else if (j == 2) {
                        //cell01.setCellValue(order.getCount(count));
                        Map<Integer,Integer>amnout=order.getCount();
                        int productIdcount=amnout.get(opq);
                        cell01.setCellValue(productIdcount);

                    } else if (j == 3) {
                        //cell01.setCellValue(order.getSumpay(count));
                        Map<Integer,Integer>amnout=order.getSumpay();
                        int productIdsumpay=amnout.get(opq);
                        cell01.setCellValue(productIdsumpay);

                    } else if (j == 4) {
                        //cell01.setCellValue(order.getPayment(count));
                        Map<Integer,Integer>payment=order.getSumpay();
                        int productIdpayment=payment.get(opq);
                        cell01.setCellValue(productIdpayment);
                    } else if (j == 5) {
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String op = format.format(order.getDate());
                        cell01.setCellValue(op);
                    }

                }
            }
            FileOutputStream fOut = new FileOutputStream(outputFile);
            workbook.write(fOut);
            fOut.flush();
            fOut.close();
            System.out.println("文件生成...");
        } catch (Exception e) {
            System.out.println("已运行 xlCreate() : " + e);
        }
    }
}
