package frame.jerry.com.fastandroid.model;

import org.litepal.crud.DataSupport;

import java.util.Date;
import java.util.List;

/**
 * Created by lufeisong on 16/3/16.
 */
public class Album extends BaseModel {
    String name;
    String publisher;
    Date release;
    String serial;
    long id;
    double price;
    int sales;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public List<Singer> getSingers() {
        return DataSupport.where("name=?", name).find(Singer.class);
    }
}
