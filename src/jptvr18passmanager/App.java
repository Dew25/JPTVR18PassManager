/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptvr18passmanager;

import classes.NewResource;
import classes.SaverToFile;
import entity.Resource;
import java.io.IOException;
import static java.lang.Math.ceil;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Melnikov
 */
public class App {
    private List<Resource> listResources = new ArrayList<>();
    private SaverToFile saverToFile = new SaverToFile();

    public App() {
        listResources.addAll(saverToFile.loadListResorces());
    }
    
    public void run(){
        System.out.println("--- Менеджер паролей ---");
        String repeat = "r";
        do{
            System.out.println("Выберите задачу: ");
            System.out.println("0 - выйти из программы");
            System.out.println("1 - добавить ресурс");
            System.out.println("2 - список ресурсов");
            System.out.println("3 - удалить ресурс");
            Scanner scanner = new Scanner(System.in);
            String task;
            boolean inputTrue;
            do{
                task = scanner.nextLine();
                try {
                    Integer.parseInt(task);
                    inputTrue = true;
                } catch (Exception e) {
                    inputTrue = false;
                }
                
            }while(!inputTrue);
            
            switch (task) {
                case "0":
                    repeat = "q";
                    break;
                case "1":
                    System.out.println("Выбрана задача 1");
                    NewResource newResource = new NewResource();
                    listResources.add(newResource.createRecource());
                    saverToFile.saveResource(listResources);
                    break;
                case "2":
                    System.out.println("Выбрана задача 2");
                    System.out.println("Список ресурсов:");
                    for(Resource r : listResources){
                        System.out.println(r.toString());
                    }
                    break;
                case "3":
                    System.out.println("Выбрана задача 3");
                    System.out.println("Список ресурсов:");
                    int i = 1;
                    for(Resource r : listResources){
                        System.out.printf("%d. %s ",i,r.getName());
                        i++;
                    }
                    System.out.println("Выберите номер ресурса для удаления");
                    int numDeleteResource = scanner.nextInt();
                    scanner.nextLine();
                    listResources.remove(numDeleteResource - 1);
                    saverToFile.saveResource(listResources);
                    break;
                default:
                    System.out.println("Используйте номера из списка задач");    
                    break;    
            }
        }while(!"q".equals(repeat));
        
    }
}
