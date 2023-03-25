package com.proje.diyetisyeninibul.restapi;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.proje.diyetisyeninibul.FileUploadUtil;
import com.proje.diyetisyeninibul.business.IDiyetisyenService;
import com.proje.diyetisyeninibul.entities.Diyetisyen;

@Configuration
@EnableAutoConfiguration
@RestController
@RequestMapping("/")
public class DiyetisyenController {
	private IDiyetisyenService diyetisyenService;

	@Autowired
	public DiyetisyenController(IDiyetisyenService diyetisyenService) {
		this.diyetisyenService = diyetisyenService;
	}

	@RequestMapping("/new")
	public ModelAndView add(Model model) {
		ModelAndView modelAndView = new ModelAndView("new_diyetisyen");
		Diyetisyen diyetisyen = new Diyetisyen();
		modelAndView.addObject("diyetisyen", diyetisyen);
		return modelAndView;
	}

	@GetMapping("/diyetisyenler/{diyetisyenID}")
	public Diyetisyen getByDiyetisyenID(@PathVariable int diyetisyenID) {
		return diyetisyenService.getByDiyetisyenID(diyetisyenID);
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView get(Model model) {
		List<Diyetisyen> diyetisyenler = diyetisyenService.getAll();
		model.addAttribute("diyetisyenler", diyetisyenler);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin");
		return modelAndView;
	}

	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public ModelAndView selectDiyetisyen(Model model) {
		List<Diyetisyen> diyetisyenler = diyetisyenService.getAll();
		model.addAttribute("diyetisyenler", diyetisyenler);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("select");
		return modelAndView;
	}

	@RequestMapping(value = "/confirm/{diyetisyenID}", method = RequestMethod.GET)
	public ModelAndView confirm(Model model, @PathVariable("diyetisyenID") Integer diyetisyenID) {
		Diyetisyen diyetisyen = diyetisyenService.getByDiyetisyenID(diyetisyenID);
		model.addAttribute("diyetisyen", diyetisyen);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("confirm");
		return modelAndView;
	}

	@RequestMapping(value = "/diyetisyen_login")
	public ModelAndView diyetisyenLogin(Model model) {
		ModelAndView modelAndView = new ModelAndView("diyetisyen_login");
		return modelAndView;
	}

	@RequestMapping(value = "/view_meals/{diyetisyenID}", method = RequestMethod.GET)
	public ModelAndView viewMeals(Model model, @PathVariable("diyetisyenID") Integer diyetisyenID) {
		Diyetisyen diyetisyen = diyetisyenService.getByDiyetisyenID(diyetisyenID);
		model.addAttribute("diyetisyen", diyetisyen);
		ModelAndView modelAndView = new ModelAndView("view_meals");
		return modelAndView;
	}

	@RequestMapping(value = "/rate/{diyetisyenID}", method = RequestMethod.GET)
	public ModelAndView rate(Model model, @PathVariable("diyetisyenID") Integer diyetisyenID) {
		Diyetisyen diyetisyen = diyetisyenService.getByDiyetisyenID(diyetisyenID);
		model.addAttribute("diyetisyen", diyetisyen);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("rate");
		return modelAndView;
	}

	@RequestMapping(value = "/rate/{diyetisyenID}", method = RequestMethod.POST)
	public String rate(@PathVariable int diyetisyenID, Diyetisyen dyt) {
		Diyetisyen diyetisyen = diyetisyenService.getByDiyetisyenID(diyetisyenID);
		diyetisyen.setNumberOfOrders(diyetisyen.getNumberOfOrders() + 1);
		diyetisyen.setSum(diyetisyen.getSum() + dyt.getRating());
		diyetisyen.setRating((int) (Math.ceil(diyetisyen.getSum() / (double) diyetisyen.getNumberOfOrders())));
		diyetisyenService.save(diyetisyen);
		return "Bilgiler güncellendi";
	}

	@RequestMapping(value = "/edit/{diyetisyenID}", method = RequestMethod.GET)
	public ModelAndView edit(Model model, @PathVariable("diyetisyenID") Integer diyetisyenID) {
		Diyetisyen diyetisyen = diyetisyenService.getByDiyetisyenID(diyetisyenID);
		model.addAttribute("diyetisyen", diyetisyen);
		ModelAndView modelAndView = new ModelAndView("edit_diyetisyen");
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{diyetisyenID}", method = RequestMethod.POST)
	public String edit(@PathVariable int diyetisyenID, Diyetisyen dyt, @RequestParam("image") MultipartFile multipartFile) throws IOException {
		Diyetisyen diyetisyen = diyetisyenService.getByDiyetisyenID(diyetisyenID);
	
		//diyetisyenService.save(dyt);
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		diyetisyen.setDiyetisyenPhoto(fileName);
		String uploadDir = "diyetisyen-photos/" + diyetisyen.getDiyetisyenID();
		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		
		//diyetisyen.setDiyetisyenPhoto(dyt.getDiyetisyenPhoto());
		diyetisyen.setFirstName(dyt.getFirstName());
		diyetisyen.setLastName(dyt.getLastName());
		diyetisyen.setBio(dyt.getBio());
		diyetisyen.setRating(dyt.getRating());
		diyetisyenService.save(diyetisyen);
		return "Bilgiler kaydedildi";
	}

	@RequestMapping(value = "/edit_meals/{diyetisyenID}", method = RequestMethod.GET)
	public ModelAndView editMeals(Model model, @PathVariable("diyetisyenID") Integer diyetisyenID) {
		Diyetisyen diyetisyen = diyetisyenService.getByDiyetisyenID(diyetisyenID);
		model.addAttribute("diyetisyen", diyetisyen);
		ModelAndView modelAndView = new ModelAndView("edit_meal");
		return modelAndView;
	}

	@RequestMapping(value = "/edit_meals/{diyetisyenID}", method = RequestMethod.POST)
	public String editMeals(@PathVariable int diyetisyenID, Diyetisyen dyt, BindingResult result,
			@RequestParam("breakfastPhoto") MultipartFile multipartFile1,
			@RequestParam("lunchPhoto") MultipartFile multipartFile2,
			@RequestParam("dinnerPhoto") MultipartFile multipartFile3) throws IOException {
		Diyetisyen diyetisyen = diyetisyenService.getByDiyetisyenID(diyetisyenID);
					
		String breakfastFileName = StringUtils.cleanPath(multipartFile1.getOriginalFilename());
		String lunchPhotoFileName = StringUtils.cleanPath(multipartFile2.getOriginalFilename());
		String dinnerPhotoFileName = StringUtils.cleanPath(multipartFile3.getOriginalFilename());
	
		diyetisyen.setBreakfastPhoto(breakfastFileName);
		diyetisyen.setLunchPhoto(lunchPhotoFileName);
		diyetisyen.setDinnerPhoto(dinnerPhotoFileName);
		
		String uploadDir1 = "breakfast-photos/" + diyetisyen.getDiyetisyenID();
		String uploadDir2 = "lunch-photos/" + diyetisyen.getDiyetisyenID();
		String uploadDir3 = "dinner-photos/" + diyetisyen.getDiyetisyenID();
		
		FileUploadUtil.saveFile(uploadDir1, breakfastFileName, multipartFile1);		
		FileUploadUtil.saveFile(uploadDir2, lunchPhotoFileName, multipartFile2);
		FileUploadUtil.saveFile(uploadDir3, dinnerPhotoFileName, multipartFile3);
			
		diyetisyen.setBreakfast(dyt.getBreakfast());
		diyetisyen.setLunch(dyt.getLunch());
		diyetisyen.setDinner(dyt.getDinner());
		diyetisyenService.save(diyetisyen);
		return "Bilgiler güncellendi";
	}
	
	@PostMapping("/save")
	public String save(Diyetisyen diyetisyen, @RequestParam("image") MultipartFile multipartFile) throws IOException {
		diyetisyenService.save(diyetisyen);
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		diyetisyen.setDiyetisyenPhoto(fileName);
		Diyetisyen savedDiyetisyen = diyetisyenService.save(diyetisyen);
		String uploadDir = "diyetisyen-photos/" + savedDiyetisyen.getDiyetisyenID();
		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		return "Bilgiler kaydedildi";
	}

	@RequestMapping("/delete/{diyetisyenID}")
	public String delete(@PathVariable(name = "diyetisyenID") int diyetisyenID) {
		Diyetisyen diyetisyen = getByDiyetisyenID(diyetisyenID);
		diyetisyenService.delete(diyetisyen);
		return "Diyetisyen silindi";
	}
}
