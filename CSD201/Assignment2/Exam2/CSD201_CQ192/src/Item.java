// =========================================================
// Do NOT modify this file 
// =========================================================
public class Item {    
    private String code;
    private String make;

    public Item() {
    }

    public Item(String code, String make) {
        this.code = code;
        this.make = make;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
    
    public void input() {   
        String newCode = Inputter.inputPattern("   - Enter code (Cxxx) ", "^C\\d{3}");       
        String newMake = Inputter.inputNonBlankStr("   - Enter make ");
        this.setCode(newCode);
        this.setMake(newMake);
    }
    
    public void output() {
        System.out.print(this.getCode() + " - ");
        System.out.print(this.make + " - ");
    }    
}
// =========================================================
// Do NOT modify this file 
// =========================================================