package aop;

import java.util.HashMap;

/**
 * @Author: lds
 * @Date: 2019/7/23 16:49
 */
public class JoinPoint {
    private HashMap<String,Object> anoValues = null;

    public JoinPoint(){

    }

    public JoinPoint(HashMap<String,Object> anoValues){
        this.anoValues = anoValues;
    }

    public HashMap<String, Object> getAnoValues() {
        return anoValues;
    }

    public void setAnoValues(HashMap<String, Object> anoValues) {
        this.anoValues = anoValues;
    }
}
