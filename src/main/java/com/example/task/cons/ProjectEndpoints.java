package com.example.task.cons;

/**
 * Author: @bluemmroom
 * Date: 30.07.2022
 * Time: 18:21:00
 */

public final class ProjectEndpoints {

    private ProjectEndpoints() {
        throw new IllegalStateException("ProjectEndpoints class");
    }

    public static final String API_TYPE = "/api";
    public static final String INTEGER = "/integer-type";
    public static final String STRING = "/string-type";
    public static final String BOTH = "/both-types";
    public static final String DATABASE = "/database";
}
