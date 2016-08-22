package ResourceManagement;


import java.util.Date;
import java.util.List;

public class Asset extends Resource {

    private String freeTimes;
    private String type;

    public String getFreeTimes() {
        return freeTimes;
    }

    public void setFreeTimes(String freeTimes) {
        this.freeTimes = freeTimes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
