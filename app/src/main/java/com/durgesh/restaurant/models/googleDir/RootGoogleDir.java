package com.durgesh.restaurant.models.googleDir;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Prajakta Patil on 30/8/17.

 */
@Getter
@Setter
public class RootGoogleDir {
    private String status;
    private ArrayList<Routes> routes;
}
