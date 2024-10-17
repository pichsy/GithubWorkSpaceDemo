package com.example.apkdownloader;

public interface Interceptor {
    void intercept(Chain chain);

    interface Chain {
        void proceed();
    }
}
