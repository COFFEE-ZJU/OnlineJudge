package cn.edu.zju.coffee.nowcoder.sohu.y2016.n01;

import java.util.*;

/**
 * Created by zkf on 3/17/16.
 */
public class Main {
    private static class Person {
        int weight, hight, maxCount = 1;
        List<Person> biggers, smallers;
        Person prev = null;

        public Person(int weight, int hight) {
            this.weight = weight;
            this.hight = hight;
            biggers = new LinkedList<>();
            smallers = new LinkedList<>();
        }

        public boolean isBiggerThan(Person other) {
            return weight >= other.weight && hight >= other.hight;
        }

        public boolean isSmallerThan(Person other) {
            return weight <= other.weight && hight <= other.hight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> persons = new LinkedList<>();
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            Person[] all = new Person[n];
            for (int i = 0; i < n; i++) {
                scanner.nextInt();
                all[i] = new Person(scanner.nextInt(), scanner.nextInt());
            }
            if (n == 1) {
                System.out.println(1);
                continue;
            }

            for (int i = 0; i < n-1; i++) {
                Person p = all[i];
                for (int j = i+1; j < n; j++) {
                    Person o = all[j];
                    if (p.isBiggerThan(o)) {
                        p.smallers.add(o);
                        o.biggers.add(p);
                    }
                    else if (p.isSmallerThan(o)) {
                        p.biggers.add(o);
                        o.smallers.add(p);
                    }
                }
            }

            persons.clear();
            for (Person p : all) {
                if (p.biggers.isEmpty())
                    persons.add(p);
            }

            int max = 1;
            Person maxStart = null;
            while (!persons.isEmpty()) {
                Person p = persons.remove(0);
                for (Person sm : p.smallers) {
                    if (p.maxCount >= sm.maxCount) {
                        sm.maxCount = p.maxCount+1;
                        sm.prev = p;
                        if (sm.maxCount > max) {
                            max = sm.maxCount;
                            maxStart = sm;
                        }
                        persons.add(sm);
                    }
                }
            }
            System.out.println(max);
            while (maxStart != null) {
                System.out.println(String.format("w: %d, h: %d", maxStart.weight, maxStart.hight));
                maxStart = maxStart.prev;
            }
        }
        scanner.close();
    }
}
