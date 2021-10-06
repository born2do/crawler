package com.born2do.crawler.pipeline;

import com.overzealous.remark.Remark;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

/**
 * @author chenhy
 * @date 2021/9/1
 */
public class MarkdownPipeLine implements Pipeline {

    private Path path;

    public MarkdownPipeLine(Path path) {
        this.path = path;
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
        String content = (String) resultMap.get("content");
        // 将HTML格式转换为Markdown格式
        Remark remark = new Remark();
        content = remark.convert(content);
        try {
            Files.write(path, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            // 换行
            Files.write(path, System.getProperty("line.separator").getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
