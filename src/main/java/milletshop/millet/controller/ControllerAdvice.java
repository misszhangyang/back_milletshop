package milletshop.millet.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * 定义控制器通知
 */

//@org.springframework.web.bind.annotation.ControllerAdvice(basePackages={"milletshop.millet.controller"})
public class ControllerAdvice {

    //绑定格式化，参数转化规则和增加验证器等
    @InitBinder
    public void initBinder(){

    }

    //在指定控制器之前执行，可以初始化数据模型
    @ModelAttribute
    public void modelAttribute(){}


    //异常处理，使得被拦截的处理器发生异常时，都能使用相同的视图去响应
    @ExceptionHandler
    public void exceptionHandler(){

    }
}
