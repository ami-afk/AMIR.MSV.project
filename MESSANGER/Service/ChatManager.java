package MESSANGER.Service;

import MESSANGER.Model.Chat;
import MESSANGER.Model.DAO.ChatDao;
import MESSANGER.Model.DAO.LikeMSGDao;
import MESSANGER.Model.DAO.ReplyDao;
import MESSANGER.Model.DAO.StartChatDao;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

public class ChatManager {
    private ChatDao ChatDao;
    private ReplyDao ReplyDao;
    private LikeMSGDao likeMSGDao;
    private StartChatDao startChatDao;

    public ChatManager(MESSANGER.Model.DAO.ChatDao chatDao, MESSANGER.Model.DAO.ReplyDao replyDao, LikeMSGDao likeMSGDao, StartChatDao startChatDao) {
        ChatDao = chatDao;
        ReplyDao = replyDao;
        this.likeMSGDao = likeMSGDao;
        this.startChatDao = startChatDao;
    }

    public Collection <Chat> getUserChats(long Userid) {
        Set<Long> SenderUserid = startChatDao.getAll()
                .stream()
                .filter(startChat -> startChat
                        .getSender()
                        .getId() == Userid).map(startChat -> startChat.getSender().getId())
                .collect(Collectors
                        .toSet());
        return ChatDao.getAll().stream().filter(chat -> SenderUserid.contains(chat.getSender().getId()))
                .sorted(Comparator.comparing(Chat::getWritedAt)).collect(Collectors.toList());
    }
}
