package com.born2do.crawler.pipeline;

import com.born2do.crawler.constant.PathConstant;
import com.born2do.crawler.log.ILogger;
import com.born2do.crawler.log.LoggerImpl;
import com.born2do.crawler.util.ImageDownLoadUtils;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author chenhy
 * @date 2021/9/12
 */
@Component
public class Ku137PipeLine implements Pipeline {

    private static final ILogger logger = new LoggerImpl(Ku137PipeLine.class);

    private static final String dir = PathConstant.DIR;

    /**
     * Process extracted results.
     *
     * @param resultItems resultItems
     * @param task        task
     */
    @Override
    public void process(ResultItems resultItems, Task task) {
        Map<String, Object> resultMap = resultItems.getAll();
        String webName = (String) resultMap.get("WebName");
        String jiGou = (String) resultMap.get("jiGou");
        Map<String, List<String>> albumDetail = (Map<String, List<String>>) resultMap.get("albumDetail");
        for (Map.Entry<String, List<String>> entry : albumDetail.entrySet()) {
            String path = dir + "/" + webName.trim() + "/" + jiGou.trim() + "/" + entry.getKey().trim();
            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            List<String> imgUrls = entry.getValue();
            for (String imgUrl: imgUrls) {
                int result = ImageDownLoadUtils.download(imgUrl, path);
                if (0 == result) {
                    System.out.println(imgUrl + "文件下载完成");
                    logger.info(imgUrl +"文件下载完成", "Ku137");
                } else if (2 == result) {
                    System.out.println(imgUrl + "文件已经存在");
                    logger.info(imgUrl + "文件已经存在", "Ku137");
                } else {
                    System.out.println(imgUrl + "文件下载失败");
                    logger.error(imgUrl + "文件下载失败", "Ku137");
                }
            }
        }
    }
}
