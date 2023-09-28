package org.example.animals;

public class Counter {
    protected int count;

    public Counter(int count) {
        this.count = count;
    }

    public int countInfo(){
        return this.count;
    }

    public void add(int count) {
        count++;
    }

}
