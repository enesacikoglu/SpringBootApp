package sample.data.cassandra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import sample.data.cassandra.entity.Product;
import sample.data.cassandra.model.CustomerModel;
import sample.data.cassandra.model.DataTableModel;
import sample.data.cassandra.service.CustomerService;



@Api(basePath = "/api/customer", produces = "application/json", value = "Customer", description = "Operations with customer")
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	
	@ApiOperation(value = "Get customers", notes = "Fetch List of Customers")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Please check url"), @ApiResponse(code = 200, message = "List<Customers>"),
			@ApiResponse(code = 500, message = "Error occurred while fetching Customers") })
	@ResponseBody
	@RequestMapping(value = "/allCustomers", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<CustomerModel>> getCustomers() { 
		return new ResponseEntity<List<CustomerModel>>(this.customerService.findAll(), HttpStatus.OK);
	}
	
	
	
	@ApiOperation(value = "Get All customers", notes = "Fetch List of Customers")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Please check url"), @ApiResponse(code = 200, message = "List<Customers>"),
			@ApiResponse(code = 500, message = "Error occurred while fetching Customers") })
	@ResponseBody
	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<DataTableModel> getAllCustomers() { 
		
		DataTableModel tableModel= new DataTableModel();
		tableModel.setData(customerService.findAll());
		
		return new ResponseEntity<DataTableModel>(tableModel, HttpStatus.OK);
		
	
	}
		
}
