package e_m_s;
import java.util.Scanner;

public class E_M_S {

    
    public static void main(String[] args) {
        //MySQLDatabase db = new MySQLDatabase();
        //db.readData();
        //Add_elmpoyee ap= new Add_elmpoyee();
        //ap.readData();
        //search_e ss = new search_e();
        //ss.Search();
        //delete_e dd = new delete_e();
        //dd.Delete();
        //update_e up = new update_e();
        //up.updata();
        
        System.out.println("Welcome to The employee management system ");
        System.out.println("==============================================================="+"\n");
        Scanner input = new Scanner(System.in);
        String User,pass,b_user = "admin",b_pass = "admin";
        System.out.println("Intail U&P: admin");
        System.out.print("Enter your User name: ");
        User = input.nextLine();
        System.out.print("Enter your Password: ");
        
        pass = input.nextLine();
        
        if(User.equals(b_user) && (pass.equals(b_pass))){
            
            System.out.println("1. ADD new Empolyee");
            System.out.println("2. Search Empolyee");
            System.out.println("3. Update Empolyee Details");
            System.out.println("4. Delete Empolyee Details");
            
            System.out.print("Enter the option Number: ");
            int op = input.nextInt();
            switch(op){
                case 1:
                    Add_elmpoyee ap= new Add_elmpoyee();
                    ap.readData();
                    break;
                case 2:
                    search_e ss = new search_e();
                    ss.Search();
                    break;
                case 3:
                    update_e up = new update_e();
                    up.updata();
                    break;
                case 4:
                    delete_e dd = new delete_e();
                    dd.Delete();
                    break;
                    
            }
        
        }
        else{
            System.out.println("Invaild User name or Password. Try again Later");
        }
    }
    
}
