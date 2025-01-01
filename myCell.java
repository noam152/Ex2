public class myCell {
    private String cellName;
    private String cellValue;

    public myCell(String name, String value){
        this.cellValue = value;
        this.cellName = name;
    }
    public myCell(String name){
        cell c1 = new cell (name, null);
    }
    public String getCellName() {
        return cellName;
    }
    public String getCellValue() {
        return cellValue;
    }
    public String setCellValue(String value){
        return this.cellValue = value;
    }
    public String setCellName(String value){
        return this.cellName = value;
    }
    public String toString(){}
        public boolean isCell(cell c1) {
        boolean ans = false;
        if(c1.isNumber(cellValue)) {
            ans = true;
        }
        if(c1.isText(cellValue)){
            ans = true;
        }
        if(c1.isForm(cellValue)){
            ans = true;
        }
        return ans;
    }
    public boolean isNumber(String value){
        try{
            Double.parseDouble(value);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
    public boolean isText(String value){
      if(!isNumber(value) && value.charAt(0)!='='){
          return true;
      }
      return false;
    }
    public boolean isForm(String value) {
        if (value.charAt(0) != '=') {
            return false;
        }
        else {
            String newValue = value.substring(1);
            if(isText(newValue)){
                return true;
            }
            else if(){

            }
        }

    }
}
