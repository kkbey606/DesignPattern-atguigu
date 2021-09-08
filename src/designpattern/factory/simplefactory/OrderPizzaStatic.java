package designpattern.factory.simplefactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ProjectName: code
 * @Package: designpattern.factory.trandition
 * @ClassName: OrderPizza
 * @Author: guoyy
 * @Description:
 * @Date: 2021/9/1 下午10:30
 * @UpdateDate: 2021/9/1 下午10:30
 * @Version: 1.0
 */
public class OrderPizzaStatic {

    Pizza pizza = null;

    public OrderPizzaStatic(){
        String orderType="";
        do{
            orderType=getType();
            pizza = SimpleFactory.createPizzaStatic(orderType);
            if(pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else{
                System.out.println("订购pizza失败");
                break;
            }
        }while(true);
    }

    private String getType(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input pizza type: ");
        String pizzaType = "";
        try {
            pizzaType = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pizzaType;
    }
}
