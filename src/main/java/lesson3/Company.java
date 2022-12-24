package lesson3;

import com.google.gson.annotations.SerializedName;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class Company {
        private String id;
        private String name;
        private String address;
        private String phoneNumber;
        private String inn;
        private String founded;
        private List<Security> securities;

        @Override
        public String toString() {
                return "Company{" +
                        "id='" + id + '\'' +
                        ", name='" + name + '\'' +
                        ", address='" + address + '\'' +
                        ", phoneNumber='" + phoneNumber + '\'' +
                        ", inn='" + inn + '\'' +
                        ", founded='" + founded + '\'' +
                        ", securities=" + securities +
                        '}';
        }
}