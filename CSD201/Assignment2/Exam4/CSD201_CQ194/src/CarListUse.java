// =========================================================
// Do NOT modify this file 
// =========================================================
public class CarListUse {
   public static void main(String args[]){
       String filename1 = "data-in.txt";
       String filename2 = "data-out.txt";
       I_Menu menu = new Menu();
       menu.addItem("Add new Car");
       menu.addItem("Remove a Car");
       menu.addItem("Update a Car");
       menu.addItem("Print list");
       menu.addItem("Save to file");
       menu.addItem("Others: Quit"); 
       int choice;
       I_List list = new CarList();
       list.AddFromFile(filename1); // load initial data
       do{
           System.out.println("____________________________");
           System.out.println("\n       CAR MANAGER");
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