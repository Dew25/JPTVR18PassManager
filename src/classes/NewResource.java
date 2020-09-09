/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Resource;
import java.util.Scanner;

/**
 *
 * @author Melnikov
 */
public class NewResource {
    public Resource createRecource(){
        System.out.println("--- Создание нового ресурса ---");
        Resource resource = new Resource();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Имя ресурса: ");
        resource.setName(scanner.nextLine());
        System.out.print("URL ресурса: ");
        resource.setUrl(scanner.nextLine());
        System.out.print("Логин: ");
        resource.setLogin(scanner.nextLine());
        System.out.print("Password: ");
        resource.setPassword(scanner.nextLine());
        return resource;
    }
}
