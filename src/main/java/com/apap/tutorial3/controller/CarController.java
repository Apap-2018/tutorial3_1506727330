package com.apap.tutorial3.controller;

import com.apap.tutorial3.model.CarModel;
import com.apap.tutorial3.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CarController {
    @Autowired
    private CarService mobilService;

    @RequestMapping("/car/add")
    public String add(@RequestParam(value="id",required = true) String id,
                      @RequestParam(value="brand",required = true) String brand,
                      @RequestParam(value="type",required = true) String type,
                      @RequestParam(value="price",required = true) Long price,
                      @RequestParam(value="amount",required = true) Integer amount){
        CarModel car = new CarModel(id,brand,type,price,amount);
        mobilService.addCar(car);
        return "add";
    }

    @RequestMapping("/car/view")
    public String view(@RequestParam(value = "id",defaultValue = "") String id, Model model){
        CarModel archive = mobilService.getCarDetail(id);
        model.addAttribute("car", archive);
        return "view-car";
    }

    @RequestMapping("/car/viewall")
    public String viewall(Model model){
        List<CarModel> archive = mobilService.getCarList();
        model.addAttribute("listCar",archive);
        return "viewall-car";
    }

    @RequestMapping("/car/view/{id}")
    public String viewById(@PathVariable String id, Model model){
        CarModel car = mobilService.getCarDetail(id);
        model.addAttribute("car",car);
        return "view-car";
    }

    @RequestMapping("/car/update/{id}/amount/{amount}")
    public String update(@PathVariable("id") String id, @PathVariable("amount") String amount, Model model){
        CarModel car = mobilService.getCarDetail(id);
        Integer intAmount = Integer.parseInt(amount);
        Integer oldAmount,newAmount;
        if (car != null){
            oldAmount = car.getAmount();
            car.setAmount(intAmount);
            newAmount = car.getAmount();
        }else {
            oldAmount = null;
            newAmount = null;
        }
        model.addAttribute("oldAmount",oldAmount);
        model.addAttribute("newAmount",newAmount);
        return "update-amount";
    }
    @RequestMapping({"/car/update//amount/{amount}","/car/delete/"})
    public String withoutId(){
        return "null-id-error";
    }

    @RequestMapping("/car/delete/{id}")
    public String delete(@PathVariable String id, Model model){
        CarModel car = mobilService.getCarDetail(id);
        boolean isDeleted = false;
        if (car != null){
            if (mobilService.getCarList().remove(car)){
                System.out.println("\n\n\nSukses kok gan\n\n");
                isDeleted = true;
            }
        }

        model.addAttribute("isDeleted",isDeleted);
        return "delete";
    }
}
