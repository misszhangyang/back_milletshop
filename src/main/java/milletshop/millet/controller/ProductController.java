package milletshop.millet.controller;

import milletshop.millet.entity.Product;
import milletshop.millet.entity.User;
import milletshop.millet.service.product.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class

ProductController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/test")
    public ModelAndView testPage() {
        ModelAndView modelAndView = new ModelAndView("test");
        return modelAndView;
    }

    @GetMapping("/welcome")
    public ModelAndView testWelcome() {
        ModelAndView modelAndView = new ModelAndView("/welcome/welcome");
        return modelAndView;
    }

    @PostMapping("/purchase")
    public void purchase(long userId, long productId, int quantity) {
        boolean success = purchaseService.purchase(userId, productId, quantity);
    }

    @GetMapping("/getProductList")
    public List<Product> getProductList() {
        List<Product> proLists = purchaseService.getProductList();
        return proLists;
    }

    //跳转至上传文件页面
    @GetMapping("/upload")
    public ModelAndView upload() {
        return new ModelAndView("upload");
    }

    //上传文件使用HttpServlettRequest作为参数
    @PostMapping("/upload/httpservletrequest")
    public Map<String, Object> uploadFile(HttpServletRequest httpServletRequest) {
        boolean flage = false;
        MultipartHttpServletRequest mrep = null;
        if (httpServletRequest instanceof MultipartHttpServletRequest) {
            mrep = (MultipartHttpServletRequest) httpServletRequest;
        } else {
            return dealResultMap(false, "上传文件失败");
        }
        //获取MultipartFile文件信息
        MultipartFile mf = mrep.getFile("file");
        //获取源文件名称
        String fileName = mf.getOriginalFilename();
        File file = new File(fileName);
        try {
            //保存文件
            mf.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
            return dealResultMap(false,"上传失败");
        }
        return dealResultMap(true,"上传成功");
    }

    /**
     * 使用MultipartFile作为参数上传文件
     * @param file
     * @return
     */
    @PostMapping("/upload/multipartfile")
    public Map<String,Object> uploadMuitioartFile(MultipartFile file){
        String fileName = file.getOriginalFilename();
        File dest = new File(fileName);
        try {
            //写入文件
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            return dealResultMap(false,"上传失败");
        }
        return dealResultMap(true,"上传文件成功");
    }

    /**
     * 使用Part作为参数上传文件
     * @param file
     * @return
     */
    @PostMapping("/upload/part")
    public Map<String,Object> uploadPart(Part file){
        String fileName = file.getSubmittedFileName();
        try {
            //写入文件
            file.write(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return dealResultMap(false,"上传文件失败");
        }
        return dealResultMap(true,"上传文件成功");
    }
    /**
     * 处理文件上传结果
     * @param b  是否成功
     * @param str 对应消息
     * @return  map返回信息
     */
    private Map<String, Object> dealResultMap(boolean b, String str) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("success",b);
        resultMap.put("msg",str);
        return resultMap;
    }

    @GetMapping("/converter")
    @ResponseBody
    public User stringConverterUser(User user) {
        return user;
    }


    class Result {
        private boolean success;
        private String msg = null;

        public Result(boolean success, String msg) {
            this.msg = msg;
            this.success = success;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

}
