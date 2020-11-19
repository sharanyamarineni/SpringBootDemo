package com.zemoso.springboot.cruddemo.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zemoso.springboot.cruddemo.entity.Book;
import com.zemoso.springboot.cruddemo.entity.Item;
import com.zemoso.springboot.cruddemo.service.BookService;
import com.zemoso.springboot.cruddemo.service.UserService;

@Controller
@RequestMapping("cart")
public class CartContoller {
	private BookService bookService;
	public CartContoller(BookService theBookService) {
			bookService = theBookService;
		}

	@GetMapping("/addCart")
	public String addToCart(@RequestParam("bookId") int theId,
									Model theModel,HttpSession session) {
		
		if(session.getAttribute("cart")==null) {
			List<Item> cart = new ArrayList<Item>();
			cart.add(new Item(bookService.findById(theId),1));
			session.setAttribute("cart", cart);
		}
		else {
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			int index= isExists(theId, cart);
			if(index==-1) {
				cart.add(new Item(bookService.findById(theId),1));

			}else {
				int quantity= cart.get(index).getQuantity()+1;
				cart.get(index).setQuantity(quantity);
			}
			session.setAttribute("cart", cart);

		}
		return "cart";			
	}
	@GetMapping("/removeCart")
	public String removeCart(@RequestParam("bookId") int theId,
									Model theModel,HttpSession session) {
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		int index = this.isExists(theId, cart);
		cart.remove(index);
		session.setAttribute("cart", cart);
		return "cart";
	}
	@RequestMapping(value = "/updateCart", method = RequestMethod.POST)
	public String updateCart(HttpServletRequest request,
									Model theModel,HttpSession session) {
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		String[] quantity = request.getParameterValues("quantity");
		for(int i=0;i<cart.size();i++) {
			cart.get(i).setQuantity(Integer.parseInt(quantity[i]));
		}
		session.setAttribute("cart", cart);
		return "cart";
	}
	@GetMapping("/myCart")
	public  String myCart ( Model theModel,HttpSession session){
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		session.setAttribute("cart", cart);
	   return "cart";
	}

	
	private int isExists(int id,List<Item> cart) {
		for(int i=0;i<cart.size();i++) {
			if(cart.get(i).getBook().getId()==id)
				return i;
		}
		return -1;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap, HttpSession session) {
		double s=total(session);
		System.out.println("total sum="+s);
		modelMap.put("total", s);
		return "cart";
	}
	
	private double total(HttpSession session) {
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		double s=0;
		for(Item item:cart) {
			s+= item.getQuantity() * item.getBook().getPrice().doubleValue();
		}
		return s;
	}
}
