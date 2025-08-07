package at.mklestil.gardenpomodorotimer.model;

import java.util.ArrayList;

public class Tags {
    public final ArrayList<String> tags;

    public Tags(){
        tags = new ArrayList<>();
        tags.add("lernen");

    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void addTags(String tag){
        if(tag != null && !tag.isEmpty() && !tags.contains(tag)) {
            tags.add(tag);
        } else {
            System.out.println("Tag is null, empty or already exists: " + tag);
        }
    }

    public void removeTag(String tag){
        if(tag != null && !tag.isEmpty() && tags.contains(tag)) {
            tags.remove(tag);
        } else {
            System.out.println("Tag is null, empty or does not exist: " + tag);
        }
    }


}
