package com.shaokat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shaokat.model.Product;
import com.shaokat.service.ProductCRUD;

@Controller
public class ProductController {

	@Autowired
	private ProductCRUD productService;
	
	@GetMapping("/product")
	public String index(){
		return "proudctIndex";
	}
	
	@GetMapping("/product/list")
	public String AllProducts(Model model){
		
		model.addAttribute("allProducts",productService.getAllProducts());
		
		return"productList";
	}
	
	@GetMapping("/product/create")
	public String createNewProduct(Model model){
		
		model.addAttribute("product", new Product());
		return "createProduct";
		
	}
	
	@PostMapping("/product/create")
	public String createNewProduct(@ModelAttribute("proudct") Product product,
			RedirectAttributes redirctAttribs){
		
		productService.create(product);
		redirctAttribs.addFlashAttribute("confirmationMessage", "product was created successfully");
		
		return "redirect:/product/list";
		
	}
	
	@GetMapping("/product/edit/{productId}")
	public String editProduct(@PathVariable long productId,Model model){
		Product selectedProduct = productService.select(productId);
		model.addAttribute("selectedProduct", selectedProduct);
		return "editProduct";
		
	}
	@PostMapping("/product/edit")
	public String editProduct(@ModelAttribute("selectedProduct") Product product,
			RedirectAttributes redirctAttribs){
		productService.update(product);
		redirctAttribs.addFlashAttribute("confirmationMessage", "product was edited successfully");
		return "redirect:/product/list";
	}
	
	@GetMapping("/product/delete/{productId}")
	public String deleteProduct(@PathVariable long productId,Model model){
		Product selectedProduct = productService.select(productId);
		model.addAttribute("selectedProduct", selectedProduct);
		return "deleteProduct";
		
	}
	@PostMapping("/product/delete")
	public String deleteProduct(@ModelAttribute("selectedProduct") Product product,
			RedirectAttributes redirctAttribs){
		System.err.println("id of the selected product:"+product.getId());
		productService.delete(product.getId());
		redirctAttribs.addFlashAttribute("confirmationMessage", "product was deleted successfully");
		return "redirect:/product/list";
	}
}
