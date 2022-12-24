package lesson3;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

import com.google.gson.annotations.SerializedName;

@Data
public class Security {

    private String name;
    private List<String> currency;
    private String code;
    private String date;


    @Override
    public String toString() {
        return "Security{" +
                "name='" + name + '\'' +
                ", currency=" + currency +
                ", code='" + code + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
