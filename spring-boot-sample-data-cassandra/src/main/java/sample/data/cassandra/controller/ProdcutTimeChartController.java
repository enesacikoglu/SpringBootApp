// package sample.data.cassandra.controller;
//
// import java.util.List;
//
//
// import org.springframework.beans.factory.annotation.Autowired;
//
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.servlet.ModelAndView;
//
// import sample.data.cassandra.entity.ProductCassandraEntity;
// import sample.data.cassandra.model.ProductBarChart;
//
// import sample.data.cassandra.service.ProductCassandraService;
//
//
// @RestController
// public class ProdcutTimeChartController {
//
//
//
// @Autowired
// private ProductCassandraService productCassandraService;
//
//
// @RequestMapping("/productID")
// public List<ProductBarChart> getAllProductsById(@RequestParam("id") String
// id){
// return productCassandraService.getProductBarChartById(id);
// }
//
// @RequestMapping("barchart/productID")
// public ModelAndView getAllProducts(@RequestParam("id") String id,Model
// model){
// return new ModelAndView("barchart", "barchart", null);
// }
//
// }
