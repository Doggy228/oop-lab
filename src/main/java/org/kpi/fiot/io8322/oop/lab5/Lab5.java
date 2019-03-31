package org.kpi.fiot.io8322.oop.lab5;


public class Lab5 {
    public static void main(String[] argc) {
        StringBuilder sbText = new StringBuilder(
                "Аж ось і весна.\n" +
                        "Випустила   наша яблунька бруньки, а тут повилазила   погана гусінь з гнізд і почала в'їдатися в бруньки та вигризати в них ямки. " +
                        "Аж тут ще лазить жук-довгоносик і з'їдає молоде листячко. " +
                        "Сумує яблунька.\n" +
                        "Гуляли\t\tв садку діти. " +
                        "Підбігли до своєї улюбленої яблуньки.");
        String[] arWords = {"яблунька", "в", "дітлахи", "гуляли", "і"};
        TextAll textAll = new TextAll();
        textAll.initFromStringBuilder(sbText);
        System.out.println("*********************************");
        System.out.println("Преобразованый текст");
        System.out.println("*********************************");
        for (Sentence sentence : textAll.getChildren()) {
            System.out.println(sentence);
        }
        System.out.println("*********************************");
        for (String word : arWords) {
            System.out.printf("Слово [%s] встречается в %d предложениях.\r\n", word, textAll.foundWord(word.toLowerCase()));
        }
    }
}