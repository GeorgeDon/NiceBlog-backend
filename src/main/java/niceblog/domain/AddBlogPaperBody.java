package niceblog.domain;

/**
 * Created by GeorgeDon on 2017/11/23.
 */
public class AddBlogPaperBody {

    private  String title;
    private String paper;
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "AddBlogPaperBody{" +
                "title='" + title + '\'' +
                ", paper='" + paper + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
