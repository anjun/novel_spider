package AnnotaionTest;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;

public class JobRun {
	public static void main(String[] args) {
		OOSpider.create(
				Site.me().setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36"),
				new JobInfoPipeline(), SpiderAnnotation.class)
				.addUrl("http://www.huxiu.com/").thread(5).run();
	}
}
