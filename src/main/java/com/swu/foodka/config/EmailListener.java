package com.swu.foodka.config;

import com.swu.foodka.controller.AdminController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author liuxiaolin
 */
@Component
public class EmailListener implements ApplicationListener<ObjEvent> {

    @Autowired
    AdminController adminController;

    @Override
    public void onApplicationEvent(ObjEvent event) {
        Object source = event.getSource();
        System.out.println("监听到了...");
        /**
         *  邮件监听器，一旦有邮件事件，则会触发此处,接收到消息
         */
        adminController.saveMsg();
    }
}
