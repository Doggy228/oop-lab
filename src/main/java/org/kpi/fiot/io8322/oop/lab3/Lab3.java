package org.kpi.fiot.io8322.oop.lab3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;


public class Lab3 {
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());

    public static int foundWord(final List<String[]> wordsInSentence, final String word) {
        int count = 0;
        for(String[] words: wordsInSentence){
            for(String wordSentence: words){
                if(word.equals(wordSentence)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] argc) {
        StringBuilder sbText = new StringBuilder(
                "Аж ось і весна.\n"+
                "Випустила наша яблунька бруньки, а тут повилазила погана гусінь з гнізд і почала в'їдатися в бруньки та вигризати в них ямки. "+
                "Аж тут ще лазить жук-довгоносик і з'їдає молоде листячко. "+
                "Сумує яблунька.\n" +
                "Гуляли в садку діти. "+
                "Підбігли до своєї улюбленої яблуньки.");
        String[] arWords = {"яблунька", "в", "дітлахи","гуляли","і"};
        String[] arSentences = sbText.toString().split("[.?!]");
        List<String[]> wordsInSentence = new ArrayList<>();
        for(String sentence: arSentences){
            if(!sentence.trim().isEmpty()){
                wordsInSentence.add(sentence.trim().toLowerCase().split("[^a-z0-9а-яєії_']"));
            }
        }
        for (String word: arWords) {
            System.out.printf("Слово [%s] встречается в %d предложениях.\r\n", word, Lab3.foundWord(wordsInSentence, word.toLowerCase()));
        }
    }
}

