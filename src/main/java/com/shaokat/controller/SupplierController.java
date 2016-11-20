package com.shaokat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shaokat.model.Supplier;
import com.shaokat.service.SupplierCRUD;


@Controller
public class SupplierController {
	
	@Autowired
	private SupplierCRUD supplierService;
	
	@GetMapping("/supplier")
	public String index(){
		return "supplierIndex";
	}
	@GetMapping("/supplier/list")
	public String AllProducts(Model model){
		
		model.addAttribute("allSupplier",supplierService.getAllSupplier());
		
		return"supplierList";
	}
	
	
	@GetMapping("/supplier/create")
	public String createNewSupplier(Model model){
		model.addAttribute("supplier", new Supplier());
		return "createSupplier";
		
	}
	
	@PostMapping("/supplier/create")
	public String createNewSupplier(@ModelAttribute("supplier") Supplier supplier, 
			RedirectAttributes redirectAttribs){
		supplierService.create(supplier);
		redirectAttribs.addFlashAttribute("confirmationMessage", "Supplier was created successfully");
		
		return "redirect:/supplier/list";
		
	}
	
	@GetMapping("/supplier/edit/{supplierId}")
	public String editSupplier(@PathVariable long supplierId, Model model){
		Supplier selectedSupplier = supplierService.select(supplierId);
		model.addAttribute("selectedSupplier", selectedSupplier);
		return "editSupplier";
	}
	
	@PostMapping("/supplier/edit")
	public String editSupplier(@ModelAttribute("selectedSupplier") Supplier supplier, RedirectAttributes redirectAttributes){
		System.out.println(supplier.getId());
		supplierService.update(supplier);
		redirectAttributes.addFlashAttribute("confaramtionMessage", "supplier successfully updated");
		return "redirect:/supplier/list";
	}
}
