package com.checkpeng.springboottest.zookeeper;

import lombok.extern.log4j.Log4j;
import org.apache.zookeeper.ZooDefs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

import static org.apache.zookeeper.CreateMode.PERSISTENT;

@RestController
@RequestMapping("zookeeper")
@Log4j
public class ZookeeperController {

    @Autowired
    ZooKeeperConn zooKeeperConn;

    @GetMapping("create")
    public String create(@RequestParam("path") String path,
                         @RequestParam("data") String data) {
        String result;
        try {
            result = zooKeeperConn.getZooKeeper().create(path, data.getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE, PERSISTENT);
        } catch (Exception e) {
            return e.getMessage().toString();
        }
        return result;
    }

    @GetMapping("delete")
    public void delete(@RequestParam("path") String path) {
        String result;
        try {
            zooKeeperConn.getZooKeeper().delete(path, 1);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @GetMapping("get")
    public String get(@RequestParam("path") String path) {
        String result;
        try {

        } catch (Exception e) {
            log.error(e);
        }
        return null;
    }
}
