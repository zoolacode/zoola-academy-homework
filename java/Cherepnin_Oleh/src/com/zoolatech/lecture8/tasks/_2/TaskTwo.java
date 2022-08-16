package com.zoolatech.lecture8.tasks._2;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Create a class ImageProcessorTask that accepts an image (represented as an int[][] array, where each item
 * of an array is an individual pixel) and applies some transformation to each pixel (your choice, e.g., multiplies
 * it by 10). The class needs to recursively split the processing task into smaller subtasks (subimages), and start
 * processing of a subimage only if its width and height are <= 10 pixels. Note: you don’t need to create a new
 * subarray for each subtask, it’s enough to pass coordinates of its bounds. Each subtask should be processed
 * concurrently. Hint: the simplest way would be to split an image on each step to 4 quadrants. Imagine that an
 */

public class TaskTwo {
    public static void main(String[] args) {
        int[][] image = new int[70][50];
        int counter = 11;
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                image[i][j] = j + 1;
            }
        }

        RecursiveAction task = new ImageProcessorTask(image);
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        forkJoinPool.invoke(task);

        for (int[] ints : image) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}

