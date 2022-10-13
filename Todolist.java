/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package todolist;
import java.util.Scanner;
/**
 *
 * @author hp
 */
public class Todolist {
public static String[]model = new String[10];
public static Scanner scanner = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        viewShowTodoList();
        
    }
    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }
    
    public static void testInput() {
        String name = input("Nama");
        String channel = input("Channel");
        System.out.println("Hi " + name);
        System.out.println(channel);
    }
    
    public static void showTodoList() {
        System.out.println("TODOLIST");
        for (int i = 0; i < model.length; i++) {
            String todo = model[i];
            int no = i + 1;
            
            if (todo != null) {
            System.out.println(no + ". " + todo);
                
            }
        }
    }
    
    public static void testshowTodoList() {
        showTodoList();
    }
    
    public static void addTodoList(String todo) {
//cek apakah model penuh?
        boolean isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }
        
        // jika penuh, kita resize ukuran array 2x lipat
        if (isFull) {
            String[] temp = model;
            model = new String[model.length * 2];
            
            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }
        // tambahkan ke posisi yang data array nya NULL
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }
     
    public static void testAddTodoList() {
        for (int i = 0; i < 25; i++) {
            addTodoList("Contoh Todo Ke." + i);
        }
        showTodoList();
    }
    
    /**
    *Menghapus todo dari list
    */
    public static boolean removeTodoList(Integer number) {
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {            
            for (int i = (number -1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else{
                model[i] = model[i + 1];   
                }
            }
            return true;
        }
    }
    
    public static void testRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");

        boolean result = removeTodoList(20);
        System.out.println(result);
        
        result = removeTodoList(7);
        System.out.println(result);
        
        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

   public static void viewShowTodoList() {
       while(true){
       showTodoList();
       
       System.out.println("Menu : ");
       System.out.println("1. Tambah");
       System.out.println("2. Hapus");
       System.out.println("x. Keluar");
       
       String input = input("pilih");
       if (input.equals("1")) {
           viewAddTodoList();
        } else if (input.equals("2")) {
            viewRemoveTodoList();
        } else if (input.equals("x")) {
            break;
        } else  {
            System.out.println("404 (Tidak ditemukan)");
        }
       }
   } 
   
   static void testViewShowTodoList() {
       addTodoList("Satu");
       addTodoList("Dua");
       addTodoList("Tiga");
       addTodoList("Empat");
       addTodoList("Lima");
       
       viewShowTodoList();
   }
   
   static void viewAddTodoList() {
       System.out.println("Menamabah TODOLIST");
       
       String todo = input("Todo (pilih x jika batal)");
       
       if(todo.equals("x")){
           //batal
       } else {
           addTodoList(todo);
       }
   }
   
   static void testViewAddTodoList() {
       addTodoList("Satu");
       addTodoList("Satu");
       addTodoList("Satu");
       addTodoList("Empat");
       addTodoList("Lima");
       
       viewAddTodoList();
       showTodoList();
   }
   
   static void viewRemoveTodoList() {
       System.out.println("MENGHAPUS TODOLIST");
       
       String number = input("Nomor yang dihapur(x jika batal)");
       
       if (number.equals("x")) {
           //batal
       } else{
           boolean success = removeTodoList(Integer.valueOf(number));
           if(!success) {
               System.out.println("Gagal menghapus TodoList : " + number);
           }
       }
   }

    static void testViewRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");
        
        showTodoList();
        viewRemoveTodoList();
        showTodoList();
    }
}
