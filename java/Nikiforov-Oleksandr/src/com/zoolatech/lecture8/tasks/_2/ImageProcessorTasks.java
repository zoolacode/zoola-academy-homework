package com.zoolatech.lecture8.tasks._2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ImageProcessorTasks extends RecursiveAction {
    private static final int MAX_SIZE = 10;
    private int[][] pixels;
    private int maxWidth;
    private int minWidth;
    private int maxHeight;
    private int minHeight;

    public ImageProcessorTasks(int[][] pixels, int maxWidth, int minWidth, int maxHeight, int minHeight) {
        this.pixels = pixels;
        this.maxWidth = maxWidth;
        this.minWidth = minWidth;
        this.maxHeight = maxHeight;
        this.minHeight = minHeight;
    }

    public ImageProcessorTasks(int[][] pixels){
        this(pixels, pixels.length, 0, pixels[0].length, 0);
    }

    private void updatePixels(){
        for(int i = minHeight; i <maxHeight;i++){
            for(int j = minWidth; j <maxWidth;j++){
                pixels[i][j]++;
            }
        }
    }

    @Override
    protected void compute() {
        if(maxHeight-minHeight>MAX_SIZE||maxWidth-minWidth>MAX_SIZE){
            int midWidth = (maxWidth + minWidth)/2;
            int midHeight = (maxHeight-minHeight)/2;
            List<ImageProcessorTasks> imageTasks = List.of(
                    new ImageProcessorTasks(pixels, maxWidth, midWidth, maxHeight, midHeight),
                    new ImageProcessorTasks(pixels, maxWidth, midWidth, midHeight, minHeight),
                    new ImageProcessorTasks(pixels, midWidth, minWidth, maxHeight, midHeight),
                    new ImageProcessorTasks(pixels, midWidth, minWidth, minHeight, midHeight));
            ForkJoinTask.invokeAll(imageTasks);
        }else{
            updatePixels();
            printPixels();
        }
    }

    public void printPixels(){
        Arrays.stream(pixels).map(Arrays::toString).forEach(System.out::println);
        System.out.println("\n");
    }
}
