package milletshop.millet.controller;

import milletshop.millet.entity.FuzzySearch;
import milletshop.millet.entity.Phone;
import milletshop.millet.entity.Version_Phone;
import milletshop.millet.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.HashMap;
import java.util.List;


@RestController
public class PhoneController {

    @Autowired
    private ProductMapper productMapper;

    /**
     * 获取手机列表
     * @return
     */
    @Cacheable("phoneLists")
    @PostMapping("/getPhoneList")
    public List<Phone> getPhoneList(){
        long start = System.currentTimeMillis();
        List<Phone> list = productMapper.getPhoneList();
        long end = System.currentTimeMillis();
        System.out.println("本次查询耗时：" + (end-start));
        return productMapper.getPhoneList();
    }

    /**
     * 分页查询
     * @param pageSize
     * @return
     */
    @PostMapping("/queryByPageSize")
    public List<Phone> getPhoneListByPage(@RequestBody Integer pageSize){
        int totalPageSize = (pageSize -1) * 10;
        List<Phone> list = productMapper.getPhoneList();
        List<Phone>  lists = productMapper.getPhoneListByPage(totalPageSize);
        return productMapper.getPhoneListByPage(totalPageSize);
    }

    /**
     * 依据手机Id获取对应的手机信息
     * @param id
     * @return
     */
    @PostMapping("/getPhoneByd")
    public Phone getPhoneById(@PathVariable("id") Integer id){
        return productMapper.getPhoneById(id);
    }


    /**
     * 依据手机名称获取手机信息
     * @param phone
     * @return
     */
    @PostMapping("/getPhoneByName")
    public HashMap<String,Object> getPhoneByName(@RequestBody Phone phone){
        HashMap<String,Object> resultMap = new HashMap<>();
        Phone phone1 = productMapper.getPhoneWithName(phone.getPhoneName());
        List<Phone> colorLists = productMapper.getPhoneColorWithName(phone.getPhoneName());
        List<Version_Phone> versionList = productMapper.getPhoneVersionWithName(phone.getPhoneName());
        resultMap.put("phone",phone1);
        resultMap.put("colors",colorLists);
        resultMap.put("versions",versionList);
        return  resultMap;
    }

    /**
     * 模糊查询，依据手机名称和对应的id区间
     * @param fuzzySearch
     * @return
     */
    @PostMapping("/getPhoneByFuzzySearch")
    public List<Phone> getPhoneByQuzzySearch(@RequestBody FuzzySearch fuzzySearch){
        if(fuzzySearch != null){
            String phoneName = fuzzySearch.getPhoneName();
            int x = fuzzySearch.getMinId();
            if(!StringUtils.isEmpty(phoneName)){
               return productMapper.getPhoneByFuzzySearchWithPhoneName(phoneName,fuzzySearch.getMinId(),fuzzySearch.getMaxId());
            }else{
               return productMapper.getPhoneByFuzzySearch(fuzzySearch.getMinId(),fuzzySearch.getMaxId());
            }
        }
        return null;

    }

}
