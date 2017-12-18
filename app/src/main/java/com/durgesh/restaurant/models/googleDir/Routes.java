package com.durgesh.restaurant.models.googleDir;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Prajakta Patil on 30/8/17.

 */
@Getter
@Setter
public class Routes {
    private String summary;

    private Bounds bounds;

    private String copyrights;

    private ArrayList<String> waypoint_order;

    private ArrayList<Legs> legs;

    private ArrayList<String> warnings;

    private Overview_polyline overview_polyline;

}
