
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 服装
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/fuzhaung")
public class FuzhaungController {
    private static final Logger logger = LoggerFactory.getLogger(FuzhaungController.class);

    @Autowired
    private FuzhaungService fuzhaungService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("fuzhaungDeleteStart",1);params.put("fuzhaungDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = fuzhaungService.queryPage(params);

        //字典表数据转换
        List<FuzhaungView> list =(List<FuzhaungView>)page.getList();
        for(FuzhaungView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FuzhaungEntity fuzhaung = fuzhaungService.selectById(id);
        if(fuzhaung !=null){
            //entity转view
            FuzhaungView view = new FuzhaungView();
            BeanUtils.copyProperties( fuzhaung , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody FuzhaungEntity fuzhaung, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fuzhaung:{}",this.getClass().getName(),fuzhaung.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<FuzhaungEntity> queryWrapper = new EntityWrapper<FuzhaungEntity>()
            .eq("fuzhaung_uuid_number", fuzhaung.getFuzhaungUuidNumber())
            .eq("fuzhaung_name", fuzhaung.getFuzhaungName())
            .eq("fuzhaung_types", fuzhaung.getFuzhaungTypes())
            .eq("fuzhaung_kucun_number", fuzhaung.getFuzhaungKucunNumber())
            .eq("fuzhaung_price", fuzhaung.getFuzhaungPrice())
            .eq("fuzhaung_clicknum", fuzhaung.getFuzhaungClicknum())
            .eq("shangxia_types", fuzhaung.getShangxiaTypes())
            .eq("fuzhaung_delete", fuzhaung.getFuzhaungDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FuzhaungEntity fuzhaungEntity = fuzhaungService.selectOne(queryWrapper);
        if(fuzhaungEntity==null){
            fuzhaung.setFuzhaungClicknum(1);
            fuzhaung.setShangxiaTypes(1);
            fuzhaung.setFuzhaungDelete(1);
            fuzhaung.setCreateTime(new Date());
            fuzhaungService.insert(fuzhaung);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FuzhaungEntity fuzhaung, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,fuzhaung:{}",this.getClass().getName(),fuzhaung.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<FuzhaungEntity> queryWrapper = new EntityWrapper<FuzhaungEntity>()
            .notIn("id",fuzhaung.getId())
            .andNew()
            .eq("fuzhaung_uuid_number", fuzhaung.getFuzhaungUuidNumber())
            .eq("fuzhaung_name", fuzhaung.getFuzhaungName())
            .eq("fuzhaung_types", fuzhaung.getFuzhaungTypes())
            .eq("fuzhaung_kucun_number", fuzhaung.getFuzhaungKucunNumber())
            .eq("fuzhaung_price", fuzhaung.getFuzhaungPrice())
            .eq("fuzhaung_clicknum", fuzhaung.getFuzhaungClicknum())
            .eq("shangxia_types", fuzhaung.getShangxiaTypes())
            .eq("fuzhaung_delete", fuzhaung.getFuzhaungDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FuzhaungEntity fuzhaungEntity = fuzhaungService.selectOne(queryWrapper);
        if("".equals(fuzhaung.getFuzhaungPhoto()) || "null".equals(fuzhaung.getFuzhaungPhoto())){
                fuzhaung.setFuzhaungPhoto(null);
        }
        if(fuzhaungEntity==null){
            fuzhaungService.updateById(fuzhaung);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<FuzhaungEntity> list = new ArrayList<>();
        for(Integer id:ids){
            FuzhaungEntity fuzhaungEntity = new FuzhaungEntity();
            fuzhaungEntity.setId(id);
            fuzhaungEntity.setFuzhaungDelete(2);
            list.add(fuzhaungEntity);
        }
        if(list != null && list.size() >0){
            fuzhaungService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<FuzhaungEntity> fuzhaungList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            FuzhaungEntity fuzhaungEntity = new FuzhaungEntity();
//                            fuzhaungEntity.setFuzhaungUuidNumber(data.get(0));                    //服装编号 要改的
//                            fuzhaungEntity.setFuzhaungName(data.get(0));                    //服装名称 要改的
//                            fuzhaungEntity.setFuzhaungPhoto("");//详情和图片
//                            fuzhaungEntity.setFuzhaungTypes(Integer.valueOf(data.get(0)));   //服装类型 要改的
//                            fuzhaungEntity.setFuzhaungKucunNumber(Integer.valueOf(data.get(0)));   //服装库存 要改的
//                            fuzhaungEntity.setFuzhaungPrice(Integer.valueOf(data.get(0)));   //购买获得积分 要改的
//                            fuzhaungEntity.setFuzhaungOldMoney(data.get(0));                    //服装原价 要改的
//                            fuzhaungEntity.setFuzhaungNewMoney(data.get(0));                    //现价/积分 要改的
//                            fuzhaungEntity.setFuzhaungClicknum(Integer.valueOf(data.get(0)));   //点击次数 要改的
//                            fuzhaungEntity.setFuzhaungContent("");//详情和图片
//                            fuzhaungEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            fuzhaungEntity.setFuzhaungDelete(1);//逻辑删除字段
//                            fuzhaungEntity.setCreateTime(date);//时间
                            fuzhaungList.add(fuzhaungEntity);


                            //把要查询是否重复的字段放入map中
                                //服装编号
                                if(seachFields.containsKey("fuzhaungUuidNumber")){
                                    List<String> fuzhaungUuidNumber = seachFields.get("fuzhaungUuidNumber");
                                    fuzhaungUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> fuzhaungUuidNumber = new ArrayList<>();
                                    fuzhaungUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("fuzhaungUuidNumber",fuzhaungUuidNumber);
                                }
                        }

                        //查询是否重复
                         //服装编号
                        List<FuzhaungEntity> fuzhaungEntities_fuzhaungUuidNumber = fuzhaungService.selectList(new EntityWrapper<FuzhaungEntity>().in("fuzhaung_uuid_number", seachFields.get("fuzhaungUuidNumber")).eq("fuzhaung_delete", 1));
                        if(fuzhaungEntities_fuzhaungUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(FuzhaungEntity s:fuzhaungEntities_fuzhaungUuidNumber){
                                repeatFields.add(s.getFuzhaungUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [服装编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        fuzhaungService.insertBatch(fuzhaungList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = fuzhaungService.queryPage(params);

        //字典表数据转换
        List<FuzhaungView> list =(List<FuzhaungView>)page.getList();
        for(FuzhaungView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FuzhaungEntity fuzhaung = fuzhaungService.selectById(id);
            if(fuzhaung !=null){

                //点击数量加1
                fuzhaung.setFuzhaungClicknum(fuzhaung.getFuzhaungClicknum()+1);
                fuzhaungService.updateById(fuzhaung);

                //entity转view
                FuzhaungView view = new FuzhaungView();
                BeanUtils.copyProperties( fuzhaung , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody FuzhaungEntity fuzhaung, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,fuzhaung:{}",this.getClass().getName(),fuzhaung.toString());
        Wrapper<FuzhaungEntity> queryWrapper = new EntityWrapper<FuzhaungEntity>()
            .eq("fuzhaung_uuid_number", fuzhaung.getFuzhaungUuidNumber())
            .eq("fuzhaung_name", fuzhaung.getFuzhaungName())
            .eq("fuzhaung_types", fuzhaung.getFuzhaungTypes())
            .eq("fuzhaung_kucun_number", fuzhaung.getFuzhaungKucunNumber())
            .eq("fuzhaung_price", fuzhaung.getFuzhaungPrice())
            .eq("fuzhaung_clicknum", fuzhaung.getFuzhaungClicknum())
            .eq("shangxia_types", fuzhaung.getShangxiaTypes())
            .eq("fuzhaung_delete", fuzhaung.getFuzhaungDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FuzhaungEntity fuzhaungEntity = fuzhaungService.selectOne(queryWrapper);
        if(fuzhaungEntity==null){
            fuzhaung.setFuzhaungDelete(1);
            fuzhaung.setCreateTime(new Date());
        fuzhaungService.insert(fuzhaung);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
