import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Order {
   private User user;
   private Product product[];
   private Map<Integer,Integer> count;
   private Map<Integer,Integer> sumpay;
   private Map<Integer,Integer> payment;
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

    public Map<Integer, Integer> getCount() {
        return count;
    }

    public void setCount(Map<Integer, Integer> count) {
        this.count = count;
    }

    public Map<Integer, Integer> getSumpay() {
        return sumpay;
    }

    public void setSumpay(Map<Integer, Integer> sumpay) {
        this.sumpay = sumpay;
    }

    public Map<Integer, Integer> getPayment() {
        return payment;
    }

    public void setPayment(Map<Integer, Integer> payment) {
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
