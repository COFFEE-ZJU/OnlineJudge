package leetcode;

/**
 * Created by Zhangkefei on 2016/1/30.
 */
public class Point {
    public int x, y;
    public Point() { x = 0; y = 0; }
    public Point(int a, int b) { x = a; y = b; }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }
}
