import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
   private User user;
   private Product product[];
   private int count;
   private float sumpay;
   private float payment;
   private Date date;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product[] getProduct() {
        return product;
    }

    public void setProduct(Product[] product) {
        this.product = product;
    }

    public int getCount(int count1) {
        count=count1;
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getSumpay(int count) {
        for (int i=0;i<count;i++){
            sumpay=sumpay+product[i].getPricr();
        }

        return sumpay;

    }

    public void setSumpay(float sumpay) {
        this.sumpay = sumpay;
    }

    public float getPayment(int count) {
        for (int i=0;i<count;i++){
            payment=payment+product[i].getPricr();
        }
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }

    public Date getDate() {
        Date date=new Date();
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
