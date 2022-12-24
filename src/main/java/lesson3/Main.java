package lesson3;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws ParseException {
        GsonParser gsonParser = new GsonParser();
        Root root = gsonParser.parse();
        info(root);
        securities(root);
        AfterDate(root);
        searchForSecurities(root);
    }

    private static void AfterDate(Root root) {
        System.out.println("Введите дату, чтобы вывести название и дату создания всех организаций, основанных после введенной даты");
        Scanner in = new Scanner(System.in);
        String mydate = in.nextLine();
        LocalDate newDate = convert(mydate);

        for (int i = 0; i < root.getCompanies().size(); i++) {
            Company company = root.getCompanies().get(i);
            LocalDate datee = LocalDate.parse(company.getFounded(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            LocalDate dateOfPaper = LocalDate.parse(datee.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            if (dateOfPaper.isAfter(newDate)){
                System.out.println(company.getName());
                System.out.println(company.getFounded() + "\n");
            }
        }
        System.out.println("*********************************************");
    }

    public static void info(Root root) {
        System.out.println("Info:");
        for (int i = 0; i < root.getCompanies().size(); i++) {
            Company company = root.getCompanies().get(i);
            Stream.of(company).forEach(company1 ->
                    System.out.println(String.join("", "'", company.getName(), "' - '", company.getFounded(), "'"))
            );
        }
        System.out.println("\n*********************************************");
    }

    public static void securities(Root root) {
        System.out.println("\nценные бумаги: ");
        for (int i = 0; i < root.getCompanies().size(); i++) {
            Company company = root.getCompanies().get(i);

            LocalDate datee = LocalDate.parse(company.getSecurities().get(0).getDate(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            LocalDate dateOfPaper = LocalDate.parse(datee.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

            if(dateOfPaper.isBefore(LocalDate.now())){
                System.out.println(company.getSecurities().get(0).getDate());
                System.out.println("код " + company.getSecurities().get(0).getCode());
                System.out.println("дата " + company.getSecurities().get(0).getDate());
                System.out.println("название орг " + company.getName());
                System.out.println("число бумаг " + company.getSecurities().size());
                System.out.println("\n");
            }
        }


        System.out.println("*********************************************\n");

    }
    public static void searchForSecurities(Root root) {
        System.out.println("Введите валюту для поиска ценных бумаг");
        Scanner in2 = new Scanner(System.in);
        String value = in2.nextLine();
        for (int i = 0; i < root.getCompanies().size(); i++) {
            Company company = root.getCompanies().get(i);
            for (int j = 0; j < company.getSecurities().size(); j++) {
                if(company.getSecurities().get(j).getCurrency().contains(value))
                    System.out.println("Id: " + company.getId());
                System.out.println("Code: " + company.getSecurities().get(j).getCode());
            }
        }
    }

    public static LocalDate convert(String mydate) {
        if (mydate.matches("^(0?[1-9]|[12][0-9]|3[0-1])\\.(0?[1-9]|1[0-9])\\.\\d{4}$")) {
            LocalDate dateEmpty = LocalDate.parse(mydate.toString(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            return LocalDate.parse(dateEmpty.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        } else if (mydate.matches("^(0?[1-9]|[12][0-9]|3[0-1])\\.(0?[1-9]|1[0-9])\\.\\d{2}$")) {
            LocalDate dateEmpty = LocalDate.parse(mydate.toString(), DateTimeFormatter.ofPattern("dd.MM.yy"));
            return LocalDate.parse(dateEmpty.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        } else if (mydate.matches("^(0?[1-9]|[12][0-9]|3[0-1])\\/(0?[1-9]|1[0-9])\\/\\d{4}$")) {
            LocalDate dateEmpty = LocalDate.parse(mydate.toString(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return LocalDate.parse(dateEmpty.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        } else if (mydate.matches("^(0?[1-9]|[12][0-9]|3[0-1])\\/(0?[1-9]|1[0-9])\\/\\d{2}$")) {
            LocalDate dateEmpty = LocalDate.parse(mydate.toString(), DateTimeFormatter.ofPattern("dd/MM/yy"));
            return LocalDate.parse(dateEmpty.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        } else {
            System.out.println("неправильный формат");
        }
        return null;
    }
}
