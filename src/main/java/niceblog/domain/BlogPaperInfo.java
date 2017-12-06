package niceblog.domain;

/**
 * Created by GeorgeDon on 2017/12/6.
 */
public class BlogPaperInfo {
    private String id;
    private  String date;
    private String author;
    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BlogPaperInfo{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
