/*
[done] - Создайте класс StringExtensions, c дополнительными методами для работы со строками:

[done] - String reverse(String str) - переворачивает строку задом наперёд.

[done] - int countSubstrings(String str, String substr) - возвращает кол-во вхождений подстроки substr в строке str

[done] - String fullCensor(String str, String [] forbiddenWords) - в параметре forbiddenWords передаётся массив запрещённых (нецензурных).
Если в строке str находятся такие слова, то нужно каждую букву такого слова заменить символом звёздочки "*".

[done] - String partialCensor(String str, String [] forbiddenWords, int numOfTeasedSybols) - то же самое, что в fullCensor(),
но в этом варианте есть дополнительное поле numOfTeasedSybols указывает кол-во символов, в начале и конце каждого "зацензуренного" слова,
которые необходимо оставить.

[done] - int numOfDuplicates(String [] string, String target)  - возвращает кол-во дубликатов строки из переменной target в массиве строки string
*/


class StringExtensions {

    static String reverse (String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

    static int countSubstrings(String str, String substr) {
        return (str.length() - str.replace(substr, "").length()) / substr.length();
    }

    static String fullCensor(String str, String [] forbiddenWords) {
        for (String word : forbiddenWords) {
            String res = "*".repeat(word.length());
            str = str.replace(word, res);
        }
        return str;
    }

    static String partialCensor(String str, String [] forbiddenWords, int numOfTeasedSybols) {
        for (String word : forbiddenWords) {
            StringBuilder res = new StringBuilder();
            int i = 0;
            while (i < numOfTeasedSybols) {
                res.append(word.charAt(i));
                i++;
            }
            while (i < (word.length() - numOfTeasedSybols)){
                res.append("*");
                i++;
            }
            while (i < word.length()) {
                res.append(word.charAt(i));
                i++;
            }
            str = str.replace(word, res.toString());
        }
        return str;
    }

    static int numOfDuplicates(String [] string, String target) {
        int cntr = 0;
        for (String word : string) {
            if (word.equals(target)) {
                cntr++;
            }
        }
        return cntr;
    }

}


public class Main {
    public static void main(String[] args) {
        String textExample = "В недрах тундры выдры в гетрах\n" +
                "Тырят в вёдра ядра кедров.\n" +
                "Выдрав с выдры в тундре гетры,\n" +
                "Вытру выдрой ядра кедра,\n" +
                "Вытру гетрой выдре морду,\n" +
                "Выдру — в тундру, ядра — в вёдра!";
        System.out.println("----------------- 1. reverse -----------------");
        System.out.println(StringExtensions.reverse(textExample));
        System.out.println();
        System.out.println("----------------- 2. countSubstrings -----------------");
        System.out.println(StringExtensions.countSubstrings(textExample, "др"));
        System.out.println();
        System.out.println("----------------- 3. fullCensor -----------------");
        System.out.println(StringExtensions.fullCensor(textExample, new String[]{"Вытру", "ядра"}));
        System.out.println();
        System.out.println("----------------- 4. partialCensor -----------------");
        System.out.println(StringExtensions.partialCensor(textExample, new String[]{"Вытру", "ядра"}, 0));
        System.out.println("----------------------------------");
        System.out.println(StringExtensions.partialCensor(textExample, new String[]{"Вытру", "ядра"}, 1));
        System.out.println("----------------------------------");
        System.out.println(StringExtensions.partialCensor(textExample, new String[]{"Вытру", "ядра"}, 2));
        System.out.println("----------------------------------");
        System.out.println(StringExtensions.partialCensor(textExample, new String[]{"Вытру", "ядра"}, 3));
        System.out.println();
        System.out.println("----------------- 5. numOfDuplicates -----------------");
        System.out.println(StringExtensions.numOfDuplicates(new String[]{"ядра", "Вытру", "ядра", "ядра"}, "ядра"));

    }
}
