package niceblog.utlis;

import niceblog.domain.AddBlogPaperBody;
import niceblog.domain.BlogPaper;

import java.util.Date;
import java.util.UUID;

/**
 * Created by GeorgeDon on 2017/4/10.
 */
public class BeanBuilder {

    public static String generateGUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "");
    }


    public static BlogPaper generateBlogPaper(AddBlogPaperBody addBlogPaperBody){
        BlogPaper paper=new BlogPaper();
        paper.setId(generateGUID());
        paper.setAuthor(addBlogPaperBody.getAuthor());
        paper.setDate(DateUtlis.getStringDateShort());
        paper.setPaper(addBlogPaperBody.getPaper());
        paper.setTitle(addBlogPaperBody.getTitle());
        return paper;
    }

}
