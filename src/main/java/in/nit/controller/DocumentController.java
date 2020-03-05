package in.nit.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import in.nit.model.Document;
import in.nit.service.IDocumentService;

@Controller
@RequestMapping("/doc")
public class DocumentController {
	@Autowired
	private IDocumentService service;
	@RequestMapping("/show")
	public String showPage(Model model) {
		model.addAttribute("list",service.getAllDocuments());
		return "Documents";
	}
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String uploadDoc( @RequestParam Integer fileId, 
			@RequestParam CommonsMultipartFile fileOb,Model model)
	{
		if(fileOb!=null) {
			Document doc=new Document();
			doc.setFileId(fileId); 
			doc.setFileName(fileOb.getOriginalFilename());
			doc.setFileData(fileOb.getBytes());
			service.saveDocument(doc);
			String msg=fileId+"   is uploaded"; 
			model.addAttribute("message", msg); 
		}
		return "redirect:show";
	}
	@RequestMapping("/download")
	public void doUpload(HttpServletResponse response,@RequestParam Integer fid) {
		Document doc=service.getOneDocument(fid);
		response.setHeader("Content-Disposition", "attachement;filename="+doc.getFileName());
		try {
			FileCopyUtils.copy(doc.getFileData(),response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
