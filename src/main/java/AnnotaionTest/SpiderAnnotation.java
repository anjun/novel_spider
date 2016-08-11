package AnnotaionTest;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;

@TargetUrl("http://www.huxiu.com/")
public class SpiderAnnotation implements AfterExtractor{

	@ExtractBy("//div[@class='mob-ctt']/h3/a/text()")
	private List<String> title=null;
	
	@Override
	public String toString() {
		return "JobInfo {" + "title=" + title.size() +"}";
	}

	public void afterProcess(Page page) {
		// TODO Auto-generated method stub
	}

	public List<String> getTitle() {
		return title;
	}

	public void setTitle(List<String> title) {
		this.title = title;
	}
	
}
