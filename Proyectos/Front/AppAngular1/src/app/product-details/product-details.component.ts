import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from '../model/product';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {

  product: Product

  constructor(
    private productService: ProductService,
    private activateRouter: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    //capturando el codigo
    const id = this.activateRouter.snapshot.params['codigo'];
    //llamo al servicio enviandole el id para que retorne el producto encontrado
    this.productService.detail(id).subscribe(data => this.product=data);
  }

  volver() :void {
    this.router.navigate(['/']);
  }

}
