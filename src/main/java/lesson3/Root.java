package lesson3;

import lombok.Data;

import java.util.List;

@Data
public class Root {
    private List<Company> companies;

    @Override
    public String toString() {
        return "companies=" + companies +
                '}';
    }
}

