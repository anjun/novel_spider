package AnnotaionTest;

import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

public class JobInfoPipeline implements PageModelPipeline<SpiderAnnotation> {


    public void process(SpiderAnnotation l, Task task) {
    	System.out.println(l.getTitle());
    }
}