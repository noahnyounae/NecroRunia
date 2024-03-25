package fr.skypieya.necrorunia.random;

import java.util.Random;

public class RandomUtil {
    private final Random _random;
    public RandomUtil(){
        this._random = new Random();
    }

    public Random GetRandom(){return _random;}

}
