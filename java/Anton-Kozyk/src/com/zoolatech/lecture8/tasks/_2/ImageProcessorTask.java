package com.zoolatech.lecture8.tasks._2;

import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ImageProcessorTask extends RecursiveAction {
    private static final int MAX_SIZE = 10;
    private final int fromWidth;
    private final int toWidth;
    private final int fromHeight;
    private final int toHeight;
    final int[][] image;

    public ImageProcessorTask(int[][] image) {
        this(0, image.length, 0, image[0].length, image);
    }

    public ImageProcessorTask(int fromHeight, int toHeight, int fromWidth, int toWidth, int[][] image) {
        this.fromHeight = fromHeight;
        this.toHeight = toHeight;
        this.fromWidth = fromWidth;
        this.toWidth = toWidth;
        this.image = image;
    }

    @Override
    protected void compute() {
        if (toHeight - fromHeight > MAX_SIZE || toWidth - fromWidth > MAX_SIZE) {
            int midHeight = fromHeight + (toHeight - fromHeight) / 2;
            int midWidth = fromWidth + (toWidth - fromWidth) / 2;
            List<ImageProcessorTask> tasks = List.of(new ImageProcessorTask(fromHeight, midHeight, fromWidth, midWidth, image),
                    new ImageProcessorTask(midHeight, toHeight, fromWidth, midWidth, image),
                    new ImageProcessorTask(midHeight, toHeight, midWidth, toWidth, image),
                    new ImageProcessorTask(fromHeight, midHeight, midWidth, toWidth, image));
            ForkJoinTask.invokeAll(tasks);
        } else {
            processValue(fromHeight, fromWidth, toWidth, toHeight);
        }
    }

    private void processValue(int startHeight, int startWidth, int width, int height) {
        for (int i = startHeight; i < height; i++) {
            for (int j = startWidth; j < width; j++) {
                image[i][j] += 3;
            }
        }
    }
}
