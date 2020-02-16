package hoimsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	/*
	 * 	修改药品信息
	 */
	@PostMapping(value = "/updatemed", produces = "application/json;charset=UTF-8")
	Msg chageMedicine(@RequestBody Medicine med) {
		if(medService.updateOneMedicine(med)>0) {
			
			return Msg.success().resetMsg("修改药品信息成功！")
					.add("updatemed", 
							medService.getMedicineBymId(med.getmId()));
		}
		return Msg.fail().resetMsg("修改药品信息失败！");
	}
	
	/*
	 * 	增加药品
	 * 
	 */
	@PostMapping(value = "/addmed", produces = "application/json;charset=UTF-8")
	Msg addMedicine(@RequestBody Medicine med) {
		if(medService.addOneMedicine(med)>0) {
			return Msg.success().resetMsg("添加药品信息成功!")
					.add("addmed", 
							med);
		}
		return Msg.fail().resetMsg("添加药品信息失败!");
	}
	
	/*
	 * 	删除药品
	 */
	@PostMapping(value = "/delmed")
	Msg delMedicine(Integer mId) {
		Medicine delmed = medService.getMedicineBymId(mId);
		if(medService.delOneMedicine(mId)>0) {
			return Msg.success().resetMsg("删除药品信息成功").add("delmed", delmed);
		}
		return Msg.fail().resetMsg("删除药品信息失败!");
	}
	
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
