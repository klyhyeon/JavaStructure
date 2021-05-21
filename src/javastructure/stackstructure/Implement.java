package javastructure.stackstructure;

import javastructure.arraystructure.CircularlyLinkedList;
import lombok.ToString;

public class Implement {

    public static boolean isMatched(String expression) {
        final String opening = "[{(";
        final String closing = ")}]";
        CircularlyLinkedList<Character> buffer = new CircularlyLinkedList<>();
        for (Character c : expression.toCharArray()) {
            if (opening.indexOf(c) != -1)
                buffer.addFirst(c);
            else if (closing.indexOf(c) != -1)
                if (buffer.first() != c)
                    return false;
                else if (buffer.isEmpty())
                    return false;
                else
                    buffer.removeFirst();
        }
        return buffer.isEmpty();
    }

    /**
     * 경우의 수 :
     *  1. <tag>
     *      1.1 parenBuffer : 괄호 여닫힘 확인
     *      1.2 tagBuffer : "tag" push
     *  2. </tag>
     *      2.1 parenBuffer : 괄호 여닫힘 확인
     *      2.2 tagBuffer : "태그" pop
     * */
    public boolean isHTMLMatched(String HTML) {
        final char opening = '<';
        final char closing = '>';
        final char ending = '/';
        boolean openingTagFlag = false;
        int openingParen = 0;
        int l = HTML.length();
        CircularlyLinkedList<Character> parenBuffer = new CircularlyLinkedList<>();
        CircularlyLinkedList<String> tagBuffer = new CircularlyLinkedList<>();
        for (int i = 0; i < l; i++) {
            char c = HTML.toCharArray()[i];
            //opening
            if (c == opening && i != l - 1) {
                parenBuffer.addFirst(opening);
                openingParen = i + 1;
                openingTagFlag = (HTML.toCharArray()[i + 1] != ending);
            }
            //closing
            else if (c == closing) {
                if (parenBuffer.isEmpty()) {
                    return false;
                } //valid case
                else {
                    parenBuffer.removeFirst();
                    if (openingTagFlag) {
                        String openingTagName = HTML.substring(openingParen, i);
                        tagBuffer.addFirst(openingTagName);
                        openingTagFlag = false;
                    } else {
                        String closingTagName = HTML.substring(openingParen, i);
                        if (tagBuffer.isEmpty())
                            return false;
                        else if (!tagBuffer.removeFirst().equals(closingTagName)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean isHTMLMatched2(String html) {
        CircularlyLinkedList<String> buffer = new CircularlyLinkedList<>();
        int j = html.indexOf('<');
        while (j != -1) {
            int k = html.indexOf('>', j+1);
            if (k == -1)
                return false;
            String tag = html.substring(j+1, k);
            if (!tag.startsWith("/"))
                buffer.addFirst(tag);
            else {
                if (buffer.isEmpty())
                    return false;
                if (!tag.substring(1).equals(buffer.removeFirst()))
                    return false;
            }
            j = html.indexOf('<', k+1);
        }
        return buffer.isEmpty();
    }
}
