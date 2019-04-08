package com.thought.extend;

/**
 * @ClassName BirdController
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class BirdController {
    public void run(Bird bird){
        bird.move();
    }

    public static void main(String[] args) {
        BirdController birdController = new BirdController();
        Bird bird = new Bird();
        birdController.run(bird);
    }
}
