package com.zoolatech.lecture8.tasks._2;

/*
Create a class ImageProcessorTask that accepts an image
(represented as an int[][] array, where each item of an array is an individual pixel)
and applies some splintedQuadrant to each pixel (your choice, e.g., multiplies it by 10).
The class needs to recursively split the processing task into smaller subtasks (subimages),
and start processing of a subimage only if its width and height are <= 10 pixels.
Note: you don’t need to create a new subarray for each subtask, it’s enough to pass coordinates of its bounds.
Each subtask should be processed concurrently.
Hint: the simplest way would be to split an image on each step to 4 quadrants.
Imagine that an initial image is just a big quadrant.
 */

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class Number2 {
    public static void main(String[] args) {
        int[][] image = new int[12][12];
        ImageProcessorTask imageProcessorTask = new ImageProcessorTask(image);
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        forkJoinPool.invoke(imageProcessorTask);

        for (int[] ints : image) {
            for (int j : ints) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}

class ImageProcessorTask extends RecursiveAction {
    private final int fromHeight;
    private final int toHeight;
    private final int fromWidth;
    private final int toWidth;
    private final int[][] image;

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
        int MAX_SIZE = 10;
        if (toWidth - fromWidth >= MAX_SIZE || toHeight - fromHeight >= MAX_SIZE) {
            int toMidWidth = fromHeight + (toHeight - fromHeight) / 2;
            int toMidHeight = fromWidth + (toWidth - fromWidth) / 2;
            List<ImageProcessorTask> imageProcessorTaskList = List.of(
                    new ImageProcessorTask(fromHeight, toMidHeight, fromWidth, toMidWidth, image),
                    new ImageProcessorTask(toMidHeight, toHeight, fromWidth, toMidWidth, image),
                    new ImageProcessorTask(toMidHeight, toHeight, toMidWidth, toWidth, image),
                    new ImageProcessorTask(fromHeight, toMidHeight, toMidWidth, toWidth, image));
            ForkJoinTask.invokeAll(imageProcessorTaskList);
        } else {
            for (int i = 0; i < image.length; i++) {
                for (int j = 0; j < image[i].length; j++) {
                    image[i][j]++;
                }
            }
        }
    }
}