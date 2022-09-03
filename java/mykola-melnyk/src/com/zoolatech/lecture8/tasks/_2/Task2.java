package com.zoolatech.lecture8.tasks._2;

import java.util.concurrent.ForkJoinPool;

/**
 * Create a class ImageProcessorTask that accepts an image (represented as an int[][] array, where each item
 * of an array is an individual pixel) and applies some transformation to each pixel (your choice, e.g.,
 * multiplies it by 10). The class needs to recursively split the processing task into smaller subtasks
 * (subimages), and start processing of a subimage only if its width and height are <= 10 pixels. Note:
 * you don’t need to create a new subarray for each subtask, it’s enough to pass coordinates of its
 * bounds. Each subtask should be processed concurrently. Hint: the simplest way would be to split
 * an image on each step to 4 quadrants. Imagine that an initial image is just a big quadrant.
 */

public class Task2 {
    public static void main(String[] args) {
        int imgSize = 20;
        ForkJoinPool pool = ForkJoinPool.commonPool(); // create a pool of threads
        int[][] pixels = new int[imgSize][imgSize]; // create an array
        int inc = 1; // fill with increment numbers
        for (int i = 0; i < imgSize; i++) {
            for (int j = 0; j < imgSize; j++)
                pixels[i][j] = inc++;
        }


        ImageProcessorTask myImg = new ImageProcessorTask(pixels);
        pool.invoke(myImg); // start the task

        for (int i = 0; i < imgSize; i++) {  // print the array
            for (int j = 0; j < imgSize; j++) {
                System.out.printf("%4d ", pixels[i][j]);
            }

            System.out.println();
        }
    }

}
