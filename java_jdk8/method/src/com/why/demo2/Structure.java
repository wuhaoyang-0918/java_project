package com.why.demo2;

/**
 * @author why
 * @date 2021/9/23 14:51
 * @PackageName com.why.demo2
 * @description
 */
public class Structure {
    public static void main(String[] args) {
       /*  UserInterface userInterface = () -> {
            return new UserEntity();
        };*/
        //System.out.println(userInterface.getUser());

        UserInterface userInterface1 = UserEntity::new;
        System.out.println(userInterface1.getUser());
    }
}
