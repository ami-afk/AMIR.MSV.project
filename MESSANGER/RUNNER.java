package MESSANGER;

import MESSANGER.EXCEPTIONS.MessangerException;
import MESSANGER.Model.Chat;
import MESSANGER.Model.DAO.*;
import MESSANGER.Model.User;
import MESSANGER.Service.ChatManager;
import MESSANGER.Service.IdGenerator;
import MESSANGER.Service.UserManager;

import java.util.Collection;
import java.util.Scanner;

public class RUNNER {

    private static User user = null ;
    private static UserManager userManager;

    private static ChatManager chatManager;

    private static Scanner scanner;

    public static void main(String[] args) {


        UserDao UserDao = new UserDao();
        IdGenerator<User> userIdGenerator = new IdGenerator<>(UserDao);
        ChatDao ChatDao = new ChatDao();
        ReplyDao ReplyDao = new ReplyDao();
        StartChatDao startChatDao = new StartChatDao();
        LikeMSGDao likeMSGDao = new LikeMSGDao();

        userManager = new UserManager(UserDao, startChatDao, userIdGenerator);
        chatManager = new ChatManager(ChatDao, ReplyDao, likeMSGDao, startChatDao);

        scanner = new Scanner(System.in);
        while (true) {
            ShowMainMenu();


            int Choose = scanner.nextInt();

            try {
                if (Choose == 1) {
                    Login();

                } else if (Choose == 2) {
                    Register();
                } else if (Choose == 3) {
                    break;
                }
                showUserChats();
            } catch (MessangerException e) {
                System.out.println(e.getErrorType().getDescription());
                //e.printstacktrace


            }
        }

        }

        private static void ShowMainMenu () {
            System.out.println("================");
            System.out.println("1-Login");
            System.out.println("2-Register");
            System.out.println("3-Exit");

        }

        private static void Login () {
            System.out.println("Enter Your Username");
            String Username = scanner.next();

            System.out.println("Enter Your Password");
            String Password = scanner.next();
            user = userManager.login(Username, Password);

        }

    private static void Register () {
        System.out.println("Enter Your Username");
        String Username = scanner.next();

        System.out.println("Enter Your Password");
        String Password = scanner.next();
        user = userManager.Register(Username, Password);

    }

    private static void showUserChats() {
        Collection<Chat> userChats = chatManager.getUserChats(user.getId());


        System.out.println("+++++++++++++++");

        userChats.forEach(System.out::println);

        System.out.println("+++++++++++++++");

        System.out.println("Select Message Id To View");

    }
}
