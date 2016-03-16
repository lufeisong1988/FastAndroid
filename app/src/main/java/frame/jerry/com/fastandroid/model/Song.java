package frame.jerry.com.fastandroid.model;

/**
 * Created by lufeisong on 16/3/16.
 */
public class Song extends BaseModel {
    String duration;
    String name;
    String lyric;
    long id;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
