package com.born2do.crawler.pipeline;

import com.born2do.crawler.constant.PathConstant;
import com.born2do.crawler.log.ILogger;
import com.born2do.crawler.log.LoggerImpl;
import com.born2do.crawler.util.ImageDownLoadUtils;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author chenhy
 * @date 2021/9/6
 */
public class YeituPipeLine implements Pipeline {

    private static final ILogger logger = new LoggerImpl(YeituPipeLine.class);

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
        if (null == resultMap || 0 == resultMap.size()) {
            return;
        }
        // 请求头参数
        Map<String, String> requestProperty = (Map<String, String>) resultMap.get("requestProperty");
        // 网站名称
        String webName = (String) resultMap.get("webName");
        // 相册标签
        String tag = (String) resultMap.get("tag");
        Map<String, Object> albumDetail = (Map<String, Object>) resultMap.get("albumDetail");
        for (Map.Entry<String, Object> entry : albumDetail.entrySet()) {
            String albumName = entry.getKey();
            String path = dir + "/" + webName + "/" + tag + "/" + albumName;
            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            List<String> imgUrls = (List<String>) entry.getValue();
            for (String imgUrl: imgUrls) {
                int result = ImageDownLoadUtils.downloadWithRequestProperty(imgUrl, path, requestProperty);
                if (0 == result) {
                    System.out.println(imgUrl + "文件下载完成");
                    logger.info(imgUrl +"文件下载完成", "yeitu");
                } else if (2 == result) {
                    System.out.println(imgUrl + "文件已经存在");
                    logger.info(imgUrl + "文件已经存在", "yeitu");
                } else {
                    System.out.println(imgUrl + "文件下载失败");
                    logger.error(imgUrl + "文件下载失败", "yeitu");
                }
            }
        }
    }
}
