package com.zoolatech.lecture8.tasks._2;

import java.util.concurrent.RecursiveAction;

public class ImageProcessorTask extends RecursiveAction {
    private static final int MAX_SIZE = 10;
    private final int from;
    private final int to;

    private final int[][] pixels;


    public ImageProcessorTask(int from, int to, int[][] pixels) {
        this.from = from;
        this.to = to;
        this.pixels = pixels;
    }

    public ImageProcessorTask(int[][] pixels) {
        this(0, pixels.length, pixels);
    }

    @Override
    protected void compute() {
        if (to - from <= MAX_SIZE) {
            for (int i = from; i < to; ++i) {
                for (int j = from; j < to; j++)
                    pixels[i][j] *= 2;
            }
        } else {
            int mid = from + (to - from) / 2;
            invokeAll(new ImageProcessorTask(from, mid, pixels), new ImageProcessorTask(mid, to, pixels));
        }
    }
}
