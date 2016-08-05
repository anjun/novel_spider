package spider;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class GithubRepoPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    public void process(Page page) {
        //page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
        //page.putField("author", page.getUrl().regex("http://www.97xiao.com/").toString());
        page.putField("name", page.getHtml().xpath("//a[@id='sort1']/h2/text()").toString());
        if (page.getResultItems().get("name")==null){
            //skip this page
            page.setSkip(true);
        }
       // page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
    	GithubRepoPageProcessor g =new GithubRepoPageProcessor();
    	//g.getSite().setCharset("UTF-8");
        Spider.create(g).addUrl("http://www.97xiao.com/").addPipeline(new JsonFilePipeline("D:\\webmagic\\")).thread(5).run();
    }
}