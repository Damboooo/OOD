package ResourceManagement;


import java.util.Date;
import java.util.List;

public class Asset extends Resource {

    private List<Date> freeTimes;
    private String type;

    public List<Date> getFreeTimes() {
        return freeTimes;
    }

    public void setFreeTimes(List<Date> freeTimes) {
        this.freeTimes = freeTimes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
