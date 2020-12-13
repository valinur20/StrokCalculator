package comVISh;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassAnaliz {
    ClassPrint classPrint;

    public void analiz_value(String value) {
        classPrint = new ClassPrint();

        if (!value.substring(0, 1).equals("\"")) {
            classPrint.print_error("Ошибка ввода данных");
        }
        else {
            Pattern pattern = Pattern.compile("\"(.*?)\"");
            Matcher m = pattern.matcher(value);
            int count_naideno_slov = 0;
            String slovo1 = "";
            String slovo2 = "";

            while (m.find()) {
                count_naideno_slov++;

                if (count_naideno_slov == 1) {
                    slovo1 = m.group(1).trim();
                }
                if (count_naideno_slov == 2) {
                    slovo2 = m.group(1).trim();
                }
            }

            if (slovo2.equals("")) {
                String tmp_slovo1 = "\"" + slovo1 + "\"";
                String ostatok = value.replace(tmp_slovo1, "").trim();

                if (ostatok.indexOf("/") != -1) {
                    String[] arValue = ostatok.split("/");

                    if (proverka_len(1, arValue[1])) {
                        classPrint.print_delenie(slovo1, Integer.parseInt(arValue[1].trim()));
                    } else {
                        classPrint.print_error("Ошибка ввода данных");
                    }
                } else {
                    if (ostatok.indexOf("*") != -1) {
                        String[] arValue = ostatok.split("\\*");

                        if (proverka_len(1, arValue[1])) {
                            classPrint.print_umnohenie(slovo1, Integer.parseInt(arValue[1].trim()));
                        } else {
                            classPrint.print_error("Ошибка ввода данных");
                        }
                    } else {

                        classPrint.print_error("Ошибка ввода данных");
                    }
                }
            } else {
                String tmp_slovo1 = "\"" + slovo1 + "\"";
                String tmp_slovo2 = "\"" + slovo2 + "\"";
                String tmp3 = value.replace(tmp_slovo1, "").trim();
                String ostatok = tmp3.replace(tmp_slovo2, "").trim();

                if (ostatok.indexOf("+") != -1) {
                    if ((proverka_len(0, slovo1)) && (proverka_len(0, slovo2))) {
                        classPrint.print_summa(slovo1, slovo2);
                    } else {
                        classPrint.print_error("Ошибка ввода данных");
                    }
                } else {
                    if (ostatok.indexOf("-") != -1) {
                        if ((proverka_len(0, slovo1)) && (proverka_len(0, slovo2))) {
                            classPrint.print_minus(slovo1, slovo2);
                        } else {
                            classPrint.print_error("Ошибка ввода данных");
                        }
                    } else {
                        classPrint.print_error("Ошибка ввода данных");
                    }
                }
            }
            if (count_naideno_slov > 2) {
                classPrint.print_error("Ошибка ввода данных");
            }
        }
    }
    private static boolean proverka_len(int chifra, String value) {
        value = value.trim();
        if (chifra == 1) {
            if (Integer.parseInt(value) <= 10) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            if (value.length() <= 10) {
                return true;
            }
            else {
                return false;
            }
        }
    }
}
