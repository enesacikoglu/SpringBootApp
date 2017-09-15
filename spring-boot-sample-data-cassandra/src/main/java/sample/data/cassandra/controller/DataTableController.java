package sample.data.cassandra.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sample.data.cassandra.model.CustomerModel;
import sample.data.cassandra.service.CustomerService;

@Controller
public class DataTableController {

	@Autowired
	private CustomerService customerService;
	
	
	@RequestMapping(path = { "/datatable" }, method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView dataTable(Model model) {
		List<CustomerModel> customerList=(List<CustomerModel>)customerService.findAll();
		return new ModelAndView("datatable", "datatable", customerList);
	}
	

//	@RequestMapping("product/new")
//	public String newProduct(Model model) {
//		model.addAttribute("product", new Product());
//		return "productform";
//	}
//	
//	
//	@RequestMapping("product/edit/{id}")
//	public String edit(@PathVariable Integer id, Model model) {
//		model.addAttribute("product", productService.getProductById(id));
//		return "productform";
//	}
//
//
//	@RequestMapping(value = "product", method = RequestMethod.POST)
//	public String saveProduct(Product product) {
//		productService.saveProduct(product);
//		return "redirect:/product/" + product.getId();
//	}

	@RequestMapping(value="customer/delete")
	public String deleteCustomer(@RequestParam("id") String id) {

        customerService.deleteCustomer(id);
        
        return "redirect:/datatable";
	}
	
}
