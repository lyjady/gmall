package org.augustus.manage.config;


import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author LinYongJin
 * @date 2020/2/17 21:28
 */
@Configuration
public class CustomBeans {

    @Bean
    public StorageClient storageClient() throws IOException, MyException {
        String tracker = CustomBeans.class.getResource("/tracker.conf").getPath();
        ClientGlobal.init(tracker);
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getTrackerServer();
        return new StorageClient(trackerServer, null);
    }
}
