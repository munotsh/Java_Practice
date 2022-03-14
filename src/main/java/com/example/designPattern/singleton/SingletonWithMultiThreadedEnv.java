package com.example.designPattern.singleton;

public class SingletonWithMultiThreadedEnv {

    private SingletonWithMultiThreadedEnv(){
    }

    private static class SingletonWrapper{
        private static final SingletonWithMultiThreadedEnv INC = new SingletonWithMultiThreadedEnv();
    }
    public static SingletonWithMultiThreadedEnv getInstance()
    {
        return SingletonWrapper.INC;
    }

}
