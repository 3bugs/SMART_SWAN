package th.ac.dusit.dbizcom.smartswan.model;

public class DetailsContent {

    public final String title;
    public final String content;
    public final int[] galleryImages;

    public DetailsContent(String title, String content, int[] galleryImages) {
        this.title = title;
        this.content = content;
        this.galleryImages = galleryImages;
    }
}
