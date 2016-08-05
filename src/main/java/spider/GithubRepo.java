package spider;

import java.util.List;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;

@TargetUrl("http://www.97xiao.com/")
@ExtractBy(value="//div[@class='recomclass']")
public class GithubRepo {

	@ExtractBy(value = "//dl//dd[1]/a/text()", notNull = true)
	private List<String> name;

	public static void main(String[] args) {
		
		//System.out.println(name.size());
		
		OOSpider.create(Site.me().setSleepTime(1000),
				new ConsolePageModelPipeline(), GithubRepo.class)
				.addUrl("http://www.97xiao.com/").thread(5).run();
	}
}
