package com.born2do.crawler.pipeline;

import com.born2do.crawler.constant.PathConstant;
import com.born2do.crawler.log.ILogger;
import com.born2do.crawler.log.LoggerImpl;
import com.born2do.crawler.mapper.PcinfMapper;
import com.born2do.crawler.pojo.Pcinf;
import com.born2do.crawler.util.ImageDownLoadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.selector.Selectable;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author chenhy
 * @date 2021/9/2
 */
@Component
public class YalayiPipeline implements Pipeline {

    private static final ILogger logger = new LoggerImpl(YalayiPipeline.class);

    private static final String dir = PathConstant.DIR;

    @Autowired
    private PcinfMapper pcinfMapper;

    public YalayiPipeline() {
    }

    /**
     * Process extracted results.
     *
     * @param resultItems resultItems
     * @param task        task
     */
    @Override
    public void process(ResultItems resultItems, Task task) {
        Map<String, Object> resultMap = resultItems.getAll();
        String wbName = (String) resultMap.get("webName");
        String modelName = (String) resultMap.get("modelName");
        String artName = (String) resultMap.get("artName");
        List<Selectable> picUrls = (List<Selectable>) resultMap.get("picUrls");
        Pcinf pcinf = new Pcinf();
        pcinf.setWbname(wbName);
        pcinf.setWbsite((String) resultMap.get("website"));
        pcinf.setPgaddr((String) resultMap.get("pgaddr"));
        pcinf.setMdname(modelName);
        pcinf.setMdinfo("");
        pcinf.setArtnam(artName);
        pcinf.setResolu((String) resultMap.get("resolution"));
        pcinf.setIssues((String) resultMap.get("issues"));
        pcinf.setLabels((String) resultMap.get("lables"));
        pcinf.setIntrod((String) resultMap.get("introduction"));

        String path = dir + "/" + wbName + "/" + modelName + "/" + artName;

        boolean dirExist = true;
        if (null != picUrls && !picUrls.isEmpty()) {
            dirExist = mkdir(path);
        } else {
            return;
        }

        if (dirExist) {
            for (Selectable selectable : picUrls) {
                String imageUrl = selectable.toString();
                pcinf.setPcaddr(imageUrl);
                pcinf.setFupath(path + "/" + imageUrl.substring(imageUrl.lastIndexOf("/") + 1) + ".jpg");
                int result = ImageDownLoadUtils.download(imageUrl, path);
                if (0 == result) {
                    try {
                        pcinfMapper.insert(pcinf);
                        System.out.println(imageUrl + "文件下载完成");
                        logger.info(imageUrl +"文件下载完成", "yalayi");
                    } catch (Exception e) {
                        logger.error(pcinf.toString() + "插入库表失败", "yalayi");
                    }
                } else if (2 == result) {
                    System.out.println(imageUrl + "文件已经存在");
                    logger.info(imageUrl + "文件已经存在", "yalayi");
                } else {
                    System.out.println(imageUrl + "文件下载失败");
                    logger.error(imageUrl + "文件下载失败", "yalayi");
                }
            }
        }


    }

    private boolean mkdir(String path) {
        boolean isSucceed = true;
        try {
            File files = new File(path);
            if (!files.exists()) {
                files.mkdirs();
            }
        } catch (Exception e) {
            isSucceed = false;
            System.out.println("文件夹创建失败：" + path);
        }
        return isSucceed;
    }
}
