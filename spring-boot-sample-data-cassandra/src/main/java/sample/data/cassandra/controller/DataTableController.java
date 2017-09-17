package sample.data.cassandra.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sample.data.cassandra.entity.ProductEntity;
import sample.data.cassandra.model.CustomerDataTableModel;
import sample.data.cassandra.model.CustomerModel;
import sample.data.cassandra.model.ProductDataTableModel;
import sample.data.cassandra.model.ProductEntityModel;
import sample.data.cassandra.service.CustomerService;
import sample.data.cassandra.service.ProductEntityService;

@Controller
public class DataTableController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductEntityService productEntityService;

	@RequestMapping(path = { "/datatable" }, method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView dataTable(Model model) {
		List<CustomerModel> customerList = (List<CustomerModel>) customerService.findAll();
		return new ModelAndView("datatable", "datatable", customerList);
	}

	@RequestMapping(path = { "/datatableEditor" }, method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView dataTableEditor(Model model) {
		List<CustomerModel> customerList = (List<CustomerModel>) customerService.findAll();
		return new ModelAndView("datatableEditor", "datatableEditor", customerList);
	}

	@RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
	public ResponseEntity<ProductDataTableModel> getAllProducts(Model model, Pageable pageable) {
		ProductDataTableModel tableModel = new ProductDataTableModel();

		tableModel.setData(productEntityService.findAll());

		return new ResponseEntity<ProductDataTableModel>(tableModel, HttpStatus.OK);
	}

//	@RequestMapping("/barchart")
//	public String barchart() {
//		return "barchart";
//	}

	// @RequestMapping("product/new")
	// public String newProduct(Model model) {
	// model.addAttribute("product", new Product());
	// return "productform";
	// }
	//
	//
	// @RequestMapping("product/edit/{id}")
	// public String edit(@PathVariable Integer id, Model model) {
	// model.addAttribute("product", productService.getProductById(id));
	// return "productform";
	// }
	//
	//
	// @RequestMapping(value = "product", method = RequestMethod.POST)
	// public String saveProduct(Product product) {
	// productService.saveProduct(product);
	// return "redirect:/product/" + product.getId();
	// }

	@RequestMapping(value = "customer/delete")
	public ResponseEntity<CustomerDataTableModel> deleteCustomer(@RequestParam("id") String id) {

		if (customerService.deleteCustomer(id)) {
			return new ResponseEntity<CustomerDataTableModel>(new CustomerDataTableModel(), HttpStatus.OK);
		}

		else {
			return null;
		}

	}

}
