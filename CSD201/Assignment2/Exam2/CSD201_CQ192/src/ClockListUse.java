// =========================================================
// Do NOT modify this file 
// =========================================================
public class ClockListUse {
   public static void main(String args[]){
       String filename1 = "data-in.txt";
       String filename2 = "data-out.txt";
       I_Menu menu = new Menu();
       menu.addItem("Add new Clock");
       menu.addItem("Remove a Clock");
       menu.addItem("Update a Clock");
       menu.addItem("Print list");
       menu.addItem("Save to file");
       menu.addItem("Others: Quit"); 
       int choice;
       I_List list = new ClockList();
       list.AddFromFile(filename1); // load initial data
       do{
           System.out.println("____________________________");
           System.out.println("\n       CLOCK MANAGER");
           System.out.println();
           choice= menu.getChoice();
           switch(choice){
               case 1: list.add(); break;
               case 2: list.remove();break;
               case 3: list.update();break;
               case 4: list.print();break;
               case 5: list.saveToFile(filename2);break;
           }
       }
       while (choice>=0 && choice<=5);
   }   
}
// =========================================================
// Do NOT modify this file 
// =========================================================