package org.kpi.fiot.io8322.oop.lab5;

import java.util.ArrayList;
import java.util.List;

public class TextAll {
    private List<Sentence> children;

    public void initFromStringBuilder(StringBuilder sb) {
        children = new ArrayList<>();
        int indexChar = 0;
        while (indexChar < sb.length()) {
            Sentence sentence = new Sentence();
            children.add(sentence);
            indexChar = sentence.initFromStringBuilder(sb, indexChar);
        }
    }

    public int foundWord(String word) {
        int count = 0;
        for (Sentence sentence : children) {
            if (sentence.isPresentWord(word)) {
                count++;
            }
        }
        return count;
    }

    public List<Sentence> getChildren() {
        return children;
    }
}
