package com.sys.demo01.controller;

import com.sys.demo01.pojo.Khmc;
import com.sys.demo01.pojo.TreeDataResult;
import com.sys.demo01.service.imple.KhmcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("khmc")
public class KhmcController {
    @Autowired
    private KhmcServiceImpl khmcServiceImpl;

    @GetMapping("query/{khmc_id}")
    public Khmc selectKhmcById(@PathVariable Long khmc_id) {

        return khmcServiceImpl.selectKhmcById(khmc_id);
    }

    @GetMapping("delete/{khmc_id}")
    public boolean deleteKhmcById(@PathVariable Long khmc_id) {

        return khmcServiceImpl.deleteKhmcById(khmc_id) == 1;
    }

    @PostMapping("getAll")
    @ResponseBody
    public List<TreeDataResult> getKhmc() {
        List<Khmc> list = khmcServiceImpl.getAll();
        List<TreeDataResult> treeList = new ArrayList<TreeDataResult>();
        treeList.add(new TreeDataResult(0, "所有用户", "open", null, -1));
        for (Khmc khmc : list) {
            treeList.add(new TreeDataResult(khmc.getKhmc_id(), khmc.getKhmc_name(), null, null, 0));
        }
        return treeList;
    }

}
