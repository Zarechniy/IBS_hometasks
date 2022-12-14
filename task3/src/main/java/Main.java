import model.Company;
import model.Security;
import model.Shares;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) throws IOException {

        Parser parser = new Parser();
        Shares shares = parser.parse();

        ArrayList<Company> companies = new ArrayList<>(shares.getCompanies());

        ArrayList<Security> securities = new ArrayList<>();
        for (Company company : companies) {
            securities.addAll(company.getSecurities());
        }

        System.out.println("Список компаний: ");
        companies.forEach(Company::getNameAndFoundationDate);

        System.out.println("\n" + "Список просроченных ценных бумаг: ");
        securities.forEach(security -> {
            try {
                security.expiredSecuritiesPrintInfo();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });

        AtomicInteger count = new AtomicInteger();
        securities.forEach(security -> {
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("dd.MM.yyyy");
            String date = security.getDate();
            Date currentDate = new Date();

            int result = 0;
            try {
                result = format.parse(date).compareTo(currentDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (result < 0) {
                count.getAndIncrement();
            }
        });

        System.out.println("\n" + "Общее количество просроченных бумаг: " + count);

        System.out.println("\n" + "Введите запрос даты:");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInsert = reader.readLine();

        DateCheck dateCheck = new DateCheck();
        assert userInsert != null;
        if (dateCheck.isValidDate1(userInsert)) {
            LocalDate insertedDate = toLocalDate(userInsert);
            for (Company company : companies) {
                LocalDate expireDate = toLocalDate(company.getFounded());
                int result = insertedDate.compareTo(expireDate);
                if (result < 0) {
                    company.getNameAndFoundationDate();
                }
            }
        } else if (dateCheck.isValidDate2(userInsert)) {
            LocalDate insertedDate = toLocalDate(userInsert);
            for (Company company : companies) {
                LocalDate expireDate = toLocalDate(company.getFounded());
                int result = insertedDate.compareTo(expireDate);
                if (result < 0) {
                    company.getNameAndFoundationDate();
                }
            }
        } else if (dateCheck.isValidDate3(userInsert)) {
            LocalDate insertedDate = toLocalDate(userInsert);
            for (Company company : companies) {
                LocalDate expireDate = toLocalDate(company.getFounded());
                int result = insertedDate.compareTo(expireDate);
                if (result < 0) {
                    company.getNameAndFoundationDate();
                }
            }
        } else if (dateCheck.isValidDate4(userInsert)) {
            LocalDate insertedDate = toLocalDate(userInsert);
            for (Company company : companies) {
                LocalDate expireDate = toLocalDate(company.getFounded());
                int result = insertedDate.compareTo(expireDate);
                if (result < 0) {
                    company.getNameAndFoundationDate();
                }
            }
        }

            System.out.println("\n" + "Введите запрос валюты:");

            String currencyRub = "RUB";
            String currencyEu = "EU";
            String currencyUsd = "USD";
            String userInsert1 = reader.readLine();

            assert userInsert1 != null;
            if (userInsert1.equalsIgnoreCase(currencyRub)) {
                securities.forEach(security -> {
                    if (security.getCurrency().contains("RUB")) {
                        companies.forEach(company -> {
                            if (company.getSecurities().contains(security)) {
                                System.out.print("For: ");
                                System.out.println("ID " + company.getId());
                            }
                        });
                        System.out.println("Security code: " + security.getCode() + "\n");
                    }
                });
            } else if (userInsert1.equalsIgnoreCase(currencyEu)) {
                securities.forEach(security -> {
                    if (security.getCurrency().contains("EU")) {
                        companies.forEach(company -> {
                            if (company.getSecurities().contains(security)) {
                                System.out.print("For: ");
                                System.out.println("ID " + company.getId());
                            }
                        });
                        System.out.println("Security code: " + security.getCode() + "\n");
                    }
                });
            } else if (userInsert1.equalsIgnoreCase(currencyUsd)) {
                securities.forEach(security -> {
                    if (security.getCurrency().contains("USD")) {
                        companies.forEach(company -> {
                            if (company.getSecurities().contains(security)) {
                                System.out.print("For: ");
                                System.out.println("ID " + company.getId());
                            }
                        });
                        System.out.println("Security code: " + security.getCode() + "\n");
                    }
                });
            }
        reader.close();
        }


    public static LocalDate toLocalDate(String inputDate) {
        Map<String, String> patterns = new HashMap<>();
        patterns.put("\\d{1,2}/\\d{1,2}/\\d{2,4}", "dd/M/");
        patterns.put("\\d{1,2}\\.\\d{1,2}\\.\\d{2,4}", "dd.M.");

        DateTimeFormatter formatter = null;
        LocalDate date = null;
        for (Map.Entry<String, String> pattern : patterns.entrySet()) {
            if (inputDate.matches(pattern.getKey())) {
                formatter = new DateTimeFormatterBuilder()
                        .appendPattern(pattern.getValue())
                        .appendValueReduced(ChronoField.YEAR_OF_ERA,
                                2, 4,
                                LocalDate.now().minusYears(80))
                        .toFormatter();
                break;
            }
        }
        if (formatter != null) {
            try {
                date = LocalDate.parse(inputDate, formatter);
            } catch (DateTimeParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }
}