package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;
    private final OutsourcedPartRepository outsourcedPartRepository;
    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository = outsourcedPartRepository;
        this.inhousePartRepository = inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (partRepository.count() == 0) {

            InhousePart bread = new InhousePart();
            bread.setName("Bread");
            bread.setInv(25);
            bread.setPrice(1.25);
            bread.setId((700L));
            bread.setInvMin(1);
            bread.setInvMax(100);
            inhousePartRepository.save(bread);


            OutsourcedPart bacon = new OutsourcedPart();
            bacon.setName("Bacon");
            bacon.setInv(50);
            bacon.setPrice(2.75);
            bacon.setId(902L);
            bacon.setInvMin(1);
            bacon.setInvMax(100);
            outsourcedPartRepository.save(bacon);

            OutsourcedPart mayo = new OutsourcedPart();
            mayo.setName("Mayo");
            mayo.setInv(75);
            mayo.setPrice(0.25);
            mayo.setId(602L);
            mayo.setInvMin(1);
            mayo.setInvMax(100);
            outsourcedPartRepository.save(mayo);

            OutsourcedPart tomato = new OutsourcedPart();
            tomato.setName("Tomato");
            tomato.setInv(50);
            tomato.setPrice(1.00);
            tomato.setId(509L);
            tomato.setInvMin(1);
            tomato.setInvMax(100);
            outsourcedPartRepository.save(tomato);

            OutsourcedPart egg = new OutsourcedPart();
            egg.setName("Egg");
            egg.setInv(50);
            egg.setPrice(2.00);
            egg.setId(111L);
            egg.setInvMin(1);
            egg.setInvMax(100);
            outsourcedPartRepository.save(egg);

            if (productRepository.count() == 0) {
                Product blt_sandwich = new Product("B.L.T(Bacon, Lettuce, Tomato)", 5.99, 5);
                Product bacon_egg = new Product("Bacon, Egg & Cheese", 6.99, 10);
                Product deli_ham = new Product("Deli Ham & Cheese", 6.49, 8);
                Product deli_turkey = new Product("Deli Turkey & Cheese", 6.49, 4);
                Product tuna_salad = new Product("Tuna Salad", 50.00, 7);
                productRepository.save(blt_sandwich);
                productRepository.save(bacon_egg);
                productRepository.save(deli_ham);
                productRepository.save(deli_turkey);
                productRepository.save(tuna_salad);
            }






       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
            List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                System.out.println(part.getName() + " " + part.getCompanyName());
            }



        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

            System.out.println("Started in Bootstrap");
            System.out.println("Number of Products" + productRepository.count());
            System.out.println(productRepository.findAll());
            System.out.println("Number of Parts" + partRepository.count());
            System.out.println(partRepository.findAll());

        }
    }
}