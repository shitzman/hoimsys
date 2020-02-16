package hoimsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import hoimsys.bo.DtDoctor;
import hoimsys.bo.Msg;
import hoimsys.po.Medicine;
import hoimsys.service.MedicineService;

@RestController
@RequestMapping("api/medicine")
@CrossOrigin
public class MedicineController {

	@Autowired
	MedicineService medService;
	
	
	//返回所有药品信息
	@GetMapping(value = "/showmedicines")
	Msg showMdicineController(
			@RequestParam(value = "search", defaultValue = "")String search,
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		List<Medicine> medList = medService.getMedicineList(search);
		
		PageInfo<Medicine> pagemedList = new PageInfo<Medicine>(medList);
		return Msg.success().add("medList", pagemedList);
	}
}
