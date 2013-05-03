package com.siolabs.tambola;

import com.googlecode.objectify.ObjectifyFactory;
import entities.User;
import entities.Score;
import entities.House;
import entities.Round;
import com.googlecode.objectify.*;


public class OfyService {
    static {
        factory().register(User.class);
        factory().register(Score.class);
        factory().register(House.class);
        factory().register(Round.class);
    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}