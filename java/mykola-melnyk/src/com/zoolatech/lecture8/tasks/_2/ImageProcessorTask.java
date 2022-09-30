package com.zoolatech.lecture8.tasks._2;

import java.util.concurrent.RecursiveAction;
import java.util.function.Function;

public class ImageProcessorTask extends RecursiveAction {
    private static final int MAX_SIZE = 10;
    private final int fromY;
    private final int toY;
    private final int fromX;
    private final int toX;

    private final int[][] pixels;
    private final Function<Integer, Integer> f;


    public ImageProcessorTask(int fromX, int toX, int fromY, int toY, int[][] pixels, Function<Integer, Integer> f) {
        this.fromX = fromX;
        this.toX = toX;
        this.fromY = fromY;
        this.toY = toY;
        this.pixels = pixels;
        this.f = f;
    }

    public ImageProcessorTask(int[][] pixels, Function<Integer, Integer> f) {
        this(0, pixels.length, 0, pixels.length, pixels, f);
    }

    @Override
    protected void compute() {
        if ((toX - fromX <= MAX_SIZE) || (toY - fromY <= MAX_SIZE)) {
            for (int x = fromX; x < toX; x++) {
                for (int y = fromY; y < toY; y++)
                    pixels[x][y]  = f.apply(pixels[x][y]);
            }
        } else {
            int midX = fromX + (toX - fromX) / 2;
            int midY = fromY + (toY - fromY) / 2;
            invokeAll(new ImageProcessorTask(fromX, midX, fromY, midY, pixels, f),
                    new ImageProcessorTask(fromX, midX, midY, toY, pixels, f),
                    new ImageProcessorTask(midX, toX, fromY, midY, pixels, f),
                    new ImageProcessorTask(midX, toX, midY, toY, pixels, f));
        }
    }
}
