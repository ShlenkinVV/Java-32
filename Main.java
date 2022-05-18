package com.company;


import java.util.HashMap;
import java.util.Map;



public class Main {
    public static void main(String[] args) throws Exception{
        System.out.println("Vova | 123 | 123");                                  //первое задание
        System.out.println(registration("Vova", "123", "123"));

        System.out.println("\n\nVovaaaaaaa123456781234 | 123 | 123");
        System.out.println(registration("Vovaaaaaaa123456781234", "123", "123"));

        System.out.println("\n\nVova$ | 123 | 123");
        System.out.println(registration("Vova$", "123", "123"));

        System.out.println("\n\nVova | 123 | abc");
        System.out.println(registration("Vova", "123", "abc"));


        HashMap<String, String> users= new HashMap<String, String>();           //второе задание
        users.put("Vova", "123");
        users.put("Daniil", "7777");
        users.put("kizaru", "abc123");

        System.out.println("\n===========================");
        authentication("Vova", "123", users);
        authentication("Daniil", "1010", users);
        authentication("Salamon$$$", "abcabc", users);

    }


    public static class WrongLoginException extends Exception{
        String error;

        public WrongLoginException() {
            error = "Неправильный логин\n";
        }

        public WrongLoginException(String str){
            super(str);
            error=str;
        }

        public String toString(){
            return "Неправильный логин - " + error;
        }
    }

    public static class WrongPasswordException extends Exception{
        String error;

        public WrongPasswordException() {
            error = "Неправильный пароль\n";
        }

        public WrongPasswordException(String str){
            super(str);
            error=str;
        }

        public String toString(){
            return "Неправильный пароль - " + error;
        }
    }

    public static boolean registration(String login, String password, String confirm_password) throws WrongLoginException, WrongPasswordException{
        try {
            if (login.length() > 20)
                throw new WrongLoginException("Слишком длинный логин");
            else if (!login.matches("[\\w]+$"))
                    throw new WrongLoginException("Логин не соотвествует символам");
            if (password.length()>20)
                throw new WrongPasswordException("Слишком длинный пароль\n");
            else if (!password.matches("[\\w]+$"))
                throw new WrongPasswordException("Пароль не соответсвует символам");
            if (!password.equals(confirm_password))
                throw new WrongPasswordException("Пароли не совпадают");
                    else return true;

            }
        catch(WrongLoginException  e){
                System.out.println(e);
                return false;
            }
        catch( WrongPasswordException e){
            System.out.println(e);
            return false;
        }
    }

    public static void authentication(String login, String passwd, HashMap<String, String> users)throws WrongLoginException, WrongPasswordException{
        boolean userFound=false;
       boolean ok=false;
        for (Map.Entry<String, String> entry : users.entrySet())
            if (entry.getKey().equals(login)) {
                userFound = true;
                if (entry.getValue().equals(passwd)) {
                    System.out.println("Аутентификация прошла успешно!");
                    ok = true;
                }
            }

        if (!ok) {
            if (registration(login, passwd, passwd)) {
                if (!userFound)
                    System.out.println("Такой пользователь не найден");
                else System.out.println("Неверный пароль");
            }
        }
    }

}




