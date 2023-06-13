public class Action {
    int value;
    String action;
    int gotoState;
    public Action(String action){

        if (action.contains("O")){
            value = Integer.parseInt(action.substring(0,action.indexOf("O")));
            this.action = "O";
            try {
                gotoState = Integer.parseInt(action.substring(action.indexOf("O")+1));
            }
            catch (NumberFormatException e){
                gotoState = -1;
            }
        } else if (action.contains("L")) {
            value = Integer.parseInt(action.substring(0,action.indexOf("L")));
            this.action = "L";
            try {
                gotoState = Integer.parseInt(action.substring(action.indexOf("L")+1));
            }
            catch (NumberFormatException e){
                gotoState = -1;
            }
        } else if (action.contains("R")) {
            value = Integer.parseInt(action.substring(0,action.indexOf("R")));
            this.action = "R";
            try {
                gotoState = Integer.parseInt(action.substring(action.indexOf("R")+1));
            }
            catch (NumberFormatException e){
                gotoState = -1;
            }
        }


    }
}
