package org.kpi.fiot.io8322.oop.lab5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sentence {
    private List<SentencePart> children;
    private Set<String> uniqueWords;

    public int initFromStringBuilder(StringBuilder sb, int indexChar) {
        children = new ArrayList<>();
        uniqueWords = new HashSet<>();
        int indexCurrent = indexChar;
        while (indexCurrent < sb.length()) {
            if (sb.charAt(indexCurrent) == '.' || sb.charAt(indexCurrent) == '!' || sb.charAt(indexCurrent) == '?') {
                SentencePartEnd sentencePartEnd = new SentencePartEnd();
                children.add(sentencePartEnd);
                indexCurrent = sentencePartEnd.initFromStringBuilder(sb, indexCurrent);
                break;
            }
            char c = ("" + sb.charAt(indexCurrent)).toLowerCase().charAt(0);
            if ((c >= 'a' && c <= 'z') || (c >= 'а' && c <= 'я') || (c >= '0' && c <= '9') || c == 'є' || c == 'і' || c == 'ї' || c == '_' || c == '\'') {
                SentencePartWord sentencePartWord = new SentencePartWord();
                children.add(sentencePartWord);
                indexCurrent = sentencePartWord.initFromStringBuilder(sb, indexCurrent);
                uniqueWords.add(children.get(children.size() - 1).toString().toLowerCase());
            } else {
                SentencePartDevider sentencePartDevider = new SentencePartDevider();
                children.add(sentencePartDevider);
                indexCurrent = sentencePartDevider.initFromStringBuilder(sb, indexCurrent);
            }
        }
        return indexCurrent;
    }

    public boolean isPresentWord(String word) {
        return uniqueWords.contains(word);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (SentencePart sentencePart : children) {
            stringBuilder.append(sentencePart.toString());
        }
        return stringBuilder.toString();
    }


}
