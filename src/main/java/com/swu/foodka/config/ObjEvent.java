package com.swu.foodka.config;

import com.swu.foodka.entity.User;
import org.springframework.context.ApplicationEvent;

/**
 * @author liuxiaolin
 */
public class ObjEvent extends ApplicationEvent {

    private User user;

    private String content;

    public ObjEvent(Object source, User user, String content){
        super(source);
        this.user=user;
        this.content = content;
    }

    public ObjEvent(Object source) {
        super(source);
    }
}
