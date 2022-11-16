import { Component, OnInit } from '@angular/core';
import { Product } from '../model/product';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products : Product[]

  constructor(private productService : ProductService) { }

  ngOnInit(): void {

  }
  reloadData(){
    console.log("Reload!");
    this.productService.getProductList().subscribe(products => this.products=products);
  }

}
