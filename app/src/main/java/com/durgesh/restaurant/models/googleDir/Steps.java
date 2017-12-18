package com.durgesh.restaurant.models.googleDir;


import lombok.Getter;
import lombok.Setter;

/**
 * Created by Prajakta Patil on 30/8/17.

 */
@Getter
@Setter
public class Steps {

    private String html_instructions;

    private DirDuration duration;

    private DirDistance distance;

    private End_location end_location;

    private DirPolyline polyline;

    private Start_location start_location;

    private String travel_mode;
}
