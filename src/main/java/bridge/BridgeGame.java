package bridge;

import java.util.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @return
     */
    public static String move(int bridge_size,int cnt) {
        Map<String, String> mineMap = new HashMap<String, String>() {
            {
                put("U", "1");
                put("D", "0");
            }

        };
        String blank="";
        String result = null;
        int bridge_index=0;
        boolean check = true;
        List<Integer> list =  new ArrayList();
        List<String> list2 =  new ArrayList();
        BridgeMaker bridgeMaker=new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge=bridgeMaker.makeBridge(bridge_size);
        System.out.println(bridge);
        while (check==true){
            if(bridge_index==bridge_size){
                OutputView.printResult(result,cnt,1);
                return "";
            }

            blank=InputView.readMoving();
            if(Objects.equals(bridge.get(bridge_index), blank)){

                list.add(1);
                list2.add(blank);
                bridge_index+=1;
                result=OutputView.printMap(list,list2,bridge_index);
                continue;
            }
            check=false;
            list.add(0);
            list2.add(blank);
            bridge_index+=1;
            result=OutputView.printMap(list,list2,bridge_index);

        }
        return result;


    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static boolean retry(String result,int cnt) {
        String retry;
        retry=InputView.readGameCommand();
        if(!retry.equals("R")){
            OutputView.printResult(result,cnt,0);
            return false;}
        if(retry.equals("R")){
            return true;
        }
        return true;

    }
}
