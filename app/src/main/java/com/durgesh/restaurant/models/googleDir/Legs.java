package com.durgesh.restaurant.models.googleDir;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Prajakta Patil on 30/8/17.

 */
@Getter
@Setter
public class Legs {

    private DirDuration duration;

    private DirDistance distance;

    private End_location end_location;

    private String start_address;

    private String end_address;

    private Start_location start_location;

    private ArrayList<String> traffic_speed_entry;

    private ArrayList<String> via_waypoint;

    private ArrayList<Steps> steps;
}
