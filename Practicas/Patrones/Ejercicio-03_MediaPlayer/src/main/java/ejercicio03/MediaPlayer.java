package ejercicio03;

import java.util.ArrayList;
import java.util.List;

public class MediaPlayer {
    private List<Media> media = new ArrayList<>();

    public void play(){
        media.forEach(m -> m.play());
    }
}
