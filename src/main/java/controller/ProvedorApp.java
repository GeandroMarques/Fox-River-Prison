package controller;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class ProvedorApp {
    private static ProvedorApp provedorApp;
    private Javalin app;

    private ProvedorApp(){
        this.app = Javalin.create(config ->{
                    config.staticFiles.add("/public", Location.CLASSPATH);
                })
                .start(7070);
    }

    public static ProvedorApp getInstance(){
        if (provedorApp == null) provedorApp = new ProvedorApp();
        return provedorApp;
    }

    public Javalin getApp(){
        return this.app;
    }
}
