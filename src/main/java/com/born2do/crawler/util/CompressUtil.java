package com.born2do.crawler.util;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 文件打包工具类
 * @author chenhy
 * @date 2021/9/8
 */
public class CompressUtil {

    private static final int  BUFFER_SIZE = 1024 * 5;

    /**
     * 压缩成ZIP
     * @param sourceFile 源文件夹
     * @param out 压缩文件输出流
     * @param keepDirStructure 是否保留原来的目录结构。
     *                         true:保留目录结构;
     *                         false:所有文件跑到压缩包根目录下(注意：不保留目录结构可能会出现同名文件,会压缩失败)
     * @throws RuntimeException 压缩失败会抛出运行时异常
     */
    public static void compressToZip(File sourceFile, OutputStream out, boolean keepDirStructure)
            throws RuntimeException{
        ZipOutputStream zos = null ;
        try {
            zos = new ZipOutputStream(out);
            compress(sourceFile, zos, sourceFile.getName(), keepDirStructure);
        } catch (Exception e) {
            throw new RuntimeException("zip error from CompressUtil",e);
        }finally{
            if(null != zos){
                try {
                    zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 递归压缩方法
     * @param sourceFile 源文件
     * @param zos        zip输出流
     * @param name       压缩后的名称
     * @param keepDirStructure  是否保留原来的目录结构。
     *                          true:保留目录结构;
     *                          false:所有文件跑到压缩包根目录下(注意：不保留目录结构可能会出现同名文件,会压缩失败)
     * @throws Exception 异常
     */
    private static void compress(File sourceFile, ZipOutputStream zos, String name, boolean keepDirStructure)
            throws Exception{
        byte[] buf = new byte[BUFFER_SIZE];
        if(sourceFile.isFile()){
            // 向zip输出流中添加一个zip实体，构造器中name为zip实体的文件的名字
            zos.putNextEntry(new ZipEntry(name));
            // copy文件到zip输出流中
            int len;
            FileInputStream in = new FileInputStream(sourceFile);
            while ((len = in.read(buf)) != -1){
                zos.write(buf, 0, len);
            }
            // Complete the entry
            zos.closeEntry();
            in.close();
        } else {
            File[] listFiles = sourceFile.listFiles();
            if(listFiles == null || listFiles.length == 0){
                // 需要保留原来的文件结构时,需要对空文件夹进行处理
                if(keepDirStructure){
                    // 空文件夹的处理
                    zos.putNextEntry(new ZipEntry(name + "/"));
                    // 没有文件，不需要文件的copy
                    zos.closeEntry();
                }
            }else {
                for (File file : listFiles) {
                    String fileName = file.getName();
                    // 判断是否需要保留原来的文件结构
                    if (keepDirStructure) {
                        // 注意：file.getName()前面需要带上父文件夹的名字加一斜杠,
                        // 不然最后压缩包中就不能保留原来的文件结构,即：所有文件都跑到压缩包根目录下了
                        fileName = name + "/" +fileName;
                    }
                    compress(file, zos, fileName, keepDirStructure);
                }
            }
        }
    }
}
