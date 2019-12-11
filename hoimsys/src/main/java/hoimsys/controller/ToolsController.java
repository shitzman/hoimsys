package hoimsys.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import hoimsys.bo.Msg;

@Controller
@RequestMapping("api/tools")
public class ToolsController {
	
	
	/*
	 * 上传图片文件：
	 * 接收jpg，png的图片返回相对文件名，加上项目路径即可查看该文件
	 */
	@ResponseBody
	@PostMapping("/uploadimg")
	public Msg upLoadImg(@RequestParam("imgFile") MultipartFile imgFile) {
		String imgName = null;
		if(imgFile.isEmpty()) {
			return Msg.fail().resetMsg("未接收到图片文件");
		}else {
			imgName = imgFile.getOriginalFilename();
			String imgSuffix = imgName.substring(imgName.lastIndexOf(".")+1).trim();//获得文件后缀名
			boolean b = imgSuffix.equalsIgnoreCase("jpg") || imgSuffix.equalsIgnoreCase("png");
			//如果即文件后缀既不是jpg也不是png;
			if(!b) {
				return Msg.fail().resetMsg("请选择【.jpg】或【.png】格式的图片");
			}
			try {
				int a = (int) (Math.random()*10000);
				imgName = a+imgFile.getOriginalFilename();//链接随机数防止文件名重复
				String path = ResourceUtils.getURL("classpath:").getPath()+File.separator+"static"+File.separator+"img"+File.separator;
				File uploadDir = new File(path);
				if(!uploadDir.exists()) uploadDir.mkdirs();
				//获取项目在当前机器上的真实绝对路径，将上传文件储存在项目的img文件夹中；
				imgFile.transferTo(new File(path+imgName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return Msg.success().add("imgPath", "img/"+imgName);
	}
	
	
	/*
	 * 删除文件：
	 * 	接收文件名去图片uploadimg存储路径删除该文件；
	 */
	@ResponseBody
	@GetMapping("/delfile")
	public Msg delFile(String fileName) {
		String path = null;
		try {
			path = ResourceUtils.getURL("classpath:").getPath()+File.separator+"static"+File.separator+"img"+File.separator;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File file = new File(path+fileName);
		if (file.exists()) {
			file.delete();
			return Msg.success().resetMsg("删除文件成功");
		}
		
		return Msg.fail().resetMsg("删除失败");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
