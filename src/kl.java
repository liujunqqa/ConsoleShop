import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;

public class kl {
    public static String outputFile = "D:\\test.xls";
    public static void main(String []args){


            try {
                // 创建新的Excel 工作簿
                HSSFWorkbook workbook = new HSSFWorkbook();
                // 在Excel工作簿中建一工作表，其名为缺省值
                // 如要新建一名为"效益指标"的工作表，其语句为：
                HSSFSheet sheet = workbook.createSheet("学生成绩");
                //创建第一行
                HSSFRow row = sheet.createRow((short)0);
                //创建第一行的第一个单元格
                HSSFCell cell01 = row.createCell((short)0);
                //创建第一行的第二个单元格
                HSSFCell cell02 = row.createCell((short)1);
                // 在第一行单元格中输入一些内容
                cell01.setCellValue("科目");
                cell02.setCellValue("分数");

                //创建第二行
                HSSFRow row1 = sheet.createRow((short)1);
                //创建第二行的第一个单元格
                HSSFCell cell11 = row1.createCell((short)0);
                //创建第二行的第二个单元格
                HSSFCell cell12 = row1.createCell((short)1);
                // 在第二行单元格中输入一些内容
                cell11.setCellValue("语文");
                cell12.setCellValue("90");

                //创建第三行
                HSSFRow row2 = sheet.createRow((short)2);
                //创建第三行的第一个单元格
                HSSFCell cell21 = row2.createCell((short)0);
                //创建第三行的第二个单元格
                HSSFCell cell22 = row2.createCell((short)1);
                // 在第三行单元格中输入一些内容
                cell21.setCellValue("数学");
                cell22.setCellValue("90");

                //创建第四行
                HSSFRow row3 = sheet.createRow((short)3);
                //创建第四行的第一个单元格![图片描述](https://dn-simplecloud.shiyanlou.com/courses/uid1552050-20201214-1607918833073)
                HSSFCell cell31 = row3.createCell((short)0);
                //创建第四行的第二个单元格
                HSSFCell cell32 = row3.createCell((short)1);
                // 在第四行单元格中输入一些内容
                cell31.setCellValue("英语");
                cell32.setCellValue("100");

                // 新建一输出文件流
                FileOutputStream fOut = new FileOutputStream(outputFile);
                // 把相应的Excel 工作簿存盘
                workbook.write(fOut);
                fOut.flush();
                // 操作结束，关闭文件
                fOut.close();
                System.out.println("文件生成...");
            } catch (Exception e) {
                System.out.println("已运行 xlCreate() : " + e);
            }
        }
    }

