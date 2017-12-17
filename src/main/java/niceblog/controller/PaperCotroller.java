package niceblog.controller;


import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import niceblog.Constant.NiceBlogConstant;
import niceblog.Dao.PaperDao;
import niceblog.domain.AddBlogPaperBody;
import niceblog.domain.BlogPaper;
import niceblog.domain.BlogPaperInfo;
import niceblog.domain.WResponse;
import niceblog.utlis.BeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by GeorgeDon on 2017/4/10.
 */

@RestController
@RequestMapping("/v1")
@CrossOrigin
public class PaperCotroller {

    @Autowired
    private PaperDao paperDao;

    @ApiOperation(value = "创建一篇博客", notes = "根据addBlogPaperBody对象创建paper")
    @ApiImplicitParam(name = "addBlogPaperBody", value = "", required = true, dataType = "AddBlogPaperBody")
    @RequestMapping(value = "/papers", method = RequestMethod.POST)
    WResponse addBlogPaper(@RequestBody AddBlogPaperBody addBlogPaperBody, HttpServletRequest request) {
        WResponse response = new WResponse();
        response.setMessage("ok");
        BlogPaper paper=BeanBuilder.generateBlogPaper(addBlogPaperBody);
        paperDao.addPaper(paper);
        response.setStatus(NiceBlogConstant.STATUS_CODE_OK);
        Map<String,Object> data=new HashMap<String,Object>();
        data.put("id",paper.getId());
        response.setData(data);
        return response;
    }

    @ApiOperation(value = "查询文章", notes = "根据id查询paper")
    @ApiImplicitParam(name = "id", value = "paper id", required = true, paramType = "path",dataType="String")
    @RequestMapping(value = "/papers/{id}", method = RequestMethod.GET)
    WResponse getBlogPaper(@PathVariable String id) {
        WResponse response = new WResponse();
        response.setMessage("ok");
        BlogPaper paper=paperDao.queryPaperByid(id);
        response.setStatus(NiceBlogConstant.STATUS_CODE_OK);
        Map<String,Object> data=new HashMap<String,Object>();
        data.put("paper",paper);
        response.setData(data);
        return response;
    }
    @ApiOperation(value = "查询一串内容", notes = "")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "size", value = "size", required = true, paramType = "query",dataType="int"),
            @ApiImplicitParam(name = "page", value = "size", required = true, paramType = "query",dataType="int")})
    @RequestMapping(value = "/papers", method = RequestMethod.GET)
    WResponse queryBlogPapers(@RequestParam int size,@RequestParam int page, HttpServletRequest request) {
        WResponse response = new WResponse();
        response.setMessage("ok");
        int fromIndex=(page-1)*size;
        List<BlogPaper> papers=paperDao.queryPapers(fromIndex,size);
        response.setStatus(NiceBlogConstant.STATUS_CODE_OK);
        Map<String,Object> data=new HashMap<String,Object>();
        data.put("papers",papers);
        response.setData(data);
        return response;
    }

    @ApiOperation(value = "查询一串内容简介", notes = "")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "size", value = "size", required = true, paramType = "query",dataType="int"),
                    @ApiImplicitParam(name = "page", value = "size", required = true, paramType = "query",dataType="int")})
    @RequestMapping(value = "/paperInfos", method = RequestMethod.GET)
    WResponse queryPaperInfos(@RequestParam int size,@RequestParam int page, HttpServletRequest request) {
        WResponse response = new WResponse();
        response.setMessage("ok");
        int fromIndex=(page-1)*size;
        List<BlogPaperInfo> papers=paperDao.queryPaperInfos(fromIndex,size);
        int num=paperDao.queryPaperCount();
        response.setStatus(NiceBlogConstant.STATUS_CODE_OK);
        Map<String,Object> data=new HashMap<String,Object>();
        data.put("papers",papers);
        data.put("count",num);
        response.setData(data);
        return response;
    }

}
