package com.zoolatech.lecture8.tasks._2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

/**
 * Create a class ImageProcessorTask that accepts an image (represented as an
 * int[][] array, where each item of an array is an individual pixel) and
 * applies some transformation to each pixel (your choice, e.g., multiplies
 * it by 10). The class needs to recursively split the processing task into
 * smaller subtasks (subimages), and start processing of a subimage only if
 * its width and height are <= 10 pixels. Note: you don’t need to create a new
 * subarray for each subtask, it’s enough to pass coordinates of its bounds.
 * Each subtask should be processed concurrently. Hint: the simplest way would
 * be to split an image on each step to 4 quadrants. Imagine that an initial
 * image is just a big quadrant.
 */

public class Task2 {

    public static void main(String[] args) {
        int[][] image = new int[35][45];
        for (int[] row : image) {
            Arrays.fill(row, 10);
        }

        ImageProcessorTask imageProcessorTask = new ImageProcessorTask(image);
        ForkJoinPool pool = new ForkJoinPool(4);
        pool.invoke(imageProcessorTask);

        for (int[] row : image){
            for (int num : row){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }

    private static class ImageProcessorTask extends RecursiveAction {
        private static final int MAX_SIZE = 10;

        private final int[][] image;
        private final int fromH;
        private final int toH;
        private final int fromW;
        private final int toW;

        public ImageProcessorTask(int[][] image) {
            this(image, 0, image.length, 0, image[0].length);
        }

        public ImageProcessorTask(int[][] image, int fromH, int toH, int fromW, int toW) {
            this.image = image;
            this.fromH = fromH;
            this.toH = toH;
            this.fromW = fromW;
            this.toW = toW;
        }

        @Override
        protected void compute() {
            if (toH - fromH > MAX_SIZE & toW - fromW > MAX_SIZE) {
                int heightMid = fromH + (toH - fromH) / 2;
                int widthMid = fromW + (toW - fromW) / 2;

                List<ImageProcessorTask> tasks = List.of(
                        new ImageProcessorTask(image, fromH, heightMid, fromW, widthMid),
                        new ImageProcessorTask(image, fromH, heightMid, widthMid, toW),
                        new ImageProcessorTask(image, heightMid, toH, fromW, widthMid),
                        new ImageProcessorTask(image, heightMid, toH, widthMid, toW)
                );

                ForkJoinTask.invokeAll(tasks);
            } else {
                for (int i = fromH; i < toH; i++) {
                    for (int y = fromW; y < toW; y++) {
                        image[i][y] *= 10;
                    }
                }
            }
        }
    }
}
