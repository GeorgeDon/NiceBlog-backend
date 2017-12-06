package niceblog.domain;

/**
 * Created by GeorgeDon on 2017/11/23.
 */
public class BlogPaper {
    private String id;
    private  String date;
    private String author;
    private String paper;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    @Override
    public String toString() {
        return "BlogPaper{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", author='" + author + '\'' +
                ", paper='" + paper + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
