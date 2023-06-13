import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void printTm(Action a,int state, int point, ArrayList<Integer> tm){
        System.out.print("state:"+state+" point:"+point+" \t"+a.value+a.action+a.gotoState+"\t");
        int count = 0;
        for (Integer i : tm){
            if (count==point){
                System.out.print("*");
            }else {
                System.out.print(" ");
            }
            System.out.print(i+" ");
            count++;
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        ArrayList<Integer> tm = new ArrayList<>();
        tm.add(0);
        System.out.print("请输入操作数数目");
        Scanner input = new Scanner(System.in);
        int numOperator = input.nextInt();
        for (int i = 0;i<numOperator;i++){
            System.out.print("请输入第"+(i+1)+"个操作数");
            int x = input.nextInt();
            for (int j=0;j<=x;j++){
                tm.add(1);
            }
            tm.add(0);
        }
        tm.add(0);tm.add(0);


        ArrayList<Tab> table = new ArrayList<>();
        //不要删掉这一行，为了直接取索引号
        table.add(new Tab(null,null));
        /*后继函数
        table.add(new Tab(new Action("0O0"),new Action("0O0")));
        table.add(new Tab(new Action("1L2"),new Action("1R1")));
        table.add(new Tab(new Action("0R3"),new Action("1L2")));*/


        //x.-y
        /*这是一个处理x-y的机器，下面这堆table.add就是把表格输入
        * null就是空格，0R8就是字面意思，懂的都懂*/

        table.add(new Tab(null,new Action("0R2")));
        table.add(new Tab(new Action("0R8"),new Action("1R3")));
        table.add(new Tab(new Action("0R4"),new Action("1R3")));
        table.add(new Tab(new Action("0R4"),new Action("0R5")));
        table.add(new Tab(new Action("0L10"),new Action("1L6")));
        table.add(new Tab(new Action("0L6"),new Action("1L7")));
        table.add(new Tab(new Action("0R1"),new Action("1L7")));
        table.add(new Tab(new Action("0R8"),new Action("0R9")));
        table.add(new Tab(new Action("1O13"),new Action("0R9")));
        table.add(new Tab(new Action("0L10"),new Action("1R11")));
        table.add(new Tab(new Action("1L12"),null));
        table.add(new Tab(new Action("0R13"),new Action("1L12")));


        int currState = 1;
        int point = 1;
        Action curAction = new Action("0O0");
        while (currState != -1){
            printTm(curAction,currState,point,tm);
            int pointed_value = tm.get(point);
            try {
                if (pointed_value == 0){
                    curAction = table.get(currState).action0;
                }else {
                    curAction = table.get(currState).action1;
                }
                if (curAction == null){
                    currState = -1;
                    continue;
                }
            }
            catch (IndexOutOfBoundsException e){
                currState = -1;
                continue;
            }

            tm.set(point,curAction.value);
            if (curAction.action.equals("L")){point--;}
            else if (curAction.action.equals("R")) {
                point++;
            }
            if (point<0){
                currState = -1;
                continue;
            } else if (point>=tm.size()) {
                while (point>= tm.size()){
                    tm.add(0);
                }
            }
            currState = curAction.gotoState;
        }
    }

}