package eslam.example.com.college.models;

public class Posts {

    private String imageUserUrl;
    private String imagePostUrl;
    private String textPost;
    private String textUserCollege;
    private int postId;
    private int userId;
    private double postTime;

    public Posts( String textPost) {
        this.textPost = textPost;
    }
    public String getImageUserUrl() {
        return imageUserUrl;
    }

    public String getImagePostUrl() {
        return imagePostUrl;
    }

    public String getTextPost() {
        return textPost;
    }

    public String getTextUserCollege() {
        return textUserCollege;
    }

    public int getPostId() {
        return postId;
    }

    public int getUserId() {
        return userId;
    }

    public double getPostTime() {
        return postTime;
    }
}
