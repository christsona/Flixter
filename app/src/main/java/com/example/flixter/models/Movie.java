package com.example.flixter.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {

    String overview;
    String posterPath;
    String title;
    String backDropPath;
    double rating;
    int key;

    public Movie(){}


    public Movie(JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        overview = jsonObject.getString("overview");
        title = jsonObject.getString("title");
        backDropPath = jsonObject.getString("backdrop_path");
        rating = jsonObject.getDouble("vote_average");
        key = jsonObject.getInt("id");


    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws Exception{
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i<movieJsonArray.length();i++){
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getBackDropPath(){
        return String.format("https://image.tmdb.org/t/p/w342/%s",backDropPath);
    }

    public int getKey(){
        return key;
    }

    public double getRating(){
        return rating;
    }

    public String getTitle() {
        return title;
    }
}
