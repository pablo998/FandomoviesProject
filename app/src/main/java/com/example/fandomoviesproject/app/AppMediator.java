package com.example.fandomoviesproject.app;

import com.example.fandomoviesproject.menu.MenuState;

public class AppMediator {

    private MenuState menuState;

    private static AppMediator INSTANCE;


    private AppMediator() {

        menuState = new MenuState();
    }

    public static void resetInstance() {
        INSTANCE = null;
    }


    public static AppMediator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AppMediator();
        }

        return INSTANCE;
    }

    public MenuState getMenuState() {
        return menuState;
    }


}
