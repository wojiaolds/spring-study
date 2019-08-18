package io.utils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
/**
 * 功能描述: <br>
 *  枚举实现的单例模式
 * @Date 2019/8/16 21:31
 * @Author lds
 */
public enum Calculator {
    Instance;
    private final static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
    public Object cal(String expression) throws ScriptException {
        return jse.eval(expression);
    }
}