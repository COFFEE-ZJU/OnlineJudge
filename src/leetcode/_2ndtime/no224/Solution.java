package leetcode._2ndtime.no224;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * Whiteboard coding!
 */
public class Solution {
    private interface Token {
        Num apply(Num n1, Num n2);
    }
    private static class Num implements Token {
        final int num;

        private Num(int num) {
            this.num = num;
        }

        @Override
        public Num apply(Num n1, Num n2) {
            throw new UnsupportedOperationException();
        }
    }
    private static class Op implements Token {
        final char c;

        private Op(char c) {
            this.c = c;
        }

        @Override
        public Num apply(Num n1, Num n2) {
            int num1 = n1.num, num2 = n2.num;
            if (c == '+') return new Num(num1+num2);
            else if (c == '-') return new Num(num1-num2);
            else throw new UnsupportedOperationException();
        }
    }

    private static class Tokenizer {
        final String str;
        int idx = 0, len;

        private Tokenizer(String str) {
            this.str = str.replace(" ", "");
            len = str == null ? 0 : this.str.length();
        }

        boolean hasNext() {
            return idx < len;
        }

        Token next() {
            char c = str.charAt(idx++);
            if (c < '0' || c > '9') return new Op(c);

            int num = c - '0';
            while (idx < len) {
                c = str.charAt(idx);
                if (c < '0' || c > '9') return new Num(num);

                num = num * 10 + (c - '0');
                idx++;
            }
            return new Num(num);
        }
    }

    public int calculate(String s) {
        Num curN = new Num(0);
        Op curOp = new Op('+');
        int idx = 0;
        Deque<Token> stack = new ArrayDeque<>();
        Tokenizer tokenizer = new Tokenizer(s);
        while (tokenizer.hasNext()) {
            Token token = tokenizer.next();
            if (token instanceof Num) {
                curN = curOp.apply(curN, (Num) token);
                continue;
            }

            Op op = (Op) token;
            switch (op.c) {
                case '+':
                case '-':
                    curOp = op;
                    break;
                case '(':
                    stack.push(curN);
                    stack.push(curOp);
                    curN = new Num(0);
                    curOp = new Op('+');
                    break;
                case ')':
                    Op oper = (Op) stack.pop();
                    Num number = (Num) stack.pop();
                    curN = oper.apply(number, curN);
                    break;
            }
        }
        return curN.num;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calculate(" 1 + 2"));
        System.out.println(new Solution().calculate(" 2-1 + 2 "));
        System.out.println(new Solution().calculate("(1+(4+5+2)-3)+(6 +8) "));
    }
}