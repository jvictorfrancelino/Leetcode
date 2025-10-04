package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher("Java_2025");

        // matches()
        boolean ok = m.matches();

        // find()
        Matcher m2 = Pattern.compile("\\d+").matcher("O ano é 2025 e o mês é 090");
        while(m2.find()){
            System.out.println(m2.group()); // imprime "2025" e depois "09"
        }

        // group()
        Pattern p2 = Pattern.compile("(\\w+)@(\\w+\\.\\w+)");
        Matcher m3 = p2.matcher("email: teste@gmail.com");
        if (m3.find()){
            System.out.println(m3.group(0)); // "teste@gmail.com"
            System.out.println(m3.group(1)); // "teste"
            System.out.println(m3.group(2)); // "gmail.com"
        }

        // replaceAll() e replaceFirst()
        String resultado = m.replaceAll("X");
        String s = "abc123def456";
        String r = s.replaceAll("\\+", "#");
        // resultado: "abc#def#"

        //lookinAt()
        Matcher m4 = Pattern.compile("\\d+").matcher("123abc");
        System.out.println(m4.lookingAt());

        // Direto em String
        "Java 2025".matches("Java \\d+");
        "abc123def".replaceAll("\\d+", "#");

        // Com Pattern e Matcher
        Pattern p3 = Pattern.compile("\\d+");
        Matcher m5 = p3.matcher("A1 B22 C333");
        while (m.find()) {
            System.out.println(m.group()); // 1, 22, 333
        }

        // Com flags
        Pattern p4 = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
        System.out.println(p4.matcher("JaVa").matches());

    }
}
