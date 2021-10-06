package com.born2do.crawler.util;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/**
 * @author chenhy
 * @date 2021/9/3
 */
public class ImageDownLoadUtils {

    public static int download(String link, String path) {
        int rtcode = 0;
        String fileName = link.substring(link.lastIndexOf("/") + 1);
        try {
            File file = new File(path + "\\" + fileName + ".jpg");
            if (file.exists()) {
                rtcode = 2;
            } else {
                URL url = new URL(link);
                URLConnection con = url.openConnection();
                con.setConnectTimeout(1000 * 5);
                InputStream inStream = con.getInputStream();
                ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int len = 0;
                while ((len = inStream.read(buf)) != -1) {
                    outStream.write(buf, 0, len);
                }
                inStream.close();
                outStream.close();
                FileOutputStream op = new FileOutputStream(file);
                op.write(outStream.toByteArray());
                op.close();
            }
        } catch (MalformedURLException e) {
            rtcode = 1;
            e.printStackTrace();
        } catch (IOException e) {
            rtcode = 1;
            e.printStackTrace();
        }
        return rtcode;
    }
    
    public static int downloadWithRequestProperty(String picUrl, String path, Map<String, String> requestPropertyMap) {
        int rtcode = 0;
        String filename = picUrl.substring(picUrl.lastIndexOf("/") + 1);
        File file = new File(path + "/" + filename + ".jpg");
        if (file.exists()) {
            rtcode = 2;
        } else {
            URL url = null;
            URLConnection connection = null;
            InputStream inputStream = null;
            OutputStream outputStream = null;
            try {
                url = new URL(picUrl);
                connection = url.openConnection();
                connection.setConnectTimeout(1000 * 5);
                for (Map.Entry<String, String> entry: requestPropertyMap.entrySet()) {
                    connection.addRequestProperty(entry.getKey(), entry.getValue());
                }
                inputStream = connection.getInputStream();
                byte[] buffer = new byte[1024 * 5];
                outputStream = new FileOutputStream(file);
                int length;
                while (-1 != (length = inputStream.read(buffer))) {
                    outputStream.write(buffer, 0, length);
                }
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                rtcode = 1;
                e.printStackTrace();
            } finally {
                if (null != outputStream) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (null != inputStream) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return rtcode;
    }
}
