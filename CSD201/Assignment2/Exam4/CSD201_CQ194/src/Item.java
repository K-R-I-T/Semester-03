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
        String newCode = Inputter.inputPattern("   - Enter code (CAxxx) ", "^CA\\d{3}");       
        String newMake = Inputter.inputNonBlankStr("   - Enter make ");
        this.setCode(newCode);
        this.setMake(newMake);
    }
    
    @Override
    public String toString(){
        return getCode() + ", " + getMake();
    } 
}
// =========================================================
// Do NOT modify this file 
// =========================================================