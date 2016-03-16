package frame.jerry.com.fastandroid.model;

/**
 * Created by lufeisong on 16/3/16.
 */
public class Singer extends BaseModel {
    String name;
    long id;
    boolean isMale;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean isMale) {
        this.isMale = isMale;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
