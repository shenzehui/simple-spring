package com.szh.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by szh on 2023-05-24
 *
 * @author szh
 */

public interface Resource {

    /**
     * 提供获取 InputStream 流的方法，接下来再分别实现三种不同的流文件操作：classPath、FileSystem、URL
     */
    InputStream getInputStream() throws IOException;
}
