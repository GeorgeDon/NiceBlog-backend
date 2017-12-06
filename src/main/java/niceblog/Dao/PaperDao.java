package niceblog.Dao;

import niceblog.domain.BlogPaper;
import niceblog.domain.BlogPaperInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by GeorgeDon on 2017/11/23.
 */
public interface PaperDao {
    BlogPaper queryPaperByid(@Param("id") String id);
    boolean addPaper(BlogPaper blogPaper);
    List<BlogPaper> queryPapers(@Param("fromIndex") int fromIndex, @Param("pageSize") int pageSize);
    List<BlogPaperInfo> queryPaperInfos(@Param("fromIndex") int fromIndex, @Param("pageSize") int pageSize);
    int queryPaperCount();
}
