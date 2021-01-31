package com.checkpeng.springboottest.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Before;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

@Slf4j
@Component
public class ZooKeeperConn {

    private static final String ZK_ADDRESS = "121.196.157.45:2181";

    private static final int SESSION_TIMEOUT = 500000000;

    private static ZooKeeper zooKeeper;

    private static final String ZK_NODE = "/zk-node";


    @Before
    @PostConstruct
    public void init() throws IOException, InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        zooKeeper = new ZooKeeper(ZK_ADDRESS, SESSION_TIMEOUT, event -> {
            if (event.getState() == Watcher.Event.KeeperState.SyncConnected &&
                    event.getType() == Watcher.Event.EventType.None) {
                countDownLatch.countDown();
                log.info("连接成功！");
            }
        });
        log.info("连接中....");
        countDownLatch.await();
    }

    public ZooKeeper getZooKeeper() {
        return zooKeeper;
    }
}
