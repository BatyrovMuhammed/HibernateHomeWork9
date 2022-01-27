package peaksoft;

import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
   public static Scanner scanner = new Scanner(System.in);
   public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        // реализуйте алгоритм здесь
//       while (true) {
//           UserService userService = new UserServiceImpl();
//           User.prnt();
//           int a = scanner.nextInt();
//           String b = scanner.nextLine();
//           if (a == 1) {
//               userService.createUsersTable();
//           } else if (a == 2) {
//               userService.dropUsersTable();
//           } else if (a == 3) {
//               System.out.println("Bazaga koshuu");
//               System.out.println("Name:");
//               String name = scanner.nextLine();
//               System.out.println("Last_name:");
//               String lastName = scanner.nextLine();
//               System.out.println("Age:");
//               byte age = (byte) scanner.nextInt();
//               userService.saveUser(name, lastName, age);
//           } else if (a == 4) {
//               System.out.println(" Kaisyl id ochuruunu kalaisyz? ");
//               long id = scanner.nextByte();
//               userService.removeUserById(id);
//               System.out.println(" Siz tandagan id ochtu: ");
//           } else if (a == 5) {
//               System.out.println(userService.getAllUsers());
//           } else if (a == 6) {
//               userService.cleanUsersTable();
//           } else {
//               System.out.println(" ~~~ Kechiresiz myndai adres jok: ~~~ ");
//               System.out.println(" ~~~ Kairadan tandap korunuz: ~~~ ");
//               System.out.println("  ");
//           }
//       }

//        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
////        userDaoHibernate.createUsersTable();
////        userDaoHibernate.dropUsersTable();
//        userDaoHibernate.saveUser("Beksultan", "Mamatkdayr uulu", (byte) 12);
//        userDaoHibernate.getAllUsers().forEach(System.out::println);

        UserService userService = new UserServiceImpl();
//        userService.dropUsersTable();
//        userService.createUsersTable();
//userService.dropUsersTable();
//        userService.saveUser("testName", "testLastName", (byte) 12);
//        List<User> userList = userService.getAllUsers();
//        System.out.println(userList.size());
        }
    }


