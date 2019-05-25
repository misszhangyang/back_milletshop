package milletshop.millet.entity;

import java.util.HashMap;
import java.util.Map;

public class ResultMap<T> {
    private int resultCode;
    private String resultType;
    private T resultValue;


    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public T getResultValue() {
        return resultValue;
    }

    public void setResultValue(T resultValue) {
        this.resultValue = resultValue;
    }

    public static Map<String,ResultMap> setSuccess(ResultMap resultMap){
        Map<String,ResultMap> resMap = new HashMap<>();
        resMap.put("result",resultMap);
        return resMap;
    }

    public static Map<String,ResultMap> setError(ResultMap resultMap){
        Map<String,ResultMap> resMap = new HashMap<>();
        resMap.put("result",resultMap);
        return resMap;
    }
}
