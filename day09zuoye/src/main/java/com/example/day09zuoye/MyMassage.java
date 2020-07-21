package com.example.day09zuoye;

public class MyMassage {
    private int flag;
    private int max;
    private int progress;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public MyMassage(int flag, int max, int progress) {
        this.flag = flag;
        this.max = max;
        this.progress = progress;
    }
}
