package com.zoolatech.lecture8.tasks._2;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class ImageProcessorTask extends RecursiveAction {
    private final static int MAX = 10;
    private final int[][] pixels;
    private int maxWidth;
    private int startWidth;
    private int maxHeight;
    private int startHeight;

    public ImageProcessorTask(int[][] pixels) {
        this(pixels, pixels.length, 0, pixels[0].length, 0);
    }

    public ImageProcessorTask(int[][] pixels, int maxWidth, int startWidth, int maxHeight, int startHeight) {
        this.pixels = pixels;
        this.maxWidth = maxWidth;
        this.startWidth = startWidth;
        this.maxHeight = maxHeight;
        this.startHeight = startHeight;
    }

    @Override
    protected void compute() {
        if (startHeight - maxHeight > MAX || startWidth - maxHeight > MAX) {
            int midHeight = (maxHeight - startHeight) / 2;
            int midWidth = (maxWidth - startWidth) / 2;
            List<ImageProcessorTask> tasks = List.of(
                    new ImageProcessorTask(pixels, maxWidth, midWidth, maxHeight, midHeight),
                    new ImageProcessorTask(pixels, midWidth, startWidth, midHeight, startHeight),
                    new ImageProcessorTask(pixels, maxWidth, midWidth, midHeight, startHeight),
                    new ImageProcessorTask(pixels, midWidth, startWidth, maxHeight, midHeight));
            invokeAll(tasks);
        } else {
            updatePixel(startWidth, startHeight, maxWidth, maxHeight);
        }
    }

    private void updatePixel(int startWidth, int startHeight, int maxWidth, int maxHeight) {
        for (int i = startWidth; i < maxWidth; i++) {
            for (int j = startHeight; j < maxHeight; j++) {
                pixels[i][j] = pixels[i][j] * 2;
            }
        }
    }
}
