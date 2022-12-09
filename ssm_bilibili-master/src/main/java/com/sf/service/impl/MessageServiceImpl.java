package com.sf.service.impl;

import com.sf.dao.impl.MessageImpl;
import com.sf.entity.*;
import com.sf.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageImpl messageImpl;

    public boolean message(MessageEntity message) {
        int bl = messageImpl.message(message);
        if (bl > 0) {
            return true;
        }
        return false;
    }

    public boolean Shoppingcart(ShoppingCart shoppingCart) {
        int bl = messageImpl.Shoppingcart(shoppingCart);
        if (bl > 0) {
            return true;
        }
        return false;
    }

    public boolean forumadd(ForumEntity forument) {
        int bl = messageImpl.forumadd(forument);
        if (bl > 0) {
            return true;
        }
        return false;
    }

    public boolean forumreply(ForumreplyEntity forumreply) {
        int bl = messageImpl.forumreply(forumreply);
        if (bl > 0) {
            return true;
        }
        return false;
    }

    public boolean addvideo(VideoEntity video) {
        int bl = messageImpl.addvideo(video);
        if (bl > 0) {
            return true;
        }
        return false;
    }

}
