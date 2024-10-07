import { Component } from '@angular/core';
import {Product} from "../modules/Poduct.module";
import {ProductServiceService} from "../services/product-service.service";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent {
  products!:Product[];
  constructor(private productService:ProductServiceService ) {
  }
  ngOnInit() {
    this.productService.getProducts().subscribe((data: { _embedded: { products: Product[]; }; })=>this.products=data._embedded.products);
  }

}
