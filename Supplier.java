import java.io.Serializable;

public class Supplier extends Person implements Serializable {
    private String id,password;

    public Supplier(String name, String contantnum, String id, String password) {

        super(name, contantnum);
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
