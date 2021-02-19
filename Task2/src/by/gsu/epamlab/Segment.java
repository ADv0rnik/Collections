package by.gsu.epamlab;

public class Segment implements Comparable<Segment>{
    private int len;
    private int num;

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Segment(int len, int num) {
        this.len = len;
        this.num = num;
    }

    public Segment(int len) {
        this.len = len;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int compareTo(Segment segment){
        return Integer.compare(len, segment.len);
    }

    @Override
    public String toString() {
        return String.format("%d;%d",len,num);
    }
}
